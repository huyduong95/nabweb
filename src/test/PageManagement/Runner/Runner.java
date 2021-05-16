package Runner;

import CoreManagement.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/TestSuite"}
        , glue = "PageDefinition"
        , plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)

public class Runner {
    @BeforeClass
    public static void createSession() {
        DriverManager.initDriver();
    }

    @AfterClass
    public static void killAllSession() {
        DriverManager.quitAllDriver();
    }
}
