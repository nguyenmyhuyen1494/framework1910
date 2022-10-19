package commons;

import pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Apply_BasePage extends BaseTest {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private MyProductReviewPage myProductReviewPage;
    private String emailAddress = "jessinguyen" + fakeNumber() + "@gmail.com";
    String firstName = "Jessi";
    String lastName = "lastName";
    String password = "551965@Jessi";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
//        homePage = new HomePage(driver);
//        registerPage = new RegisterPage(driver);
//        loginPage = new LoginPage(driver);

        // Ẩn việc khởi tạo ở PageGeneratorManager
        homePage = PageGeneratorManager.getHomePage(driver);

    }

//    @Test
//    public void TC_01_Register_Empty_Data() {
//        System.out.println("Step 1: Click to Register Link");
//// Che giau viec khoi tao
//        registerPage = homePage.openRegisterPage();
//
//        System.out.println("Step 2: Click to Register Button");
//        registerPage.clickToRegisterButton();
//
//        System.out.println("Step 3: Verify Error Message");
//        Assert.assertEquals(registerPage.getErrorMessAtFirstNameTextbox(), "First name is required.");
//        Assert.assertEquals(registerPage.getErrorMessAtLastNameTextbox(), "Last name is required.");
//        Assert.assertEquals(registerPage.getErrorMessAtEmailTextbox(), "Email is required.");
//        Assert.assertEquals(registerPage.getErrorMessAtPassWordTextbox(), "Password is required.");
//        Assert.assertEquals(registerPage.getErrorMessAtConfirmPasswordTextbox(), "Password is required.");
//
//    }
//
//    @Test
//    public void TC_02_Register_Invalid_Email() {
//
//        System.out.println("Step 1: Click to Register Link");
//// Che giau viec khoi tao
//        registerPage = homePage.openRegisterPage();
//        System.out.println("Step 2: Input required textbox");
//        registerPage.inputFirstName(firstName);
//        registerPage.inputLastName(lastName);
//        registerPage.inputEmail("123@#gfg");
//        registerPage.inputPassword(password);
//        registerPage.inputConfirmPassword(password);
//
//
//        System.out.println("Step 3: Click Register Button");
//        registerPage.clickToRegisterButton();
//
//        System.out.println("Step 4: Verify Error Message");
//        Assert.assertEquals(registerPage.getErrorMessAtEmailTextbox(), "Wrong email");
//    }
//
//    @Test
//    public void TC_03_Register_Password_Less_6_Chars() {
//
//        System.out.println("Step 1: Click to Register Link");
//        registerPage = homePage.openRegisterPage();
//
//        System.out.println("Step 2: Input required textbox");
//        registerPage.inputFirstName(firstName);
//        registerPage.inputLastName(lastName);
//        registerPage.inputEmail(emailAddress);
//        registerPage.inputPassword("551");
//        registerPage.inputConfirmPassword("551");
//
//        System.out.println("Step 3: Click Register Button");
//        registerPage.clickToRegisterButton();
//
//        System.out.println("Step 4: Verify Error Message");
//        Assert.assertEquals(registerPage.getAtLess6CharsPassWordErrorMess(), "Password must meet the following rules:");
//        Assert.assertEquals(registerPage.getAtLess6CharsPassWordErrorMess2(), "must have at least 6 characters");
//
//    }
//
//    @Test
//    public void TC_04_Register_Invalid_Confirm_Password() {
//
//        System.out.println("Step 1: Click to Register Link");
//        registerPage = homePage.openRegisterPage();
//
//        System.out.println("Step 2: Input required textbox");
//        registerPage.inputFirstName(firstName);
//        registerPage.inputLastName(lastName);
//        registerPage.inputEmail(emailAddress);
//        registerPage.inputPassword(password);
//        registerPage.inputConfirmPassword("551965Jessi");
//
//        System.out.println("Step 3: Click Register Button");
//        registerPage.clickToRegisterButton();
//
//        System.out.println("Step 4: Verify Error Message");
//        Assert.assertEquals(registerPage.getErrorMessAtConfirmPassWordTextbox(), "The password and confirmation password do not match.");
//    }

    @Test
    public void TC_05_Register_Valid_Email() {
        System.out.println("Step 1: Click to Register Link");
        registerPage = homePage.openRegisterPage();

        System.out.println("Step 2: Input required textbox");
        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(emailAddress);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        System.out.println("Step 3: Click Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Step 4: Verify Success Register Message");
        Assert.assertEquals(registerPage.getSuccessRegisterMess(), "Your registration completed");

        System.out.println("TC_05 Step 5: Click to Logout Button");
        homePage = registerPage.clickToLogoutButton();
    }

    @Test
    public void TC_06_Register_Existing_Email() {

        System.out.println("Step 1: Click to Register Link");
        registerPage = homePage.openRegisterPage();

        System.out.println("Step 2: Input required textbox");
        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(emailAddress);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        System.out.println("Step 3: Click Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Step 4: Verify Error Message");
        Assert.assertEquals(registerPage.getExistingEmailErrorMess(), "The specified email already exists");

    }

    @Test
    public void TC_07_Log_In_Empty_Data() {
        System.out.println("Step 1: Click to Login Link");
        loginPage = homePage.openLoginPage();

        System.out.println("Step 2: Click to Login Button");
        loginPage.clickToLogInButton();

        System.out.println("Step 3: Verify Error Message");
        Assert.assertEquals(loginPage.getErrorMessAtEmailTextbox(), "Please enter your email");
    }

    @Test
    public void TC_08_Log_In_Valid_Data() {
        System.out.println("Step 1: Click to Login Link");
        // new page = old page.action
        loginPage = homePage.openLoginPage();
        System.out.println("Step 2: Input Required Textbox");

        loginPage.inputEmail(emailAddress);
        loginPage.inputPassword(password);

        System.out.println("Step 3: Click to Login Button");
        homePage = loginPage.clickToLogInButton();

        System.out.println("Step 4: Verify Success Login Message");
        Assert.assertEquals(loginPage.getSuccessLoginMess(), "Welcome to our store");

    }

    @Test
    public void TC_09_My_Account() {
        System.out.println("Step 1: Click to My Account Link");
        myAccountPage = homePage.openMyAccountPage();
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
    }
    @Test
    public void TC_10_Switch_Page() {
        System.out.println("Step 1: Click to Address Link");
        addressPage = myAccountPage.openAddressPage(driver);

        System.out.println("Step 2: Click to My Product Review Link");
        myProductReviewPage = addressPage.openMyProductReviewPage(driver);




        }

//    @AfterClass
//        public void closeTab(){
//        driver.quit();
//        }

    }

