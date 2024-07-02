package academy.devdojo.springboot2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//a anotação garantira que a classe poderá ser injetada como dependência de outras
@Component
public class DateUtil {
    public String formatLocalDataTimeToDataBaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss").format(localDateTime);
    }
}
