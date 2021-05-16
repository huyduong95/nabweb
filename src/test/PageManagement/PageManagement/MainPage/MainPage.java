package PageManagement.MainPage;

import PageManagement.AbstractPage;
import org.openqa.selenium.WebElement;

import static CoreManagement.ActionManager.*;

public class MainPage extends AbstractPage {

    // Action
    public void typeIntoTextBox(String textBoxType, String value) {
        WebElement ele = waitElementDisplayByXpath("");
        typeElement(ele, value);
    }

    // Verification


}
