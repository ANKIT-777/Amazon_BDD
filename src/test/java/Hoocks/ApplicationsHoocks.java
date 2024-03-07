
package Hoocks;

import io.cucumber.java.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.BrowserSetup;

public class ApplicationsHoocks {
    private BrowserSetup setup;
    private WebDriver driver;

    @Before
    public void  getBrowser(){
        WebDriver driver = new ChromeDriver();
        setup.setDriver(driver);
        driver.get("https://www.amazon.in/");
    }


    @After(order = 0)
    public void quitBrowser(){
        setup.quitDriver();

    }

}
