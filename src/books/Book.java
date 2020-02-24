package books;

public class Book {

    private String name;
    private double price;
    private boolean availability;

    public Book(){
        this.name = "None";
        this.price = 1;
        this.availability = false;
    }

    public Book(String name, double price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void show(){
        System.out.println("Name: "+name+" Price: "+price+" Availability: "+availability);
    }
}
