CREATE DATABASE Друзья_человека;
USE Друзья_человека;

-- создаём низкоуровневые таблицы

CREATE TABLE Cats (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10)
);
CREATE TABLE Dogs (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10)
);
CREATE TABLE Hamsters (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10)
);
CREATE TABLE Camels (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    capacity INTEGER
);
CREATE TABLE Horses (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    capacity INTEGER
);
CREATE TABLE Donkeys (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    capacity INTEGER
);

-- вставляем во все низкоуровневые таблицы колонку "навык"

ALTER TABLE Cats ADD COLUMN skill VARCHAR(20) AFTER color;
ALTER TABLE Dogs ADD COLUMN skill VARCHAR(20) AFTER color;
ALTER TABLE Hamsters ADD COLUMN skill VARCHAR(20) AFTER color;
ALTER TABLE Camels ADD COLUMN skill VARCHAR(20) AFTER color;
ALTER TABLE Horses ADD COLUMN skill VARCHAR(20) AFTER color;
ALTER TABLE Donkeys ADD COLUMN skill VARCHAR(20) AFTER color;

-- заполняем низкоуровневые таблицы данными

INSERT INTO Cats (name, birthday, color, skill) 
VALUES
('Рыжик', '2020-10-10', 'рыжий', 'мяукает'),
('Мурзик', '2016-03-25', 'полосатый', 'крепко спит'),
('Даша', '2012-11-04', 'белая', 'царапается');

INSERT INTO Dogs (name, birthday, color, skill) 
VALUES
('Шарик', '2014-12-08', 'серый', 'сидит на цепи'),
('Бобик', '2018-05-29', 'чёрный', 'лает'),
('Треф', '2012-11-04', 'белый', 'приносит тапки');

INSERT INTO Hamsters (name, birthday, color, skill) 
VALUES
('Дуся', '2022-01-11', 'рыжий', 'много ест'),
('Хома', '2023-01-05', 'белый', 'самый маленький'),
('Антон', '2022-12-10', 'пятнистый', 'кусается');

INSERT INTO Camels (name, birthday, color, skill, capacity) 
VALUES
('Шаруф', '2007-07-11', 'бежевый', 'плюётся', 100),
('Зара', '2011-08-01', 'песочный', 'убегает', 40),
('Бабур', '2010-11-07', 'белый', 'жуёт', 80);

INSERT INTO Horses (name, birthday, color, skill, capacity) 
VALUES
('Леди', '2018-01-02', 'вороная', 'гарцует', 60),
('Верный', '2020-03-02', 'гнедой', 'жеребёнок', 10),
('Быстрый', '2014-10-03', 'белый', 'иноходец', 70);

INSERT INTO Donkeys (name, birthday, color, skill, capacity) 
VALUES
('Лаки', '2016-08-07', 'серый', 'упрямится', 30),
('Люк', '2018-02-02', 'пегий', 'крикливый', 40),
('Лео', '2018-11-27', 'белый', 'сговорчивый', 45);

-- удаляем таблицу с верблюдами, уехавшими на юг

DROP TABLE Camels;

-- создаём табличку "Вьючные животные"

CREATE TABLE Beasts (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    skill VARCHAR(20),
    capacity INTEGER
);

-- вставляем в неё содержимое таблиц "Ослы" и "Лошади"

INSERT INTO Beasts (name, birthday, color, skill, capacity)
SELECT name, birthday, color, skill, capacity FROM Horses
UNION ALL
SELECT name, birthday, color, skill, capacity FROM Donkeys;

-- создаём таблицу "Молодняк"

CREATE TABLE Youngsters (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    skill VARCHAR(20),
    age INTEGER,
    kind VARCHAR(10)
);

-- вставляем в неё всех животных младше 3 лет, но старше года

INSERT INTO Youngsters(name, birthday, color, skill, age, kind)
SELECT name, birthday, color, skill, DATEDIFF(CURDATE(), birthday) DIV 30 AS age, 'donkey' AS kind FROM Donkeys
WHERE birthday BETWEEN CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR
UNION ALL
SELECT name, birthday, color, skill, DATEDIFF(CURDATE(), birthday) DIV 30 AS age, 'horse' AS kind FROM Horses
WHERE birthday BETWEEN CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR
UNION ALL
SELECT name, birthday, color, skill, DATEDIFF(CURDATE(), birthday) DIV 30 AS age, 'dog' AS kind FROM Dogs
WHERE birthday BETWEEN CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR
UNION ALL
SELECT name, birthday, color, skill, DATEDIFF(CURDATE(), birthday) DIV 30 AS age, 'cat' AS kind FROM Cats
WHERE birthday BETWEEN CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR
UNION ALL
SELECT name, birthday, color, skill, DATEDIFF(CURDATE(), birthday) DIV 30 AS age, 'hamster' AS kind FROM Hamsters
WHERE birthday BETWEEN CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR;

-- создаём табличку для объединения
CREATE TABLE Animals (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    color VARCHAR(10),
    skill VARCHAR(20),
    kind VARCHAR(10)
);

-- объединяем все таблички животных

INSERT INTO Animals(name, birthday, color, skill, kind)
SELECT name, birthday, color, skill, 
       'donkey' AS kind
  FROM Donkeys
UNION
SELECT name, birthday, color, skill, 
       'horse' AS kind
  FROM Horses
UNION
SELECT name, birthday, color, skill, 
       'dog' AS kind
  FROM Dogs
UNION
SELECT name, birthday, color, skill, 
       'cat' AS kind
  FROM Cats
UNION
SELECT name, birthday, color, skill, 
       'hamster' AS kind
  FROM Hamsters;
  







