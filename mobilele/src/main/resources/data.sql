-- some test users

INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', 1, '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi');


INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (1, 2);


INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');

INSERT INTO offers (id, offer_id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id)
VALUES
    (1, '5ebdd23e-7bf3-4166-ab67-98242b871f6a', 'Качваш са, караш са, отиваш на фиеста 1. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320001, 2601, 'MANUAL', 2005, 1, 1),
    (2, '5ebdd23e-7bf3-4166-ab67-98242b871f6b', 'Качваш са, караш са, отиваш на фиеста 2. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320002, 2602, 'MANUAL', 2005, 1, 1),
    (3, '5ebdd23e-7bf3-4166-ab67-98242b871f6c', 'Качваш са, караш са, отиваш на фиеста 3. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320003, 2603, 'MANUAL', 2005, 1, 1),
    (4, '5ebdd23e-7bf3-4166-ab67-98242b871f6d', 'Качваш са, караш са, отиваш на фиеста 4. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320004, 2605, 'MANUAL', 2005, 1, 1),
    (5, '5ebdd23e-7bf3-4166-ab67-98242b871f6e', 'Качваш са, караш са, отиваш на фиеста 5. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320005, 2604, 'MANUAL', 2005, 1, 1),
    (6, '5ebdd23e-7bf3-4166-ab67-98242b871f6f', 'Качваш са, караш са, отиваш на фиеста 6. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320006, 2606, 'MANUAL', 2005, 1, 1),
    (7, '5ebdd23e-7bf3-4166-ab67-98242b871f60', 'Качваш са, караш са, отиваш на фиеста 7. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320007, 2607, 'MANUAL', 2005, 1, 1),
    (8, '5ebdd23e-7bf3-4166-ab67-98242b871f61', 'Качваш са, караш са, отиваш на фиеста 8. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320008, 2609, 'MANUAL', 2005, 1, 1),
    (9, '5ebdd23e-7bf3-4166-ab67-98242b871f62', 'Качваш са, караш са, отиваш на фиеста 9. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320009, 2640, 'MANUAL', 2005, 1, 1),
    (10, '5ebdd23e-7bf3-4166-ab67-98242b871f63', 'Качваш са, караш са, отиваш на фиеста 10. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320010, 2630, 'MANUAL', 2005, 1, 1),
    (11, '5ebdd23e-7bf3-4166-ab67-98242b871f64', 'Качваш са, караш са, отиваш на фиеста 11. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320011, 2633, 'MANUAL', 2005, 1, 1),
    (12, '5ebdd23e-7bf3-4166-ab67-98242b871f65', 'Качваш са, караш са, отиваш на фиеста 12. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320012, 2654, 'MANUAL', 2005, 1, 1),
    (13, '5ebdd23e-7bf3-4166-ab67-98242b871f66', 'Качваш са, караш са, отиваш на фиеста 13. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320013, 2612, 'MANUAL', 2005, 1, 1);