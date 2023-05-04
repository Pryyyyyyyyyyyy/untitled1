package test;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Tests {
    private static final Logger logger = Logger.getLogger(String.valueOf(Tests.class));

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
        long IMPLICITY_WAIT = 20;
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        wait = new Waiters(driver);
        action = new Action(driver);
        assertions = new Assertions(driver);
        elements = new Elements(driver);
    }

    public static void testClickRusLink() {
        driver.get("https://pampik.com/ua");
        elements.clickOnElement2(By.xpath("//a[@data-lang='ru-RU']"));
        logger.info("Clicked on RU link from home page");
    }


    public static void testSearch() {
        driver.get("https://pampik.com/ua");
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-form__input']")));
        searchBox.sendKeys("Підгузки");
        wait.until(ExpectedConditions.textToBePresentInElementValue(searchBox, "Підгузки"));
    }
/*
    String searchResultsText = elements.getElementText(By.xpath("//div[@class='search-page__title']/h1"));
        logger.info("Search results text: " + searchResultsText);
    }*/

}