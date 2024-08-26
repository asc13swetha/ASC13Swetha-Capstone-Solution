package com.atsbooking.model;

import java.time.LocalDateTime;

public class BookingModel
{
    private String id;
    private String passengerName;
    private LocalDateTime bookingDate;
    private int seatNumber;
    private int cost;
    private int amount;
    private String depDate;
    private String depTime;
    private String arrDate;
    private String arrTime;


        // default constructor
    public BookingModel() {
    }

    public BookingModel(String id,String passengerName, LocalDateTime bookingDate,int seatNumber,int cost,int amount,String depDate,String depTime,String arrDate,String arrTime)
    {
        this.id = id;
        this.passengerName = passengerName;
        this.bookingDate=bookingDate;
        this.seatNumber= seatNumber;
        this.cost=cost;
        this.amount=amount;
        this.depDate=depDate;
        this.depTime=depTime;
        this.arrDate=arrDate;
        this.arrTime=arrTime;
    }

    public String getId()
    {
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
