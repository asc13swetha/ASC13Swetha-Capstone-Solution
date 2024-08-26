package com.atsbooking.service;

import com.atsbooking.model.BookingModel;

import java.util.List;

public interface BookingService {
    String generateId();
    List<BookingModel> getAllBookings();
}
