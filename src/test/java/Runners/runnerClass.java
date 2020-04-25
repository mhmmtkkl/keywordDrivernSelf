package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },

        features={"src/test/resources"},
        glue={"StepDefinition"},
        dryRun=false
)

public class runnerClass {

}
