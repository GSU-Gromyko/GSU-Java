package serialisation_;

import book.Book;
import exceptions_.EmptyArrayException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialisation {

    public Book[] deSerialize() throws EmptyArrayException{
        Book[] books = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/books.csv"));
            books = (Book[])objectInputStream.readObject();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        if (books.length == 0) throw new EmptyArrayException("Array is empty");
        return books;
    }

}
