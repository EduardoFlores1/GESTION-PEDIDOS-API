CREATE TABLE categorias(
                           id BIGSERIAL PRIMARY KEY,
                           nombre VARCHAR(50) NOT NULL
);

CREATE TABLE productos(
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(50) NOT NULL,
                          descripcion VARCHAR(255) NOT NULL,
                          precio DECIMAL(10,2) NOT NULL,
                          stock INT NOT NULL,
                          image_url VARCHAR(255) NOT NULL,
                          categoria_id BIGINT REFERENCES categorias(id) NOT NULL,
                          estado VARCHAR(10) NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          updated_at TIMESTAMP NOT NULL
);

CREATE TABLE clientes(
                         id BIGSERIAL PRIMARY KEY,
                         username VARCHAR(50) UNIQUE NOT NULL,
                         email VARCHAR(150) NOT NULL,
                         nombres VARCHAR(50) NOT NULL,
                         apellidos VARCHAR(50) NOT NULL,
                         telefono CHAR(9) NOT NULL,
                         direccion VARCHAR(150) NOT NULL,
                         sexo VARCHAR(20) NOT NULL,
                         fecha_nacimiento DATE NOT NULL,
                         estado VARCHAR(10) NOT NULL,
                         created_at TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP NOT NULL
);


-- categorias
SELECT * FROM categorias;

INSERT INTO categorias(nombre) VALUES ('Electrónica');
INSERT INTO categorias(nombre) VALUES ('Joyería');
INSERT INTO categorias(nombre) VALUES ('Ropa de Hombre');
INSERT INTO categorias(nombre) VALUES ('Ropa de Mujer');

-- productos
SELECT * FROM productos;

-- electronica
INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Disco duro postable M2', 'USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity', 750.00, 20, 'https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg', 1, 'Activo', '2024-10-27 10:00:00', '2024-10-27 10:00:00');

INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Monitor Samsung 144Hz', '49 INCH SUPER ULTRAWIDE 32:9 CURVED GAMING MONITOR with dual 27 inch screen side by side QUANTUM DOT (QLED) TECHNOLOGY', 25.50, 100, 'https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_.jpg', 1, 'Activo', '2024-10-27 10:05:00', '2024-10-27 10:05:00');

-- joyas
INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Brazalete de plata dragon', 'From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean', 85.00, 50, 'https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg', 2, 'Activo', '2024-10-27 10:10:00', '2024-10-27 10:10:00');

INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Anillo de diamante', 'Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her', 180.00, 30, 'https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg', 2, 'Activo', '2024-10-27 10:15:00', '2024-10-27 10:15:00');

-- ropa hombre
INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Camisa slim fit', 'Slim-fitting style, contrast raglan long sleeve, three-button henley placket', 60.00, 40, 'https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg', 3, 'Activo', '2024-10-27 10:20:00', '2024-10-27 10:20:00');

INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Chaqueta de algodon hombre', 'great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions', 200.00, 15, 'https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg', 3, 'Activo', '2024-10-27 10:25:00', '2024-10-27 10:25:00');

-- ropa mujer
INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Polo sólido blanco', '95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach, Lightweight fabric with great stretch for comfort', 130.00, 25, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 4, 'Activo', '2024-10-27 10:30:00', '2024-10-27 10:30:00');

INSERT INTO productos (nombre, descripcion, precio, stock, image_url, categoria_id, estado, created_at, updated_at)
VALUES ('Chaqueta negra', '100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER)', 55.00, 60, 'https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg', 4, 'Activo', '2024-10-27 10:35:00', '2024-10-27 10:35:00');



-- clientes
SELECT * FROM clientes;

INSERT INTO clientes (username, email, nombres, apellidos, telefono, direccion, sexo, fecha_nacimiento, estado, created_at, updated_at)
VALUES ('jdoe', 'jdoe@example.com', 'John', 'Doe', '123456789', '123 Elm Street', 'Masculino', '1990-05-15', 'Activo', '2024-10-27 10:00:00', '2024-10-27 10:00:00');

INSERT INTO clientes (username, email, nombres, apellidos, telefono, direccion, sexo, fecha_nacimiento, estado, created_at, updated_at)
VALUES ('asmith', 'asmith@example.com', 'Anna', 'Smith', '987654321', '456 Oak Avenue', 'Femenino', '1985-03-22', 'Activo', '2024-10-27 10:05:00', '2024-10-27 10:05:00');

INSERT INTO clientes (username, email, nombres, apellidos, telefono, direccion, sexo, fecha_nacimiento, estado, created_at, updated_at)
VALUES ('mperez', 'mperez@example.com', 'Maria', 'Perez', '555888333', '789 Pine Road', 'Femenino', '1992-08-30', 'Inactivo', '2024-10-27 10:10:00', '2024-10-27 10:10:00');

INSERT INTO clientes (username, email, nombres, apellidos, telefono, direccion, sexo, fecha_nacimiento, estado, created_at, updated_at)
VALUES ('rbrown', 'rbrown@example.com', 'Robert', 'Brown', '444333222', '101 Maple Boulevard', 'Masculino', '1978-11-15', 'Activo', '2024-10-27 10:15:00', '2024-10-27 10:15:00');

INSERT INTO clientes (username, email, nombres, apellidos, telefono, direccion, sexo, fecha_nacimiento, estado, created_at, updated_at)
VALUES ('ljones', 'ljones@example.com', 'Linda', 'Jones', '222111444', '202 Cedar Court', 'Femenino', '1982-02-17', 'Activo', '2024-10-27 10:20:00', '2024-10-27 10:20:00');


