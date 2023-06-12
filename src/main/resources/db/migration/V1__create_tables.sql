CREATE TABLE brand (
    id INTEGER NOT NULL,
    name VARCHAR(25) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE price (
    id INTEGER NOT NULL,
    brand_id INTEGER NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    currency VARCHAR(3) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);