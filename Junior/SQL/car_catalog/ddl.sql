
create table car_body(
    id serial primary key,
    name varchar(30) not null
    );

create table car_engine (
    id serial primary key,
    name varchar(30) not null
    );

create table car_transmission (
    id serial primary key,
    name varchar(30) not null
    );

create table car (
    id serial primary key,
    name varchar(30) not null,
    body_id integer not null references car_body(id),
    engine_id integer not null references car_engine(id),
    transmission_id integer not null references car_transmission(id)
    );



