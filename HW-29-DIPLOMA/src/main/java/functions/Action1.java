package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Action1 {
    private final WebDriver driver;
    private final Logger logger = Logger.getLogger(Action1.class.getName());

    public Action1(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By by) {
        logger.info("Clicking element located by " + by.toString());
        driver.findElement(by).click();
    }
}