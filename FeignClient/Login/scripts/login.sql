use ats;
CREATE Table login(
    id BIGINT PRIMARY KEY,
    email_Id VARCHAR(25),
    password VARCHAR(25),
    phone_Number VARCHAR(25),
    failed_Attempts VARCHAR(25),
    last_Attempt_Time DATETIME,
    locked BOOLEAN DEFAULT FALSE
);
SELECT * from login;
insert into login values(1,"swetha@gmail.com","Swetha@12","4387437761",0,"2020-04-28 06:45:34",false);
INSERT INTO login VALUES(2,"hello@gmail.com","Hello@12","4336874761",0,"2020-04-18 06:30:34",false);
DROP TABLE login;