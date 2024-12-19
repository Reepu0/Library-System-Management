package app;

public class Logger {
    private static Logger instance;

    // Constructor is private to prevent instantiation
    private Logger() {}

    // Method to return the single instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println(message);  // You can change this to write to a file or database
    }
}
