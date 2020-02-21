create table rules (
    id serial primary key,
    rule varchar(50) not null
    );

create table roles (
    id serial primary key,
    role varchar(50) not null
    );

create table role_rules (
    id serial primary key,
    role_id integer references roles(id) not null,
    rule_id integer references rules(id) not null
    );

create table users (
    id serial primary key,
    name varchar(50) not null,
    role_id integer references roles(id) not null
    );

create table category (
    id serial primary key,
    category varchar(50) not null
    );

create table state (
    id serial primary key,
    state varchar(50) not null
    );

create table items (
    id serial primary key,
    user_id integer references users(id) not null,
    category_id integer references category(id) not null,
    state_id integer references state(id) not null
    );

create table comments (
    id serial primary key,
    item_id integer references items(id) not null,
    comment varchar(50)
    );

create table attachs (
    id serial primary key,
    item_id integer references items(id) not null,
    attach varchar(50)
    );

