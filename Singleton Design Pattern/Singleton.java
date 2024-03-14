class SingletonEager{
    private static SingletonEager instance = new SingletonEager();
    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return instance;
    }
}

class SingletonLazy{
    private static SingletonLazy instance=null;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(instance==null){
            instance = new SingletonLazy();//1,2 at same time
        }
        return instance;
    }
}
class SingletonThreadSafeMethod{
    private static SingletonThreadSafeMethod instance=null;

    private SingletonThreadSafeMethod(){}

    public static synchronized SingletonThreadSafeMethod getInstance(){
        if(instance==null){
            instance = new SingletonThreadSafeMethod();//1,2 at same time
        }
        return instance;
    }
}
class SingletonThreadSafeBlock{
    private static SingletonThreadSafeBlock instance=null;
    
    private SingletonThreadSafeBlock(){
        
    }

    public static SingletonThreadSafeBlock getInstance(){
        if(instance==null){
            synchronized(SingletonThreadSafeBlock.class){
                instance = new SingletonThreadSafeBlock();
            }
        }
        return instance;
    }
}


class Singleton{
    public static void main(String[] args) {
        SingletonLazy eagerObject = SingletonLazy.getInstance() ;
        System.out.println(eagerObject);

        SingletonLazy eagerObject1 = SingletonLazy.getInstance() ;
        System.out.println(eagerObject1);
        // SingletonEager eagerObject = SingletonEager.getInstance() ;
        // //eagerObject.getInstance();
        // System.out.println(eagerObject.hashCode());

        // SingletonEager eagerObject1 = SingletonEager.getInstance() ;
        // //eagerObject.getInstance();
        // System.out.println(eagerObject1.hashCode());
    }
}

//Example of singleton class
//https://medium.com/@rosuth/implementing-a-singleton-logger-in-java-eec94d2556c9
/* 
package creational.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger _instance;
    private LogLevel logLevel;
    private List<String> logs;
    private PrintWriter fileWriter;

    private Logger() {
        logLevel = LogLevel.INFO;
        logs = new ArrayList<>();
        try {
            fileWriter = new PrintWriter(new FileWriter("server.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance retrieval
    public static Logger getInstance() {
        if (_instance == null) {
            synchronized (Logger.class) {
                if (_instance == null) {
                    _instance = new Logger();
                }
            }
        }
        return _instance;
    }

    // Set the log level
    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    // Log a message with the specified level
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String log = String.format("[%s] [%s] %s", level, LocalDateTime.now(), message);
            System.out.println(log);
            fileWriter.println(log);
            fileWriter.flush();
        }
        logs.add(String.format("[%s] [%s] %s", level, LocalDateTime.now(), message));
    }

    // Display all logged messages
    public void displayLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Get the singleton instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are both loggers of the same reference? " + (logger1 == logger2));

        // Set the log levels and log messages
        logger1.setLogLevel(LogLevel.TRACE);
        System.out.println("\nTRACE level defined...");
        logger1.log(LogLevel.TRACE, "trace level log message");
        logger1.log(LogLevel.DEBUG, "debug level log message");
        logger1.log(LogLevel.INFO, "info level log message");
        logger1.log(LogLevel.WARN, "warn level log message");
        logger1.log(LogLevel.ERROR, "error level log message");

        // Display all logged messages
        System.out.println("Displaying all logged messages...");
        logger1.displayLogs();
    }
}
*/