package PageObjectManagement;

import static Common.CommonAction.getPropertyFromPropertiesFile;
import static CoreManagement.ActionManager.*;

public class AbstractPage {
    private String loadingIconXpath = "//div[@class='owm-loader']";

    // Get Function
    public String getUrlByPage(String pageName) {
        String url = "";
        switch (pageName.toLowerCase()) {
            case "main":
                url = getPropertyFromPropertiesFile("config", "MAIN_URL");
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
