create database bookstore;
use bookstore;

-- Author table
CREATE TABLE author (
	authorID INT AUTO_INCREMENT PRIMARY KEY,
    authorName varchar(20)  UNIQUE
);
        ALTER TABLE author
        ADD CONSTRAINT authorName UNIQUE (authorName);

-- Category table
CREATE TABLE category (
	categoryID INT AUTO_INCREMENT PRIMARY KEY,
    categoryName varchar(20)  UNIQUE
);
        ALTER TABLE category
        ADD CONSTRAINT categoryName UNIQUE (categoryName);

-- Book table
CREATE TABLE book (
    bookUID INT AUTO_INCREMENT PRIMARY KEY,
    bookName varchar(20),
    authorID INT,
    foreign key (categoryID) references category(categoryID),
    foreign key (authorID) references author(authorID),
	categoryID INT(20),
    isbn INT
    );


INSERT INTO `bookstore`.`author` (`authorName`) VALUES ('MileyCyrus')	;
INSERT INTO `bookstore`.`category` (`categoryName`) VALUES ('ficntioonn')	;
INSERT INTO `bookstore`.`book` (`bookName`, `authorID`, `categoryID`, `isbn`) VALUES ( 'SUmitt', 1, 1 , 123) ;
INSERT INTO `bookstore`.`book` (`bookName`, `authorID`, `categoryID`, `isbn`) VALUES ( 'Miefwegwrgergstry', 1, 1 , 5466345) ;


-- ALL BOOK, Author, Category related queries
use bookstore;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID  ;
select * from book;
select * from author;
select * from category;
select * from category where categoryID = 1 ;
UPDATE category SET categoryName = (?) WHERE categoryID = (?);
UPDATE category SET categoryName = ('Fiction') WHERE categoryID = (2);
DELETE FROM book WHERE categoryID=(?);
DELETE FROM category WHERE categoryID=(?);
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE author.authorName = ("J.K.Rowling");
INSERT INTO `bookstore`.`book` (`bookName`, `authorID`, `categoryID`, `isbn`) VALUES ( 'Sumit', 2, 3 , 101) ;
INSERT INTO `bookstore`.`book` (`bookName`, `authorID`, `categoryID`, `isbn`) VALUES ( 'Mistry', 1, 1 , 201) ;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE category.categoryID = 2  ;

INSERT into bookstore.book (bookName, authorID, categoryID, isbn) values ("Quora",9,6,7);
UPDATE book SET bookUID = (?) , bookName = (?), authorID = (?), categoryID = (?), isbn= (?) ;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID ;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE book.bookUID = (?) ;
UPDATE book SET bookName = (?), authorID = (Select authorID from author where authorName = (?)), categoryID = (Select categoryID from category where categoryName = (?)), isbn= (?) WHERE bookUID = (?)  ; Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID ;
UPDATE book SET bookName = ("Kafka"), authorID = (Select authorID from author where authorName = (?)), categoryID = (Select categoryID from category where categoryName = (?)), isbn= (562) WHERE bookUID = (3)  ; Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID ;
Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID  WHERE  bookName = "Aussie" or authorName = "" or categoryName = "" or isbn= "1" ;


-- You can not directly add/update foreign key in table
Reference Error Code: 1452.
Cannot add or update a child row: a foreign key constraint fails (`bookstore`.`book`, CONSTRAINT `book_ibfk_2` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`))	0.016 sec

-- UPDATE QUERY more information:
     UPDATE query FORMAT:
                UPDATE table_name
                SET column_name1= value1, column_name2= value2
                WHERE condition;
        Error Code: 1452.
        Cannot add or update a child row: a foreign key constraint fails (`bookstore`.`book`, CONSTRAINT `book_ibfk_2` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`))	0.016 sec
        Solution:
                You DO NOT change   authorID + categoryID.    (X)
                You only change     authorName + categoryID   (Y)
                WRONG query -----> String updateBook       = " UPDATE book SET bookName = (?), authorID = (?), categoryID = (?), isbn= (?) WHERE bookUID = (?) ; " ;
            ->  I stopped allowing user to create duplicate CategoryName and duplicate AuthorNames by
                altering table by adding UNIQUE in Author.authorName and UNIQUE in Category.categoryName
                This is good design. and this error is good  java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'AuthorA' for key 'author.authorName'
