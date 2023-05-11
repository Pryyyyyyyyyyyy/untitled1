package functions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class Elements {
    static final Logger logger = Logger.getLogger(String.valueOf(Elements.class));
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
    }

    public WebElement findElement(By by) {
        try {
            waiters.waitForVisabilityOfElement(by);
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            waiters.waitForVisabilityOfElement(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getElementText(WebElement element){

        waiters.waitForVisabilityOfElement(element);
        return element.getText();
    }
    public String getElementText(By by){
        waiters.waitForVisabilityOfElement(by);
        logger.info("Getting text from element");
        return driver.findElement(by).getText();
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }
    public void clickOnElement(WebElement element){
        waiters.waitForVisabilityOfElement(element);
        element.click();
    }
    public void clickOnElement2(By by){
        WebElement element= waiters.waitForPresenceOfElementReturn(by);
        logger.info("Click on element located by"+by);
        element.click();
        element.getText();
    }
    public void clickOnElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }
    public void clickOnElementInsideFrameXpath(String xpathFrame, String xpathElemnt){
        waiters.waitForFrameAndSwitchXpath(xpathFrame);
        WebElement element =findElementByXpath(xpathElemnt);
        element.click();
    }
    public boolean isElementDisplayed(String xpath){
        return findElementByXpath(xpath).isDisplayed();
    }
    public String getElementText1(By by) {
        WebElement element = findElement(by);
        return element.getText();
    }
    public void sendKeysToElement(By by, String keys) {
        WebElement element = driver.findElement(by);
        element.sendKeys(keys);
    }
    public void submitForm(By by) {
        WebElement inputField = findElement(by);
        inputField.submit();
    }

  /*  public void submitForm1(By locator) {
        WebElement element = wait.waitForPresenceOfElementLocated(locator);
        element.sendKeys(Keys.ENTER);
    }*/
  /*  public void submitForm2(By by) {
        WebElement inputField = findElement(by);
         inputField.sendKeys();
        inputField.submit();
    }*/

}