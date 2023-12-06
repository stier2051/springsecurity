create table if not exists customer (
    id BIGINT PRIMARY KEY ,
    email TEXT NOT NULL ,
    pwd TEXT NOT NULL,
    role TEXT NOT NULL);