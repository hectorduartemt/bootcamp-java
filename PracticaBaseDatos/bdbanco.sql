use banco;
drop table if exists clientes;

create table if not exists clientes(
	idCliente int not null auto_increment,
	nombreCli varchar(45) not null,
	direccionCli varchar(45) not null,
	ciudadCli varchar(45) not null,
	producto int not null,
	primary key (idCliente)
	
);

drop table if exists empleados;
create table if not exists empleados(
	idEmpleado int not null auto_increment,
	nombreEmp varchar(45) not null,
	telefonoEmp varchar(45) not null,
	subordinadoEmp varchar(45) not null,
	fechaIngresoEmp datetime not null,
	idSupervisor int not null,
	cliente int not null,
	primary key(idEmpleado)
	
);

drop table if exists productos;
create table if not exists productos(
	idProducto int not null auto_increment,
	numProducto varchar(45) not null,
	tipoProducto varchar(45) not null,
	cliente int not null,
	primary key(idProducto)
);


drop table if exists sucursales;
create table if not exists sucursales(
	nombreSuc varchar(45) not null,
	ciudadSuc varchar(45) not null,
	empleado int not null,
	primary key(nombreSuc, ciudadSuc)
);

alter table clientes add constraint fk_producto_cliente foreign key (producto)
references productos(idProducto) on delete cascade on update cascade;

alter table empleados add constraint fk_cliente_asociado foreign key (cliente)
references clientes(idCliente) on delete cascade on update cascade;

alter table productos add constraint fk_cliente_producto foreign key (cliente)
references clientes(idCliente) on delete cascade on update cascade;

alter table sucursales  add constraint fk_empleado_sucursal foreign key (empleado)
references empleados(idEmpleado) on delete cascade on update cascade;



