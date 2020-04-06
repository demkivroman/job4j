create database items_system with encoding='utf8' owner=postgres;

create table users (
    user_id serial primary key,
    name varchar(50) not null,
    login varchar(50) not null
    );
    
alter table users add column role_id integer references role(role_id);

create table state (
    state_id serial primary key,
    state bool);
    
create table category(cat_id serial primary key, category int);

create table item (
item_id serial primary key,
user_id int references users(user_id),
category_id int references category(cat_id),
state_id int references state(state_id),
name varchar(50),
date date
);
create table attaches(
atach_id serial primary key,
file varchar(100),
date date,
item_id int references item(item_id));

create table comments(
comment_id serial primary key,
item_id int references item(item_id),
comment text,
date date);
create table rules(rule_id serial primary key, name varchar(50));

create table role_rules (rr_id serial primary key, 
role_id int references role(role_id),
rule_id int references rules(rule_id)
);

insert into role (name) values ('role1');
insert into role (name) values ('role2');

insert into users (name, login, role_id) values ('Roman Demkiv', 'dyoma', 1);
insert into users (name, login, role_id) values ('Taras Demkiv', 'dyoma', 1);

items_system=# insert into rules (name) values ('rule1');
INSERT 0 1
items_system=# insert into rules (name) values ('rule2');

insert into role_rules (role_id, rule_id) values (1,2);
INSERT 0 1
items_system=# insert into role_rules (role_id, rule_id) values (2,2);

insert into state (state) values (true);
INSERT 0 1
items_system=# insert into state (state) values (false);

insert into category (category) values(10);
INSERT 0 1
items_system=# insert into category (category) values(20);

insert into item (user_id, category_id, state_id, name, date) values(1,1,1,'item1','2020-05-04');

insert into comments (item_id, comment, date) values (1, 'some large comment', '2020-12-25');

insert into attaches (file, date, item_id) values ('C:/projects/job4j/...','2020-10-01',1);





