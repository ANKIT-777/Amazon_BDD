package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.SearchBar;
import utility.BrowserSetup;

import javax.swing.*;

import static utility.BrowserSetup.getDriver;
//import utility.BrowserSetup;

public class LoginSteps {


    WebDriver driver;
    LoginPage login;


    @Given("I am on the login page")
    public void goToLoginPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        BrowserSetup.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        if(driver.getTitle().equals("Amazon.in")){
            driver.navigate().refresh();
        }
        login = new LoginPage(driver);
        driver = getDriver();
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    }

    @When("I enter (.*) and (.*)$")
    public void enterCredentials(String username,String password) throws InterruptedException {
        login.inputValues(username,password);
    }

    @When("I click the login button")
    public void clickLoginButton() throws InterruptedException {
        login.loginButtonClick();
    }

    @Then("I should see the welcome message")
    public void verifyWelcomeMessage() {
        String exTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    }





}
