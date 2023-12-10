INSERT INTO cars (id, brand, model, year, rating, fuel, transmission, image_url, description)
VALUES (1, 'Mercedes', 'S-class', '2020', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-1.jpg', 'The S-Class Sedan combines a broad selection of elegant materials with fine surfaces. Innovative technology and high-resolution screens lend it a progressive character. Furthermore, high-tech and infotainment are presented with a user-friendly architecture.'),
       (2, 'Range Rover', 'Evoque', '2019', '4', 'HYBRID', 'AUTOMATIC', '/images/car-2.jpg', 'The Range Rover Evoque is a small, premium SUV that you should consider if you want stylish looks, a high-tech interior and the ability to traipse off-road.'),
       (3, 'McLaren', '720s', '2021', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-3.jpg', 'The McLaren 720S features twin-hinged butterfly doors and many design features from the McLaren F1. The headlights hide air vents that funnel incoming air to two small radiators in front of the wheels. The doors feature air channels that direct air to the engine.'),
       (4, 'Ford', 'Mustang', '1967', '4', 'GASOLINE', 'MANUAL', '/images/car-4.jpg', 'Shelby believed the Mustang had great potential with some modifications. Shelby took the Ford Mustang and changed the engine, transmission, exhaust, suspension and more to create the 1965 Shelby GT350. The result was a high-performance variant of the Mustang that was designed for speed and power.'),
       (5, 'Rolls-Royce', 'Cullinan', '2021', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-5.jpg', 'The Rolls-Royce Cullinan is the first SUV Rolls-Royce has ever produced, named after the world`s largest uncut diamond. It is an absolutely vast 4x4 and one of the most luxurious cars of any kind. It is certainly a huge departure for the luxury British carmaker, which has a long history of producing sumptuous saloons.'),
       (6, 'Bentley', 'Continental GT', '2022', '4', 'HYBRID', 'AUTOMATIC', '/images/car-6.jpg', 'Bentley Continental GT stands for grand, a type of car that is designed for both long-distance driving and high speeds in mind. That vehicle combines luxury and performance attributes.'),
       (7, 'Ferrari', 'Enzo', '2002', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-7.jpg', 'The Enzo was a technological marvel of its time. Like the Ferrari F50 that preceded it, the Enzo featured technology developed from Formula 1, including a carbon-fiber tub, push-rod suspension, carbon-ceramic brakes, and Ferrari`s 6-speed “F1” automated manual.'),
       (8, 'Lamborghini', 'Urus', '2022', '4', 'GASOLINE', 'AUTOMATIC', '/images/car-8.jpg', 'The soul of a super sports car and the functionality of an SUV: Lamborghini Urus is the first Super Sport Utility Vehicle in the world. With extreme proportions, breathtaking design, extraordinary driving dynamics and heart-pounding performance, Urus represents freedom in its quintessential state.'),
       (9, 'Mercedes', 'AMG GT', '2021', '4', 'GASOLINE', 'AUTOMATIC', '/images/car-9.jpg', 'The new Mercedes-AMG GT Coupe borrows much of its brains and muscle from the SL roadster. The new GT Coupe is longer, wider, and has a longer wheelbase than before, but the big news is its standard all-wheel-drive system is something the AMG GT has never offered before.'),
       (10, 'Mercedes', 'AMG GTR', '2020', '4', 'GASOLINE', 'AUTOMATIC', '/images/car-10.jpg', 'The Mercedes-AMG GTR  offers 585 hp V8 biturbo engine, adjustable coil-over suspension with active rear axle steering, active aerodynamics and intelligent lightweight construction form the foundations for highly dynamic handling characteristics and unique sport experience.'),
       (11, 'Mercedes', 'Maybach', '2023', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-11.jpg', 'Maybach vehicles are known for their quality and luxury, and they are often used by royalty and dignitaries. This car is long and large, with spacious interior and plenty of luxury features that are standard in the Maybach we couldn`t possibly list them all here.'),
       (12, 'Mercedes', 'G-class', '2022', '5', 'GASOLINE', 'AUTOMATIC', '/images/car-12.jpg', 'The G-class is the best SUV in the Mercedes-Benz line-up and probably in the world too. The G-class model is as luxurious as you would expect a Mercedes SUV to be but remains true to its heritage with incredible off-road ability. Permanent four-wheel drive and three lockable differentials are standard fit.');


INSERT INTO specifications (id, per_day_price, per_hour_price, per_month_price, mileage, seats, luggage_capacity, car_id)
VALUES (1, '350', '89', '2000', '20000', '4', '8', '1'),
       (2, '280', '70', '1700', '25000', '4', '4', '2'),
       (3, '400', '100', '2700', '10000', '2', '1', '3'),
       (4, '300', '80', '1850', '50000', '2', '3', '4'),
       (5, '450', '120', '3000', '12000', '5', '8', '5'),
       (6, '410', '105', '2350', '10000', '2', '2', '6'),
       (7, '600', '180', '7500', '15000', '2', '1', '7'),
       (8, '430', '110', '2900', '14000', '5', '6', '8'),
       (9, '330', '85', '1950', '18000', '2', '2', '9'),
       (10, '360', '95', '2100', '22000', '2', '2', '10'),
       (11, '500', '140', '3500', '8000', '4', '8', '11'),
       (12, '580', '170', '5700', '10000', '5', '6', '12');


INSERT INTO users (id, email, password, first_name, last_name, image_url)
VALUES (1, 'user1@.abv.bg', '12345', 'John', 'John', '/images/person_1.jpg'),
       (2, 'user2@.abv.bg', '12345', 'Mark', 'Mark', '/images/person_2.jpg'),
       (3, 'user3@.abv.bg', '12345', 'Bob', 'Bob', '/images/person_3.jpg'),
       (4, 'user4@.abv.bg', '12345', 'Jeramy', 'Jeramy', '/images/person_4.jpg'),
       (5, 'user5@.abv.bg', '12345', 'Justin', 'Justin', '/images/person_5.jpg'),
       (6, 'user6@.abv.bg', '12345', 'Frank', 'Frank', '/images/person_1.jpg'),
       (7, 'user7@.abv.bg', '12345', 'Philip', 'Philip', '/images/person_2.jpg'),
       (8, 'user8@.abv.bg', '12345', 'Jake', 'Jake', '/images/person_3.jpg'),
       (9, 'user9@.abv.bg', '12345', 'Brian', 'Brian', '/images/person_4.jpg'),
       (10, 'user10@.abv.bg', '12345', 'Stanley', 'Stanley', '/images/person_5.jpg'),
       (11, 'user11@.abv.bg', '12345', 'Vincent', 'Vincent', '/images/person_2.jpg'),
       (12, 'user12@.abv.bg', '12345', 'Derek', 'Derek', '/images/person_3.jpg');


INSERT INTO reviews (id, posted_on, rating, text, car_id, user_id)
VALUES (1, '20.10.2021', '5', 'It was a great experience', '1', '1'),
       (2, '20.10.2021', '5', 'It was a great experience', '1', '2'),
       (3, '20.10.2021', '5', 'It was a great experience', '1', '3'),
       (4, '20.10.2021', '5', 'It was a great experience', '1', '4'),
       (5, '20.10.2021', '5', 'It was a great experience', '2', '1'),
       (6, '20.10.2021', '5', 'It was a great experience', '2', '2'),
       (7, '20.10.2021', '5', 'It was a great experience', '3', '3'),
       (8, '20.10.2021', '5', 'It was a great experience', '3', '4'),
       (9, '20.10.2021', '5', 'It was a great experience', '4', '1'),
       (10, '20.10.2021', '5', 'It was a great experience', '5', '1'),
       (11, '20.10.2021', '5', 'It was a great experience', '7', '1'),
       (12, '20.10.2021', '5', 'It was a great experience', '7', '2');

INSERT INTO chauffeurs (id, name, surname, gender, age, rating, price_per_hour, image_url)
VALUES (1, 'Frank', 'Martin', 'male', '42', '4', '40', '/images/chauffeur.jpg'),
       (2, 'Jeffrey', 'McDonald', 'male', '27', '4', '38', '/images/chauffeur_1.jpg'),
       (3, 'James', 'Howard', 'male', '34', '4', '35', '/images/chauffeur_2.jpg'),
       (4, 'Michael', 'Harris', 'male', '36', '5', '35','/images/chauffeur_5.jpg'),
       (5, 'David', 'Hudson', 'male', '28', '5', '40','/images/chauffeur_6.jpg'),
       (6, 'Andrew', 'Matthews', 'male', '34', '4', '37', '/images/chauffeur_7.jpg'),
       (7, 'Joseph', 'Knight', 'male', '50', '5', '38', '/images/chauffeur_3.jpg'),
       (8, 'Oliver', 'Wood', 'male', '35', '3', '30', '/images/chauffeur_4.jpg'),
       (9, 'Paul', 'Davis', 'male', '39', '4', '33', '/images/chauffeur_8.jpg'),
       (10, 'Ryan', 'Evans', 'male', '30', '5', '32', '/images/chauffeur_9.jpg'),
       (11, 'Emily', 'Thomas', 'female', '27', '5', '32', '/images/chauffeur_10.jpg'),
       (12, 'Alexandra', 'Brooks', 'female', '34', '5', '34', '/images/chauffeur_11.jpg');