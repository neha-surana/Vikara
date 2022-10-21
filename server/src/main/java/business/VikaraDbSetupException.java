package business;

public class VikaraDbSetupException extends RuntimeException {

    public VikaraDbSetupException(String message) {
        super(message);
    }

    public VikaraDbSetupException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class VikaraConnectionDbSetupException extends VikaraDbSetupException {
        public VikaraConnectionDbSetupException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class VikaraQueryDbSetupException extends VikaraDbSetupException {
        public VikaraQueryDbSetupException(String message) {
            super(message);
        }

        public VikaraQueryDbSetupException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
