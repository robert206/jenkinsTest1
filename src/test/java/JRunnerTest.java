import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"}
        ,glue={"CucumberTests"}
        ,tags = {"not @avoid","@FunctionalTest"}
        , plugin = {"json:target/cucumber.json", "html:target/cucumber-pretty"}
)

public class JRunnerTest {

}
