package com.pruebatecnica.prueba.service.impl;

import com.pruebatecnica.prueba.exception.CustomException;
import com.pruebatecnica.prueba.mapper.PedidoItemMapper;
import com.pruebatecnica.prueba.mapper.PedidoMapper;
import com.pruebatecnica.prueba.model.dto.pedido.request.PedidoCreate;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoDetalladoResponse;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoResponse;
import com.pruebatecnica.prueba.model.entities.ClienteEntity;
import com.pruebatecnica.prueba.model.entities.PedidoEntity;
import com.pruebatecnica.prueba.model.entities.ProductoEntity;
import com.pruebatecnica.prueba.model.enums.EstadoPedido;
import com.pruebatecnica.prueba.repository.ClienteRepository;
import com.pruebatecnica.prueba.repository.PedidoItemRepository;
import com.pruebatecnica.prueba.repository.PedidoRepository;
import com.pruebatecnica.prueba.repository.ProductoRepository;
import com.pruebatecnica.prueba.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoItemRepository pedidoItemRepository;
    private final PedidoMapper pedidoMapper;
    private final PedidoItemMapper pedidoItemMapper;

    @Override
    public Flux<PedidoResponse> findAll() {
        return pedidoRepository.findAll()
                .flatMap(pedidoEntity ->
                    // buscamos cliente por clienteId
                    clienteRepository.findById(pedidoEntity.getClienteId())
                            .map(clienteEntity -> {
                                PedidoResponse pedidoResponse = pedidoMapper.toResponse(pedidoEntity);
                                pedidoResponse.setClienteUsername(clienteEntity.getUsername());
                                pedidoResponse.setClienteTelefono(clienteEntity.getTelefono());
                                return pedidoResponse;
                            }).defaultIfEmpty(new PedidoResponse())
                );
    }

    @Override
    public Mono<PedidoDetalladoResponse> findById(Long id) {
        return null;
    }

    @Override
    public Mono<PedidoResponse> save(PedidoCreate create) {
        ClienteEntity clienteEntity = new ClienteEntity();
        return clienteRepository.findById(create.getClienteId())
                .doOnNext(cliente -> {
                    clienteEntity.setUsername(cliente.getUsername());
                    clienteEntity.setTelefono(clienteEntity.getTelefono());
                })
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "El cliente no existe.")))
                // procesamos items para actualizar stock
                .thenMany(Flux.fromIterable(create.getItems()))
                .flatMap(item -> productoRepository.findById(item.getProductoId())
                        .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "Producto no encontrado.")))
                        .flatMap(producto -> {
                            // reducimos stock
                            if (producto.getStock() < item.getCantidad()) {
                                return Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "Stock insuficiente."));
                            }
                            producto.setStock(producto.getStock() - item.getCantidad());
                            return productoRepository.save(producto);
                        })
                ).collectList()
                // obtenemos productos para la tabla maestra
                .flatMap(productosActualizados -> pedidoRepository.save(construirPedido(productosActualizados, create)))
                .flatMap(pedido ->
                    // guardamos los detalles del pedido
                    Flux.fromIterable(create.getItems())
                            .flatMap(item -> pedidoItemRepository.save(pedidoItemMapper.toEntity(item)))
                            .then(Mono.just(pedido))
                )
                .map(pedido -> {
                    PedidoResponse response = pedidoMapper.toResponse(pedido);
                    response.setClienteUsername(clienteEntity.getUsername());
                    response.setClienteTelefono(clienteEntity.getTelefono());
                    return response;
                })
                .onErrorResume(error -> {
                    revertirCambios(); // sin implementar
                    return Mono.error(error);
                });

    }

    @Override
    public void cancelarById(String id) {

    }

    private void revertirCambios() {}

    private PedidoEntity construirPedido(List<ProductoEntity> productosActualizados, PedidoCreate create) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        var dateTime = LocalDateTime.now();
        pedidoEntity.setClienteId(create.getClienteId());
        pedidoEntity.setNumeroPedido(UUID.randomUUID().toString());
        pedidoEntity.setTotalProductos(productosActualizados.size());
        BigDecimal total = create.getItems().stream()
                .map(item -> {
                    // Encuentra el producto correspondiente en productosActualizados
                    ProductoEntity producto = productosActualizados.stream()
                            .filter(p -> p.getId().equals(item.getProductoId()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Producto no encontrado en productos actualizados"));

                    // Calcula el subtotal del item (precio * cantidad)
                    return producto.getPrecio().multiply(new BigDecimal(item.getCantidad()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        pedidoEntity.setEstado(EstadoPedido.APROBADO.toString());
        pedidoEntity.setCreatedAt(dateTime);
        pedidoEntity.setUpdatedAt(dateTime);
        return pedidoEntity;
    }
}
