package org.library.Library.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "food_table")
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate expirationDate;
    private Integer quantity;

    public Food(Integer quantity, LocalDate expirationDate, String name, Long id) {
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
