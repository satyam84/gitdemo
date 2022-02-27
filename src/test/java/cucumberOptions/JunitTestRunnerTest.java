package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\java\\AddToCart.feature" }, glue = { "StepDefinations" }, monochrome = true, tags="@CheckOut or @ProductValidation",
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class JunitTestRunnerTest{

}
