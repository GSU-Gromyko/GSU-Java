package books;
import java.util.ArrayList;
import java.util.Comparator;

public class Sort_books {

    public static ArrayList<Book> byNames(Book[] array){
        ArrayList<Book> sorted_by_name = new ArrayList<>();
        for (Book book: array){
            if (book != null){
                sorted_by_name.add(book);
            }
        }
        sorted_by_name.sort(Comparator.comparing(Book::getName));
        return sorted_by_name;
    }

    public static ArrayList<Book> byPrices(Book[] array){
        ArrayList<Book> sorted_by_price = new ArrayList<>();
        for (Book book: array){
            if (book != null){
                sorted_by_price.add(book);
            }
        }
        sorted_by_price.sort(Comparator.comparing(Book::getPrice));
        return sorted_by_price;
    }

}
