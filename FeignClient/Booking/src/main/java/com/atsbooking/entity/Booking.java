package com.atsbooking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="BOOKING")
public class Booking
{
    @Id
    private String id;
    @Column(name= "PASSENGER_NAME",nullable = false)
    private String passengerName;
    @Column(name="BOOKING_DATE",nullable = false)
    private LocalDateTime bookingDate;
    @Column(name= "SEAT_NUMBER",nullable = false)
    private int seatNumber;
    @Column(name= "COST",nullable = false)
    private int cost;
    @Column(name= "AMOUNT",nullable = false)
    private int amount;
    @Column(name = "DEPARTURE_DATE",nullable = false)
    private String depDate;
    @Column(name = "DEPARTURE_TIME",nullable = false)
    private String depTime;
    @Column(name = "ARRIVAL_DATE",nullable = false)
    private String arrDate;
    @Column(name = "ARRIVAL_TIME",nullable = false)
    private String arrTime;
    public Booking() {
    }

    public Booking(String id, String passengerName, LocalDateTime bookingDate,int seatNumber,int cost,int amount,String depDate,String depTime,String arrDate,String arrTime) {
        this.id = id;
        this.passengerName = passengerName;
        this.bookingDate = bookingDate;
        this.seatNumber= seatNumber;
        this.cost=cost;
        this.amount=amount;
        this.depDate=depDate;
        this.depTime=depTime;
        this.arrDate=arrDate;
        this.arrTime=arrTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }
}

