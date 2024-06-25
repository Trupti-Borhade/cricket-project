package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "stepdef",
        tags = "@smoke",
        plugin = { "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)


public class TestRunner {
}

