package exercise;

import java.util.Arrays;
import java.util.Collections;

public class App {
    public static String[][] enlargeArrayImage(String[][] matrix) {
        return Arrays.stream(matrix)
                .map(x -> new String[][] {x, x})
                .flatMap(x -> Arrays.stream(x))
                .map(x -> Arrays.stream(x)
                                .map(e -> new String[]{e, e})
                                .flatMap(e -> Arrays.stream(e))
                                .toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
