
--creacion del usuario
CREATE USER usuarioelectronichomes WITH PASSWORD '!@#$AaBbCc';
--permiso CRUD para todos los esquemas y sus tablas
GRANT ALL PRIVILEGES ON DATABASE electronichomes to usuarioelectronichomes;

