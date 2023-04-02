package exercise;

import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
       MaxThread thread1 = new MaxThread(numbers);
       MinThread thread2 = new MinThread(numbers);
       thread1.start();
       LOGGER.info(thread1.getName() + " started");
       thread2.start();
       LOGGER.info(thread2.getName() + " started");
       try {
           thread1.join();
           thread2.join();
       } catch (InterruptedException e) {
           System.out.println("Поток был прерван");
       }
       return Map.of("max", thread1.getMax(), "min", thread2.getMin());
    }
    // END
}
