package CoreManagement;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static Common.CommonAction.getConfigData;

public class DriverManager {

    private static WebDriver driver;

    public static void initDriver() {
        String browser = getConfigData("BROWSER");
        String browserVersion = getConfigData("VERSION");
        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().clearPreferences();
            WebDriverManager.chromedriver().version(browserVersion).setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().clearPreferences();
            WebDriverManager.firefoxdriver().version(browserVersion).setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitAllDriver() {
        driver.close();
        driver.quit();
    }
}
