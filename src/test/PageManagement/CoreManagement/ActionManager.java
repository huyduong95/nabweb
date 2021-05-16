package CoreManagement;

import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static CoreManagement.DriverManager.getDriver;

public class ActionManager {

    private static int timeoutInSeconds = 60;

    public static void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static WebElement findElementByXpath(String xpath) {
        WebElement ele = getDriver().findElement(By.xpath(xpath));
        return ele;
    }

    public static WebElement waitElementDisplayByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        WebElement ele = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return getDriver().findElement(By.xpath(xpath));
            }
        });
        return ele;
    }

    public static boolean waitUntilElementDisplayByXpath(String xpath) {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        Boolean result;
        try {
            result = wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(@Nullable WebDriver webDriver) {
                    try {
                        WebElement ele = getDriver().findElement(By.xpath(xpath));
                        if (ele != null) {
                            return true;
                        }
                    } catch (Exception ex) {
                        return false;
                    }
                    return false;
                }
            });
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static boolean waitUntilElementDisplayByXpath(String xpath, int timeOut) {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        Boolean result;
        try {
            result = wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(@Nullable WebDriver webDriver) {
                    try {
                        WebElement ele = getDriver().findElement(By.xpath(xpath));
                        if (ele != null) {
                            return true;
                        }
                    } catch (Exception ex) {
                        return false;
                    }
                    return false;
                }
            });
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static boolean waitUntilElementNotDisplayByXpath(String xpath) {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        Boolean result = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nullable WebDriver webDriver) {
                try {
                    WebElement ele = getDriver().findElement(By.xpath(xpath));
                    if (ele != null) {
                        return false;
                    }
                } catch (Exception ex) {
                    return true;
                }
                return false;
            }
        });
        return result;
    }

    public static void typeElement(WebElement ele, String value) {
        if (ele.getTagName().equalsIgnoreCase("input")) {
            ele.sendKeys(value);
        }
    }

    public static void pressHotkeys(WebElement ele, String hotkey) {
        if (hotkey.equalsIgnoreCase("Enter")) {
            ele.sendKeys(Keys.ENTER);
        }
    }
}
