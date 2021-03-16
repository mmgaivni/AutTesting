package SeleniumAutomation.Demo;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.vlocity.common.utilities.QeLogger;
//import com.vlocity.common.utilities.RuntimeException;


/**
 * Wrapper for all web elements operations.
 * 
 * @author Eswar
 *
 */
public class ElementLibrary {

    //private static final QeLogger log = new QeLogger(MethodHandles.lookup());

    private WebDriver driver;

    private static final int DEFAULT_ELEMENT_TO_BE_APPEAR_TIMEOUT_IN_SECONDS = 40;
    private static final int DEFAULT_ELEMENT_TO_BE_CLICKABLE_TIMEOUT_IN_SECONDS = 40;
    private static final int DEFAULT_FRAME_TO_BE_AVAILABLE_TIMEOUT_IN_SECONDS = 50;

    public ElementLibrary(WebDriver driver) {
        this.driver = driver;
        System.out.println("DRIVER : "+driver);
    }
    
    public WebElement elementToBePresent(String locateBy, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_ELEMENT_TO_BE_APPEAR_TIMEOUT_IN_SECONDS);

        WebElement foundElement = null;
        
        try {
            switch(locateBy) {

            case("id"):
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
            break;

            case("link"):
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
            break;

            case("xpath"):
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
            break;

            case("name"): 
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
            break;

            case("class"): 
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
            break;

            case("tag"): 
                foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
            break;

            default : 
                throw new RuntimeException("Locator type is not supported. Supported types are 'id,link,xpath,name,class,tag'");
            }
        } catch(ElementNotVisibleException e) {
            throw new RuntimeException("Element is not visible.", e);
        } catch(NoSuchElementException e) {
            throw new RuntimeException("No Such element.", e);
        }  catch (TimeoutException e) {
            throw new RuntimeException("Element is not found with in time.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while locating the element.", e);
        }
        return foundElement;
    }

    public List<WebElement> elementsToBePresent(String locateBy, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_ELEMENT_TO_BE_APPEAR_TIMEOUT_IN_SECONDS);

        List<WebElement> foundElements = null;
        
        try {
            switch(locateBy) {

            case("id"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));break;

            case("link"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));break;

            case("partialLinkText"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));break;

            case("xpath"):foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));break;

            case("name"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));break;

            case("class"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorValue)));break;

            case("tag"): foundElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locatorValue)));break;

            default : 
                throw new RuntimeException("Locator type is not supported. Supported types are 'id,link,partialLinkTex,xpath,name,class,tag'");

            }
        } catch(ElementNotVisibleException e) {
            throw new RuntimeException("Element is not visible.", e);
        } catch(NoSuchElementException e) {
            throw new RuntimeException("No Such element.", e);
        }  catch (TimeoutException e) {
            throw new RuntimeException("Element is not found with in time.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while locating the element.", e);
        }
        return foundElements;
    }

    public void fillInput(WebElement element, String data) {
        try {
            element.clear();
            element.sendKeys(data);
            //log.info("Data entred successfully");
        } catch (InvalidElementStateException e) {
            throw new RuntimeException("Invalid Element.", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Invalid Element.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while filling input.", e);
        }
    }

    public void click(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_ELEMENT_TO_BE_CLICKABLE_TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(element));			
            element.click();
        } catch (InvalidElementStateException e) {
            throw new RuntimeException("Invalid Element.", e);
        } catch(NoSuchElementException e) {
            throw new RuntimeException("No Such element.", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Element is not found with in time.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found whilte locate the element.", e);
        }
    }

    public String getText(WebElement element) {	
        String value = "";
        try {
            value = element.getText();
        } catch (WebDriverException e) {
            throw new RuntimeException("Text is not found.", e);
        }
        return value;
    }

    public String getTitle() {		
        String value = "";
        try {
            value =  driver.getTitle();
        } catch (WebDriverException e) {
            throw new RuntimeException("Tile is not found.", e);
        } 
        return value;
    }

    public String getAttribute(WebElement element, String attribute) {		
        String attributeValue = "";
        try {
            attributeValue =  element.getAttribute(attribute);
        } catch (WebDriverException e) {
            throw new RuntimeException("Attribute is not found.", e);
        } 
        return attributeValue;
    }

    public void selectDropDownUsingText(WebElement element, String value) {
        try {
            new Select(element).selectByVisibleText(value);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while selecting dropdown element.", e);
        }
    }

    public void selectDropDownUsingIndex(WebElement element, int index) {
        try {
            new Select(element).selectByIndex(index);
        } catch(NoSuchElementException e) {
            throw new RuntimeException("No Such element.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while selecting element.", e);
        }
    }

    public boolean verifyTitle(String expectedTitle) {
        boolean value =false;
        try {
            if(getTitle().equals(expectedTitle)) {
                value = true;
            }
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifying title of element.", e);
        } 
        return value;
    }

    public boolean verifyExactText(WebElement element, String expectedText) {
        boolean result = false;
        try {
            if(getText(element).equals(expectedText)) {

                result = true;
            }
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifying exact text of element.", e);
        } 

        return result;
    }

    public boolean verifyPartialText(WebElement element, String expectedText) {
        boolean result = false;

        try {
            if(getText(element).contains(expectedText)) {
                result = true;
            }
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifying partial text of element.", e);
        } 

        return result;
    }

    public boolean verifyExactAttribute(WebElement element, String attribute, String value) {
        boolean result = false;
        try {
            if(getAttribute(element, attribute).equals(value)) {

                result = true;
            }
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifing exact attribute value.", e);
        } 

        return result;
    }

    public boolean verifyPartialAttribute(WebElement element, String attribute, String value) {
        boolean result = false;
        try {
            if(getAttribute(element, attribute).contains(value)) {
                result = true;
            }
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifing partial attribute value.", e);
        }

        return result;
    }

    public boolean verifySelected(WebElement element) {
        boolean result = false;
        try {
            if(element.isSelected()) {
                result = true;
            } 
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifing element selected.", e);
        }

        return result;
    }

    public boolean verifyDisplayed(WebElement element) {
        boolean result = false;
        try {
            if(element.isDisplayed()) {
                result = true;
            } 
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while verifying the element is displayed.", e);
        } 
        return result;
    }

    public void switchToWindow(int index) {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            List<String> allHandles = new ArrayList<String>();
            allHandles.addAll(allWindowHandles);
            driver.switchTo().window(allHandles.get(index));
        } catch (NoSuchWindowException e) {
            throw new RuntimeException("Window is not found.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while switching to window.", e);
        }
    }

    public void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            throw new RuntimeException("Frame is not found.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while switching to frame.", e);
        } 
    }

    public void switchToFrame(String frameName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_FRAME_TO_BE_AVAILABLE_TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));

        } catch (NoSuchFrameException e) {
            throw new RuntimeException("Frame is not found.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while switching to frame.", e);
        } 
    }

    public void switchToFrame(int index) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_FRAME_TO_BE_AVAILABLE_TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        } catch (NoSuchFrameException e) {
            throw new RuntimeException("Frame is not found.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver expception found while switching to frame.", e);
        } 
    }

    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();
            alert.dismiss();

        } catch (NoAlertPresentException e) {
            throw new RuntimeException("Alert is not present.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Webdriver exception found while dismising alert.", e);
        } 
    }

    public String getAlertText() {
        String text = "";       
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
        } catch (NoAlertPresentException e) {
            throw new RuntimeException("Alert is not present.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while getting Alert window text.", e);
        } 
        return text;
    }

   /* public long takeSnap(){
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
        try {
           // FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while taking sanpshot.", e);
        } catch (IOException e) {
            throw new RuntimeException("IO expception found while taking snapshot", e);
        }
        return number;
    }*/

    public void closeBrowser() {
        try {
            driver.close();

        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while closing browser", e);
        }
    }

    public void closeAllBrowsers() {
        try {
            driver.quit();
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while closing all browsers.", e);
        }
    }

   /* public void waitForAttributeValue(String locateBy, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_ELEMENT_TO_BE_APPEAR_TIMEOUT_IN_SECONDS);
        try {
            switch(locateBy) {
            case("id"): 
                wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.id(locatorValue)).getAttribute("value").length() != 0);
            break;
            case("link"): 
                wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.linkText(locatorValue)).getAttribute("value").length() != 0);
            break;
            case("xpath"): wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.xpath(locatorValue)).getAttribute("value").length() != 0);
            break;
            case("name"): wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.name(locatorValue)).getAttribute("value").length() != 0);
            break;
            case("class"): wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.className(locatorValue)).getAttribute("value").length() != 0);
            break;
            case("tag"): wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.tagName(locatorValue)).getAttribute("value").length() != 0);
            break;
            default : 
                throw new RuntimeException("Locator type is not supported. Supported types are 'id,link,xpath,name,class,tag'");
            }
        }  catch(NoSuchElementException e) {
            throw new RuntimeException("No Such element.", e);
        }  catch (TimeoutException e) {
            throw new RuntimeException("Element is not found with in time.", e);
        } catch (WebDriverException e) {
            throw new RuntimeException("Exception found while locating the element.", e);
        }
    }*/

    // TODO : Currently explicit wait is not working while new screen is loading.
    // Need to debug, will replace it once solution is found.
    public void waitforScreenToLoad(int timeoutInMilliSeconds) {
        try {
            Thread.sleep(timeoutInMilliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception found.", e);
        }
    }
}