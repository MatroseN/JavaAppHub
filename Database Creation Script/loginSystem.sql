DROP Database loginSystem;
create Database loginSystem;
use loginSystem;

create table userAccount (
	userID int not null auto_increment,
    userMessage Text,
    accountType varchar (10) NULL DEFAULT 'USER',
    userName varchar(255),
    pass BLOB(255),
    primary key(userID)
)engine = innodb;

create table flashCard (
	userID int,
	cardID int not null auto_increment,
	question text,
    answer text,
    primary key(cardID, userID),
    foreign key(userID) references userAccount(userID)
)engine = innodb
