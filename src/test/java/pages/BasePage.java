package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver){
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.driver, 20);

    public  void click(WebElement elementAttr){
         elementAttr.click();
    }

    public  void writeText(WebElement elementAttr, String text){
           elementAttr.sendKeys(text);
    }

    public String readText(WebElement elementAttr){
            return  elementAttr.getText();
    }

    public WebElement waitForElement(WebElement elementAttr){
            return (wait.until(ExpectedConditions.visibilityOf(elementAttr)));
    }

    public void mouseHoverToAnElement(WebElement elementAttr){
        Actions builder = new Actions(driver);
        builder.moveToElement(elementAttr).build().perform();
    }
}