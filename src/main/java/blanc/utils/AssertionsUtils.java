package blanc.utils;


import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

@Slf4j
public class AssertionsUtils {

    private static final String LOG_MESSAGE = "{} :\nactual : '{}'\nexpected : '{}'";
    private static final String ACTUAL = "actual = ";
    private static final String EXPECTED = "expected = ";

    private AssertionsUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void equalInteger(int actual, int expected, String message) {
        Allure.step(message, () -> {
            Allure.step(ACTUAL + actual);
            Allure.step(EXPECTED + expected);
            log.debug(LOG_MESSAGE, message, actual, expected);
            Assertions
                    .assertThat(actual)
                    .as(message)
                    .isEqualTo(expected);
            log.debug("Assertions.equalInteger - Данная проверка прошла успешно");
        });
    }

}

