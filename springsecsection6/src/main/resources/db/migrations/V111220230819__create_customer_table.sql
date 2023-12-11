CREATE TABLE IF NOT EXISTS customer(
    customer_id BIGINT PRIMARY KEY ,
    name TEXT NOT NULL ,
    email TEXT NOT NULL ,
    mobile_number TEXT NOT NULL,
    pwd TEXT NOT NULL,
    role TEXT NOT NULL,
    create_dt TIMESTAMP);

INSERT INTO customer (customer_id, name, email, mobile_number, pwd, role, create_dt)
VALUES (nextval('customer_seq'), 'admin', 'admin@mail.kz', '+77771112233', '$2a$12$/pxy6wIn00Cbg0SyMjK4G.YT8tADivqWOvNKoYTz4xTd2cX33X2Ji', 'admin', now());