CREATE TABLE IF NOT EXISTS customer (
    customer_id SERIAL NOT NULL,
    gender INTEGER NOT NULL,
    birthday DATE NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS holding_point (
    customer_id INTEGER NOT NULL,
    holdingPoint INTEGER NOT NULL,
PRIMARY KEY (customer_id)
);


