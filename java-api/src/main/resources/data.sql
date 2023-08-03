INSERT INTO ISSUERS(issuer_name)
VALUES ('BNPParibasIssu 4,37% Microsoft Corp (USD)'),
('Airbus 3.15%  USD'),
('UBS Facebook (USD)'),
('Amazon'),
('HM Treasury United Kingdon'),
('TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S'),
('First Norway Alpha Kl.IV');

INSERT INTO BOOKS (book_name)
VALUES ('Trading_book_1'),
('Trading_book_2'),
('Trading_book_3'),
('Trading_book_4'),
('Trading_book_5'),
('Trading_book_6');

INSERT INTO clients (bond_holder, issuer_id)
VALUES
('AZ Holdings Inc', 1),
('Acme co', 2),
('Sovereign Investments', 3),
('Astra Trading Ltd', 2),
('Sovereign Investments', 3),
('Muncipal Gov Of Orange County', 4),
('Goldman Sachs', 5),
('UBS', 5),
('Barclays', 5),
('British Telecom', 5),
('Pension Holdings', 5),
('Zurich Pension fund 4', 6),
('Zurich Pension fund 4', 7);

INSERT INTO users (user_email)
VALUES
('user1@gmail.com'),
('user2@gmail.com');

INSERT INTO BONDS (
    cusip,
    isin,
    face_value,
    bond_maturity_date,
    coupon_percent,
    bond_currency,
    bond_type,
    redemption_status,
    is_active,
    trade_settlement_date,
    client_id,
    book_id)

    VALUES
        ('22331122', 'XS1988387210', 1000, '2023-08-05', 4.37, 'USD', 'CORP', 'open' , TRUE, '2021-08-04', 1, 1),
        ('22331122', 'XS1988387210', 1000, '2023-08-05', 4.37, 'GBP', 'CORP', 'open' , TRUE, '2021-08-04', 1, 1),
        ('123456780', 'USN0280EAR64', 900, '2023-07-30', 3.15, 'USD', 'CORP', 'open' , TRUE, '2021-08-23', 2, 2),
        ('123456780', 'USN0280EAR64', 900, '2023-07-30', 3.15, 'GBP', 'CORP', 'open' , TRUE, '2021-09-10', 2, 2),
        ('123456bh0', 'A12356111', 900, '2023-09-30', 2, 'USD', 'CORP', 'open' , TRUE, '2021-08-23', 3, 3),
        ('123456780', 'USN0280EAR64', 900, '2023-07-30', 3.15, 'USD', 'CORP', 'open' , TRUE, '2021-08-23', 4, 2),
        ('123456bh0', 'A12356111', 900, '2023-09-30', 2, 'USD', 'CORP', 'open' , TRUE, '2021-08-23', 5, 2),
        ('AMZN 3.15 08/22/27 REGS', 'USU02320AG12', 900, '2023-08-03', 3.15, 'GBP', 'CORP', 'open' , TRUE, '2021-09-27', 6, 4),
        ('AMZN 3.15 08/22/27 REGS', 'USU02320AG12', 900, '2023-08-03', 3.15, 'USD', 'CORP', 'open' , TRUE, '2021-08-23', 6, 4),
        ('BDCHBW8', 'GB00B6460505', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	FALSE, '2021-09-27', 7, 6),
        ('BDCHBW8', 'GB00B6460506', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-09-28', 7, 6),
        ('BDCHBW8', 'GB00B6460507', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-09-29', 8, 6),
        ('BDCHBW8', 'GB00B6460508', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-09-30', 8, 6),
        ('BDCHBW8', 'GB00B6460509', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-01', 9, 6),
        ('BDCHBW8', 'GB00B6460510', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-02', 10, 6),
        ('BDCHBW8', 'GB00B6460511', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-03', 10, 6),
        ('BDCHBW8', 'GB00B6460512', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-04', 10, 6),
        ('BDCHBW8', 'GB00B6460513', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-05', 11, 6),
        ('BDCHBW8', 'GB00B6460514', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-06-06', 11, 6),
        ('BDCHBW8', 'GB00B6460515', 900, '2023-08-09', 0.75, 'GBP',	'GOVN', 'open',	TRUE, '2021-10-07', 11, 6),
        ('87973RAA8', 'US87973RAA86', 690, '2023-08-06', 2.02, 'USD', 'SOVN', 'open', TRUE, '2021-09-27', 11, 4),
        ('87973RAA8', 'US87973RAA86', 690, '2023-08-06', 2.02, 'USD', 'SOVN', 'open', TRUE, '2021-08-23', 11, 4),
        ('87973RAA8', 'US87973RAA86', 690, '2023-08-06', 2.02, 'USD', 'SOVN', 'open', TRUE, '2021-09-27', 11, 4),
        ('87973RAA8', 'US87973RAA86', 690, '2023-08-06', 2.02, 'USD', 'SOVN', 'open', TRUE, '2021-08-23', 11, 4),
        ('87973RAA8', 'IE00B29LNP31', 340, '2023-12-22', 1.123, 'USD', 'SOVN', 'open', TRUE, '2021-09-27', 11, 4),
        ('87973RAA8', 'IE00B29LNP31', 340, '2023-12-22', 1.123, 'USD', 'SOVN', 'open', TRUE, '2021-08-23', 11, 4),
        ('87973RAA8', 'IE00B29LNP31', 340, '2023-12-22', 1.123, 'USD', 'SOVN', 'open', TRUE, '2021-09-27', 11, 4),
        ('87973RAA8', 'IE00B29LNP31', 340, '2023-12-22', 1.123, 'USD', 'SOVN', 'open', TRUE, '2021-08-23', 11, 4);

