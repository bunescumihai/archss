CREATE TABLE buyer_profiles
(
    id           BIGSERIAL PRIMARY KEY,
    owner_id     BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    region       VARCHAR(100),
    contact_info VARCHAR(255)
);