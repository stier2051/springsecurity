DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS customer_seq;

CREATE TABLE IF NOT EXISTS customer(
    customer_id BIGINT PRIMARY KEY ,
    name TEXT NOT NULL ,
    email TEXT NOT NULL ,
    mobile_number TEXT NOT NULL ,
    pwd TEXT NOT NULL ,
    role TEXT NOT NULL ,
    create_dt date DEFAULT NULL
);

CREATE SEQUENCE customer_seq START 1;

CREATE TABLE IF NOT EXISTS accounts(
    customer_id BIGINT not null REFERENCES customer (customer_id) ON DELETE CASCADE ,
    account_number BIGINT PRIMARY KEY ,
    account_type TEXT NOT NULL ,
    branch_address TEXT NOT NULL ,
    create_dt date DEFAULT NULL
);

