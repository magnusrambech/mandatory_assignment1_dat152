CREATE TABLE IF NOT EXISTS products (
	pno INTEGER PRIMARY KEY, pName TEXT, priceInEuro INTEGER, imageFile TEXT
);
CREATE TABLE IF NOT EXISTS description(
	pno INTEGER, langCode TEXT, dText TEXT, FOREIGN KEY(pno) REFERENCES products, PRIMARY KEY(pno, langCode)
);
CREATE TABLE IF NOT EXISTS cart (
	langCode TEXT, pno INTEGER, PRIMARY KEY(pno), FOREIGN KEY(pno, langCode) REFERENCES description, FOREIGN KEY(pno) REFERENCES products
);


INSERT OR IGNORE INTO products
(pno, pName, priceInEuro, imageFile)
VALUES
(1, 'Orange Juice', 3, 'juice.jpg'),
(2, 'Avocado', 2, 'avocado.jpg');

INSERT OR IGNORE INTO description
(pNo, langCode, dText)
VALUES
(1, 'en-US', 'OJ - not from concentrate'),
 (1, 'nb-NO', 'Appelsinjuice - ikke fra konsentrat'),
 (1, 'nl-NL', 'Sinaasappelsap - niet van concentraat'),
 (2, 'nb-NO', 'Avokado fra Peru'),
 (2, 'en-US', 'Avocado from Peru'),
 (2, 'nl-NL', 'Avocado uit Peru');