package ru.gb.market;

public class Product {
    private String title;
    private int id;
    private float price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Product(int id, String name, float price) {
        this.title = name;
        this.id = id;
        this.price = price;
    }
}
