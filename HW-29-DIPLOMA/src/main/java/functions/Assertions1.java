package functions;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Assertions1 {
    private final WebDriver driver;
    private final Logger logger = Logger.getLogger(String.valueOf(Assertions1.class));

    public Assertions1(WebDriver driver) {
        this.driver = driver;
    }

    public void assertElementIsDisplayed(@NotNull By by) {
        logger.info("Asserting that element located by " + by.toString() + " is displayed");
        assertTrue("Element located by " + by.toString() + " is not displayed, but it should be",
                driver.findElement(by).isDisplayed());

    }
    public void assertElementIsntDisplayed(@NotNull By by) {
        logger.info("Asserting that element located by " + by.toString() + " is not displayed");
        assertFalse("Element located by " + by.toString() + " is not displayed, but it should be",
                driver.findElement(by).isDisplayed());
    }
}

