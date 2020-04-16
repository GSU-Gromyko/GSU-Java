package books;

public class Book {

    private String name;
    private double price;
    private boolean pictures;

    public Book(){
        this.name = "None";
        this.price = 1;
        this.pictures = false;
    }

    public Book(String name, double price, boolean pictures) {
        this.name = name;
        this.price = price;
        this.pictures = pictures;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPictures() {
        return pictures;
    }

    public void show(){
        System.out.println("Name: "+name+" Price: "+price+" Availability: "+ pictures);
    }

}
