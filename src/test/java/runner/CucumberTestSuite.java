package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to your feature files
    glue = "steps", // Package where step definitions are located
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"},
    monochrome = true // Optional: cleaner console output
)
public class CucumberTestSuite {
}
