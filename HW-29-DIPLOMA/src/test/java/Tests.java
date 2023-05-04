package org.example;

import functions.Waiters;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.util.Elements;
import java.util.concurrent.TimeUnit;

public class Tests {
    private static final Logger logger = LoggerFactory.getLogger(Tests.class);

    private static final long EXPLICITY_WAIT = 20L;
    static Waiters wait;
    static Action action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    public static void main(String[] args) {
        setupDriver();
        testClickRusLink();
        testSearch();
        driver.quit();
    }

    public static void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        long IMPLICITY_WAIT;
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        wait = new Waiters(driver);
        action = new Action(driver);
        assertions = new Assertions(driver);
        elements = new Elements(driver);
    }

    public static void testClickRusLink() {
        driver.get("https://pampik.com/ua");
        WebElement rusLink = wait.waitForPresenceOfElementLocated(By.xpath("//a[@data-lang='ru-RU']"));
        action.clickElement(rusLink);
        logger.info("Clicked on RU link from home page");
    }

    public static void testSearch() {
        driver.get("https://pampik.com/ua");
        WebElement searchBox = wait.waitForElementToBeClickable(By.xpath("//input[@id='search-form__input']"));
        action.sendTextToElement(searchBox, "Підгузки");
        wait.waitForTextToBePresentInElementValue(searchBox, "Підгузки");
        String searchResultsText = elements.getElementText(By.xpath("//div[@class='search-page__title']/h1"));
        logger.info("Search results text: " + searchResultsText);
    }
}
