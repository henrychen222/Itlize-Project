USE Market_backend

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Manufacturer'))
BEGIN;
    DROP TABLE [Manufacturer];
END;
GO

CREATE TABLE [Manufacturer] (
    [ManufacturerID] INTEGER NOT NULL IDENTITY(1, 1),
    [Department] VARCHAR(255) NULL,
    [Phone] VARCHAR(100) NULL,
    [Email] VARCHAR(255) NULL,
    [WebUrl] VARCHAR(50) NULL,
    PRIMARY KEY ([ManufacturerID])
);
GO

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Buyer'))
BEGIN;
    DROP TABLE [Buyer];
END;
GO

CREATE TABLE [Buyer] (
    [BuyerID] INTEGER NOT NULL IDENTITY(1, 1),
    [email] VARCHAR(255) NULL,
    [firstname] VARCHAR(100) NULL,
    [lastname] VARCHAR(255) NULL,
    [username] VARCHAR(100) NULL,
    [password] VARCHAR(100) NULL,
    PRIMARY KEY ([BuyerID])
);
GO

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Sales'))
BEGIN;
    DROP TABLE [Sales];
END;
GO

CREATE TABLE [Sales] (
    [SalesID] INTEGER NOT NULL IDENTITY(1, 1),
    [Name] VARCHAR(255) NULL,
    [Phone] VARCHAR(100) NULL,
    [Email] VARCHAR(255) NULL,
    [ManufacturerID] INTEGER NULL,
    [WebUrl] VARCHAR(50) NULL,
    PRIMARY KEY ([SalesID])
);
GO

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

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Category'))
BEGIN;
    DROP TABLE [Category];
END;
GO

CREATE TABLE [Category] (
    [CategoryID] INTEGER NOT NULL IDENTITY(1, 1),
    [CategoryName] VARCHAR(100) NULL,
    PRIMARY KEY ([CategoryID])
);
GO

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('SubCategory'))
BEGIN;
    DROP TABLE [SubCategory];
END;
GO

CREATE TABLE [SubCategory] (
    [SubCategoryID] INTEGER NOT NULL IDENTITY(1, 1),
    [SubCategoryName] VARCHAR(255) NULL,
    [CategoryID] INTEGER NULL,
    PRIMARY KEY ([SubCategoryID])
);
GO

USE Market_backend
IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('AttributeType'))
BEGIN;
    DROP TABLE [AttributeType];
END;
GO

CREATE TABLE [AttributeType] (
    [AttributeTypeID] INTEGER NOT NULL IDENTITY(1, 1),
    [AttributeTypeName] VARCHAR(100) NULL,
    PRIMARY KEY ([AttributeTypeID])
);
GO

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('Attribute'))
BEGIN;
    DROP TABLE [Attribute];
END;
GO

CREATE TABLE [Attribute] (
    [AttributeID] INTEGER NOT NULL IDENTITY(1, 1),
    [AttributeName] VARCHAR(255) NULL,
    [IsRange] Bit NOT NUll,
    [MinValue] INTEGER NULL,
    [MaxValue] INTEGER NULL,
    [AttributeTypeID] INTEGER NULL,
    [SubCategoryID] INTEGER NULL,
    PRIMARY KEY ([AttributeID])
);
GO

INSERT INTO AttributeType([AttributeTypeName]) VALUES('Product Type'),('Technical Specification'),('Brand'),('Past Selections'),('Certification'),('Other');

INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Use Type','False',NULL,NULL,1,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Application','False',NULL,NULL,1,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Mounting Location','False',NULL,NULL,1,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Accessories','False',NULL,NULL,1,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Model Year''s','True',2010,2016,1,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Airflow(CFM)','True',5000,10000,2,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Max Power(W)','True',9.84,65,2,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Sound at max speed(dBA)','True',20,35,2,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Fan sweep diameter(in)','True',18,60,2,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Height(in)','True',12,78,2,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('Select Brand(s)','False',NULL,NULL,3,1);
INSERT INTO Attribute([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID]) VALUES('With the words','False',NULL,NULL,5,1);


INSERT INTO Buyer([email], [firstname], [lastname], [password], [username]) VALUES('12345@gamil.com', 'barF', 'fooL', '123456', 'Alex');

