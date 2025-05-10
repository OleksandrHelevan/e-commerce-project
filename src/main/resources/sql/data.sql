CREATE TABLE users
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(100)                     NOT NULL,
    password   VARCHAR(255)                     NOT NULL,
    phone      VARCHAR(20),
    email      VARCHAR(255),
    birth_date DATE,
    sex        ENUM ('MALE', 'FEMALE', 'OTHER') NOT NULL
);

INSERT INTO users (username, password, phone, email, birth_date, sex)
VALUES ('Oleksandr', '$2a$12$fjLiG9PTmDpULekwy11mqeLN3x1e1RlYbz4sMPdlWnuH5Z1CACGGC', '+380981044950',
        'oleksandr@example.com', '2006-03-15', 'MALE'),
       ('Anna', '$2a$12$jkQaoccClqFm5EFKeh87P.GURzTafJV6qva7wxS3oMN7nEPsYdguG', '+380971234567', 'anna@example.com',
        '2000-01-10', 'FEMALE'),
       ('Ivan', '$2a$12$EvnBt2IF1myzw/e8Wbj.reAwPgRNu4t0vCNSRz3WlGg.Nv2FRedZG', '+380931112233', 'ivan@example.com',
        '1998-05-22', 'MALE'),
       ('Maria', '$2a$12$73tORd2YTpaI3qTC7m0/peCslAqVe7U23S0qMo4mOTWUxqVZfqG7W', '+380993334455', 'maria@example.com',
        '2002-07-03', 'FEMALE'),
       ('Petro', '$2a$12$ibPw3dUTByi97acDMWGsPuLlX2eVOBc3/NXiQCThLkUo08NgQAqYy', '+380661234567', 'petro@example.com',
        '1995-11-30', 'MALE'),
       ('Svitlana', '$2a$12$wxiPOHIxXY5wwWfSUWzLhupSowgCArHj6sA.oPMPhqF9GbPiehC1u', '+380992223344',
        'svitlana@example.com', '2001-09-14', 'FEMALE'),
       ('Dmytro', '$2a$12$XTim8RPqP4upyHwLqWQZD.3HCuFZyLYXR8HK8Vk3dCAybqCJdzchK', '+380681234567', 'dmytro@example.com',
        '1999-02-18', 'MALE'),
       ('Anastasiya', '$2a$12$rVuLT8NzdyjyXm6TmllUF.EnOCXXJ3529d1sv/vIASrhErtQZ52P6', '+380671122334',
        'anastasiya@example.com', '2003-06-27', 'FEMALE'),
       ('Yuriy', '$2a$12$7RyRtlenPHBZZ/ua4/PMluWlOLOXYejiuMJ98kD.tnoJg3wma/7yW', '+380951234567', 'yuriy@example.com',
        '1997-03-12', 'MALE'),
       ('Oksana', '$2a$12$1jdja1gm/SlqrKvVyNjqcu494c2G8NIGHmOBFBKAlH3Y8UQzLooOm', '+380991122334', 'oksana@example.com',
        '2000-12-05', 'FEMALE'),
       ('Andriy', '$2a$12$SDBflNG5qV7HUces6l9RieqwY6x8KfYpHtoZ0YvKKZ1iqQRDNVpZy', '+380671234567', 'andrii@example.com',
        '1996-08-08', 'MALE'),
       ('Natalia', '$2a$12$3gsGNiXyiJFSHJaW54YAuOC4QqiBsMXC63FJbkU6nrS5krZLLgsju', '+380931234567',
        'natalia@example.com', '1994-10-21', 'FEMALE');