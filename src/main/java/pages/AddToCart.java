package pages;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.eo.Se;
import io.cucumber.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddToCart {
    private WebDriver driver;

    @FindBy(id="a-autoid-1-announce")
    WebElement addToCart;

    @FindBy(css ="a#nav-cart")
    WebElement carButton;

    public AddToCart(WebDriver driver){
        this.driver= driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
    }


    public void search_the_product(String text) throws InterruptedException {
        SearchBar search  = new SearchBar(driver);
        search.checkSearchBox(text);
        search.clickOnSearchButton();
    }


    public void addd_to_cart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 450);");
        addToCart.click();
    }

    public void go_to_cart(){
        carButton.click();
    }

    public List<WebElement> get_list_of_products(){
        return driver.findElements(By.className("a-truncate-cut"));
    }

    public List<WebElement> get_list_of_prices(){
        return driver.findElements(By.cssSelector("div.a-section.a-spacing-mini > span.a-size-medium"));

    }

    public String get_sub_total(){
        return driver.findElement(By.cssSelector("#sc-subtotal-amount-buybox > span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap")).getText();
    }



}
