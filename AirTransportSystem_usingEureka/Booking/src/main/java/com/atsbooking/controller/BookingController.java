package com.atsbooking.controller;
import com.atsbooking.entity.Booking;
import com.atsbooking.model.BookingModel;
import com.atsbooking.repository.BookingRepository;
import com.atsbooking.service.BookingService;
import com.atsbooking.exceptions.BookingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public List<BookingModel> getAllBookings()
    {
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/{id}")
    public BookingModel getBookingDetails(@PathVariable(value = "id") String id) {
        try {
            Booking bookingDetails = bookingRepository.findById(id).get();
            return new BookingModel(bookingDetails.getId(),bookingDetails.getPassengerName(),bookingDetails.getBookingDate(),bookingDetails.getSeatNumber(),bookingDetails.getCost(),bookingDetails.getAmount(),bookingDetails.getDepDate(),bookingDetails.getDepTime(),bookingDetails.getArrDate(),bookingDetails.getArrTime());
        } catch (BookingNotFoundException bookingNotFoundException) {
            return null;
        }
    }
    @PostMapping("/booking")
    public String insertAirportDetails(@RequestBody BookingModel bookingModel)
    {
            if (bookingModel.getPassengerName() == null || bookingModel.getPassengerName().isEmpty() ||bookingModel.getBookingDate() == null||bookingModel.getSeatNumber()<=0||
                    bookingModel.getCost()<= 0||bookingModel.getAmount()<=0||bookingModel.getAmount() <= 0||
                    bookingModel.getDepDate() == null || bookingModel.getDepDate().isEmpty() ||
                    bookingModel.getDepTime() == null || bookingModel.getDepTime().isEmpty() ||
                    bookingModel.getArrDate() == null || bookingModel.getArrDate().isEmpty() ||
                    bookingModel.getArrTime() == null || bookingModel.getArrTime().isEmpty()) {
                return "Provide The Required Details";
            }
        String bookingId = bookingService.generateId();
        Booking bookingDetails= new Booking(bookingId,bookingModel.getPassengerName(),bookingModel.getBookingDate(),bookingModel.getSeatNumber(),bookingModel.getCost(),
                bookingModel.getAmount(),bookingModel.getDepDate(),bookingModel.getDepTime(),bookingModel.getArrDate(),bookingModel.getArrTime());
        bookingRepository.save(bookingDetails);
        return "Booking Details inserted successfully";
    }

    @DeleteMapping("/booking/{bookingId}")
    public String deleteBookingDetails(@PathVariable(value = "bookingId") String id) {
        try {
            Booking bookingDetailsToBeDeleted = bookingRepository.findById(id).get();
            bookingRepository.delete(bookingDetailsToBeDeleted);
            return "Booking Details deleted successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Booking Details is not available";
        }
    }

    @PutMapping("/booking")
    public String updateBookingDetails(@RequestBody BookingModel bookingModel) {
        try {
            Booking bookingDetailsToBeUpdated = bookingRepository.findById(bookingModel.getId()).get();
            if (bookingModel.getPassengerName() != null && !bookingModel.getPassengerName().isEmpty()) {
                bookingDetailsToBeUpdated.setPassengerName(bookingModel.getPassengerName());
            }
            if(bookingModel.getBookingDate() != null){
                bookingDetailsToBeUpdated.setBookingDate(bookingModel.getBookingDate());
            }
            if(bookingModel.getSeatNumber() >0){
                bookingDetailsToBeUpdated.setSeatNumber(bookingModel.getSeatNumber());
            }
            if(bookingModel.getCost() > 0){
                bookingDetailsToBeUpdated.setCost(bookingModel.getCost());
            }
            if(bookingModel.getAmount() > 0 ){
                bookingDetailsToBeUpdated.setAmount(bookingModel.getAmount());
            }
            if (bookingModel.getDepDate() != null && !bookingModel.getDepDate().isEmpty()) {
                bookingDetailsToBeUpdated.setDepDate(bookingModel.getDepDate());
            }
            if (bookingModel.getDepTime() != null && !bookingModel.getDepTime().isEmpty()) {
                bookingDetailsToBeUpdated.setDepDate(bookingModel.getDepTime());
            }
            if (bookingModel.getArrDate() != null && !bookingModel.getArrDate().isEmpty()) {
                bookingDetailsToBeUpdated.setArrDate(bookingModel.getArrDate());
            }
            if (bookingModel.getArrTime() != null && !bookingModel.getArrTime().isEmpty()) {
                bookingDetailsToBeUpdated.setDepDate(bookingModel.getArrTime());
            }
            bookingRepository.save(bookingDetailsToBeUpdated);
            return "Plane Details updated Successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Airport Details not updated for the provided Airport Id";
        }
    }
}
