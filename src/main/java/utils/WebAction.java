package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WebAction {

    private static final Logger logger = LoggerFactory.getLogger(WebAction.class.getName());

    public WebDriver driver;

    public WebAction(WebDriver driver) {
        this.driver = driver;
    }

    public void enterData(By by, CharSequence... data) {
        WebElement elm = getElement(by);
        elm.clear();
        elm.sendKeys(data);
    }

    public void enterData(WebElement element, CharSequence... data) {
        element.clear();
        element.sendKeys(data);
    }


    public boolean click(By by) throws IOException {
        try {
            WebElement elm = getElement(by);
            elm.click();
            return true;
        } catch (Exception e) {
            takeScreenshot();
            return false;
        }
    }

    public boolean isElementDisplayed(By by) {
        return getElement(by).isDisplayed();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = PropertiesReader.getEnvProperties().getProperty("screenshotpath");
        File DestFile=new File(screenshotPath+File.separator+"screenshot_"+new SimpleDateFormat("ddMMYYYYHHmmss").format(Calendar.getInstance().getTime())+".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

//    public boolean selectDropdown(WebElement dropDownele, String value){
//        boolean flag = false;
//        try {
//            Select select = new Select(dropDownele);
//            select.selectByValue(value);
//            flag = true;
//        }catch (Exception e){
//            flag = false;
//            e.printStackTrace();
//        }
//        return flag;
//    }


}








