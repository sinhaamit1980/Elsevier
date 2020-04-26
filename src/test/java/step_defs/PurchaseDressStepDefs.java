package step_defs;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import pages.CheckoutPage;
import pages.HomePage;
import pages.PageGenerator;
import pages.SummerDressesPage;

public class PurchaseDressStepDefs {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    HomePage home_page;
    SummerDressesPage summer_dresses_page;
    CheckoutPage check_out_page;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        page = new PageGenerator(driver);
        home_page = page.GetInstance(HomePage.class);
        summer_dresses_page = page.GetInstance(SummerDressesPage.class);
        check_out_page = page.GetInstance(CheckoutPage.class);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page(){
        home_page.navigate_to_home_page();
    }

//    @When("I add a summer dress \"([^\"]*)\" to the cart")
    @When("I add a summer dress {string} to the cart")
    public void i_add_a_summer_dress_to_the_cart(String summer_dress_product){
        home_page.navigate_to_summer_dress_section();
        summer_dresses_page.add_a_product_to_cart(summer_dress_product);
    }

    @Then("I get the success message")
    public void i_get_the_success_message(){
        String actual_text = summer_dresses_page.get_cart_success_message();
        String expected_text = "Product successfully added to your shopping cart";
        Assert.assertTrue(actual_text.contains(expected_text));
    }

    @And("I can see the detail of the product added in the cart")
    public void i_can_see_the_detail_of_the_product_added_in_cart(){
        String actual_text = summer_dresses_page.get_product_detail_from_cart_overlay();
        String expected_text = "Printed Summer Dress";
        Assert.assertTrue(actual_text.contains(expected_text));
    }

    @Given("I have summer dress added to the cart")
    public void i_have_summer_dress_added_to_the_cart(){
        i_am_on_the_home_page();
        i_add_a_summer_dress_to_the_cart("Printed Chiffon Dress");
        summer_dresses_page.proceed_to_checkout();
    }

    @And("I proceed to checkout without sign in")
    public void i_proceed_to_checkout_without_sign_in(){
        check_out_page.continue_to_checkout();
    }

    @Then("I can see the option to Sign in")
    public void i_can_see_the_option_to_sing_in(){
        String actual_check_out_step = check_out_page.get_checkout_2nd_order_step();
        Assert.assertTrue(check_out_page.verify_sign_in());
        Assert.assertTrue(actual_check_out_step.contains("Sign in"));
    }
}
