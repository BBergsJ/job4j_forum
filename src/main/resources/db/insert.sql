insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');

insert into roles(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into users(username, password, enabled, role_id) values ('root',
         '$2a$10$706agRx2D5UbIgSugPn8NechD/uymTVh37vGTvR6sUA.eWPvV2pRS',
         true,
        (select id from roles where name = 'ROLE_ADMIN'));