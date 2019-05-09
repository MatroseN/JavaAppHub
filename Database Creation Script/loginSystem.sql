DROP DATABASE loginSystem;
CREATE DATABASE loginSystem;
USE loginSystem;

CREATE TABLE useraccount (
	userID int not null auto_increment,
    userMessage Text,
    accountType varchar (10) NULL DEFAULT 'USER',
    userName varchar(255),
    pass BLOB(255),
    primary key(userID)
)engine = innodb;

CREATE TABLE flashcard (
	cardID int not null auto_increment,
	userID int,
	question text,
    answer text,
	foreign key(userID)references useraccount(userID),
    primary key(cardID, userID)
)engine = innodb;
