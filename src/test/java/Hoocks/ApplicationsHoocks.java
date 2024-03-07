
package Hoocks;

import io.cucumber.java.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
        if(driver.getTitle().equals("Amazon.in")){
            driver.navigate().refresh();
        }
    }


    @After(order = 0)
    public void quitBrowser(){
        setup.quitDriver();
    }

    @After(order = 1)
    public void reportSetup(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
    }

}
