package Options;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( format= {"json:target/Destination/EstimatedBorrow.json"},
features = "src/test/java/Options",
glue = "Options"
)

public class EstimatedBorrowRunnerTest {

}
