CREATE TABLE drachyova.users ( id INT(10) NOT NULL AUTO_INCREMENT , login VARCHAR(30) NOT NULL , password VARCHAR(30) NOT NULL ,
 email VARCHAR(30) NOT NULL , fk_role INT(10) NOT NULL , PRIMARY KEY (id)) ENGINE = InnoDB;