package gsu;

import java.util.ArrayList;
import java.util.Collections;

public class Printer {
    public static void PrintSortedWords(ArrayList<String> text){
        Collections.sort(text);
        String letter = text.get(0).substring(0, 1);
        boolean redline = true;
        for (String word:text) {
            if(!word.substring(0, 1).equals(letter)){
                redline = true;
                letter = word.substring(0, 1);
            }
            if(redline){
                System.out.println("\t"+word);
            } else {
                System.out.println(word);
            }
            redline = false;
        }
    }
}
