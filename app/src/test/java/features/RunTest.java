package features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//        glue = "stepDefs/Mystepdefs",
        features = {"D:\\Users\\Raul\\Documents\\SpaceInvadersCS\\app\\src\\test\\java\\features\\"}
)

public class RunTest  {
}
