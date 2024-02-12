package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/AppFeatures" },
tags= "@formSubmission and @AC5-6",
glue = { "StepDefinitions", "AppHooks" }, plugin = {
		"json:target/cucumber.json", "pretty" })
public class TestRunner {

}
