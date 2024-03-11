package TestrRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
      plugin = {
//               "me.jvt.cucumber.report.PrettyReports:target/cucumber",

                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "html: target/cucumber-reports"},
        tags = "@login"
)

public class myTestRunner {

}
