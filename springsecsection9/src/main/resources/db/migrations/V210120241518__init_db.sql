DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS customer_seq;

CREATE TABLE IF NOT EXISTS customer
(
    customer_id   BIGINT PRIMARY KEY,
    name          TEXT NOT NULL,
    email         TEXT NOT NULL,
    mobile_number TEXT NOT NULL,
    pwd           TEXT NOT NULL,
    role          TEXT NOT NULL,
    create_dt     DATE DEFAULT NULL
);

CREATE SEQUENCE customer_seq START 1;

CREATE TABLE IF NOT EXISTS accounts
(
    account_number BIGINT PRIMARY KEY,
    customer_id    BIGINT NOT NULL,
    account_type   TEXT   NOT NULL,
    branch_address TEXT   NOT NULL,
    create_dt      DATE DEFAULT NULL,

    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS account_transactions
(
    transaction_id      TEXT PRIMARY KEY,
    account_number      BIGINT NOT NULL,
    customer_id         BIGINT NOT NULL,
    transaction_dt      DATE   NOT NULL,
    transaction_summary TEXT   NOT NULL,
    transaction_type    TEXT   NOT NULL,
    transaction_amt     INT    NOT NULL,
    closing_balance     INT    NOT NULL,
    create_dt           DATE DEFAULT NULL,

    CONSTRAINT fk_account_number FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS loans
(
    loan_number        BIGINT PRIMARY KEY,
    customer_id        BIGINT NOT NULL,
    start_dt           DATE   NOT NULL,
    loan_type          TEXT   NOT NULL,
    total_loan         INT    NOT NULL,
    amount_paid        INT    NOT NULL,
    outstanding_amount INT    NOT NULL,
    create_dt          DATE DEFAULT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE SEQUENCE loans_seq START 1;

CREATE TABLE IF NOT EXISTS cards
(
    card_id          BIGINT PRIMARY KEY,
    card_number      TEXT   NOT NULL,
    customer_id      BIGINT NOT NULL,
    card_type        TEXT   NOT NULL,
    total_limit      INT    NOT NULL,
    amount_used      INT    NOT NULL,
    available_amount INT    NOT NULL,
    create_dt        DATE DEFAULT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE SEQUENCE cards_seq START 1;


CREATE TABLE IF NOT EXISTS notice_details
(
    notice_id       BIGINT PRIMARY KEY,
    notice_summary  TEXT NOT NULL,
    notice_details  TEXT NOT NULL,
    notice_begin_dt DATE DEFAULT NULL,
    notice_end_dt   DATE DEFAULT NULL,
    create_dt       DATE DEFAULT NULL,
    update_dt       DATE DEFAULT NULL
);

CREATE SEQUENCE notice_details_seq START 1;

CREATE TABLE IF NOT EXISTS contact_messages(
    contact_id TEXT PRIMARY KEY,
    contact_name TEXT NOT NULL,
    contact_email TEXT NOT NULL,
    subject TEXT NOT NULL,
    message TEXT NOT NULL,
    create_dt DATE DEFAULT NULL
)
