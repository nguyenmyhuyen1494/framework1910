package pageUIs;

public class RegisterPageUI {
    public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//button[text()='Register']";
    public static final String FIRST_NAME_ERROR_MESS = "//span[@id='FirstName-error']";
    public static final String LAST_NAME_ERROR_MESS= "//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MESS = "//span[@id='Email-error']";
    public static final String PASSWORD_ERROR_MESS = "//span[@id='Password-error']";
    public static final String CONFIRM_ERROR_MESS = "//span[@id='ConfirmPassword-error']";
    public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
    public static final String EXISTING_EMAIL_ERROR_MESAGE = "//div[contains(@class, 'message-error')]/ul/li";
    public static final String LESS_6_CHARS_PASSWORD_ERROR_MESS = "//span[@id='Password-error']/p";
    public static final String OFFICIAL_LESS_6_CHARS_PASSWORD_ERROR_MESS = "//span[@id='Password-error']/ul";

}
