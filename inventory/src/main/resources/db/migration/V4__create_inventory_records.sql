CREATE TABLE inventory_records
(
    id            BIGSERIAL PRIMARY KEY,
    action        VARCHAR(50) NOT NULL, -- ADD, UPDATE, REMOVE
    old_quantity  DOUBLE PRECISION,
    new_quantity  DOUBLE PRECISION,
    timestamp     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    stock_item_id BIGINT      NOT NULL,

    CONSTRAINT fk_inventory_stock FOREIGN KEY (stock_item_id) REFERENCES stock_items (id) ON UPDATE CASCADE ON DELETE CASCADE
);