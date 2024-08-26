SHOW TABLES;
use ats;
CREATE Table plane(id VARCHAR(6),PLANE_MAKER VARCHAR(20),MODEL VARCHAR(20),CAPACITY int);
select* from plane;
INSERT INTO plane VALUES("PL0001","Boeing","Boeing767",345);
INSERT INTO plane VALUES("PL0002","Airbus","Airbus56",500);
drop TABLE plane;
