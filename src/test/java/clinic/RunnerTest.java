package clinic;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources/clinic.feature")
@RunWith(Cucumber.class)
public class RunnerTest {

}
