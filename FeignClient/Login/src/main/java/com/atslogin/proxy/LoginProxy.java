package com.atslogin.proxy;

import com.atslogin.model.BookingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="booking-ms")
public interface LoginProxy {
    @GetMapping("/api/booking")
    List<BookingModel> getAllBooking();
}
