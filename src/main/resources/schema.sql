-- Create table for Item entity
CREATE TABLE Item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    quantity INT
);

-- Create table for Order entity
CREATE TABLE Orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customerId BIGINT,
    orderDate DATE,
    status VARCHAR(50)
);

-- Create table for OrderItem entity (if needed)
CREATE TABLE OrderItem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    orderId BIGINT,
    itemId BIGINT,
    quantity INT,
    price DECIMAL(10, 2)
);

-- Create table for RestockOrder entity
CREATE TABLE RestockOrder (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    supplierId BIGINT,
    orderDate DATE,
    status VARCHAR(50)
);

-- Create table for Supplier entity
CREATE TABLE Supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contactInfo TEXT
);
