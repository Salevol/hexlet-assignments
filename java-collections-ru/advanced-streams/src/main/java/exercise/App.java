package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

public class App {
    public static String getForwardedVariables(String conf) {
        return Arrays.stream(conf.split("\n"))
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.split(","))
                .flatMap(x -> Arrays.stream(x))
                .filter(y -> y.startsWith("X_FORWARDED_"))
                .map(y -> y.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
