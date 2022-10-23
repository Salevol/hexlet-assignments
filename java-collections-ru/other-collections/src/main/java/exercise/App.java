package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        return Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                .distinct()
                .flatMap(key -> Map.of(key, getDiff(map1, map2, key)).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2) -> key1, LinkedHashMap::new));
    }

    private static String getDiff(Map<String, Object> map1, Map<String, Object> map2, String key) {
        if (!map1.containsKey(key) && map2.containsKey(key)) {
            return "added";
        } else if (map1.containsKey(key) && !map2.containsKey(key)) {
            return "deleted";
        } else if (map1.get(key).equals(map2.get(key))){
            return "unchanged";
        } else {
            return "changed";
        }
    }
}
