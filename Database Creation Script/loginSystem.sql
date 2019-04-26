Drop Database login_system;
create Database login_system;
use login_system;

create table userAccount (
	userID int not null auto_increment,
    userMessage Text,
    accountType varchar (10) NULL DEFAULT 'USER',
    userName varchar(255),
    pass BLOB(255),
    primary key(userID)
)engine = innodb;

