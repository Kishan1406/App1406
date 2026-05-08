CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(8,2),
    available_copies INT
);

CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(100),
    phone VARCHAR(15),
    join_date DATE
);

CREATE TABLE issued_books (
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    book_id INT,
    issue_date DATE,
    return_date DATE,
    status VARCHAR(20),

    FOREIGN KEY(member_id) REFERENCES members(member_id),
    FOREIGN KEY(book_id) REFERENCES books(book_id)
);

CREATE TABLE fines (
    fine_id INT PRIMARY KEY AUTO_INCREMENT,
    issue_id INT,
    fine_amount DECIMAL(8,2),

    FOREIGN KEY(issue_id) REFERENCES issued_books(issue_id)
);


INSERT INTO books(title, author, category, price, available_copies)
VALUES
('Java Basics','James Gosling','Programming',450,10),
('MySQL Guide','John Smith','Database',500,8),
('Aptitude Master','RS Aggarwal','Aptitude',350,15);


INSERT INTO members(member_name, phone, join_date)
VALUES
('Kishan','9876543210','2025-01-10'),
('Rahul','9876543211','2025-02-15');


INSERT INTO issued_books(member_id, book_id, issue_date, return_date, status)
VALUES
(1,1,'2025-03-01','2025-03-10','Returned'),
(2,2,'2025-03-05',NULL,'Issued');

/* View*/
SELECT * FROM books;

SELECT title, available_copies
FROM books
WHERE available_copies > 0;

/* Join */
SELECT
    m.member_name,
    b.title,
    i.issue_date,
    i.status
FROM members m
INNER JOIN issued_books i
ON m.member_id = i.member_id
INNER JOIN books b
ON i.book_id = b.book_id;


SELECT
    member_id,
    COUNT(*) AS total_books
FROM issued_books
GROUP BY member_id;


SELECT *
FROM issued_books
WHERE status = 'Returned';


/* View Concept */

CREATE VIEW library_report AS
SELECT
    m.member_name,
    b.title,
    i.issue_date,
    i.status
FROM members m
JOIN issued_books i
ON m.member_id = i.member_id
JOIN books b
ON i.book_id = b.book_id;


SELECT * FROM library_report;

/* Procedure */ 

DELIMITER //

CREATE PROCEDURE GetMemberBooks(IN mid INT)
BEGIN
    SELECT
        b.title,
        i.issue_date,
        i.status
    FROM issued_books i
    JOIN books b
    ON i.book_id = b.book_id
    WHERE i.member_id = mid;
END //

DELIMITER ;

/* Procedure */
DELIMITER //

CREATE TRIGGER reduce_book_count
AFTER INSERT ON issued_books
FOR EACH ROW
BEGIN
    UPDATE books
    SET available_copies = available_copies - 1
    WHERE book_id = NEW.book_id;
END //

DELIMITER ;

/* Fine 10 rupee per date */ 
SELECT
    issue_id,
    DATEDIFF(return_date, issue_date) AS days_taken,
    CASE
        WHEN DATEDIFF(return_date, issue_date) > 7
        THEN (DATEDIFF(return_date, issue_date) - 7) * 10
        ELSE 0
    END AS fine
FROM issued_books
WHERE status = 'Returned';

CALL GetMemberBooks(1);