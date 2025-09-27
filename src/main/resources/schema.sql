CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(500) NOT NULL,
    last_name VARCHAR(500) NOT NULL,
    email VARCHAR NOT NULL,
    phone VARCHAR NOT NULL,
    created_by VARCHAR NOT NULL,
    updated_by VARCHAR,
    created_datetime TIMESTAMP NOT NULL,
    updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    description VARCHAR(500) NOT NULL,
    price int  NOT NULL,
    cost int  NOT NULL,
    created_by VARCHAR NOT NULL,
    updated_by VARCHAR,
    created_datetime TIMESTAMP NOT NULL,
    updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS po_h (
    id SERIAL PRIMARY KEY,
    datetime TIMESTAMP NOT NULL,
    desciption VARCHAR(500) NOT NULL,
    total_price INT  NOT NULL,
    total_cost INT  NOT NULL,
    created_by VARCHAR NOT NULL,
    updated_by VARCHAR,
    created_datetime TIMESTAMP NOT NULL,
    updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS po_d (
    id SERIAL PRIMARY KEY,
    poh_id INT NOT NULL,
    item_id INT NOT NULL,
    item_qty INT NOT NULL,
    item_cost INT NOT NULL,
    item_price INT NOT NULL,
    created_by VARCHAR  NOT NULL,
    updated_by VARCHAR,
    created_datetime TIMESTAMP NOT NULL,
    updated_datetime TIMESTAMP,
    CONSTRAINT fk_id_poh FOREIGN KEY (poh_id) REFERENCES po_h(id)
);