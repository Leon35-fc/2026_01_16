package org.example.entities;

import java.util.Date;

public abstract class Gioco {
    Long id;
    String title;
    Date published;
    Double price;

    public Gioco(Long id, String title, Date published, Double price){
        this.id = id;
        this.title=title;
        this.published;
        this.price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
