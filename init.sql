DROP DATABASE IF EXISTS golf_docker_2025;
CREATE DATABASE golf_docker_2025;
USE golf_docker_2025;

DROP TABLE IF EXISTS tournament_participants;
DROP TABLE IF EXISTS tournaments;
DROP TABLE IF EXISTS members;

CREATE TABLE members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    email_address VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    start_of_membership_date DATE,
    duration_of_membership_in_days INT
);

CREATE TABLE tournaments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    location VARCHAR(100) NOT NULL,
    entry_fee DOUBLE,
    cash_prize_amount DOUBLE
);

CREATE TABLE tournament_participants (
    tournament_id BIGINT,
    member_id BIGINT,
    PRIMARY KEY (tournament_id, member_id),
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE
);

INSERT INTO members (first_name, last_name, address, email_address, phone_number, start_of_membership_date, duration_of_membership_in_days)
VALUES
    ('John', 'Doe', '123 Green St, Springfield', 'john.doe@example.com', '555-1234', '2024-01-01', 365),
    ('Jane', 'Smith', '456 Fairway Dr, Lakeside', 'jane.smith@example.com', '555-5678', '2024-02-15', 730),
    ('Michael', 'Johnson', '789 Golf Ln, Hilltown', 'michael.j@example.com', '555-9101', '2023-11-20', 180);

INSERT INTO tournaments (start_date, end_date, location, entry_fee, cash_prize_amount)
VALUES
    ('2025-04-10', '2025-04-12', 'Pebble Beach', 100.00, 5000.00),
    ('2025-06-15', '2025-06-17', 'Augusta National', 150.00, 10000.00);

INSERT INTO tournament_participants (tournament_id, member_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 1);
