use ats;
CREATE TABLE BOOKING(ID VARCHAR(6),PASSENGER_NAME VARCHAR(25),BOOKING_DATE VARCHAR(50),SEAT_NUMBER INT, COST INT,AMOUNT INT,DEPARTURE_DATE VARCHAR(25),DEPARTURE_TIME VARCHAR(25),ARRIVAL_DATE VARCHAR(25),ARRIVAL_TIME VARCHAR(25));
SELECT*FROM BOOKING;
INSERT INTO booking VALUES("BOOOO1","SWETHA","2024-08-02",8,700.00,850.00,"2024-08-10","08:30:00","2024-08-10","11:30:00");
DROP TABLE booking;