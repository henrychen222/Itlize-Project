USE Market_backend
IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Product'))
BEGIN;
    DROP TABLE [Product];
END;
GO

CREATE TABLE [Product] (
    [ProductID] INTEGER NOT NULL IDENTITY(1, 1),
    [ProductName] VARCHAR(255) NULL,
    [ProductDescription] VARCHAR(MAX) NULL,
    [ProductPrice] INTEGER NULL,
    [DocumentXML] VARCHAR(255) NULL,
    [AttributeXML] VARCHAR(255) NULL,
    [ManufacturerID] INTEGER NULL,
    [SalesID] INTEGER NULL,
    [SubCategoryID] INTEGER NULL,
    [Details] VARCHAR(MAX) NULL,
    PRIMARY KEY ([ProductID])
);
GO


 
INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>6000</Airflow><MaxPower>20</MaxPower><Sound>35</Sound><sweep>60</sweep><height>15</height></attribute>', '1', '1', '3', 'dummy details');
INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>5000</Airflow><MaxPower>10</MaxPower><Sound>25</Sound><sweep>50</sweep><height>5</height></attribute>', '1', '1', '3', 'dummy details');
INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>7000</Airflow><MaxPower>30</MaxPower><Sound>45</Sound><sweep>70</sweep><height>25</height></attribute>', '1', '1', '3', 'dummy details');

INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>8000</Airflow><MaxPower>40</MaxPower><Sound>55</Sound><sweep>80</sweep><height>35</height></attribute>', '1', '1', '3', 'dummy details');
INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>9000</Airflow><MaxPower>50</MaxPower><Sound>65</Sound><sweep>90</sweep><height>45</height></attribute>', '1', '1', '3', 'dummy details');
INSERT INTO Product([ProductName],[ProductDescription],[ProductPrice],[DocumentXML],[AttributeXML],[ManufacturerID],[SalesID],[SubCategoryID],[Details]) VALUES('name', 'description','33', 'dummydocumentxml', '<attribute><Airflow>10000</Airflow><MaxPower>60</MaxPower><Sound>75</Sound><sweep>100</sweep><height>55</height></attribute>', '1', '1', '3', 'dummy details');