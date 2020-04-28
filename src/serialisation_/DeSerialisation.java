package serialisation_;

import book.Book;
import exceptions_.NewArithmeticException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialisation {

    public Book[] deSerialize() throws NewArithmeticException{
        Book[] books = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/books.csv"));
            books = (Book[])objectInputStream.readObject();
            throw new ArithmeticException("ath error");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return books;
    }

}
