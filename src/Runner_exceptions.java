import book.Book;
import exceptions_.EmptyArrayException;
import exceptions_.NewArithmeticException;
import serialisation_.DeSerialisation;
import serialisation_.Serialisation;

public class Runner_exceptions {
    public static void main(String[] args) {

        Book[] books = new Book[5];

        books[0] = new Book("Name 1", 10, true);
        books[1] = new Book("Name 2", 20, true);
        books[2] = new Book("Name 3", 12, false);
        books[3] = new Book("Name 4", 15, true);
        books[4] = new Book("Name 5", 8, false);

        Serialisation serialisation = new Serialisation();

        try {
            serialisation.serialise(books);
        } catch (EmptyArrayException e){
            System.out.println("Out of memory");
        }

        DeSerialisation deSerialisation = new DeSerialisation();
        Book[] newBooks = null;
        try {
            newBooks = deSerialisation.deSerialize();
        } catch (NewArithmeticException e){
            System.out.println(e);
        }

        for (Book book: newBooks){
            System.out.println(book);
        }

        int booksWithPictures = 0;
        for (Book book: newBooks){
            if (book != null){
                if (book.isPictures()){
                    try {
                        booksWithPictures += 1;
                    } catch (NewArithmeticException e){
                        System.out.println("Error with math. Check " + e);
                    }
                }
            }
        }
        System.out.println("Books with pictures: " + booksWithPictures);


    }
}
