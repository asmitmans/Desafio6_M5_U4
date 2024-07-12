# Desafío - El patrón de diseño MVC y despliegue de una aplicación

#### Tabla usada
```sql
-- Crear la tabla 'usuarios'
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    correo VARCHAR(255) NOT NULL,
    nick VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    peso NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Insertar datos de prueba
INSERT INTO usuarios (correo, nick, nombre, password, peso, created_at, updated_at) VALUES
('user1@mail.com', 'user1', 'User One', 'pass123', 70.50, '2024-07-10 17:47:23', '2024-07-10 17:47:23'),
('user2@mail.com', 'user2', 'User Two', 'pass456', 65.00, '2024-07-10 17:47:23', '2024-07-10 17:47:23'),
('user3@mail.com', 'user3', 'User Three', 'pass789', 80.00, '2024-07-10 17:47:23', '2024-07-10 17:47:23');
```

#### Configuración conexión
https://github.com/asmitmans/Desafio6_M5_U4/blob/main/src/main/java/cl/fullstackjava/model/conexion/Conexion.java

