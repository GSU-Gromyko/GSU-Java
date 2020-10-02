package book;

import exceptions_.NegativeValueException;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {

    private String name;
    private double price;
    private boolean pictures;

    public Book(String name, double price, boolean pictures) throws NegativeValueException {
        this.name = name;
        if (price < 0) throw new NegativeValueException("price must be greater than 0");
        this.price = price;
        this.pictures = pictures;
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

    public void setPrice(double price) throws NegativeValueException {
        if (price < 0) throw new NegativeValueException("price must be greater than 0");
        this.price = price;
    }

    public boolean isPictures() {
        return pictures;
    }

    public void setPictures(boolean pictures) {
        this.pictures = pictures;
    }

    public void show(){
        System.out.println("Name: "+name+" Price: "+price+" Availability: "+ pictures);
    }

    public String toString(){
        return name + ";" + price + ";" + pictures;
    }

    @Override
    public int compareTo(Book o) {
        return Double.compare(price, o.price);
    }
}