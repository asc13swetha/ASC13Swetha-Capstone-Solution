package com.atsbooking.repository;

import com.atsbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,String> {
    @Query(value = "SELECT id FROM airport ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
}
