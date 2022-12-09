package business;

public class VikarastoreDbException extends RuntimeException {

    public VikarastoreDbException(String message) {
        super(message);
    }

    public VikarastoreDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class VikarastoreConnectionDbException extends VikarastoreDbException {
        public VikarastoreConnectionDbException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class VikarastoreQueryDbException extends VikarastoreDbException {
        public VikarastoreQueryDbException(String message) {
            super(message);
        }

        public VikarastoreQueryDbException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
