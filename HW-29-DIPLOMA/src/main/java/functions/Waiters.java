package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    static final Logger logger = LoggerFactory.getLogger(Waiters.class);
    private final WebDriver driver;
    private static final long EXPLICITY_WAIT=20L;

    public Waiters(WebDriver driver){
        this.driver=driver;
    }



    private FluentWait<WebDriver> fluentWait(Long duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function,Long timeOutInSeconds){
        logger.info("Waiting for function");
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }
    public void waitForVisabilityOfElement(WebElement element){
        logger.info("Waiting for visability of element");
        waitForFunction(ExpectedConditions.visibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitForVisabilityOfElement(By by){
        logger.info("Waiting for visability of element"+by.toString());
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)),EXPLICITY_WAIT);
    }
    public void waitForPresenceOfElement(By by){
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITY_WAIT);
    }
    public WebElement waitForPresenceOfElementReturn(By by){
        logger.info("Waiting for presence of element located by"+by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement waitForVisabilityOfElementReturn(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForVisabilityOfElementReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //textToBePresentInElementValue
    public void waitFortextToBePresentInElementValue(WebElement element, String text){
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(element,text),EXPLICITY_WAIT);
    }
    public void waitFortextToBePresentInElementValue(By by, String text){
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(driver.findElement(by),text),EXPLICITY_WAIT);
    }
    public void waitForInvisibilityOf(WebElement element){
        waitForFunction(ExpectedConditions
                .invisibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitForTitleContains(String text){
        waitForFunction(ExpectedConditions
                .titleContains(text),EXPLICITY_WAIT);
    }
    public WebElement waitForPresenceOfElementLocated(By by){
        logger.info("Waiting for presence of element located by"+by.toString());
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitSomeSecond(int seconds){
        int milisecond = seconds*1000;
        try {
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public WebElement waitForElementToBeClickable(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementToBeClickable(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
    public void waitForElementToBeSelected(By by){
        waitForFunction(ExpectedConditions.elementToBeSelected(driver.findElement(by)),EXPLICITY_WAIT);
    }
    public void waitForFrameAndSwitchXpath(String xpath){
        logger.info("Waiting for presence of frame located by"+xpath);
        waitForPresenceOfElementLocated(By.xpath(xpath));
        waitForFunction(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath(xpath)), EXPLICITY_WAIT);
    }
    public void waitForTextToBePresentInElementValue(By by, String text) {
        logger.info("Waiting for text '" + text + "' to be present in element value located by " + by.toString());
        long EXPLICIT_WAIT = 20;
        fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }

    public WebElement waitForVisibilityOfElement1(By locator) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfElement2(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
}