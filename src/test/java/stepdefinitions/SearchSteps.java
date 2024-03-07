package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchBar;

import java.util.ArrayList;
import java.util.List;

import static utility.BrowserSetup.getDriver;

public class SearchSteps {
    WebDriver driver = getDriver();
    SearchBar searchBar = new SearchBar(driver);
    List<WebElement> suggestions;
    String search;


    @When("user is on the homepage search bar should be visible")
    public void user_is_on_the_homepage_search_bar_should_be_visible() {
        if(driver.getTitle().equals("Amazon.in")){
            driver.navigate().refresh();
        }
    }

    @And("I'll pass the keys to search the {string}")
    public void i_ll_pass_the_keys_to_search_the(String string) throws InterruptedException {
        search = string;
        searchBar.checkSearchBox(string);
    }

    @And("I'll parse the suggestion and store them in a list")
    public void i_ll_parse_the_suggestion_and_assert_them_with_the_title() {
        suggestions = driver.findElements(By.cssSelector("div.s-suggestion.s-suggestion-ellipsis-direction"));
    }

    @And("I'll press the search button")
    public void i_ll_press_the_search_button() {
        searchBar.clickOnserachButton();
    }

    @Then("I'll parse the suggestions and assert them with the search {string}")
    public void iLlParseTheSuggestionsAndAssertThemWithTheSearch(String string) {
        boolean flag = true;
        for(WebElement w: suggestions){
            if(!w.getText().contains(search))
            {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);

    }

    @Then("I'll parse the results and assert them with the search {string}")
    public void i_ll_parse_the_results_and_assert_them_with_the_search(String string) {

    }


}
