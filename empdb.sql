-- Create database
CREATE DATABASE hibernate_employee;
USE hibernate_employee;
CREATE TABLE Employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact DOUBLE
);
INSERT INTO Employee (name, email, contact) VALUES ('Rajesh Kumar', 'rajesh.kumar@example.com', 9876543210);
INSERT INTO Employee (name, email, contact) VALUES ('Aditi Sharma', 'aditi.sharma@example.com', 8765432109);
INSERT INTO Employee (name, email, contact) VALUES ('Suresh Reddy', 'suresh.reddy@example.com', 7654321098);
INSERT INTO Employee (name, email, contact) VALUES ('Priya Singh', 'priya.singh@example.com', 6543210987);
INSERT INTO Employee (name, email, contact) VALUES ('Vikram Patel', 'vikram.patel@example.com', 5432109876);
SELECT * FROM Employee;