create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

create table roles (
    id serial primary key,
    name varchar(200) not null unique
);

create table users (
    id serial primary key,
    username varchar(200) unique,
    password varchar(200),
    enabled boolean,
    role_id int references roles(id)
);