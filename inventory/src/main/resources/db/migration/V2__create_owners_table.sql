CREATE TABLE owners
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    type         VARCHAR(50),
    contact_info VARCHAR(255)
);