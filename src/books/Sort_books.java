package books;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_books {

    public static Book[] byNames(Book[] array){
        Arrays.sort(array, Comparator.comparing(Book::getName));
        return array;
    }

    public static Book[] byPrices(Book[] array){
        Arrays.sort(array, Comparator.comparing(Book::getPrice));
        return array;
    }

}
