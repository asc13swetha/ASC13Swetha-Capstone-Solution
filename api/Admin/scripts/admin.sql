use ats;
CREATE Table admin(id int,email_Id VARCHAR(25),password VARCHAR(25),phone_Number VARCHAR(25),failed_Attempts VARCHAR(25),last_Attempt_Time DATETIME,locked VARCHAR(10));
SELECT*FROM admin;
INSERT INTO admin VALUES(2,"setha@12","Swetha@21","7654389765",1,"2024-08-20 12:56:45",true);
DROP TABLE admin;