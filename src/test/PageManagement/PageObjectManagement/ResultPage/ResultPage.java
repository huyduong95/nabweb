package PageObjectManagement.ResultPage;

import CoreManagement.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

public class ResultPage extends AbstractPage {

    private String recordCityXpath = "//div[@id='forecast_list_ul']//a[normalize-space(text())='%s']";

    public ResultPage(RemoteWebDriver driver) {
        super(driver);
    }

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
