package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddressPage;
import pageObjects.MyProductReviewPage;
import pageObjects.PageGeneratorManager;
import pageUIs.BasePageUI;

import java.util.List;
import java.util.Set;

public class BasePage {
    private long longTimeout = 30;
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    //Chỉ ap dụng cho 2 windows
    public void switchToWindowByID(WebDriver driver, String parentWindowID) {
        //Get gết ra cac ID đang có
        Set<String> allWindowIDs = driver.getWindowHandles();
        //Duyệt qua các giá trị trong all windows
        for (String id : allWindowIDs) {
            if (!id.equals(parentWindowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    //Áp dụng cho nhiều windows
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        //Get gết ra cac ID đang có
        Set<String> allWindowIDs = driver.getWindowHandles();
        //Duyệt qua các giá trị trong all windows
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
        //Get gết ra cac ID đang có
        Set<String> allWindowIDs = driver.getWindowHandles();
        //Duyệt qua các giá trị trong all windows
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    private By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    private List<WebElement> getListWebElements(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXpath(xpathLocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByValue(textItem);
    }

    public String getSelectedItemDefaultDropDown(WebDriver driver, String xpathLocator) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.isMultiple();
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator) {
        return getListWebElements(driver, xpathLocator).size();
    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.clear();
        }
    }

    public void unCheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.clear();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    public void switchTFrame(WebDriver driver, String xpathLocator) {
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    public void scrollToElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

//    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
//    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    public void waitForElementVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }
    public void waitForAllElementsVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }
    public void waitForElementInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }
    public void waitForAllElementsInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, xpathLocator)));
    }
    public void waitForElementClickable(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
}
//    public MyAccountPage openMyProductReviewPage() {
//        clickToElement(driver, BasePageUI.ADDRESS_LINK);
//        return PageGeneratorManager.get
//    }

    public AddressPage openAddressPage(WebDriver driver) {
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGeneratorManager.getAddressPage(driver);
    }
    public MyProductReviewPage openMyProductReviewPage(WebDriver driver) {
        clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGeneratorManager.getProductReviewPage(driver);

    }
}

