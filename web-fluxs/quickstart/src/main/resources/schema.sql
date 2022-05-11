DROP TABLE IF EXISTS customer;
create table customer
(
    id bigint auto_increment,
    first_name varchar(255) default '' not null,
    last_name varchar(255) default '' not null,
    constraint customer_pk
        primary key (id)
);

insert into customer value(1,"Chloe","O'Brian");
insert into customer value(3,"Kim", "Bauer");
insert into customer value(5,"David", "Palmer");
insert into customer value(7,"Michelle", "Dessler");
