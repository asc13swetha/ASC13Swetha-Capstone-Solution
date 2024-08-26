package com.atsbooking.service;

import com.atsbooking.entity.Booking;
import com.atsbooking.model.BookingModel;
import com.atsbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {

   private final BookingRepository bookingRepository;
   @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository)

   {
       this.bookingRepository = bookingRepository;
   }
    @Override
    public String generateId()
    {
        String bookingId = bookingRepository.findTopId();
        if (bookingId == null || bookingId.isEmpty()) {
            bookingId = "B0000";
        }
        String id="B";
        int num=Integer.parseInt(bookingId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }
    @Override
    public List<BookingModel> getAllBookings()
    {
        List<Booking> allBookings = bookingRepository.findAll();
        List<BookingModel> bookingModelList = new ArrayList<>();
        for (Booking bookingEntity : allBookings)
        {
            BookingModel bookingModel = new BookingModel(bookingEntity.getId(), bookingEntity.getPassengerName(),bookingEntity.getBookingDate(),bookingEntity.getSeatNumber(),bookingEntity.getCost(),bookingEntity.getAmount(),bookingEntity.getDepDate(),bookingEntity.getDepTime(),bookingEntity.getArrDate(),bookingEntity.getArrTime());
            bookingModelList.add(bookingModel);
        }
        return bookingModelList;
    }
}
