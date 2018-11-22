/*https://www.codewars.com/collections/sql-for-beginners*/


-- Part 1:
SELECT * FROM users WHERE age>=18;


-- Part 2:
SELECT * from travelers WHERE country NOT IN ('Canada', 'Mexico', 'USA');


-- Part 3:
INSERT INTO participants
            (name, age, attending)
VALUES      ('Adam', 32, true);

SELECT * FROM participants;


-- Part 4:
SELECT * FROM students WHERE tuition_received=false;


-- Part 5:
SELECT * FROM books ORDER BY copies_sold DESC LIMIT 5;
