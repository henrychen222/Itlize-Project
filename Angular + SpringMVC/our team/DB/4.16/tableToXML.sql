USE Market_backend
GO
SELECT * FROM Buyer;
SELECT * FROM Buyer WHERE [Password] = '123';

SELECT *
FROM Buyer
FOR XML AUTO
GO

-- SELECT BuyerID, Username, Email, FirstName, LastName
-- FROM Buyer
-- FOR XML AUTO

   


