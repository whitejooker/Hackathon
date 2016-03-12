drop table user;
drop table city;
drop table complain;
drop table meal;
create table city(
  id int primary key AUTO_INCREMENT,
  name varchar(100) NOT NULL
);

create table user(
  id int PRIMARY KEY AUTO_INCREMENT ,
  username varchar(30) NOT NULL ,
  name varchar(30) NOT NULL ,
  phone VARCHAR(30) NOT NULL ,
  email VARCHAR(30) NOT NULL ,
  password varchar(100) NOT NULL ,
  city_id int REFERENCES city(id),
  is_blocked BOOLEAN NOT NULL DEFAULT FALSE,
  address varchar(100) not null,
  number_of_complains int not null default 0
);

create table meal(
  id int PRIMARY KEY AUTO_INCREMENT ,
  name VARCHAR(30) NOT NULL ,
  description varchar(1000) ,
  date TIMESTAMP ,
  state int not null ,
  type_id int NOT NULL ,
  amount int NOT NULL ,
  is_active BOOLEAN DEFAULT true,
  user_id int REFERENCES user(id) ,
  picture_extension varchar(30) not null

)

create table complain(
  id int primary key AUTO_INCREMENT ,
  name varchar(30) not null ,
  user_id int REFERENCES user(id),
  date TIMESTAMP,
  description varchar(300),
  result BOOLEAN

);