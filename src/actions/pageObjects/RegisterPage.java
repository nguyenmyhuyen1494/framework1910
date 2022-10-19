package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPage extends BasePage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver =  driver;
    }
    public void clickToRegisterButton(){
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    public String getErrorMessAtFirstNameTextbox(){
       return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESS);
    }
    public String getErrorMessAtLastNameTextbox(){
        return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESS);
    }
    public String getErrorMessAtEmailTextbox(){
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESS);
    }
    public String getErrorMessAtPassWordTextbox(){
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESS);
    }
    public String getErrorMessAtConfirmPasswordTextbox(){
        return getElementText(driver, RegisterPageUI.CONFIRM_ERROR_MESS);
    }

    public void inputFirstName(String firstName){
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }
    public void inputLastName(String lastName){
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }
    public void inputEmail(String emailAddress){
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }
    public void inputPassword(String password){
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }
    public void inputConfirmPassword(String password){
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }
    public String getAtLess6CharsPassWordErrorMess(){
        return getElementText(driver, RegisterPageUI.LESS_6_CHARS_PASSWORD_ERROR_MESS);
    }
    public String getAtLess6CharsPassWordErrorMess2(){
        return getElementText(driver, RegisterPageUI.OFFICIAL_LESS_6_CHARS_PASSWORD_ERROR_MESS);
    }
    public String getErrorMessAtConfirmPassWordTextbox(){
        return getElementText(driver, RegisterPageUI.CONFIRM_ERROR_MESS);
    }
    public String getSuccessRegisterMess(){
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
    public String getExistingEmailErrorMess(){
        return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESAGE);
    }
// Click button Log out, Register Page comes back Home Page
    public HomePage clickToLogoutButton(){
        clickToElement(driver, HomePageUI.LOGOUT_BUTTON);
    return PageGeneratorManager.getHomePage(driver);
    }


















}
