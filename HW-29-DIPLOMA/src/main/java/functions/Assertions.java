package functions;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    private final WebDriver driver;
    private final Waiters waiters;
    private final Action actionist;
    private final Elements elements;
    private final Logger logger = Logger.getLogger(String.valueOf(Assertions.class));

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        waiters = new Waiters(driver);
        actionist = new Action(driver);
    }
    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath),"Элемент не отображается, а должен был");
    }
    public void equalsOfText(String xpath,String expectectText){
        assertEquals(elements.getElementText(elements.findElementByXpath(xpath)),expectectText,
                "Я ожидал получить текст "+expectectText+". А получил "+
                        elements.getElementText(elements.findElementByXpath(xpath))+".");
    }

    public void assertElementIsntDisplayed(String xpath, String expectectText) {
        assertEquals(elements.getElementText(elements.findElementByXpath(xpath)),expectectText,
                "Я ожидал получить текст "+expectectText+". А получил "+
                        elements.getElementText(elements.findElementByXpath(xpath))+".");
    }
    public void assertTextPresentOnPage(String expectedText) {
        assertTrue(driver.getPageSource().contains(expectedText),
                "The expected text " + expectedText + " is not present on the page.");
    }
    public void assertElementIsDisplayed(@NotNull By by) {
        logger.info("Asserting that element located by " + by.toString() + " is displayed");
        Assert.assertTrue("Element located by " + by.toString() + " is not displayed, but it should be",
                driver.findElement(by).isDisplayed());

    }

}

