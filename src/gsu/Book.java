package gsu;

public class Book implements Comparable<Book> {

    private int id;
    private String name;
    private String author;
    private String publisher;
    private short year;
    private short numberOfPages;
    private boolean hardCover;

    public Book(int id, String name, String author, String publisher, short year, short numberOfPages,
                boolean hardCover) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.hardCover = hardCover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(short numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    public String toString(){
        return id + ";" + name + ";" + author + ";" + publisher + ";" + year + ";" + numberOfPages + ";"
                + hardCover;
    }

    public void showInfo(){
        System.out.println("ID: " + id + " Name: " + name + " Author: " + author + " Publisher: " + publisher
                + " Year: " + year + " Number of pages: " + numberOfPages);
    }

    @Override
    public int compareTo(Book o) {
        return name.compareTo(o.getName());
    }
}
