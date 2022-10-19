package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPage extends BasePage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver =  driver;
    }
    public HomePage clickToLogInButton(){
        waitForElementClickable(driver, LoginPageUI.LOG_IN_BUTTON);
        clickToElement(driver, LoginPageUI.LOG_IN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
    public String getErrorMessAtEmailTextbox(){
        return getElementText(driver, LoginPageUI.ERROR_MESS);
    }
    public void inputEmail(String emailAddress){
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }
    public void inputPassword(String password){
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }
    public String getSuccessLoginMess(){
        return getElementText(driver, LoginPageUI.SUCCESS_LOGIN_MESS);
    }

}
