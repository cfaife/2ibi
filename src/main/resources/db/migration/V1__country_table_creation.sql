create  table country(
    id bigint not null primary key auto_increment,
    name varchar unique,
    capital varchar,
    region varchar,
    sub_region varchar,
    area varchar
);
