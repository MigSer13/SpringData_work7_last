package ru.geekbrains.market.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
