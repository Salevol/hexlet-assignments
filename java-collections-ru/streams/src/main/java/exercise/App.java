package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .filter(email -> isFree(email))
                .count();
    }

    private static Boolean isFree(String email) {
        if (email.endsWith("@hotmail.com") || email.endsWith("@yandex.ru") || email.endsWith("@gmail.com")) {
            return true;
        }
        return false;
    }
}
