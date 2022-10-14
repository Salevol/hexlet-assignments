package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        for (String word: sentence.split(" ")) {
            int count = words.containsKey(word) ? words.get(word) : 0;
            words.put(word, count + 1);
            }
        return words;
        }

    public static String toString(Map<String, Integer> map) {
        String result = "{\n";
        for (Map.Entry<String, Integer> word: map.entrySet()) {
            result += "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        return result;
    }
}
