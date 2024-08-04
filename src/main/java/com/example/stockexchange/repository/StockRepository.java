package com.example.stockexchange.repository;

import com.example.stockexchange.entity.Stock;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Stock findByName(String name);

    @Modifying
    @Query("UPDATE Stock st set st.currentPrice = ?1 where st.name=?2")
    void updatePrice(BigDecimal newPrice, String name);

    @Modifying
    @Query("DELETE FROM Stock st where st.name=?1")
    void deleteStock(String name);
}
