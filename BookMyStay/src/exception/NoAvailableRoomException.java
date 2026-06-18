package exception;

/**
 * Exception thrown when no rooms are available.
 */
public class NoAvailableRoomException extends RuntimeException {

    public NoAvailableRoomException(String message) {
        super(message);
    }
}