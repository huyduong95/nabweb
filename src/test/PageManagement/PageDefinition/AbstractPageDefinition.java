package PageDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import static CoreManagement.DriverManager.getDriver;
import static PageManagement.PageFactory.getMainPage;

public class AbstractPageDefinition {

    @And("^I open url: (.*)$")
    public void openURl(String url) throws Throwable {
        getMainPage().navigateTo(url);
    }

    @And("^I navigate to (Main) page$")
    public void navigateToPage(String page) throws Throwable {
        String url = getMainPage().getUrlByPage(page);
        getMainPage().navigateTo(url);
    }

    @And("^I wait for page load completed$")
    public void waitForPageLoad() {
        getMainPage().waitForPageLoadCompleted();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException, IOException, IllegalMonitorStateException {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png",
                    scenario.getName() + " - Failed Screen:");
        }
    }

}
