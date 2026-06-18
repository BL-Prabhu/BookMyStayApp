package exception;

/**
 * Exception thrown when a room type is not found.
 */
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(String message) {
        super(message);
    }
}