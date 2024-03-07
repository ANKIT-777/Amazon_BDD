package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.AddToCart;

import static utility.BrowserSetup.getDriver;

public class AddToCartSteps {

    WebDriver driver = getDriver();
    AddToCart addToCart = new AddToCart(driver);

    @When("I'll search the product {string}")
    public void search_that_product(String text) throws InterruptedException {
        addToCart.search_the_product(text);
    }

    @And("I'll click on the product")
    public void clickOnTheProduct(){
        addToCart.select_the_product();
    }

    @And("I'll get a page for product selected")
    public void pages(){
        addToCart.newTabforProduct();
    }

    @And("Change to the product page")
    public void changeToProductPage(){
        addToCart.switch_tab_to_product_page();
    }

    @And("Add that product to the cart")
    public void addProductToCart(){
        addToCart.addd_to_cart();
    }

    @Then("I should get a Confirmation message Added to Cart")
    public void message(){

    }
    @Then("Go to Cart")
    public void go_to_cart(){

    }
    @Then("Check the product you added is present in Cart or not")
    public void checkProduct(){

    }

}
