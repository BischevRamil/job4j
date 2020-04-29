create table meetups (id serial primary key, name varchar(50));
create table users (id serial primary key, name varchar(50), id_meetup integer references meetups(id), status boolean);
