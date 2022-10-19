package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePage extends BasePage {
 private WebDriver driver;
 public HomePage(WebDriver driver){
  this.driver =  driver;
 }

 public RegisterPage openRegisterPage(){
  clickToElement(driver, HomePageUI.REGISTER_LINK);
  return PageGeneratorManager.getRegisterPage(driver);

 }
 public LoginPage openLoginPage(){
  clickToElement(driver, HomePageUI.LOGIN_LINK);
  return PageGeneratorManager.getLoginPage(driver);
 }

 public MyAccountPage openMyAccountPage() {
  clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
  return PageGeneratorManager.getMyAccountPage(driver);
 }


}
