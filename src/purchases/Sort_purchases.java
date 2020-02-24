package purchases;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_purchases {

    public static Purchase[] get_sorted_purchases_by_values(Purchase[] array){
        Arrays.sort(array, Comparator.comparing(Purchase::money));
        return array;
    }

    public static Purchase[] get_sorted_purchases_by_names(Purchase[] array){
        Arrays.sort(array, Comparator.comparing(Purchase::getName));
        return array;
    }
}
