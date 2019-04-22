package features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//        glue = "stepDefs/Mystepdefs.java",
        features = {"features"}
)

public class RunTest  {
}
