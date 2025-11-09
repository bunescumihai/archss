CREATE TABLE stock_items
(
    id           BIGSERIAL PRIMARY KEY,
    product_id   BIGINT           NOT NULL,
    quantity     DOUBLE PRECISION NOT NULL,
    location     VARCHAR(255),
    owner_id     BIGINT           NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_stock_product FOREIGN KEY (product_id) REFERENCES products (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_stock_owner FOREIGN KEY (owner_id) REFERENCES owners (id) ON UPDATE CASCADE ON DELETE CASCADE
);