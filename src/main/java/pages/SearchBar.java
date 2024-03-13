package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class SearchBar {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
    private WebElement searchButton;

    @FindBy(css ="div.s-suggestion.s-suggestion-ellipsis-direction")
    private List<WebElement> suggestions;

    @FindBy(css = "h2 >span.a-size-base-plus.a-color-base")
    private List<WebElement> results;

    private WebDriverWait wait;

    public SearchBar(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkSearchBox(String text) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(text);
    }

    public List<WebElement> fetchSuggestions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
        return suggestions;
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public List<WebElement> fetchResults() {
        wait.until(ExpectedConditions.visibilityOfAllElements(results));
        return results;
    }
}
