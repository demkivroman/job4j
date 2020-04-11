--script for creatting database
create database car;

--script for create table <carbody>
create table carbody(
id serial primary key,
model varchar(200) not null,
type varchar (100) not null,
date date);

--script for create table <engine>
create table engine (
id serial primary key,
model varchar(200) not null,
number varchar(50) not null,
type varchar(100) not null);

--script for create table <transmision>
create table transmission (
    id serial primary key,
    type varchar(100) not null),
    model varchar(200));
    
--script for create vehicle
create table vechicle (
id serial primary key,
model varchar(200) not null,
carbody int unique references carbody(id),
engine int unique references engine(id),
transmission int unique references transmission(id));

--insert into <carbody> 
insert into carbody (model, type, date) values ('lada', 'sedan', '2020-05-01');
insert into carbody (model, type, date) values ('tavria', 'universal', '2020-05-01');
insert into carbody (model, type, date) values ('bmw', 'universal', '2020-05-01');
insert into carbody (model, type, date) values ('renault', 'hechback', '2020-05-01');
insert into carbody (model, type, date) values ('marcidess', 'sedan', '2020-05-01');
insert into carbody (model, type, date) values ('volvo', 'sedan', '2020-05-01');
insert into carbody (model, type, date) values ('hundai', 'sedan', '2020-05-01');
insert into carbody (model, type, date) values ('passat', 'sedan', '2020-05-01');

--insert into <engine> table
insert into engine (model, number, type) values ('lada 1.4 v', '123456789', 'diesal');
insert into engine (model, number, type) values ('bmw 2.0 cdi', '123056789', 'fsi');
insert into engine (model, number, type) values ('hundai 2.0 cdi', '123056789', 'fsi');

--insert into <transmision> table
insert into transmission (type, model) values ('automat', 'lada');
insert into transmission (type, model) values ('mechanic', 'bmw');
insert into transmission (type, model) values ('mechanic', 'passat');
insert into transmission (type, model) values ('tiptronic', 'merceddes');

--insert into <vechicle> table
insert into vechicle (model,carbody,engine,transmission) values ('ladaMT',1,1,1);
insert into vechicle (model,carbody,engine,transmission) values ('BMWsportege',3,2,2);
insert into vechicle (model,carbody,engine,transmission) values ('hundaiJeep',7,3,2);

--select all vechicles and details that correspond them
select v.model,c.model,c.type,e.model,e.type,e.number,t.type,t.model from vechicle v
left join carbody c on v.carbody=c.id
left join engine e on v.engine=e.id
left join transmission t on v.transmission=t.id;

--select all details that are not used to car
select c.model,c.type from carbody c left join vechicle v on v.carbody=c.id where v.carbody is null;
select e.model,e.type,e.number from engine e left join vechicle v on v.engine=e.id where v.engine is null;
select t.model,t.type  from transmission t left join vechicle v on v.transmission=t.id where v.transmission is null;



