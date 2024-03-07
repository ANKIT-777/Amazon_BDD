package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement signInButton;

    @FindBy(id = "ap_email")
    private WebElement emailInput;

    @FindBy(className = "a-button-input")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
    }



    public void inputValues(String username, String password) {
            waitForVisibility(emailInput);
            emailInput.sendKeys(username);
            continueButton.click();
            waitForVisibility(passwordInput);
            passwordInput.sendKeys(password);
    }

    public void  loginButtonClick(){
        waitForVisibility(signInSubmitButton);
        signInSubmitButton.click();
    }

    private void waitForVisibility(WebElement element) {
        Duration customTimeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, customTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
