-- DROP TABLE IF EXISTS issuers;
-- DROP TABLE IF EXISTS clients;
-- DROP TABLE IF EXISTS books;
--DROP TABLE IF EXISTS bonds;

CREATE TABLE if not exists issuers (
    issuer_id INT AUTO_INCREMENT PRIMARY KEY,
    issuer_name VARCHAR(250) NOT NULL
);

CREATE TABLE if not exists clients (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    bond_holder VARCHAR(250) NOT NULL,
    issuer_id INT,
    FOREIGN KEY (issuer_id) REFERENCES issuers(issuer_id)
);

CREATE TABLE if not exists books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(250) NOT NULL
);

CREATE TABLE if not exists users(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(250) NOT NULL
);


CREATE TABLE if not exists bonds (
    bond_id INT AUTO_INCREMENT PRIMARY KEY,
    cusip VARCHAR(250) NOT NULL,
    isin VArCHAR(250) NOT NULL,
    face_value INT NOT NULL,
    bond_maturity_date DATE NOT NULL,
    coupon_percent FLOAT NOT NULL,
    bond_currency VARCHAR(250) NOT NULL,
    bond_type VARCHAR(250) NOT NULL,
    redemption_status VARCHAR(250) NOT NULL,
    is_active BOOLEAN NOT NULL,
    trade_settlement_date DATE NOT NULL,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    book_id INT,
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

/*
CREATE TABLE trades (
    trade_id INT AUTO_INCREMENT PRIMARY KEY,
    trade_quantity INT NOT NULL,
    trade_settlement_date DATE NOT NULL,
    trade_date DATE NOT NULL,
    unit_price FLOAT NOT NULL,
    tradetype_id INT,
    FOREIGN KEY (trade_id) REFERENCES trade_types(trade_type_id),
    status_id INT,
    FOREIGN KEY (trade_id) REFERENCES status(status_id),
    currency_id INT,
    FOREIGN KEY (trade_id) REFERENCES currency_type(currency_id),
    buyer_id INT,
    FOREIGN KEY (trade_id) REFERENCES buyers(buyer_id)
);
*/
