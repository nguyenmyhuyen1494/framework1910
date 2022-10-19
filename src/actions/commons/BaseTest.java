package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    protected WebDriver getBrowserDriver(String browserName){
 // Download WebDriverManager maven trong file POM
        switch(browserName){
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
              //  System.setProperty("webdriver.gecko.driver", projectPath  + "\\browserDrivers\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
              //  System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Please input with browser name.");
        }
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        return driver;
    }
    protected int fakeNumber(){
        Random random = new Random();
        return random.nextInt((1000)+1);


    }
}
