package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SummerDressesPage extends BasePage {
    public SummerDressesPage(WebDriver driver){
        super(driver);
    }

    public  By add_to_cart_btn = By.cssSelector("div.right-block div.button-container a.ajax_add_to_cart_button");

    @FindBy(how=How.CSS, using = "img[src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
    WebElement product_image_1;

    @FindBy(how=How.CSS, using = "img[src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
    WebElement product_image_2;

    @FindBy(how=How.CSS, using = "img[src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
    WebElement product_image_3;

    @FindBy(how=How.CSS, using = "div.layer_cart_product h2")
    WebElement cart_overlay_add_success_msg;

    @FindBy(how=How.CSS, using = "div.layer_cart_cart div.button-container a")
    WebElement proceed_to_checkout;

    @FindBy(how=How.ID, using = "layer_cart_product_title")
    WebElement cart_overlay_product_detail;


    public WebElement get_product_container_element_for_a_product(String product){
        waitForElement(product_image_1);
        WebElement product_image_to_be_added;
        switch(product){
            case "Printed Summer dress 1" :
                product_image_to_be_added = product_image_1;
                mouseHoverToAnElement(product_image_1);
                break;
            case "Printed Summer dress 2" :
                product_image_to_be_added = product_image_2;
                mouseHoverToAnElement(product_image_2);
                break;
            case "Printed Chiffon Dress" :
                product_image_to_be_added = product_image_3;
                mouseHoverToAnElement(product_image_3);
                break;
            default:
                product_image_to_be_added = product_image_1;
                mouseHoverToAnElement(product_image_1);
        }

        WebElement parent_element;
        parent_element = product_image_to_be_added.findElement(By.xpath("../../../.."));
        return parent_element;
    }

    public void add_a_product_to_cart(String product){
        WebElement product_parent = get_product_container_element_for_a_product(product);
//        mouseHoverToAnElement(product_image_1);
        WebElement add_to_cart_element = product_parent.findElement(add_to_cart_btn);;
        waitForElement(add_to_cart_element);
        click(add_to_cart_element);
        waitForElement(proceed_to_checkout);

    }

    public String get_cart_success_message(){
        return readText(cart_overlay_add_success_msg);
    }

    public String get_product_detail_from_cart_overlay(){
        return readText(cart_overlay_product_detail);
    }

    public void proceed_to_checkout(){
                click(proceed_to_checkout);
    }




}
