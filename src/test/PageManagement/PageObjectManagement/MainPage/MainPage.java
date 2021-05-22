package PageObjectManagement.MainPage;

import CoreManagement.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPage extends AbstractPage {

    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }

    // Action
    public void typeIntoTextBox(String textBoxType, String value) {
        WebElement ele = waitElementDisplayByXpath("");
        typeElement(ele, value);
    }

    // Verification


}
