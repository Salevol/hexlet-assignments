package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;



public class App {
    public static void save(Path path, Car car) throws Exception {
        Files.writeString(path, car.serialize());
    }

    public static Car extract(Path path) throws IOException {
        return Car.unserialize(Files.readString(path));
    }
}