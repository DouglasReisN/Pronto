package com.api.tarefas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "itens_carrinho")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome")
    private String name;
    
    @Column(name = "preco")
    private double price;
    
    @Column(name = "data")  // Mapear 'date' para a coluna 'data' e torná-la obrigatória
    private LocalDate date;
    
    private String status;

    public Item() {
        this.date = LocalDate.now();
        this.status = "Disponível";
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.date = LocalDate.now();
        this.status = "Disponível";
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
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
        this.status = "Vendido";
    }
}
