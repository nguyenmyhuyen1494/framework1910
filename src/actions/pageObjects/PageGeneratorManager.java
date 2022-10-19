package pageObjects;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
// Noi khởi tạo các page
public class PageGeneratorManager {
    public static HomePage getHomePage(WebDriver driver){
        return new HomePage(driver);
    }
    public static RegisterPage getRegisterPage(WebDriver driver){
        return new RegisterPage(driver);
    }
    public static LoginPage getLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }
    public static MyAccountPage getMyAccountPage(WebDriver driver){
        return new MyAccountPage(driver);
    }
    public static AddressPage getAddressPage(WebDriver driver){
        return new AddressPage(driver);
    }
    public static MyProductReviewPage getProductReviewPage(WebDriver driver){
        return new MyProductReviewPage(driver);
    }

}
