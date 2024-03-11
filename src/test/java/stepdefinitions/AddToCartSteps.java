package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddToCart;

import java.util.List;

import static utility.BrowserSetup.getDriver;

public class AddToCartSteps {

    WebDriver driver = getDriver();
    AddToCart addToCart = new AddToCart(driver);

    @When("I'll search the product {string}")
    public void search_that_product(String text) throws InterruptedException {
        addToCart.search_the_product(text);
    }


    @And("Add that product to the cart")
    public void addProductToCart() throws InterruptedException {
        addToCart.addd_to_cart();
    }

    @Then("Go to Cart")
    public void checkProduct(){
        addToCart.go_to_cart();
    }

    @Then("Check the product you added is present in Cart or not")
    public void check_cart_list(){
        List<WebElement> listOfProducts = addToCart.get_list_of_products();
        System.out.println(listOfProducts);
    }

    @Then("Check the products prices and match with the subtotal")
    public void check_pricing_and_subtotal(){
        List<WebElement> listOfProducts = addToCart.get_list_of_products();
        List<WebElement> allPrices =  addToCart.get_list_of_prices();

        for(int i = 0;i<allPrices.size();i++){
            System.out.println("name of product" +listOfProducts.get(i).getText()  + " witn the price of"+   allPrices.get(i).getText());
        }
        String total = addToCart.get_sub_total();

        System.out.println(total  + " and total of all that ");

    }

}
