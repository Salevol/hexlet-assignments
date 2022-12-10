package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class App {
    public static void main(String[] args) {

    }

    public static final List<String> buildAppartmentsList(List<Home> apartments, int top) {
        return apartments.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .map(x -> x.toString())
                .limit(top)
                .toList();

    }
}
