package com.example.stockexchange.service;

import com.example.stockexchange.entity.Stock;
import com.example.stockexchange.entity.StockExchange;
import com.example.stockexchange.repository.StockExchangeRepository;
import com.example.stockexchange.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockExchangeService {
    private final StockExchangeRepository stockExchangeRepository;
    private final StockRepository stockRepository;

    public StockExchange findByName(String name) {
        return stockExchangeRepository.findByName(name);
    }

    @Transactional
    public void addStockToExchange(String name,String stockName) {
        StockExchange stockExchange = stockExchangeRepository.findByName(name);
        Stock stock = stockRepository.findByName(stockName);
        stockExchange.addStock(stock);
        stockExchangeRepository.save(stockExchange);
    }

    @Transactional
    public void deleteStockToExchange(String name,String stockName) {
        StockExchange stockExchange = stockExchangeRepository.findByName(name);
        Stock stock = stockRepository.findByName(stockName);
        stockExchange.deleteStock(stock);
        stockExchangeRepository.save(stockExchange);
    }
}
