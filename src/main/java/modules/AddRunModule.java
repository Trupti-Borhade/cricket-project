package modules;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AddRunLocator;


import java.time.Duration;

import java.util.List;

public class AddRunModule {
    private static final Logger logger = LoggerFactory.getLogger(AddRunModule.class.getName());

    WebDriver driver;
    public AddRunModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddRunLink() {
        try {
            WebElement linkElement = driver.findElement(AddRunLocator.link_addrun);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("Add Run link clicked successfully.");
        } catch(Exception e) {
            Assert.fail("Error occurred while clicking Add Player link: " + e.getMessage());
            logger.warn("Error occurred while clicking Add Player link: " + e.getMessage());
        }
    }

    public boolean verifyAddRunHeader() {
        try {
            WebElement headerElement = driver.findElement(AddRunLocator.lbl_addrun);
            Assert.assertTrue("Add Run header is present", headerElement.isDisplayed());
            logger.info("Add Run header is found.");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("Add Player header is not present");
            logger.warn("Add Player header is not found.");
            return false;
        }
    }


    public void verifyDropdownUnderPlayerName(String parentElement) {
        try {
            WebElement parent = driver.findElement(AddRunLocator.dropdown_playername);
            logger.info("Parent element found: " + parentElement);

            WebElement dropdown = new Select(parent).getFirstSelectedOption();
            logger.info("Dropdown is displayed: " + dropdown.isDisplayed());
            Assert.assertTrue("Dropdown is not found under the specified element: " + parentElement, dropdown.isDisplayed());
        } catch (Exception e) {
            logger.warn("Error occurred while verifying dropdown: " + e.getMessage());
            Assert.fail("Error occurred while verifying dropdown: " + e.getMessage());
        }
    }


    public void verifyAddRunLabels() {
        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_name);
            Assert.assertTrue("Player Name label is present", elm.isDisplayed());
            logger.info("Player Name label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Name label is not present");
            logger.warn("Player Name label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_againstcountry);
            Assert.assertTrue("Against Country label is present", elm.isDisplayed());
            logger.info("Against Country label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Against Country label is not present");
            logger.warn("Against Country label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_run);
            Assert.assertTrue("Run label is present", elm.isDisplayed());
            logger.info("Run label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Run label is not present");
            logger.warn("Run label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_balls);
            Assert.assertTrue("Balls label is present", elm.isDisplayed());
            logger.info("Balls label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Balls label is not present");
            logger.warn("Balls label is not present");
        }

        try {
            WebElement elm =  driver.findElement(AddRunLocator.lbl_fours);
            Assert.assertTrue("Fours label is present", elm.isDisplayed());
            logger.info("Fours label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Fours label is not present");
            logger.warn("Fours label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_sixes);
            Assert.assertTrue("Sixes label is present", elm.isDisplayed());
            logger.info("Sixes label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Sixes label is not present");
            logger.warn("Sixes label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddRunLocator.lbl_inning);
            Assert.assertTrue("Inning Date label is present", elm.isDisplayed());
            logger.info("Inning Date label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Inning Date label is not present");
            logger.warn("Inning Date label is not present");
        }
    }

    public boolean verifyAddRunButton() {
        try {
            WebElement buttonElement = driver.findElement(AddRunLocator.btn_addrun);
            Assert.assertTrue("Add Run button is present", buttonElement.isDisplayed());
            logger.info("Add Run button is present");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("Add Player button is not present");
            logger.warn("Add Player button is not present");
            return false;
        }
    }

    public void selectDropdownByPlayerName(String playername, String optionText) {
        try {
            WebElement dropdown = driver.findElement(AddRunLocator.select_playername);
            dropdown.click();
            logger.info("Clicked on the dropdown.");

            WebElement option = dropdown.findElement(AddRunLocator.select_playername_option);
            option.click();
            logger.info("Selected option '" + optionText + "' from the dropdown for player name : " + playername);
        } catch(NoSuchElementException e) {
            logger.warn("Element not found: " + e.getMessage());
        }
    }

    public void selectDropdownByCountry(String option, String country){
        try {
            WebElement dropdown = driver.findElement(AddRunLocator.select_country);
            dropdown.click();
            WebElement optionElement = dropdown.findElement(AddRunLocator.select_country_option);
            optionElement.click();
            logger.info("Selected dropdown option '{}' under '{}'", option, country);
            Assert.assertTrue("Dropdown option '" + option + "' under '" + country + "' is not selected",
                    optionElement.isSelected());
        }
        catch (Exception e) {
            logger.error("Error occurred while selecting dropdown option '{}' under '{}': {}", option, country, e.getMessage());
            Assert.fail("Error occurred while selecting dropdown option '" + option + "' under '" + country + "': " + e.getMessage());
        }
    }

    public void addPlayerRunInfo(String value, String locator) {
        WebElement inputField;
        switch(locator) {
            case "playerrun":
                inputField = driver.findElement(AddRunLocator.txtbox_run_id);
                break;
            case "playerballs":
                inputField = driver.findElement(AddRunLocator.txtbox_ball_id);
                break;
            case "playerfours":
                inputField = driver.findElement(AddRunLocator.txtbox_four_id);
                break;
            case "playersixes":
                inputField = driver.findElement(AddRunLocator.txtbox_six_id);
                break;
            case "playerYear":
                inputField = driver.findElement(AddRunLocator.txtbox_date);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator: " + locator);
        }
        if(inputField.isEnabled() || inputField.isDisplayed()){
            inputField.click();
            inputField.sendKeys(value);
            logger.info("Entered text '{}' into input field with locator '{}'", value, locator);
        }

    }

    public void clickAddRunButton(){
        try {
            WebElement buttonElement = driver.findElement(AddRunLocator.btn_addrun);
            Assert.assertTrue("Add Run button is present", buttonElement.isDisplayed());
            buttonElement.click();
            logger.info("Clicked on the 'Add Run' button.");
        } catch (NoSuchElementException e) {
            logger.warn("Add Run Button not found on the page.");
        }
    }

    public boolean verifyAlertText(String expectedAlertText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String actualAlertText = alert.getText();
            logger.info("Popup text verification successful: Expected text - '{}', Actual text - '{}'", expectedAlertText, actualAlertText);
            return actualAlertText.equals(expectedAlertText);
        } catch (Exception e) {
            logger.error("Popup text verification failed: {}", e.getMessage());
            return false;
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
       Assert.assertEquals(run,actualText);
    }
}















