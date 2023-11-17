INSERT INTO cars (id, brand, model, year, rating, image_url)
VALUES (1, 'Mercedes', 'S-class', '2020', '5', '/images/car-1.jpg'),
       (2, 'Range Rover', 'Evoque', '2019', '4', '/images/car-2.jpg'),
       (3, 'McLaren', '720s', '2021', '5', '/images/car-3.jpg'),
       (4, 'Mercedes', 'AMG GT', '2021', '5', '/images/car-9.jpg'),
       (5, 'Mercedes', 'AMG GTR', '2014', '5', '/images/car-10.jpg'),
       (6, 'Mercedes', 'Maybach', '2023', '5', '/images/car-1.jpg'),
       (7, 'Mercedes', 'G-class', '2022', '5', '/images/car-1.jpg');


INSERT INTO offers (id, per_day_price, per_hour_price, per_month_price, cars_id)
VALUES (1, '350', '89', '2000', '1'),
       (2, '280', '70', '1700', '2'),
       (3, '400', '100', '2300', '3'),
       (4, '330', '80', '1900', '4'),
       (5, '450', '120', '2500', '5'),
       (6, '570', '150', '3300', '6'),
       (7, '480', '130', '3000', '7');