package step_defs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:result/Result.html",
                "json:result/cucumber.json",
                "junit:result/cucumber.xml"
        },
        glue = {""},
        features = "src/test/resources",
        tags = {"not @in-progress"}
)
public class RunCucumberTest {
}
