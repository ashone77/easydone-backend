CREATE TABLE easydone_customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

CREATE TABLE easydone_task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(50) NOT NULL
);

ALTER TABLE easydone_task ADD COLUMN customer_id INT, ADD CONSTRAINT fk_customer_id
    FOREIGN KEY (customer_id) REFERENCES easydone_customer(id);