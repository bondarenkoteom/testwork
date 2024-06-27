package blanc.utils;

import blanc.exception.JsonPathNotFoundException;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class PathReader {

    public static <T> T jsonPathRead(String json, String path) {
        T value;
        try {
            value = JsonPath.parse(json).read(path);
        } catch (Exception e) {
            throw new JsonPathNotFoundException("В json нет значения по jsonPath - '%s'", e);
        }

        return value;
    }

    public static String convertToString(Object object) {
        if (object instanceof List<?> && ((List<?>) object).size() == 1) {
            return ((List<?>) object).get(0).toString();
        } else {
            return object.toString();
        }
    }

}
