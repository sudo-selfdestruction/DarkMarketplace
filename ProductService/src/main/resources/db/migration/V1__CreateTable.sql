CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          manufacturing_country VARCHAR(255),
                          cost INT,
                          weight DOUBLE
);
