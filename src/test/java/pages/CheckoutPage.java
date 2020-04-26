package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how=How.CSS, using = ".cart_navigation a")
    WebElement proceed_to_checkout;

    @FindBy(how=How.ID, using = "SubmitLogin")
    WebElement submit_login_btn;

    @FindBy(how=How.CSS, using = "ul#order_step li.second")
    WebElement sign_in_order_step;


    public void continue_to_checkout(){
        click(proceed_to_checkout);
    }

    public boolean verify_sign_in(){
        return submit_login_btn.isDisplayed();
    }

    public String get_checkout_2nd_order_step(){
        return readText(sign_in_order_step);
    }



}
