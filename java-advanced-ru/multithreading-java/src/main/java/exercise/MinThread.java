package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class MinThread extends Thread {
    private final List<Integer> list;
    private Integer min;

    public Integer getMin() {
        return min;
    }

    public MinThread(int[] list) {
        this.list = Arrays.stream(list)
                .boxed()
                .toList();
    }

    @Override
    public void run() {
        this.min = list.stream()
                .mapToInt(v -> v)
                .min().orElseThrow();
    }
}
// END
