SELECT * from Buyer;
SELECT * from Product;
SELECT * from Category;
SELECT * from Manufacturer;
SELECT * from Sales;
SELECT * from SubCategory;


SELECT * from Buyer where FirstName = 'Wei';
DELETE from Buyer where FirstName = 'Wei';


--Test for Register  4.29
SELECT * FROM Buyer WHERE Username= 'aaa';
SELECT * FROM Buyer WHERE Username= 'bbb';

DELETE FROM Buyer WHERE Username = 'aaa'
DELETE FROM Buyer WHERE Username = 'bbb'