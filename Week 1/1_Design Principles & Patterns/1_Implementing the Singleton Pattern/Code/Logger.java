public class Logger {
    private static final Logger instance = new Logger();
    private Logger() {
        System.out.println("Logger instance created.");
    }
    public static Logger getInstance() {
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
