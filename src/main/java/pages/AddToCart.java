package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
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

    @FindBy(css = "input#add-to-cart-button")
    WebElement addToCartButton;

    public AddToCart(WebDriver driver){
        this.driver= driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
    }

    public void search_the_product(String text) throws InterruptedException {
        SearchBar search  = new SearchBar(driver);
        search.checkSearchBox(text);
        search.clickOnserachButton();
    }

    public void select_the_product(){
        List<WebElement> productList = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base"));
        WebElement product = productList.get(1);
        product.click();
    }

    public void newTabforProduct(){
        Set<String> allwindows = driver.getWindowHandles();
        for(String s : allwindows){
            System.out.println(s);
        }
    }

    public void switch_tab_to_product_page(){
        String currentWindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();

        for(String s : allwindows){
            if(!s.equals(currentWindow)){
                driver.switchTo().window(s);
            }
        }
    }


    public void addd_to_cart(){
        addToCartButton.click();
    }

}
