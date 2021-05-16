package PageObjectManagement.ResultPage;

import PageDefinition.AbstractPageDefinition;
import org.junit.Assert;

import java.util.Map;

import static CoreManagement.ActionManager.waitUntilElementDisplayByXpath;

public class ResultPage extends AbstractPageDefinition {

    private String recordCityXpath = "//div[@id='forecast_list_ul']//a[normalize-space(text())='%s']";

    // Verify
    public void verifyRecordDisplayed(Map<String, String> record) {
        String cityName = record.get("City name");
        if (cityName != null) {
            String xpath = String.format(recordCityXpath, cityName);
            String errorLog = String.format("City name: %s should displayed", cityName);
            Assert.assertTrue(errorLog, waitUntilElementDisplayByXpath(xpath, 5));
        }
    }

}
