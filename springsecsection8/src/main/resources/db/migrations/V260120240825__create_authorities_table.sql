CREATE TABLE IF NOT EXISTS authorities
(
    id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    name TEXT NOT NULL,

    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE SEQUENCE authorities_seq START 1;