package com.api.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class item {
    private String name;
    private double price;
    private LocalDate date; // Data do item
    private String status;  // Status de venda ("Disponível" ou "Vendido")

    public item(String name, double price) {
        this.name = name;
        this.price = price;
        this.date = LocalDate.now(); // Data atual
        this.status = "Disponível"; // Status inicial como "Disponível"
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void markAsSold() {
        this.status = "Vendido"; // Define o status como "Vendido"
    }
}
