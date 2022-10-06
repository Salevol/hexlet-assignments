package exercise;

import java.util.Arrays;
import java.util.ArrayList;

public class App {
    public static Boolean scrabble (String characters, String word){
        if (word.length() > characters.length()) {
            return false;
        }
        ArrayList<String> letters = new ArrayList<String>(Arrays.asList(characters.split("")));

        for (String ch : word.toLowerCase().split("")) {
            if (letters.contains(ch)) {
                letters.remove(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}