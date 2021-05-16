package PageManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

import static Common.CommonAction.getPropertyFromPropertiesFile;
import static CoreManagement.ActionManager.*;
import static CoreManagement.DriverManager.getDriver;

public class AbstractPage {
    private String loadingIconXpath = "//div[@class='owm-loader']";

    // Get Function
    public String getUrlByPage(String pageName) {
        String url = "";
        switch (pageName.toLowerCase()) {
            case "main":
                url = getPropertyFromPropertiesFile("DomainEndpointPage", "MAIN_PAGE");
        }
        return url;
    }

    // Action
    public void navigateTo(String url) {
        navigateToUrl(url);
    }

    public void waitForPageLoadCompleted() {
        waitUntilElementDisplayByXpath(loadingIconXpath);
        waitUntilElementNotDisplayByXpath(loadingIconXpath);
    }

}
