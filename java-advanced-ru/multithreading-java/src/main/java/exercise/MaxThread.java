package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class MaxThread extends Thread {
    private final List<Integer> list;
    private Integer max;

    public Integer getMax() {
        return max;
    }

    public MaxThread(int[] list) {
        this.list = Arrays.stream(list)
                .boxed()
                .toList();
    }

    @Override
    public void run() {
        this.max = list.stream()
                .mapToInt(v -> v)
                .max().orElseThrow();
    }
}
// END
