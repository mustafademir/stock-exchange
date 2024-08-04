package com.example.stockexchange.service;

import com.example.stockexchange.entity.Stock;
import com.example.stockexchange.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Transactional
    public void deleteStock(String name) {
        stockRepository.deleteStock(name);
    }

    @Transactional
    public void updatePrice(BigDecimal newPrice, String name) {
        stockRepository.updatePrice(newPrice, name);
    }
}
