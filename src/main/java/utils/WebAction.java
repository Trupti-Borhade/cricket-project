package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class WebAction {

    private static final Logger logger = LoggerFactory.getLogger(WebAction.class.getName());

    public WebDriver driver;

    public WebAction(WebDriver driver) {
        this.driver = driver;
    }

    public void enterData(By by, CharSequence... data) {
        logger.info("Entering data into element located by: {}", by);
        try{
            WebElement elm = getElement(by);
        elm.clear();
        elm.sendKeys(data);
        }
        catch (Exception e){
            logger.error("Failed to enter data into element: {}", e.getMessage());
        }
    }

    public void enterData(WebElement element, CharSequence... data) {
        logger.info("Entering data into element: {}", element);
     try{
        element.clear();
        element.sendKeys(data);
        logger.info("Entered data successfully into element.");
     }
     catch(Exception e){
         logger.error("Failed to enter data into element: {}", e.getMessage());
     }
    }

    public void selectDropDown(By elm , String value){
        Select sel = new Select(getElement(elm));
        sel.selectByVisibleText(value);
    }

    public String getSelectedOption(By elm){
        Select sec = new Select(getElement(elm));
        return sec.getFirstSelectedOption().getText();
    }

    public boolean click(By by) throws IOException {
        logger.info("Clicking element located by: {}", by);
        try {
            WebElement elm = getElement(by);
            elm.click();
            logger.info("Clicked on element located by: " + by.toString());
            return true;
        } catch (Exception e) {
            logger.error("Failed to click element: {}", e.getMessage());
            takeScreenshot();
            return false;
        }
    }

    public boolean click(WebElement elm) throws IOException {
        logger.info("Clicking element: {}", elm);
        try {
            elm.click();
            return true;
        } catch (Exception e) {
            logger.error("Failed to click element: {}", e.getMessage());
            takeScreenshot();
            return false;
        }
    }

    public String getText(By by) throws IOException {
        logger.info("Getting text from element located by: {}", by);
        try {
            WebElement elm = getElement(by);
            elm.click();
            logger.info("Retrieved text successfully: {}", elm.getText());
            return elm.getText();
        } catch (Exception e) {
            logger.error("Failed to get text from element: {}", e.getMessage());
            takeScreenshot();
            return null;
        }
    }

    public String getText(WebElement elm) throws IOException {
        logger.info("Getting text from element located by: {}", elm);
        try {
            //WebElement elm = getElement(by);
            //elm.click();
            logger.info("Retrieved text successfully: {}", elm.getText());
            return elm.getText();
        } catch (Exception e) {
            logger.error("Failed to get text from element: {}", e.getMessage());
            takeScreenshot();
            return null;
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            logger.info("Element is displaying...");
            return getElement(by).isDisplayed();
        }
        catch (Exception e){
            logger.error("Failed to locate element with locator: " + by.toString(), e);
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            logger.info("Checking if element is displayed: {}", element);
            return element.isDisplayed();
        }
        catch(Exception e){
            logger.error("Failed to check element display status: {}", e.getMessage());
            return false;
        }
    }


    public WebElement getElement(By by) {
        try {
            logger.info("Finding element by: {}", by);
            return driver.findElement(by);
        }
        catch (Exception e){
            logger.error("Failed to find element by {}: {}", by, e.getMessage());
            return null;
        }
    }

    public List<WebElement> getElements(By by){
        try {
            logger.info("Finding elements by: {}", by);
            return driver.findElements(by);
        }
        catch(Exception e){
            logger.error("Failed to find elements by {}: {}", by, e.getMessage());
            return null;
        }
    }

    public WebElement getElementUsingParent(WebElement elm , By by){
        try {
            logger.info("Finding element using parent element: {}", elm);
            return elm.findElement(by);
        }
        catch(Exception e){
            logger.error("Failed to find element using parent: {}", e.getMessage());
            return null;
        }
    }

    public void takeScreenshot() throws IOException {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            String screenshotPath = PropertiesReader.getEnvProperties().getProperty("screenshotpath");
            File DestFile = new File(screenshotPath + File.separator + "screenshot_" + new SimpleDateFormat("ddMMYYYYHHmmss").format(Calendar.getInstance().getTime()) + ".png");
            FileUtils.copyFile(SrcFile, DestFile);
            logger.info("Screenshot captured and saved: {}", DestFile.getAbsolutePath());
        }
        catch (IOException e){
            logger.error("Failed to take screenshot: {}", e.getMessage());
        }
    }

    public boolean isElementEnabled(WebElement element){
        try{
            return element.isEnabled();
        }catch (Exception e){
            logger.error("An Error Occurred: "+e.getMessage());
            return false;
        }
    }

}








