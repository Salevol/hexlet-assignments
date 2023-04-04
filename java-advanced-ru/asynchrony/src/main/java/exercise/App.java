package exercise;

import java.nio.file.NoSuchFileException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.function.Supplier;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String result) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(file1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(file2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

       return future1.thenCombine(future2, (str1, str2) -> {
           try {
               writeFile(result, str1+str2);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
           return str1+str2;
       }).exceptionally(ex -> {
           System.out.println("Oops! We have an exception - " + ex.getMessage());
           return null;
       });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("file1.txt", "file2.txt", "dest.txt");
        // END
    }

    public static String readFile(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath();
        if (!Files.exists(path)) {
            throw new NoSuchFileException(path.toString());
        }
        return Files.readString(path);
    }

    public static void writeFile(String filePath, String content) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath();
        Files.writeString(path, content);
    }
}