INSERT INTO Category([CategoryName]) 
                VALUES('Mechanical');
INSERT INTO SubCategory([SubCategoryName],[CategoryID]) 
                VALUES('SubCategory1',1),('SubCategory2',1),('SubCategory3',1),('SubCategory4',1),('SubCategory5',1);

INSERT INTO Manufacturer([Department],[Phone],[Email],[WebUrl]) 
                    VALUES('Manufacturer1','1-604-105-1948','non.enim.Mauris@duinec.co.uk','www.Manufacturer1.com'),
                        ('Manufacturer2','1-604-105-1948','non.enim.Mauris@duinec.co.uk','www.Manufacturer2.com'),
                        ('Manufacturer3','1-604-105-1948','non.enim.Mauris@duinec.co.uk','www.Manufacturer3.com');
INSERT INTO Sales([Name],[Phone],[Email],[ManufacturerID],[WebUrl]) 
                    VALUES('Sale1-Cate1','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',1,'www.Sale1-Cate1.com'),
                        ('Sale2-Cate1','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',1,'www.Sale2-Cate1.com'),
                        ('Sale2-Cate1','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',1,'www.Sale2-Cate1.com'),
                        ('Sale1-Cate2','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',2,'www.Sale1-Cate2.com'),
                        ('Sale2-Cate2','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',2,'www.Sale2-Cate2.com'),
                        ('Sale3-Cate2','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',2,'www.Sale3-Cate2.com'),
                        ('Sale1-Cate3','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',3,'www.Sale1-Cate3.com'),
                        ('Sale2-Cate3','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',3,'www.Sale2-Cate3.com'),
                        ('Sale3-Cate3','1-433-258-7247','tortor.dictum.eu@laciniaSed.ca',3,'www.Sale3-Cate3.com');
