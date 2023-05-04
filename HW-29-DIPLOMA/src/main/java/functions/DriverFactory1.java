package functions;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class DriverFactory1 {

    private static final long IMPLICIT_WAIT = 20L;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    private static final Logger LOGGER = Logger.getLogger(DriverFactory1.class.getName());

    public void myMethod() {
        LOGGER.info("This is a log message");

    }


    public WebElement waitForPresenceOfElementLocated(By by) {
        LOGGER.info("Waiting for presence of element located by " + by.toString());
        long EXPLICIT_WAIT = 20;
        return fluentWait(EXPLICIT_WAIT)
                //IMPLICIT_WAIT, TimeUnit.SECONDS
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        LOGGER.info("Waiting for element to be clickable by " + by.toString());
        long EXPLICIT_WAIT = 20;
        return fluentWait(EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForTextToBePresentInElementValue(By by, String text) {
        LOGGER.info("Waiting for text '" + text + "' to be present in element value located by " + by.toString());
        long EXPLICIT_WAIT = 20;
        fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }

    private FluentWait<WebDriver> fluentWait(long timeoutSeconds) {
        long POLLING_INTERVAL = 5;
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_INTERVAL))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }





    public void sendKeysToElement(By by, String text) {
        LOGGER.info("Sending keys '" + text + "' to element located by " + by.toString());
        driver.findElement(by).sendKeys(text);
    }



    public void assertTextEquals(@NotNull By by, String expectedText) {
        LOGGER.info("Asserting that element located by " + by.toString() + " has text equal to '" + expectedText + "'");
        assertEquals(driver.findElement(by).getText(), expectedText,
                "Element located by " + by.toString() + " has text '" + driver.findElement(by).getText());
    }
}


