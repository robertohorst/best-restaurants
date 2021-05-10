DROP TABLE IF EXISTS Restaurant;
CREATE TABLE Restaurant
(
  name varchar(255),
  customer_rating INT,
  distance INT,
  price INT,
  cuisine_id BIGINT
) 
AS 
SELECT * FROM CSVREAD ('static/restaurants.csv');

DROP TABLE IF EXISTS Cuisine;
CREATE TABLE Cuisine
(
  id bigint primary key,
  name varchar(100)
) 
AS 
SELECT * FROM CSVREAD ('static/cuisines.csv');