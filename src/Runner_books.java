import books.Book;
import books.Sort_books;

public class Runner_books {
    public static void main(String[] args) {

        Book[] library = new Book[10];

        library[1] = new Book("Name 2", 12, true);
        library[2] = new Book("Name 3", 24, false);
        library[3] = new Book("Name 5", 26, true);
        library[4] = new Book("Name 1", 8, true);
        library[5] = new Book("Name 4", 16, true);
        library[6] = new Book("Name 7", 60, false);
        library[7] = new Book("Name 6", 52, true);
        library[8] = new Book("Name 8", 47, false);
        library[9] = new Book();

        double price = 0;
        int pictures =0;

        for( Book book: library){
            if (book != null){
                book.show();
                price += book.getPrice();
                if (book.isPictures()){
                    pictures += 1;
                }
            }
        }
        System.out.println("Total price is: " + price + " Count book with pictures: " + pictures);

        // SORTING
        System.out.println("Sorting by names");
        for( Book book: Sort_books.by_names(library)){
            if (book != null){
                book.show();
            }
        }

        System.out.println("Sorting by prices");
        for( Book book: Sort_books.by_prices(library)){
            if (book != null){
                book.show();
            }
        }
    }
}
