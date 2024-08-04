package com.example.stockexchange.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "stock_exchanges")
public class StockExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Boolean liveInMarket;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "stock_exchange_mapping",
            joinColumns = @JoinColumn(name = "stock_exchange_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    @JsonManagedReference
    private Set<Stock> stocks = new HashSet<>();

    public void addStock(Stock stock) {
       this.stocks.add(stock);
       stock.getStockExchanges().add(this);
    }

    public void deleteStock(Stock stock) {
        this.stocks.remove(stock);
        stock.getStockExchanges().remove(this);
    }

    @Override
    public String toString() {
        return "StockExchange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", liveInMarket=" + liveInMarket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockExchange that = (StockExchange) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name)
                && Objects.equals(description, that.description) &&
                Objects.equals(liveInMarket, that.liveInMarket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, liveInMarket);
    }
}
