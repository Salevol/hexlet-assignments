package exercise;

import java.time.LocalDateTime;

import exercise.daytimes.Daytime;
import exercise.daytimes.Morning;
import exercise.daytimes.Day;
import exercise.daytimes.Evening;
import exercise.daytimes.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BEGIN
@Configuration
class MyApplicationConfig {
    @Bean
    public Daytime getTimeOfDay() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 6 && hour < 12) {
            return new Morning();
        } else if (hour >= 12 && hour < 18) {
            return new Day();
        } else if (hour >= 18 && hour < 23) {
            return new Evening();
        } else {
            return new Night();
        }
    }
}
// END
