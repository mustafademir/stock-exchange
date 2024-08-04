package com.example.stockexchange.controller;

import com.example.stockexchange.entity.Stock;
import com.example.stockexchange.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping
    public String updatePrice(@RequestParam String name, @RequestParam BigDecimal newPrice) {
        stockService.updatePrice(newPrice, name);
        return "success";
    }

    @DeleteMapping
    public String deleteStock(@RequestParam String name) {
        stockService.deleteStock(name);
        return "success";
    }
}
