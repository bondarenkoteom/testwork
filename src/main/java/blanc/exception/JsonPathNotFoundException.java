package blanc.exception;

public class JsonPathNotFoundException extends RuntimeException {

    public JsonPathNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
