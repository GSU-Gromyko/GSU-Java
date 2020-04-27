import gsu.Printer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RunnerStringsProcessing {
    public static void main(String[] args) throws IOException {

        ArrayList<String> words = new ArrayList<String>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/text.txt"));

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {

            for (String word: currentLine.split(" ")){
                words.add(word);
            }
        }
        bufferedReader.close();

        Printer.PrintSortedWords(words);

    }
}