INSERT INTO Product([ProductName],[ProductDescription],
                        [ProductPrice],[DocumentXML],[AttributeXML],
                            [ManufacturerID],[SalesID],[SubCategoryID],[Details]) 
                    VALUES  
                        -- SubCate1
                            ('Dominic','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                123,'<doc>doccuments</doc>','<attribute><ModelYear>2010</ModelYear><Airflow>6000</Airflow><MaxPower>20</MaxPower><Sound>35</Sound><sweep>60</sweep><height>15</height></attribute>',
                                    1,1,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Atkinson','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>5050</Airflow><MaxPower>10</MaxPower><Sound>25</Sound><sweep>50</sweep><height>15</height></attribute>',
                                    1,2,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lorem','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                342,'<doc>doccuments</doc>','<attribute><ModelYear>2014</ModelYear><Airflow>7000</Airflow><MaxPower>30</MaxPower><Sound>35</Sound><sweep>70</sweep><height>25</height></attribute>',
                                    1,3,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lpsum','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2013</ModelYear><Airflow>8000</Airflow><MaxPower>40</MaxPower><Sound>25</Sound><sweep>20</sweep><height>35</height></attribute>',
                                    2,1,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Consectetuer','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2012</ModelYear><Airflow>9080</Airflow><MaxPower>50</MaxPower><Sound>30</Sound><sweep>40</sweep><height>45</height></attribute>',
                                    2,2,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Nunc','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                564,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>10000</Airflow><MaxPower>60</MaxPower><Sound>20</Sound><sweep>60</sweep><height>55</height></attribute>',
                                    2,3,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Aliquam','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7050</Airflow><MaxPower>64</MaxPower><Sound>35</Sound><sweep>55</sweep><height>66</height></attribute>',
                                    3,1,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Dapibus','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                757,'<doc>doccuments</doc>','<attribute><ModelYear>2016</ModelYear><Airflow>6060</Airflow><MaxPower>64</MaxPower><Sound>22</Sound><sweep>33</sweep><height>77</height></attribute>',
                                    3,2,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Tortor','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                789,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7070</Airflow><MaxPower>64</MaxPower><Sound>33</Sound><sweep>50</sweep><height>66</height></attribute>',
                                    3,3,1,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                        -- SubCate2
                            ('Dominic','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                123,'<doc>doccuments</doc>','<attribute><ModelYear>2010</ModelYear><Airflow>6000</Airflow><MaxPower>20</MaxPower><Sound>35</Sound><sweep>60</sweep><height>15</height></attribute>',
                                    1,1,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Atkinson','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>5050</Airflow><MaxPower>10</MaxPower><Sound>25</Sound><sweep>50</sweep><height>15</height></attribute>',
                                    1,2,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lorem','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                342,'<doc>doccuments</doc>','<attribute><ModelYear>2014</ModelYear><Airflow>7000</Airflow><MaxPower>30</MaxPower><Sound>35</Sound><sweep>70</sweep><height>25</height></attribute>',
                                    1,3,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lpsum','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2013</ModelYear><Airflow>8000</Airflow><MaxPower>40</MaxPower><Sound>25</Sound><sweep>20</sweep><height>35</height></attribute>',
                                    2,1,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Consectetuer','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2012</ModelYear><Airflow>9080</Airflow><MaxPower>50</MaxPower><Sound>30</Sound><sweep>40</sweep><height>45</height></attribute>',
                                    2,2,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Nunc','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                564,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>10000</Airflow><MaxPower>60</MaxPower><Sound>20</Sound><sweep>60</sweep><height>55</height></attribute>',
                                    2,3,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Aliquam','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7050</Airflow><MaxPower>64</MaxPower><Sound>35</Sound><sweep>55</sweep><height>66</height></attribute>',
                                    3,1,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Dapibus','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                757,'<doc>doccuments</doc>','<attribute><ModelYear>2016</ModelYear><Airflow>6060</Airflow><MaxPower>64</MaxPower><Sound>22</Sound><sweep>33</sweep><height>77</height></attribute>',
                                    3,2,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Tortor','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                789,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7070</Airflow><MaxPower>64</MaxPower><Sound>33</Sound><sweep>50</sweep><height>66</height></attribute>',
                                    3,3,2,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                        -- SubCate3
                            ('Dominic','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                123,'<doc>doccuments</doc>','<attribute><ModelYear>2010</ModelYear><Airflow>6000</Airflow><MaxPower>20</MaxPower><Sound>35</Sound><sweep>60</sweep><height>15</height></attribute>',
                                    1,1,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Atkinson','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>5050</Airflow><MaxPower>10</MaxPower><Sound>25</Sound><sweep>50</sweep><height>15</height></attribute>',
                                    1,2,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lorem','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                342,'<doc>doccuments</doc>','<attribute><ModelYear>2014</ModelYear><Airflow>7000</Airflow><MaxPower>30</MaxPower><Sound>35</Sound><sweep>70</sweep><height>25</height></attribute>',
                                    1,3,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Lpsum','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                234,'<doc>doccuments</doc>','<attribute><ModelYear>2013</ModelYear><Airflow>8000</Airflow><MaxPower>40</MaxPower><Sound>25</Sound><sweep>20</sweep><height>35</height></attribute>',
                                    2,1,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Consectetuer','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2012</ModelYear><Airflow>9080</Airflow><MaxPower>50</MaxPower><Sound>30</Sound><sweep>40</sweep><height>45</height></attribute>',
                                    2,2,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Nunc','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                564,'<doc>doccuments</doc>','<attribute><ModelYear>2011</ModelYear><Airflow>10000</Airflow><MaxPower>60</MaxPower><Sound>20</Sound><sweep>60</sweep><height>55</height></attribute>',
                                    2,3,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Aliquam','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                345,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7050</Airflow><MaxPower>64</MaxPower><Sound>35</Sound><sweep>55</sweep><height>66</height></attribute>',
                                    3,1,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Dapibus','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                757,'<doc>doccuments</doc>','<attribute><ModelYear>2016</ModelYear><Airflow>6060</Airflow><MaxPower>64</MaxPower><Sound>22</Sound><sweep>33</sweep><height>77</height></attribute>',
                                    3,2,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
                            ('Tortor','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor.',
                                789,'<doc>doccuments</doc>','<attribute><ModelYear>2015</ModelYear><Airflow>7070</Airflow><MaxPower>64</MaxPower><Sound>33</Sound><sweep>50</sweep><height>66</height></attribute>',
                                    3,3,3,'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam');


