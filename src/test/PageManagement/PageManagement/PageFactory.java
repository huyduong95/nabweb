package PageManagement;

import CoreManagement.DriverManager;
import PageManagement.ResultPage.ResultPage;
import PageManagement.MainPage.MainPage;
import PageManagement.MainPage.NavigationBar;

public class PageFactory {

    private static DriverManager driverManager;
    private static MainPage mainPage;
    private static NavigationBar navigationBar;
    private static ResultPage resultPage;

    public PageFactory(DriverManager driver) {
        this.driverManager = driver;
    }

    public static MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static NavigationBar getNavigationBar() {
        if (navigationBar == null) {
            navigationBar = new NavigationBar();
        }
        return navigationBar;
    }

    public static ResultPage getResultPage() {
        if (resultPage == null) {
            resultPage = new ResultPage();
        }
        return resultPage;
    }
}
