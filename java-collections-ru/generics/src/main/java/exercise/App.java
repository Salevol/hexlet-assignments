package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            Integer i = 0;
            for (String key : where.keySet()) {
                if (where.get(key) == book.get(key)) {
                    i++;
                }
            }
            if (i == where.size()) {
                result.add(book);
            }
        }
        return result;
    }
}
