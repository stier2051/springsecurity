INSERT INTO customer(customer_id, name, email, mobile_number, pwd, role, create_dt)
VALUES (nextval('customer_seq'), 'Hally', 'happy@example.com', '77772221133', '$2a$12$RGx/O9.E0eUIKnnUho8xVuXK035lmDF2K0CPOlWPzAZNwk6c50RRe', 'admin', current_date);

INSERT INTO accounts(customer_id, account_number, account_type, branch_address, create_dt)
VALUES (1, 186576453434, 'Savings', '123 Main Street, New York', current_date);