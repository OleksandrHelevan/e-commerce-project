CREATE TABLE phones
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    model_name       VARCHAR(255) NOT NULL,
    memory_capacity  INT          NOT NULL,
    screen_hertz     INT          NOT NULL,
    screen_size      FLOAT        NOT NULL,
    is_used          BOOLEAN      NOT NULL,
    battery_capacity INT          NOT NULL,
    price            FLOAT        NOT NULL,
    tech_condition   ENUM('NEW', 'LIKE_NEW', 'VERY_GOOD', 'GOOD', 'ACCEPTABLE', 'POOR', 'FOR_PARTS') NOT NULL
);

INSERT INTO phones (model_name, memory_capacity, screen_hertz, screen_size,
                    is_used, battery_capacity, price, tech_condition)
VALUES ('iPhone 15 Pro Max', 256, 120, 6.7, false, 100, 1399.99, 'NEW'),
       ('iPhone 14 Pro', 128, 120, 6.1, false, 100, 1099.00, 'NEW'),
       ('iPhone 13 Pro', 128, 120, 6.1, true, 90, 849.00, 'LIKE_NEW'),
       ('iPhone 12', 64, 60, 6.1, true, 80, 599.99, 'VERY_GOOD'),
       ('iPhone 11', 64, 60, 6.1, true, 85, 449.99, 'GOOD'),
       ('iPhone XR', 64, 60, 6.1, true, 75, 349.00, 'ACCEPTABLE'),
       ('iPhone X', 64, 60, 5.8, true, 70, 299.00, 'POOR'),
       ('iPhone 8', 64, 60, 4.7, true, 60, 199.99, 'FOR_PARTS'),
       ('iPhone SE (2022)', 128, 60, 4.7, true, 80, 429.00, 'GOOD'),
       ('iPhone 13 mini', 128, 60, 5.4, false, 100, 699.00, 'NEW');
