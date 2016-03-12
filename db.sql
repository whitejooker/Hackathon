DROP TABLE user;
DROP TABLE city;
DROP TABLE complain;
DROP TABLE food;

CREATE TABLE city (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE user (
  id                  INT PRIMARY KEY       AUTO_INCREMENT,
  username            VARCHAR(30)  NOT NULL,
  name                VARCHAR(30)  NOT NULL,
  phone               VARCHAR(30)  NOT NULL,
  email               VARCHAR(30)  NOT NULL,
  password            VARCHAR(100) NOT NULL,
  city_id             INT REFERENCES city (id),
  is_blocked          BOOLEAN      NOT NULL DEFAULT FALSE,
  address             VARCHAR(100) NOT NULL,
  number_of_complains INT          NOT NULL DEFAULT 0
);

DROP TABLE food;
CREATE TABLE food (
  id                INT PRIMARY KEY AUTO_INCREMENT,
  name              VARCHAR(30) NOT NULL,
  description       VARCHAR(1000),
  price             DOUBLE NOT NULL ,
  date              TIMESTAMP,
  state             INT         NOT NULL,
  type_id           INT         NOT NULL,
  amount            INT         NOT NULL,
  is_active         BOOLEAN         DEFAULT TRUE,
  user_id           INT REFERENCES user (id),
  picture_extension VARCHAR(30) NOT NULL

);

CREATE TABLE complain (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(30) NOT NULL,
  user_id     INT REFERENCES user (id),
  date        TIMESTAMP,
  description VARCHAR(300),
  result      BOOLEAN

);

INSERT INTO city VALUE (NULL, "Baku"), (NULL, "Ganja");
