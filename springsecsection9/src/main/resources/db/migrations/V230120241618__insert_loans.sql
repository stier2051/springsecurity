--loans
INSERT INTO loans (loan_number, customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (nextval('loans_seq'), 1, current_date, 'Home', 200000, 50000, 150000, current_date);

INSERT INTO loans (loan_number, customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (nextval('loans_seq'), 1, current_date, 'Vehicle', 40000, 10000, 30000, current_date);

INSERT INTO loans (loan_number, customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (nextval('loans_seq'), 1, current_date, 'Home', 50000, 10000, 40000, current_date);

INSERT INTO loans (loan_number, customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (nextval('loans_seq'), 1, current_date, 'Personal', 10000, 3500, 6500, current_date);