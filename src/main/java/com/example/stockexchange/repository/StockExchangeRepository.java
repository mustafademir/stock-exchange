package com.example.stockexchange.repository;

import com.example.stockexchange.entity.StockExchange;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
   @Lock(value = LockModeType.PESSIMISTIC_WRITE)
   StockExchange findByName(String name);
}
