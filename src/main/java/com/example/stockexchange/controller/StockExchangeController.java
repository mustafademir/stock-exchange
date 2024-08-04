package com.example.stockexchange.controller;

import com.example.stockexchange.entity.StockExchange;
import com.example.stockexchange.service.StockExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock-exchange")
@RequiredArgsConstructor
public class StockExchangeController {
    private final StockExchangeService stockExchangeService;

    @GetMapping("/{name}")
    public StockExchange getStockExchange(@PathVariable String name) {
        return stockExchangeService.findByName(name);
    }

    @PutMapping("/{name}/{stockName}")
    public String addStock(@PathVariable String name, @PathVariable String stockName) {
        stockExchangeService.addStockToExchange(name, stockName);
        return "success";
    }

    @DeleteMapping("/{name}/{stockName}")
    public String deleteStock(@PathVariable String name, @PathVariable String stockName) {
        stockExchangeService.deleteStockToExchange(name, stockName);
        return "success";
    }

}
