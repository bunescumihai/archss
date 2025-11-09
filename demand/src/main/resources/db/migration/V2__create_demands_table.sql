CREATE TABLE demands
(
    id               BIGSERIAL PRIMARY KEY,
    buyer_profile_id BIGINT       NOT NULL,
    product_id       BIGINT       NOT NULL,
    title            VARCHAR(255) NOT NULL,
    status           VARCHAR(50)  NOT NULL DEFAULT 'OPEN',
    quantity         DOUBLE PRECISION NOT NULL,
    created_at       TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    valid_until      TIMESTAMP,

    CONSTRAINT fk_demand_buyer_profile FOREIGN KEY (buyer_profile_id) REFERENCES buyer_profiles (id) ON UPDATE CASCADE ON DELETE CASCADE
);
