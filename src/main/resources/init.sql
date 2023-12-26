DROP TABLE IF EXISTS `CITY_TEMPERATURE`;

CREATE TABLE IF NOT EXISTS `CITY_TEMPERATURE`
(
    `name` VARCHAR(50) NOT NULL,
    `temperature` VARCHAR(50) NOT NULL,
    `unit` VARCHAR(50) NOT NULL
);

INSERT INTO CITY_TEMPERATURE (`name`, `temperature`, `unit`)
VALUES ('Istanbul', '8', 'CELCIUS');

INSERT INTO CITY_TEMPERATURE (`name`, `temperature`, `unit`)
VALUES ('Prag', '10', 'CELCIUS');

INSERT INTO CITY_TEMPERATURE (`name`, `temperature`, `unit`)
VALUES ('Los Angeles', '9', 'CELCIUS');

INSERT INTO CITY_TEMPERATURE (`name`, `temperature`, `unit`)
VALUES ('Kiev',  '-5', 'FAHRENHEIT');