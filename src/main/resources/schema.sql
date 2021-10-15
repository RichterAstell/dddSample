CREATE TABLE IF NOT EXISTS customer (
    customer_id SERIAL NOT NULL,
    gender INTEGER NOT NULL,
    birthday DATE NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS holding_point (
    customer_id INTEGER NOT NULL,
    holding_point INTEGER NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TYPE use_type AS ENUM ('add', 'use', 'exp', 'con');
CREATE TABLE IF NOT EXISTS holding_point_history (
    history_id SERIAL NOT NULL,
    customer_id INTEGER NOT NULL,
    holdingPoint INTEGER NOT NULL,
    use_type use_type NOT NULL,
    PRIMARY KEY (history_id)
);

