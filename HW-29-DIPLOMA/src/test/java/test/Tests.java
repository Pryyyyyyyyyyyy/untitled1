package test;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
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
        elements.clickOnElement3(By.xpath("//a[@data-lang='ru-RU']"));
        logger.info("Clicked on RU link from home page");
    }

    @Test
    public static void testSearch() {
        driver.get("https://pampik.com/ua");
        Duration timeout = Duration.ofSeconds(10);
        wait.waitForElementToBeClickable(By.xpath("//input[@id='search-form__input']"));
        elements.sendKeysToElement(By.xpath("//input[@id='search-form__input']"),"Підгузки");
        logger.info("Результати пошуку за запитом 'Підгузки'");
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
   /*     assertions.assertTextPresentOnPage("Дякуємо, Ваш email успішно додано!");*/ // питання по посткондішону
    }

    @Test
    public void testClickFqSelector2() {
        driver.get("https://pampik.com/ua");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
        elements.clickOnElement2(By.xpath("//div[@class='fq_selector active' and @itemprop='name']"));
 /*       wait.waitForVisabilityOfElement(By.xpath("//h1[@class='title' and text()='Дитяча спальня та інтер'єр']"));*/
        assertions.assertTextPresentOnPage("Дитяча спальня та інтер'єр");
    }
    @Test
    public void testClickSubMenu() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisabilityOfElement(By.xpath("//span[@class='category-menu-title' and text()='Прогулянки і поїздки']"));
        action.moveToElement(By.xpath("//span[@class='category-menu-title' and text()='Прогулянки і поїздки']"));
        wait.waitForVisabilityOfElement(By.xpath("//a[@href='/ua/category/progulocnye-kolaski']"));
        elements.clickOnElement3(By.xpath("//a[@href='/ua/category/progulocnye-kolaski']"));

    }
    @Test
    public void testMoveToElementCategoryClick() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisabilityOfElement(By.xpath("//a[@class='category-item__title' and text()='Ігрова кімната і безпека']"));
        action.moveToElement(By.xpath("//a[@class='category-item__title' and text()='Ігрова кімната і безпека']"));
        elements.clickOnElement3(By.xpath("//li[@class='all-category']/a[@href='/ua/category/igrovaya-komnata-i-bezopasnost']"));
    }
    @Test
    public void testClickPampikLinkAndAssertTitle() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");
        wait.waitForVisabilityOfElement(By.xpath("//a[@href='#' and text()='pampik.com']"));
        elements.clickOnElement2(By.xpath("//a[@href='#' and text()='pampik.com']"));
        assertions.assertTitleEquals("Дитяча кімната і безпека | | Интернет магазин детских товаров в Украине. Купить товары для детей с доставкой - Pampik.");
    }

    @Test
    public void testSliderNavigation() {
        driver.get("https://pampik.com/ua/category/detskaya-komnata-i-bezopasnost");

        wait.waitForVisabilityOfElement(By.cssSelector("h5.section-title.blog-view__title"));
        elements.scrollToElement(By.cssSelector("h5.section-title.blog-view__title"));

        wait.waitForVisabilityOfElement(By.cssSelector("button.slick-next.slick-arrow"));
        elements.clickOnElement2(By.cssSelector("button.slick-next.slick-arrow"));

        wait.waitForVisabilityOfElement(By.cssSelector("button.slick-prev.slick-arrow"));
        elements.clickOnElement2(By.cssSelector("button.slick-prev.slick-arrow"));


    }
    @Test
    public void testClickChildRoomLinkAndAssertTitle() {
        driver.get("https://pampik.com/ua/promo");
        wait.waitForVisabilityOfElement(By.xpath("//a[@class='check-box__label' and contains(text(), 'Дитяча кімната')]"));
        elements.clickOnElement2(By.xpath("//a[@class='check-box__label' and contains(text(), 'Дитяча кімната')]"));
        assertions.assertTitleEquals("Дитяча кімната | Интернет магазин детских товаров в Украине. Купить товары для детей с доставкой - Pampik.");
    }
    @Test
    public void testClickBannerLinkAndAssertText() {
        driver.get("https://pampik.com/ua/promo");
        wait.waitForVisabilityOfElement(By.xpath("//span[text()='Зміни в умовах доставки']"));
        elements.clickOnElement3(By.xpath("//span[@class='banner-link icon icon-big-arrow' and span[text()='Перейти']]"));
        assertions.assertElementIsDisplayed(By.xpath("//div[contains(@class, 'banner-item')]//span[contains(text(), 'Зміни в умовах доставки')]"));
    }

    @Test
    public void testClickContactUsTooltipAndAssertText() {
        driver.get("https://pampik.com/ua/promo");
        wait.waitForVisabilityOfElement(By.xpath("//div[@class='rngst_phone_body--tooltip rngst_phone_icon']"));
        elements.clickOnElement2(By.xpath("//div[@class='rngst_phone_body--tooltip rngst_phone_icon']"));
        wait.waitForVisabilityOfElement(By.xpath("//a[@class='messengers-icon-btn' and contains(@href, 'telegram')]"));
        assertions.assertTextPresentOnPage("Telegram");
        logger.info("Telegram");
    }
    @Test
    public void testClickDishwashingSuppliesLinkAndAssertTitle() {
        driver.get("https://pampik.com/ua/promo");
        wait.waitForVisabilityOfElement(By.xpath("//h2[text()='Види акцій та знижок']"));
        elements.clickOnElement3(By.xpath("//a[@href='https://pampik.com/ua/category/sredstva-dlya-myitya-posudyi']"));
        assertions.assertTitleEquals("Засоби для миття посуду | Интернет магазин детских товаров в Украине. Купить товары для детей с доставкой - Pampik.");
    }
    @Test
    public void testClickDeliveryBagLinkAndAssertText() {
        driver.get("https://pampik.com/ua/promo");
        wait.waitForPresenceOfElement(By.xpath("//a[@class='transparent-link transparent-link--violet' and contains(text(), 'Сумка у пологовий будинок')]"));
        elements.clickOnElement3(By.xpath("//*[@id='main']/div/div[1]/div[1]/ul[2]/li[1]/a"));
        assertions.assertTitleEquals("Сумка в роддом. Выберите готовый набор или составьте свой список.");
    }

    @AfterTest
    public void closeDriver(){
        logger.info("CLOSING DRIVER");
        driver.quit();
    }
}