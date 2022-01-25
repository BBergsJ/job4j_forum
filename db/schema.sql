create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');

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

insert into roles(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into users(username, password, enabled, role_id) values ('root',
'$2a$10$706agRx2D5UbIgSugPn8NechD/uymTVh37vGTvR6sUA.eWPvV2pRS', true,
(select id from roles where name = 'ROLE_ADMIN'));