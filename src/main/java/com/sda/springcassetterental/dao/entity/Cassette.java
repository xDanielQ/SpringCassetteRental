package com.sda.springcassetterental.dao.entity;

import javax.persistence.*;

@Entity
public class Cassette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private FilmCategory category;
    private Double price;

    public Cassette(String title, FilmCategory category, Double price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Cassette() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FilmCategory getCategory() {
        return category;
    }

    public void setCategory(FilmCategory category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
