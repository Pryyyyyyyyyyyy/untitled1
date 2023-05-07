package test;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
@BeforeTest
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
    @Test
    public static void testClickRusLink() {
        driver.get("https://pampik.com/ua");
        elements.clickOnElement2(By.xpath("//a[@data-lang='ru-RU']"));
        logger.info("Clicked on RU link from home page");
    }

    @Test
    public static void testSearch() {
        driver.get("https://pampik.com/ua");
        Duration timeout = Duration.ofSeconds(10);
      /*  WebDriverWait wait = new WebDriverWait(driver, timeout);*/
        wait.waitForElementToBeClickable(By.xpath("//input[@id='search-form__input']"));
       /* WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-form__input']")));
        searchBox.sendKeys("Підгузки");*/
        elements.sendKeysToElement(By.xpath("//input[@id='search-form__input']"),"Підгузки");
        wait.waitForTextToBePresentInElementValue(By.xpath("//h1[@class='title']"), "Результати пошуку за запитом 'Підгузки'");
     /*   wait.until(ExpectedConditions.textToBePresentInElementValue(searchBox, "Підгузки"));*/
    }
    @Test
    public static void testClickCallMeBtn() {
        driver.get("https://pampik.com/ua");
        wait.waitForPresenceOfElementLocated(By.xpath("//div[@class='callback']/a[@class='call-me-btn']"));
        elements.clickOnElement2(By.xpath("//div[@class='callback']/a[@class='call-me-btn']"));
        wait.waitForTextToBePresentInElementValue(By.xpath("//div[@class='popup-text']"), "Залиште свій номер телефону, і ми зв'яжемося з вами");
    /*    elements.clickOnElement2(By.xpath("//button[@data-dismiss='modal' and @type='button' and @class='close']"));*/
    }
    @Test
    public static void testClickFqSelector() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        elements.clickOnElement2(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        String text = elements.getElementText1(By.xpath("//div[@class='fq_selector' and not(@class='active')]"));
        System.out.println("Class text: " + text);
        assertions.assertElementIsntDisplayed(text, "active");
    }
    @Test
    public static void testSubmitEmail() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"));
        elements.sendKeysToElement(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"), "fgdfgfdg");
        elements.submitForm(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"));
        assertions.assertTextPresentOnPage("Дякуємо, Ваш email успішно додано!");
    }

}