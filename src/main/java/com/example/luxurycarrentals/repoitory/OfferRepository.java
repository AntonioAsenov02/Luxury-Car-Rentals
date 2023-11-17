package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


}
