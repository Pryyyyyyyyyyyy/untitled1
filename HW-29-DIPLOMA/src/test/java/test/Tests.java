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
        assertions.elementIsDisplayed("//div[@class='popup popup-callback']");
        assertions.elementIsDisplayed("//div[@class='popup-title']");
        By buttonLocator = By.xpath("//*[@id='callback']/div/button");
        wait.waitForElementToBeClickable(buttonLocator);
        elements.clickOnElement2(buttonLocator);

    }
    @Test
    public static void testClickFqSelector() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        elements.clickOnElement2(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        elements.getElementText1(By.xpath("//*[@id='main']/div/div[6]/section/div[2]/div[1]/div/img"));
        assertions.assertElementIsDisplayed(By.xpath("//*[@id='main']/div/div[6]/section/div[2]/div[1]/div/img"));
    }
    @Test
    public static void testSubmitEmail() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"));
        elements.sendKeysToElement(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"), "fgdfgfdg");
        elements.submitForm(By.xpath("//div[@class='input-row']/input[@type='email' and @data-validate='required-email']"));
   /*     assertions.assertTextPresentOnPage("Дякуємо, Ваш email успішно додано!");*/
    }

    @Test
    public void testClickFqSelector() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisibilityOfElement(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        elements.clickOnElement(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        wait.waitForVisibilityOfElement(By.xpath("//h1[@class='title' and text()='Дитяча спальня та інтер'єр']"));
        assertions.assertTextPresentOnPage("Дитяча спальня та інтер'єр");
    }
    @Test
    public void testClickSubMenu() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisibilityOfElement(By.xpath("//span[@class='category-menu-title' and text()='Прогулянки і поїздки']"));
        actions.moveToElement(elements.findElementByXpath("//span[@class='category-menu-title' and text()='Прогулянки і поїздки']")).perform();
        wait.waitForVisibilityOfElement(By.xpath("//a[@href='/ua/category/progulocnye-kolaski']"));
        elements.clickOnElement(By.xpath("//a[@href='/ua/category/progulocnye-kolaski']"));
        wait.waitForVisibilityOfElement(By.xpath("//h1[@class='title' and @itemprop='Name' and text()='Дитячі прогулянкові коляски']"));
        assertions.assertTextPresentOnPage("Дитячі прогулянкові коляски");
    }
    @Test
    public void testMoveToElementAndAssertDisplayed() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisibilityOfElement(By.xpath("//a[@class='category-item__title' and text()='Ігрова кімната і безпека']"));
        actions.moveToElement(elements.findElementByXpath("//a[@class='category-item__title' and text()='Ігрова кімната і безпека']")).perform();
        elements.clickOnElement(By.xpath("//a[@href='/ua/category/igrovaya-komnata-i-bezopasnost']"));
        assertions.assertElementIsDisplayed(By.xpath("//h1[@class='title' and text()='Дитяча ігрова кімната']"));
    }
    @Test
    public void testClickPampikLinkAndAssertTitle() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisibilityOfElement(By.xpath("//a[@href='#' and text()='pampik.com']"));
        elements.clickOnElement(By.xpath("//a[@href='#' and text()='pampik.com']"));
        String pageTitle = driver.getTitle();
        assertions.assertTextPresentOnPage("Ігрова кімната і безпека | | Интернет магазин детских товаров в Украине. Купить товары для детей с доставкой - Pampik.");
    }
    @Test
    public void testSliderNavigation() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");

        wait.waitForVisabilityOfElement(By.cssSelector("h5.section-title.blog-view__title"));
        elements.scrollToElement(By.cssSelector("h5.section-title.blog-view__title"));

        wait.waitForVisabilityOfElement(By.cssSelector("button.slick-next.slick-arrow"));
        elements.clickOnElement(By.cssSelector("button.slick-next.slick-arrow"));

        wait.waitForVisabilityOfElement(By.cssSelector("button.slick-prev.slick-arrow"));
        elements.clickOnElement(By.cssSelector("button.slick-prev.slick-arrow"));


    }

}