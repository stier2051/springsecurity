--cards
INSERT INTO cards (card_id, card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES (nextval('cards_seq'), '4565XXXX4656', 1, 'Credit', 10000, 500, 9500, current_date);

INSERT INTO cards (card_id, card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES (nextval('cards_seq'), '3455XXXX8673', 1, 'Credit', 7500, 600, 6900, current_date);

INSERT INTO cards (card_id, card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES (nextval('cards_seq'), '2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, current_date);