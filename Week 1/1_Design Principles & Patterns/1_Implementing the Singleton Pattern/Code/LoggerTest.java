public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        String[] messages = {"First log message.", "Second log message.", "Third log message."};
        for (String msg : messages) {
            logger1.log(msg);
        }
        Logger logger2 = Logger.getInstance();
        System.out.println("\nLogger instance check: " + (logger1 == logger2 ? "SAME instance used." : "DIFFERENT instances!"));
        System.out.println("Total messages logged: " + messages.length);
    }
}
