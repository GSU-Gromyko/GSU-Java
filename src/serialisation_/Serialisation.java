package serialisation_;

import book.Book;
import exceptions_.EmptyArrayException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;
import java.util.EmptyStackException;

public class Serialisation {

    public void serialise(Book[] books) throws EmptyArrayException {
        ObjectOutputStream objectOutputStream = null;
        if (books.length == 0) throw new EmptyArrayException("Array is empty");
        try {
            System.out.println("Serialization");
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/books.csv"));
            objectOutputStream.writeObject(books);
            objectOutputStream.close();
        } catch (NoSuchFileException ex){
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
