package modules;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AddRunLocator;
import utils.WebAction;
import utils.WebVerification;

import java.io.IOException;
import java.util.List;

public class AddRunModule {
    private static final Logger logger = LoggerFactory.getLogger(AddRunModule.class.getName());

    public WebDriver driver;
    public WebAction wAction;
    public WebVerification wVerification;

    public AddRunModule(WebDriver driver) {
        this.driver = driver;
        wAction = new WebAction(this.driver);
        wVerification = new WebVerification();
    }

    public void clickAddRunLink() {
        try {
//            WebElement linkElement = driver.findElement(AddRunLocator.link_addrun);
//            linkElement.click();
//            Assert.assertTrue("Successfully clicked on link", true);
            boolean isClickHappen = wAction.click(AddRunLocator.link_addrun);
            wVerification.assertTrue("Successfully clicked on Add Run Link", isClickHappen);
        } catch(Exception e) {
            wVerification.assertFail("Error occurred while clicking Add Run link: " + e.getMessage());
        }
    }

    public boolean verifyAddRunHeader() {
        try {
//            WebElement headerElement = driver.findElement(AddRunLocator.lbl_addrun);
//            Assert.assertTrue("Add Run header is present", headerElement.isDisplayed());
            wVerification.assertTrue("Add Run header is present", wAction.isElementDisplayed(AddRunLocator.lbl_addrun));
            return true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Add Player header is not present");
            return false;
        }
    }

    public void verifyDropdownUnderPlayerName(String parentElement) {
        try {
            WebElement parent = wAction.getElement(AddRunLocator.dropdown_playername);

            WebElement dropdown = new Select(parent).getFirstSelectedOption();
            wVerification.assertTrue("Dropdown is not found under the specified element: " + parentElement, wAction.isElementDisplayed(dropdown));
        } catch (Exception e) {
            Assert.fail("Error occurred while verifying dropdown: " + e.getMessage());
        }
    }

    public boolean verifyAddRunLabels() {
        boolean isBooleanPresent = false;
        try {
//            WebElement elm = driver.findElement(AddRunLocator.lbl_name);
//            Assert.assertTrue("Player Name label is present", elm.isDisplayed());
            wVerification.assertTrue("Player Name label is present", wAction.isElementDisplayed(AddRunLocator.lbl_name));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Player Name label is not present");
        }
        try {
            wVerification.assertTrue("Against Country label is present", wAction.isElementDisplayed(AddRunLocator.lbl_againstcountry));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Against Country label is not present");
        }

        try {
            wVerification.assertTrue("Run label is present", wAction.isElementDisplayed(AddRunLocator.lbl_run));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Run label is not present");
        }

        try {
            wVerification.assertTrue("Balls label is present", wAction.isElementDisplayed(AddRunLocator.lbl_balls));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Balls label is not present");
        }

        try {
            wVerification.assertTrue("Fours label is present", wAction.isElementDisplayed(AddRunLocator.lbl_fours));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Fours label is not present");
        }

        try {
            wVerification.assertTrue("Sixes label is present", wAction.isElementDisplayed(AddRunLocator.lbl_sixes));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Sixes label is not present");
        }

        try {
            wVerification.assertTrue("Inning Date label is present", wAction.isElementDisplayed(AddRunLocator.lbl_inning));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Inning Date label is not present");
        }
        return isBooleanPresent;
    }

    public boolean verifyAddRunButton() {
        try {
//            WebElement buttonElement = driver.findElement(AddRunLocator.btn_addrun);
            wVerification.assertTrue("Add Run button is present", wAction.isElementDisplayed(AddRunLocator.btn_addrun));
            return true;
        }
        catch(NoSuchElementException e) {
            wVerification.assertFail("Add Player button is not present");
            return false;
        }
    }


    public void selectDropdownByCountry(String option, String country){
        try {
            WebElement dropdown = wAction.getElement(AddRunLocator.select_country);
            dropdown.click();
            WebElement optionElement = wAction.getElement(AddRunLocator.select_country_option);
            optionElement.click();
            wVerification.assertTrue("Dropdown option '" + option + "' under '" + country + "' is not selected",
                    optionElement.isSelected());
        }
        catch (Exception e) {
            wVerification.assertFail("Error occurred while selecting dropdown option '" + option + "' under '" + country + "': " + e.getMessage());
        }
    }

    public void addPlayerRunInfo(String value, String locator) {
        WebElement inputField;
        switch(locator) {
            case "playerrun":
                inputField = wAction.getElement(AddRunLocator.txtbox_run_id);
                break;
            case "playerballs":
                inputField = wAction.getElement(AddRunLocator.txtbox_ball_id);
                break;
            case "playerfours":
                inputField = wAction.getElement(AddRunLocator.txtbox_four_id);
                break;
            case "playersixes":
                inputField = wAction.getElement(AddRunLocator.txtbox_six_id);
                break;
            case "playerYear":
                inputField = wAction.getElement(AddRunLocator.txtbox_date);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator: " + locator);
        }
        if(inputField.isEnabled() || inputField.isDisplayed()){
            if(locator.equalsIgnoreCase("playerYear")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.getElementById('playerYear').setAttribute('value','"+value+"');");
            }else {
//                inputField.click();
//                inputField.sendKeys(value);
                wAction.enterData(inputField,value);
            }
            logger.info("Entered text '{}' into input field with locator '{}'", value, locator);
        }

    }

    public void clickAddRunButton(){
        try {
//            WebElement buttonElement = driver.findElement(AddRunLocator.btn_addrun);
            wVerification.assertTrue("Add Run button is present", wAction.isElementDisplayed(AddRunLocator.btn_addrun));
            wAction.click(AddRunLocator.btn_addrun);
        } catch (NoSuchElementException e) {
            logger.warn("Add Run Button not found on the page.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void verifyDropdownOptionUnderPlayerName(String optionText, String dropdownIdentifier) {
        try {
            WebElement dropdownElement = driver.findElement(By.xpath("//*[@id='playername']"));
            Select select = new Select(dropdownElement);
            List<WebElement> allOptions = select.getOptions();

            for (WebElement element : allOptions) {
                if (element.getText().equalsIgnoreCase(optionText)) {
                    System.out.println("verified text " + optionText);
                    logger.info("Dropdown option '{}' under '{}' is available", optionText, dropdownIdentifier);
                    break;
                }
            }
        }
        catch(Exception e){
            logger.error("Error occurred while verifying dropdown option '{}' under '{}': {}", optionText, dropdownIdentifier, e.getMessage());
        }
    }

    public void verifyExactRunText(String run) {
        WebElement element = driver.findElement(AddRunLocator.txt_run);
        logger.info("Expected text: " + run);
        String actualText = element.getText();
        logger.info("Actual text: " + actualText);
        if (actualText.equals(run)) {
            logger.info("Text verification passed.");
        } else {
            logger.warn("Text verification failed. Expected: " + run + ", Actual: " + actualText);
        }
       wVerification.assertEquals("'{}' is '{}'. Verification passed.",run,actualText);
    }
}















