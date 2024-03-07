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
        List<WebElement> productList = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        WebElement product = productList.get(1);
        product.click();
    }


    public void addd_to_cart() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input#add-to-cart-button[type='button']")).click();
    }

}
