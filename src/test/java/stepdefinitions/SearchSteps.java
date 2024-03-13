package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchBar;
import utility.BrowserSetup;

import java.time.Duration;
import java.util.List;

public class SearchSteps {
    WebDriver driver = BrowserSetup.getDriver();
    SearchBar searchBar = new SearchBar(driver);
    List<WebElement> suggestions;
    List<WebElement> results;
    String search;

    @When("user is on the homepage search bar should be visible")
    public void user_is_on_the_homepage_search_bar_should_be_visible() {
        if (driver.getTitle().equals("Amazon.in")) {
            driver.navigate().refresh();
        }
    }

    @And("I'll pass the keys to search the {string}")
    public void i_ll_pass_the_keys_to_search_the(String string) throws InterruptedException {
        search = string;
        searchBar.checkSearchBox(string);
    }

    @And("I'll parse the suggestion and store them in a list")
    public void i_ll_parse_the_suggestion_and_store_them_in_a_list() {
        suggestions = searchBar.fetchSuggestions();
    }

    @And("I'll press the search button")
    public void i_ll_press_the_search_button() {
        searchBar.clickOnSearchButton();
    }

    @Then("I'll wait for the results")
    public void i_ll_wait_for_the_results() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h2 >span.a-size-base-plus.a-color-base")));
    }

    @Then("I'll parse the suggestions and assert them with the search {string}")
    public void i_ll_parse_the_suggestions_and_assert_them_with_the_search(String string) {
        boolean flag = true;
        System.out.println("resutls for resuls suggestion -----------");
        for (WebElement w : suggestions) {
            if (w.getText().contains(search)) {
                System.out.println(w.getText());
            }
        }
    }

    @Then("I'll parse the results and assert them with the search {string}")
    public void i_ll_parse_the_results_and_assert_them_with_the_search(String string) {
        results = searchBar.fetchResults();
        System.out.println("resutls for resuls");
        for (WebElement web : results) {
            if (web.getText().contains(string)) {
                System.out.println(web.getText());
            }
        }
    }
}
