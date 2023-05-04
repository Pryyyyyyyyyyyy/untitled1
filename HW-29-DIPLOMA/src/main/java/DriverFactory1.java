import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

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
}

public class Waiters1 {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(Waiters1.class);

    public Waiters1(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForPresenceOfElementLocated(By by) {
        logger.info("Waiting for presence of element located by " + by.toString());
        return fluentWait(EXPLICIT_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        logger.info("Waiting for element to be clickable by " + by.toString());
        return fluentWait(EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForTextToBePresentInElementValue(By by, String text) {
        logger.info("Waiting for text '" + text + "' to be present in element value located by " + by.toString());
        fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }

    private FluentWait<WebDriver> fluentWait(long timeoutSeconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_INTERVAL))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
}

public class Action1 {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(Action1.class);

    public Action1(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By by) {
        logger.info("Clicking element located by " + by.toString());
        driver.findElement(by).click();
    }

    public void sendKeysToElement(By by, String text) {
        logger.info("Sending keys '" + text + "' to element located by " + by.toString());
        driver.findElement(by).sendKeys(text);
    }
}

public class Assertions1 {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(Assertions1.class);

    public Assertions1(WebDriver driver) {
        this.driver = driver;
    }

    public void assertElementIsDisplayed(By by) {
        logger.info("Asserting that element located by " + by.toString() + " is displayed");
        assertTrue(driver.findElement(by).isDisplayed(),
                "Element located by " + by.toString() + " is not displayed, but it should be");
    }

    public void assertTextEquals(By by, String expectedText) {
        logger.info("Asserting that element located by " + by.toString() + " has text equal to '" + expectedText + "'");
        assertEquals(driver.findElement(by).getText(), expectedText,
                "Element located by " + by.toString() + " has text '" + driver.findElement(by).getText()
