package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver){

        super(driver);
    }

    @FindBy(how=How.CSS, using = "div#block_top_menu ul[class='sf-menu clearfix menu-content'] li:nth-child(2)")
    WebElement dresses;

    @FindBy(how = How.CSS, using = "div#block_top_menu ul.sf-menu li a")
    List<WebElement> dressSections;

    @FindBy(how = How.CSS, using = "div#left_column ul.tree.dynamized li:nth-child(3) a")
    WebElement summer_dress;

   @FindBy(how=How.CSS, using ="li.sfHoverForce ul.submenu-container li:nth-child(3) a")
   WebElement summer_dress_sub_menu;

    public void navigate_to_home_page(){
        driver.get("http://automationpractice.com/index.php?");
    }

    public void navigate_to_summer_dress_section(){
        mouse_hover_to_dresses_menu();
        waitForElement(summer_dress);
        click(summer_dress);
    }

    public void mouse_hover_to_dresses_menu(){
        WebElement dresses = get_dresses_section_element();
        click(dresses);
    }

    public WebElement get_dresses_section_element(){
        WebElement element = null;
        for(int i=0; i< dressSections.size(); i++){
            if(dressSections.get(i).getText().contains("DRESSES")){
                element = dressSections.get(i);
                break;
            }
        }
        return element;
    }

}
