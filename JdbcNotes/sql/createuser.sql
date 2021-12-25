create table users(
     id  int(3) primary key,
     name varchar(20),
     email varchar(20),
     country varchar(20),
     password varchar(20)
  );

  
  INSERT INTO Users  VALUES 
  (3, 'Pramod', 'pramod@gmail.com', 'India', '123'),
  (4, 'Deepa', 'deepa@gmail.com', 'India', '123'), 
  (5, 'Tom', 'top@gmail.com', 'India', '123');
  
  
  drop table users;
  
  
  
  select * from users;

  
  
  
  
 -- MySQL stored procedure.   
  
DELIMITER $$
USE `test`$$
CREATE PROCEDURE `retreive_users` ()
BEGIN
 select * from users;
END$$
DELIMITER ;





-- 222

DELIMITER $$
USE `test`$$
CREATE PROCEDURE `retreive_different_results` () BEGIN
 select distinct name from users where id = 1;
    
    select distinct email from users;
    
    select count(id) as users_count from users;
END
DELIMITER ;


