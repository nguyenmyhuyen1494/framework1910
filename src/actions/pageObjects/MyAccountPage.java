package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.MyAccountPageUI;

public class MyAccountPage extends BasePage {
    private WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver =  driver;
    }

    public boolean isMyAccountPageDisplayed() {
        waitForAllElementsVisible(driver, MyAccountPageUI.MY_ACCOUNT_WELCOME);
        return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_WELCOME);
    }


}
