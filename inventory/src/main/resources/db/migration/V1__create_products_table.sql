CREATE TABLE products
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    unit     VARCHAR(50)
);