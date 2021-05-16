package PageManagement.MainPage;

import PageDefinition.AbstractPageDefinition;
import org.openqa.selenium.WebElement;

import static CoreManagement.ActionManager.*;

public class NavigationBar extends AbstractPageDefinition {

    private String navSearchBoxXpath = "//nav[@id='nav-website']//ul[@id='first-level-nav']//input[@type='text']";

    // Action
    public void typeIntoSearchBox(String value) {
        WebElement ele = waitElementDisplayByXpath(navSearchBoxXpath);
        typeElement(ele, value);
    }

    public void typeIntoSearchBoxThenPressHotKeys(String value, String hotKey) {
        WebElement ele = waitElementDisplayByXpath(navSearchBoxXpath);
        typeElement(ele, value);
        pressHotkeys(ele, hotKey);
    }

    // Verification

}
