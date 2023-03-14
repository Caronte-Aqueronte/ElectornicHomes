---------------------------------- CREACION DE SUCURSALES ------------------------------------------------------
INSERT INTO RegistroPersonal.Sucursal VALUES ('Sucursal Central');
INSERT INTO RegistroPersonal.Sucursal VALUES ('Sucursal Norte');
INSERT INTO RegistroPersonal.Sucursal VALUES ('Sucursal Sur');

---------------------------------- INSERTS DE EMPLEADOS Sucursal Central ------------------------------------------------------

--Vendedores de la Sucursal Central
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Luis Monterroso', 20, 'Sucursal Central', '1_luis_CT', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Raquel Yoxom', 20, 'Sucursal Central', '2_raquel_CT', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Luis Lopez', 20, 'Sucursal Central', '3_luisL_CT', '123', 'VENDEDOR');

--Encargado de inventario de la Sucursal Central
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Mauricio Gonzales', 29, 'Sucursal Central', '4_mauricio_CT', '123', 'INVENTARIO');

---------------------------------- INSERTS DE EMPLEADOS Sucurlsal Norte------------------------------------------------------

--Vendedores de la Sucursal Norte
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Alex Lima', 22, 'Sucursal Norte', '5_alex', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Diego Guzman', 25, 'Sucursal Norte', '6_diego', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Maria Lemus', 28, 'Sucursal Norte', '7_maria', '123', 'VENDEDOR');

--Encargado de inventario de la Sucursal Norte
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Patricia Salanic', 24, 'Sucursal Norte', '8_patricia', '123', 'INVENTARIO');

---------------------------------- INSERTS DE EMPLEADOS Sucursal Sur------------------------------------------------------

--Vendedores de la Sucursal Sur
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Gabriela Tzun', 25, 'Sucursal Sur', '9_gabriela', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Walter Montenegro', 25, 'Sucursal Sur', '10_walter', '123', 'VENDEDOR');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Abigail Briones', 28, 'Sucursal Sur', '11_abigail', '123', 'VENDEDOR');

--Encargado de inventario de la Sucursal Sur
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Humberto Sac', 24, 'Sucursal Sur', '12_humberto', '123', 'INVENTARIO');


---------------------------------- INSERTS DE EMPLEADOS BODEGA------------------------------------------------------

INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Rodrigo Lopez', 28, 'Sucursal Central', '13_rodrigo', '123', 'BODEGA');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Ruth Rodriguez', 28, 'Sucursal Central', '14_ruth', '123', 'BODEGA');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Sara Montejo', 28, 'Sucursal Central', '15_sara', '123', 'BODEGA');
INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Jordi Campollo', 28, 'Sucursal Central', '16_jordi', '123', 'BODEGA');

---------------------------------- INSERTS DE EMPLEADOS ADMINISTRACION------------------------------------------------------

INSERT INTO RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) 
VALUES ('Antonio Guzman', 20, 'Sucursal Central', '17_antonio', '123', 'ADMINISTRACION');

---------------------------------- INSERTS DE PRODUCTOS ------------------------------------------------------

