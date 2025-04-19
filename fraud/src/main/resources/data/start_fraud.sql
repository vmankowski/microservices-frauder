INSERT INTO public.fraud_customer_entity (id, customer_id, is_fraudster, is_terrorist, is_bargary, is_thief, created_at)
VALUES
    (1, 101, true, false, false, true, '2023-10-01T10:00:00'),
    (2, 102, false, true, false, false, '2023-10-02T11:00:00'),
    (3, 103, true, true, true, false, '2023-10-03T12:00:00'),
    (4, 104, false, false, true, true, '2023-10-04T13:00:00'),
    (5, 105, true, false, true, true, '2023-10-05T14:00:00');