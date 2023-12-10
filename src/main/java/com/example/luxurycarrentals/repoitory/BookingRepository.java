package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByUserEntity_Id(Long userId);

    List<Booking> findAllByDropOffDateBefore(LocalDate today);
}
