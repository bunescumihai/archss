package com.demand.demo.repository;

import com.demand.demo.entity.BuyerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerProfile, Long> {
}
