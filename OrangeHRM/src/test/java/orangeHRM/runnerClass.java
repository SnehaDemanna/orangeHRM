package orangeHRM;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature/OrangeHRM.feature",
		//tags ="@regressionTest"
		tags = "@smokeTest"

		)		
public class runnerClass {


}
