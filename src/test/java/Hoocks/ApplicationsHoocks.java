
package Hoocks;

import io.cucumber.java.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.BrowserSetup;

import java.io.File;

public class ApplicationsHoocks {
    private BrowserSetup setup;
    private WebDriver driver;

    @Before
    public void  getBrowser(){
        WebDriver driver = new ChromeDriver();
        BrowserSetup.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        if(driver.getTitle().equals("Amazon.in")){
            driver.navigate().refresh();
        }
    }

    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }





}
