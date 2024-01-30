CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--account_translations
INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 7, 'Coffee Shop', 'Withdrawal', 30, 34500, current_date - 7);

INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 6, 'Uber', 'Withdrawal', 100, 34400, current_date - 6);

INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 5, 'Self Deposit', 'Deposit', 500, 34900, current_date - 5);

INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 4, 'Ebay', 'Withdrawal', 600, 34300, current_date - 4);

INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 1, 'OnlineTransfer', 'Deposit', 700, 35000, current_date - 2);

INSERT INTO account_transactions(transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type, transaction_amt, closing_balance, create_dt)
VALUES (uuid_generate_v4(), 1865764534, 1, current_date - 1, 'Amazon.com', 'Withdrawal', 100, 34900, current_date - 1);