INSERT INTO RegistroRecursos.Producto VALUES ('Estufa Samsung', 'Estufa marca Samsung, color negro mate.', 4000.00, 7000.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Batidora Blanck&Decker', 'Estufa marca Black&Decker, 2000 revoluciones, color negro.', 300.00, 600.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Refrigerador Samsung', 'Refrigerador marca Samsung, color negro mate.', 4000.00, 10000.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Bocina Portatil Sony', 'Bocina marca Sony, color negro.', 100.00, 250.00);
INSERT INTO RegistroRecursos.Producto VALUES ('PlayStation 5 Sony', 'PlayStation 5 marca Sony, color blanco.', 3000.00, 7000.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Licuadora', 'Licuadora marca Wirlpool, 5 velociades.', 300.00, 700.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Cafetera', 'Cafetera marca Black&Decker, color negro mate.', 300.00, 450.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Microondas', 'Estufa marca Wirlpool, Modelo ASD123.', 300.00, 700.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Television Samsung', 'Marca Samsung, 72 Pulgadas, Oled, 4k.', 7000.00, 15000.00);
INSERT INTO RegistroRecursos.Producto VALUES ('Computadora HP', 'Computadora HP Omen 15, 12 Pulgadas, Oled, 4k.', 7000.00, 15000.00);

---------------------------------- COMPRAS DE LA BODEGA ------------------------------------------------------

INSERT INTO RegistroRecursos.Compra VALUES (10000, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10001, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10002, '2023-03-11', 'Estufa Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10003, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10004, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10005, '2023-03-11', 'Batidora Blanck&Decker');

INSERT INTO RegistroRecursos.Compra VALUES (10006, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10007, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10008, '2023-03-11', 'Refrigerador Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10009, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10010, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10011, '2023-03-11', 'Bocina Portatil Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10012, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10013, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10014, '2023-03-11', 'PlayStation 5 Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10015, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10016, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10017, '2023-03-11', 'Licuadora');

INSERT INTO RegistroRecursos.Compra VALUES (10018, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10019, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10020, '2023-03-11', 'Cafetera');

INSERT INTO RegistroRecursos.Compra VALUES (10021, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10022, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10023, '2023-03-11', 'Microondas');

INSERT INTO RegistroRecursos.Compra VALUES (10024, '2023-03-11', 'Television Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10025, '2023-03-11', 'Television Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10026, '2023-03-11', 'Television Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10027, '2023-03-11', 'Computadora HP');
INSERT INTO RegistroRecursos.Compra VALUES (10028, '2023-03-11', 'Computadora HP');
INSERT INTO RegistroRecursos.Compra VALUES (10029, '2023-03-11', 'Computadora HP');

---------------------- COMPRAS PARA LA SUCRUSAL CENTRAL ---------------------------------

INSERT INTO RegistroRecursos.Compra VALUES (10030, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10031, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10032, '2023-03-11', 'Estufa Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10033, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10034, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10035, '2023-03-11', 'Batidora Blanck&Decker');

INSERT INTO RegistroRecursos.Compra VALUES (10036, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10037, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10038, '2023-03-11', 'Refrigerador Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10039, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10040, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10041, '2023-03-11', 'Bocina Portatil Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10042, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10043, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10044, '2023-03-11', 'PlayStation 5 Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10045, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10046, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10047, '2023-03-11', 'Licuadora');

INSERT INTO RegistroRecursos.Compra VALUES (10048, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10049, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10050, '2023-03-11', 'Cafetera');

INSERT INTO RegistroRecursos.Compra VALUES (10051, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10052, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10053, '2023-03-11', 'Microondas');

INSERT INTO RegistroRecursos.Compra VALUES (10054, '2023-03-11', 'Television Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10055, '2023-03-11', 'Television Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10056, '2023-03-11', 'Television Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10057, '2023-03-11', 'Computadora HP');
INSERT INTO RegistroRecursos.Compra VALUES (10058, '2023-03-11', 'Computadora HP');
INSERT INTO RegistroRecursos.Compra VALUES (10059, '2023-03-11', 'Computadora HP');

---------------------- COMPRAS PARA LA SUCRUSAL NORTE ---------------------------------

INSERT INTO RegistroRecursos.Compra VALUES (10060, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10061, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10062, '2023-03-11', 'Estufa Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10063, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10064, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10065, '2023-03-11', 'Batidora Blanck&Decker');

INSERT INTO RegistroRecursos.Compra VALUES (10066, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10067, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10068, '2023-03-11', 'Refrigerador Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10069, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10070, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10071, '2023-03-11', 'Bocina Portatil Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10072, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10073, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10074, '2023-03-11', 'PlayStation 5 Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10075, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10076, '2023-03-11', 'Licuadora');
INSERT INTO RegistroRecursos.Compra VALUES (10077, '2023-03-11', 'Licuadora');

INSERT INTO RegistroRecursos.Compra VALUES (10078, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10079, '2023-03-11', 'Cafetera');
INSERT INTO RegistroRecursos.Compra VALUES (10080, '2023-03-11', 'Cafetera');

INSERT INTO RegistroRecursos.Compra VALUES (10081, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10082, '2023-03-11', 'Microondas');
INSERT INTO RegistroRecursos.Compra VALUES (10083, '2023-03-11', 'Microondas');

INSERT INTO RegistroRecursos.Compra VALUES (10084, '2023-03-11', 'Television Samsung');

---------------------- COMPRAS PARA LA SUCRUSAL SUR ---------------------------------

INSERT INTO RegistroRecursos.Compra VALUES (10085, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10086, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10087, '2023-03-11', 'Estufa Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10088, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10089, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10090, '2023-03-11', 'Batidora Blanck&Decker');

INSERT INTO RegistroRecursos.Compra VALUES (10091, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10092, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10093, '2023-03-11', 'Refrigerador Samsung');

INSERT INTO RegistroRecursos.Compra VALUES (10094, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10095, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10096, '2023-03-11', 'Bocina Portatil Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10097, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10098, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10099, '2023-03-11', 'PlayStation 5 Sony');

---------------------------------- COMPRAS PARA LAS VENTAS ---------------------------------------------------

INSERT INTO RegistroRecursos.Compra VALUES (10100, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10101, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10102, '2023-03-11', 'Estufa Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10103, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10104, '2023-03-11', 'Batidora Blanck&Decker');

INSERT INTO RegistroRecursos.Compra VALUES (10105, '2023-03-11', 'Batidora Blanck&Decker');
INSERT INTO RegistroRecursos.Compra VALUES (10106, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10107, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10108, '2023-03-11', 'Refrigerador Samsung');
INSERT INTO RegistroRecursos.Compra VALUES (10109, '2023-03-11', 'Bocina Portatil Sony');

INSERT INTO RegistroRecursos.Compra VALUES (10110, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10111, '2023-03-11', 'Bocina Portatil Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10112, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10113, '2023-03-11', 'PlayStation 5 Sony');
INSERT INTO RegistroRecursos.Compra VALUES (10114, '2023-03-11', 'PlayStation 5 Sony');


---------------------------------- ALIMENTANDO LA BODEGA ------------------------------------------------------

INSERT INTO RegistroRecursos.Bodega VALUES (10000);
INSERT INTO RegistroRecursos.Bodega VALUES (10001);
INSERT INTO RegistroRecursos.Bodega VALUES (10002);

INSERT INTO RegistroRecursos.Bodega VALUES (10003);
INSERT INTO RegistroRecursos.Bodega VALUES (10004);
INSERT INTO RegistroRecursos.Bodega VALUES (10005);

INSERT INTO RegistroRecursos.Bodega VALUES (10006);
INSERT INTO RegistroRecursos.Bodega VALUES (10007);
INSERT INTO RegistroRecursos.Bodega VALUES (10008);

INSERT INTO RegistroRecursos.Bodega VALUES (10009);
INSERT INTO RegistroRecursos.Bodega VALUES (10010);
INSERT INTO RegistroRecursos.Bodega VALUES (10011);

INSERT INTO RegistroRecursos.Bodega VALUES (10012);
INSERT INTO RegistroRecursos.Bodega VALUES (10013);
INSERT INTO RegistroRecursos.Bodega VALUES (10014);

INSERT INTO RegistroRecursos.Bodega VALUES (10015);
INSERT INTO RegistroRecursos.Bodega VALUES (10016);
INSERT INTO RegistroRecursos.Bodega VALUES (10017);

INSERT INTO RegistroRecursos.Bodega VALUES (10018);
INSERT INTO RegistroRecursos.Bodega VALUES (10019);
INSERT INTO RegistroRecursos.Bodega VALUES (10020);

INSERT INTO RegistroRecursos.Bodega VALUES (10021);
INSERT INTO RegistroRecursos.Bodega VALUES (10022);
INSERT INTO RegistroRecursos.Bodega VALUES (10023);

INSERT INTO RegistroRecursos.Bodega VALUES (10024);
INSERT INTO RegistroRecursos.Bodega VALUES (10025);
INSERT INTO RegistroRecursos.Bodega VALUES (10026);

INSERT INTO RegistroRecursos.Bodega VALUES (10027);
INSERT INTO RegistroRecursos.Bodega VALUES (10028);
INSERT INTO RegistroRecursos.Bodega VALUES (10029);

---------------------------------- ALIMENTANDO INVENTARIO DE LA SUCURSAL CENTRAL -----------------------------------

INSERT INTO RegistroRecursos.Inventario VALUES (10030, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10031, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10032, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10033, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10034, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10035, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10036, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10037, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10038, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10039, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10040, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10041, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10042, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10043, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10044, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10045, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10046, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10047, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10048, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10049, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10050, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10051, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10052, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10053, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10054, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10055, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10056, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10057, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10058, 'Sucursal Central', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10059, 'Sucursal Central', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10100, 'Sucursal Central', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10101, 'Sucursal Central', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10102, 'Sucursal Central', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10103, 'Sucursal Central', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10104, 'Sucursal Central', 'VENDIDO');

---------------------------------- ALIMENTANDO INVENTARIO DE LA SUCURSAL NORTE -----------------------------------

INSERT INTO RegistroRecursos.Inventario VALUES (10060, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10061, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10062, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10063, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10064, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10065, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10066, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10067, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10068, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10069, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10070, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10071, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10072, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10073, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10074, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10075, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10076, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10077, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10078, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10079, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10080, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10081, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10082, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10083, 'Sucursal Norte', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10084, 'Sucursal Norte', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10105, 'Sucursal Norte', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10106, 'Sucursal Norte', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10107, 'Sucursal Norte', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10108, 'Sucursal Norte', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10109, 'Sucursal Norte', 'VENDIDO');

------------------------------ ALIMENTANDO EL INVENTARIO DE LA SUCRUSAL SUR -------------------------------

INSERT INTO RegistroRecursos.Inventario VALUES (10085, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10086, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10087, 'Sucursal Sur', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10088, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10089, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10090, 'Sucursal Sur', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10091, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10092, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10093, 'Sucursal Sur', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10094, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10095, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10096, 'Sucursal Sur', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10097, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10098, 'Sucursal Sur', 'DISPONIBLE');
INSERT INTO RegistroRecursos.Inventario VALUES (10099, 'Sucursal Sur', 'DISPONIBLE');

INSERT INTO RegistroRecursos.Inventario VALUES (10110, 'Sucursal Sur', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10111, 'Sucursal Sur', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10112, 'Sucursal Sur', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10113, 'Sucursal Sur', 'VENDIDO');
INSERT INTO RegistroRecursos.Inventario VALUES (10114, 'Sucursal Sur', 'VENDIDO');

------------------------------ REGISTRANDO CLIENTES -------------------------------

INSERT INTO RegistroVentas.Cliente VALUES (1416964, 'Alexis Rodas', 56806572);
INSERT INTO RegistroVentas.Cliente VALUES (1111111, 'Luis Lopez', 12363534);
INSERT INTO RegistroVentas.Cliente VALUES (1010101, 'Edson Prieto', 23467678);
INSERT INTO RegistroVentas.Cliente VALUES (9090909, 'Efrain Rios', 23425663);
INSERT INTO RegistroVentas.Cliente VALUES (5858585, 'Ismael Prego', 23423526);
INSERT INTO RegistroVentas.Cliente VALUES (1231234, 'Nancy Ramirez', 23456565);
INSERT INTO RegistroVentas.Cliente VALUES (8888887, 'Paola Sosa', 23432467);
INSERT INTO RegistroVentas.Cliente VALUES (0005512, 'Nancy Madrid', 78546742);
INSERT INTO RegistroVentas.Cliente VALUES (0000000, 'CF', 00000000);

----------------------------- VENTAS SUCURSAL CENTRAL -----------------------------

INSERT INTO RegistroVentas.Venta VALUES ('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454', 'Sucursal Central', 1, 7000.00, 0.00, 7000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('476ba707-1968-4cbe-a6fb-8cbac641a9a7', 'Sucursal Central', 2, 7000.00, 350.00, 6650.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('8d26e265-24c5-438f-8334-246b09cad087', 'Sucursal Central', 1, 7000.00, 0.00, 7000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('53b15ecd-0557-40af-a269-5fe121019c43', 'Sucursal Central', 3, 600.00, 30.00, 570.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('e8886b27-41e5-44b1-b2df-2cd59a3d5778', 'Sucursal Central', 1, 600.00, 0.00, 600.00, '2023-03-11');

---------------------------- VENTAS SUCURSAL NORTE -------------------------------

INSERT INTO RegistroVentas.Venta VALUES ('bcec5fce-f384-4b75-a696-3166402400c1', 'Sucursal Norte', 5, 600.00, 0.00, 600.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('d5126b9c-e7f3-46b1-904d-9bbce493e42c', 'Sucursal Norte', 5, 10000.00, 0.00, 10000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('817fabed-c538-4c18-ab83-4cedda2fade8', 'Sucursal Norte', 5, 10000.00, 1000.00, 9000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('1c7b6590-a2ed-455a-b6af-721e14be79bc', 'Sucursal Norte', 6, 10000.00, 0.00, 10000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('1c0159b0-2d0b-4967-8a0f-f037825cc1ea', 'Sucursal Norte', 7, 250.00, 25.00, 225.00, '2023-03-11');

---------------------------- VENTAS SUCURSAL SUR -------------------------------

INSERT INTO RegistroVentas.Venta VALUES ('f738bc09-aeb0-4df2-b7cf-d0a27b12028d', 'Sucursal Sur', 9, 250.00, 0.00, 250.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('e62343a9-5162-4281-949b-447677bb4d92', 'Sucursal Sur', 10, 7000.00, 0.00, 7000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('16c206af-164d-434c-b5c5-134b35b5026f', 'Sucursal Sur', 10, 250.00, 0.00, 250.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('20d8d14d-1898-4160-9810-91d5b4741250', 'Sucursal Sur', 10, 7000.00, 0.00, 7000.00, '2023-03-11');
INSERT INTO RegistroVentas.Venta VALUES ('c4e14bd9-eacf-40e0-a1eb-99495712226e', 'Sucursal Sur', 10, 7000.00, 0.00, 7000.00, '2023-03-11');





----------------------------- DESGLOCES VENTAS SUCURSAL CENTRAL -----------------------------

INSERT INTO RegistroVentas.Desgloce VALUES ('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454', 10100, 7000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('476ba707-1968-4cbe-a6fb-8cbac641a9a7', 10101, 7000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('8d26e265-24c5-438f-8334-246b09cad087', 10102, 7000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('53b15ecd-0557-40af-a269-5fe121019c43', 10103, 600.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('e8886b27-41e5-44b1-b2df-2cd59a3d5778', 10104, 600.00);

---------------------------- DESGLOCES VENTASSUCURSAL NORTE -------------------------------

INSERT INTO RegistroVentas.Desgloce VALUES ('bcec5fce-f384-4b75-a696-3166402400c1', 10105, 600.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('d5126b9c-e7f3-46b1-904d-9bbce493e42c', 10106, 10000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('817fabed-c538-4c18-ab83-4cedda2fade8', 10107, 10000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('1c7b6590-a2ed-455a-b6af-721e14be79bc', 10108, 10000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('1c0159b0-2d0b-4967-8a0f-f037825cc1ea', 10109, 250.00);

---------------------------- DESGLOCES VENTAS SUCURSAL SUR -------------------------------

INSERT INTO RegistroVentas.Desgloce VALUES ('f738bc09-aeb0-4df2-b7cf-d0a27b12028d', 10110, 250.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('e62343a9-5162-4281-949b-447677bb4d92', 10114, 7000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('16c206af-164d-434c-b5c5-134b35b5026f', 10111, 250.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('20d8d14d-1898-4160-9810-91d5b4741250', 10112, 7000.00);
INSERT INTO RegistroVentas.Desgloce VALUES ('c4e14bd9-eacf-40e0-a1eb-99495712226e', 10113, 7000.00);



---------------------------- CREACION DE ADQUISICIONES DE LOS CLIENTES -------------------------------

INSERT INTO RegistroVentas.Adquisicion VALUES ('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454', 1416964);
INSERT INTO RegistroVentas.Adquisicion VALUES ('476ba707-1968-4cbe-a6fb-8cbac641a9a7', 1416964);
INSERT INTO RegistroVentas.Adquisicion VALUES ('8d26e265-24c5-438f-8334-246b09cad087', 1111111);
INSERT INTO RegistroVentas.Adquisicion VALUES ('53b15ecd-0557-40af-a269-5fe121019c43', 1111111);
INSERT INTO RegistroVentas.Adquisicion VALUES ('e8886b27-41e5-44b1-b2df-2cd59a3d5778', 1111111);

INSERT INTO RegistroVentas.Adquisicion VALUES ('bcec5fce-f384-4b75-a696-3166402400c1', 1010101);
INSERT INTO RegistroVentas.Adquisicion VALUES ('d5126b9c-e7f3-46b1-904d-9bbce493e42c', 1010101);
INSERT INTO RegistroVentas.Adquisicion VALUES ('817fabed-c538-4c18-ab83-4cedda2fade8', 1010101);
INSERT INTO RegistroVentas.Adquisicion VALUES ('1c7b6590-a2ed-455a-b6af-721e14be79bc', 8888887);
INSERT INTO RegistroVentas.Adquisicion VALUES ('1c0159b0-2d0b-4967-8a0f-f037825cc1ea', 8888887);

INSERT INTO RegistroVentas.Adquisicion VALUES ('f738bc09-aeb0-4df2-b7cf-d0a27b12028d', 0005512);
INSERT INTO RegistroVentas.Adquisicion VALUES ('e62343a9-5162-4281-949b-447677bb4d92', 0005512);
INSERT INTO RegistroVentas.Adquisicion VALUES ('16c206af-164d-434c-b5c5-134b35b5026f', 9090909);
INSERT INTO RegistroVentas.Adquisicion VALUES ('20d8d14d-1898-4160-9810-91d5b4741250', 5858585);
INSERT INTO RegistroVentas.Adquisicion VALUES ('c4e14bd9-eacf-40e0-a1eb-99495712226e', 1231234);