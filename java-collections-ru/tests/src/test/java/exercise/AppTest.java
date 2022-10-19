package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> listEmpty = new ArrayList<>();
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1,2,3));
        int num0 = 0;
        int num1 = 3;
        int num2 = 8;

        List<Integer> actual1 = App.take(list1, num1);
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> actual2 = App.take(listEmpty, num1);
        assertThat(actual2).isEqualTo(listEmpty);

        List<Integer> actual3 = App.take(list1, num2);
        assertThat(actual3).isEqualTo(list1);


    }
}
