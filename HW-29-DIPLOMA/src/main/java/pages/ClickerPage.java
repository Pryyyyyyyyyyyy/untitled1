/*
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ClickerPage extends BasePage{

    public ClickerPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By counter = By.xpath("//div[@id='counter']/span");
        private final static By plus = By.xpath("//div[@id='plus-btn']");
        private final static By minus = By.xpath("//div[@id='minus-btn']");
        private final static By reset = By.xpath("//button[@id='reset']");
        private final static By consent = By.xpath("//p[text()='Consent']");

    }
    private static class Labels {
        private final static String frame = "//iframe[@src='https://www.clickspeedtester.com/online-click-counter/']";
        private final static String url = "https://www.clickspeedtester.com/click-counter/";
    }

    public void plusClick(int count){
        for (int i = 0;i<count;i++ ){elements.clickOnElement(Locators.plus);}
    }

    public void minusClick(int count){
        for (int i = 0;i<count;i++ ){elements.clickOnElement(Locators.minus);}
    }
    public void switchToFrame(){
        wait.waitForFrameAndSwitchXpath(Labels.frame);
    }
    public void acceptCoockies(){
        elements.clickOnElement(Locators.consent);
    }
    public int getIntFromCounter(){
        return Integer.parseInt(elements.getElementText(Locators.counter));
    }

    public void openPage(){
        driver.get(Labels.url);
    }
    public void scrollPage(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }
    public void resetClick(){
        elements.clickOnElement(Locators.reset);
    }


}*/
