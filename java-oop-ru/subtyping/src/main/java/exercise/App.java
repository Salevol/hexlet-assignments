package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class App {
    public static final void swapKeyValue(KeyValueStorage kvs) {
        Map<String, String> swapped = new HashMap<>();
        for (Entry entry: kvs.toMap().entrySet()) {
            kvs.unset((String) entry.getKey());
            kvs.set((String) entry.getValue(), (String) entry.getKey());
        }
    }
}
