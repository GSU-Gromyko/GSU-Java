import gsu.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RunnerCollections {
    public static void main(String[] args) throws IOException {

        ArrayList<Book> books = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/books.csv"));

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {

            String[] params = currentLine.split(";");

            books.add(new Book(Integer.parseInt(params[0]), params[1], params[2], params[3],
                    Short.parseShort(params[4]), Short.parseShort(params[5]), Boolean.parseBoolean(params[6])));
        }
        bufferedReader.close();

        // Sort
        Collections.sort(books);

        // Print
        String author = "Delia Owens";
        System.out.println("Books where author is " + author + ":");
        for (Book book: books){
            if (book.getAuthor().equals(author)){
                book.showInfo();
            }
        }

        String publisher = "Doubleday";
        System.out.println("Books where publisher is " + publisher + ":");
        for (Book book: books){
            if (book.getPublisher().equals(publisher)){
                book.showInfo();
            }
        }

        short year = 2018;
        System.out.println("Books released after " + year + ":");
        for (Book book: books){
            if (book.getYear() >= year){
                book.showInfo();
            }
        }

        // Write
        File csvFile = new File("src/sorted_books.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))){
            for(Book book : books){
                csvWriter.println(book);
            }
        } catch (IOException e) {
            //Handle exception
            e.printStackTrace();
        }

    }
}
