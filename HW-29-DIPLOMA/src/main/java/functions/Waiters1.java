package functions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Waiters1 {
    private final WebDriver driver;
    private final Logger logger = Logger.getLogger(String.valueOf(Waiters1.class));
    private long EXPLICIT_WAIT;

    public Waiters1(WebDriver driver) {
        this.driver = driver;
    }
}