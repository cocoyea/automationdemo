package runnerfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict=false,
        dryRun=false,
        monochrome=false,
        plugin={"pretty"},
        features = {
                "classpath:features"
        },
        glue = {
                "stepdefinitions"
        },
        tags = {
                "@ViewStock"
        }
)

public class CartPageRunner {
}
