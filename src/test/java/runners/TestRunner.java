package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // path to your feature files
        glue = "stepdefinitions",                   // package containing your step definitions
        plugin = {
                "pretty",                            // prints steps in console
                "html:target/cucumber-report.html", // HTML report
                "json:target/cucumber-report.json"  // JSON report (optional)
        },
        monochrome = true                      // cleaner console output
)
public class TestRunner {
    // No additional code needed
}