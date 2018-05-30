CREATE DATABASE IF NOT EXISTS sega_account;
USE sega_account;


CREATE TABLE IF NOT EXISTS type(
    id_type int NOT NULL,
    label VARCHAR(25),
    PRIMARY KEY (id_type)
);

CREATE TABLE IF NOT EXISTS agency(
    id_agency int NOT NULL,
    address VARCHAR(255),
    PRIMARY KEY (id_agency)
);


CREATE TABLE IF NOT EXISTS account(
    id_account int NOT NULL,
    balance FLOAT NULL,
    overdraft FLOAT NULL,
    interestRate FLOAT NULL,
    raye FLOAT NULL,
    id_agency int,
    id_type int,
    PRIMARY KEY (id_account),
    FOREIGN KEY (id_agency) REFERENCES agency(id_agency),
    FOREIGN KEY (id_type) REFERENCES type(id_type)
);