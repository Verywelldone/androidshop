package com.androidserver.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    private Category category;

    @Column
    private Integer price;

    @Column
    private Double weight;

    @Column
    private String description;

    @Column
    private Date creationDate;

    @Column
    private Integer stock;

}
