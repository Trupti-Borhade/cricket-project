package modules;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AddPlayerLocator;

import java.time.Duration;


public class AddNewPlayerModule {

    private static final Logger logger = LoggerFactory.getLogger(AddNewPlayerModule.class.getName());

    public WebDriver driver;
    public AddNewPlayerModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddPlayerLink() {
        try {
            WebElement linkElement = driver.findElement(AddPlayerLocator.link_addplayer);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("Add Player link clicked successfully.");
        } catch(Exception e) {
            Assert.fail("Error occurred while clicking Add Player link: " + e.getMessage());
            logger.warn("Error occurred while clicking Add Player link: " + e.getMessage());
        }
    }

    public boolean verifyAddPlayerHeader() {
        boolean isBooleanPresent = false;
        try {
            WebElement headerElement = driver.findElement(AddPlayerLocator.lbl_addNewPlayer);
            Assert.assertTrue("Add Player header is present", headerElement.isDisplayed());
            logger.info("Add Player header element found.");
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Add Player header is not present");
            logger.warn("Add Player header element is not found.");
        }
        return isBooleanPresent;

    }

    public void verifyAddPlayerLabels() {
        try {
            WebElement elm = driver.findElement(AddPlayerLocator.lbl_playername);
            Assert.assertTrue("Player Name label is present", elm.isDisplayed());
            logger.info("Player Name label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Name label is not present");
            logger.warn("Player Name label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddPlayerLocator.lbl_playercountry);
            Assert.assertTrue("Player Country label is present", elm.isDisplayed());
            logger.info("Player Country label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Country label is not present");
            logger.warn("Player Country label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddPlayerLocator.lbl_playergender);
            Assert.assertTrue("Player Gender label is present", elm.isDisplayed());
            logger.info("Player Gender label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Gender label is not present");
            logger.warn("Player Gender label is not present");
        }

        try {
            WebElement elm = driver.findElement(AddPlayerLocator.lbl_playeryear);
            Assert.assertTrue("Player Year label is present", elm.isDisplayed());
            logger.info("Player Year label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Year label is not present");
            logger.warn("Player Year label is not present");
        }
    }

    public boolean verifyAddPlayerButton() {
        boolean isBooleanPresent = false;
        try {
            WebElement buttonElement = driver.findElement(AddPlayerLocator.btn_addplayer);
            Assert.assertTrue("Add Player button is present", buttonElement.isDisplayed());
            logger.info("Add Player button is present");
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Add Player button is not present");
            logger.warn("Add Player button is not present");
        }
        return isBooleanPresent;

    }

    public void verifyDropdownUnderPlayerCountry(String parentElement) {
        try {
            WebElement parent = driver.findElement(AddPlayerLocator.select_country);
            logger.info("Parent element found: " + parentElement);

            WebElement dropdown = new Select(parent).getFirstSelectedOption();
            logger.info("Dropdown is displayed: " + dropdown.isDisplayed());
            Assert.assertTrue("Dropdown is not found under the specified element: " + parentElement, dropdown.isDisplayed());
        } catch (Exception e) {
            logger.warn("Error occurred while verifying dropdown: " + e.getMessage());
            Assert.fail("Error occurred while verifying dropdown: " + e.getMessage());
        }
    }

    public void addPlayerInfo(String value, String locator) {
        WebElement inputField;
        switch(locator) {
            case "playername":
                inputField = driver.findElement(AddPlayerLocator.txtbox_playername);
                break;
            case "playerYear":
                inputField = driver.findElement(AddPlayerLocator.txtbox_playeryear);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator: " + locator);
        }
        inputField.clear();
        inputField.sendKeys(value);
        logger.info("Entered text '{}' into input field with locator '{}'", value, locator);
    }


    public void verifyTextBoxUnderLabels(String label) {
        WebElement parent;
        WebElement textbox;

        if (label.equals("Player Name")) {
            parent = driver.findElement(AddPlayerLocator.lbl_playername);
            logger.info("Parent element text: " + parent.getText());

            textbox = parent.findElement(AddPlayerLocator.txtbox_playername);
        }
        else if (label.equals("Player Year")) {
            parent = driver.findElement(AddPlayerLocator.lbl_playeryear);
            logger.info("Parent element text: " + parent.getText());

            textbox = parent.findElement(AddPlayerLocator.txtbox_playeryear);
        }
        else {
            logger.error("Invalid label provided: " + label);
            return;
        }

        logger.info("Textbox is displayed: " + textbox.isDisplayed());
        Assert.assertTrue("Textbox is not found under the specified element: " + label, textbox.isDisplayed());
    }


    public void selectDropdownByCountry(String option, String country){
        try {
            WebElement dropdown = driver.findElement(AddPlayerLocator.select_country);
            dropdown.click();
            WebElement optionElement = dropdown.findElement(AddPlayerLocator.select_country_option);
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

    public void selectGender(String gender) {
        try {
            if (gender.equals("Male")) {
                WebElement genderRadioButton = driver.findElement(AddPlayerLocator.lbl_male);
                genderRadioButton.click();
                logger.info("Clicked on custom element '{}'", gender);
            } else {
                WebElement genderRadioButton = driver.findElement(AddPlayerLocator.lbl_female);
                genderRadioButton.click();
                logger.info("Clicked on custom element '{}'", gender);
            }
        } catch(NoSuchElementException e) {
            logger.warn("Gender radio button not found.");
        }
    }

    public void verifyElementText(String elementText, String expectedText){
        try {
            WebElement element = driver.findElement(AddPlayerLocator.alerttxt_id);
            String actualText = element.getText();
            logger.info("Actual text for '{}': '{}'", elementText, actualText);
            logger.info("'{}' is '{}'. Verification passed.", elementText, expectedText);
        }
        catch(Exception e){
            logger.error("Error occurred while verifying text for element '{}': {}", elementText, e.getMessage());
            Assert.assertEquals("Error occurred while verifying text for element '" + elementText + "'", expectedText, e.getMessage());
        }
    }

    public void clickAddPlayerButton() {
        try {
            WebElement buttonElement = driver.findElement(AddPlayerLocator.btn_addplayer);
            Assert.assertTrue("Add player button is present", buttonElement.isDisplayed());
            buttonElement.click();
            logger.info("Clicked on the 'Add Player' button.");
        } catch(NoSuchElementException e) {
            logger.warn("Add Player Button not found on the page.");
        }
    }

    public boolean isAlertAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            logger.info("Alert is available.");
            return true;
        } catch(Exception e) {
            logger.warn("Alert is not available.");
            return false;
        }
    }

    public void isPopupAvailable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Assert.assertTrue("Popup not available", true);
            logger.info("Popup verification successful: Popup is available");
        } catch(Exception e) {
            Assert.assertFalse("Popup available - " + e.getMessage(), false);
            logger.error("Popup verification failed: Popup available - {}", e.getMessage());
        }
    }

    public void verifyPopupText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String actualText = alert.getText();
            logger.info("Popup text verification successful: Expected text - '{}', Actual text - '{}'", expectedText, actualText);
            assert actualText.equals(expectedText) : "Popup text verification failed. Expected: '" + expectedText + "' but was: '" + actualText + "'";
        } catch(Exception e) {
            logger.error("Popup text verification failed: {}", e.getMessage());
        }
    }

    public void iRefreshApplication() {
        driver.navigate().refresh();
        logger.info("Application refreshed.");
    }


    public void acceptPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            logger.info("Alert is present.");
            Alert alert = driver.switchTo().alert();
            alert.accept();
            logger.info("Accepted the alert.");
        } catch(Exception e) {
           logger.warn("Alert not found.");
        }
    }


    public void selectDropdownByPlayerName(String playeroption, String playername) {
        try {
            WebElement dropdown = driver.findElement(AddPlayerLocator.select_playername);
            dropdown.click();
            WebElement optionElement = dropdown.findElement(AddPlayerLocator.select_playername_option);
            optionElement.click();
            logger.info("Selected dropdown option '{}' under '{}'", playeroption, playername);
            Assert.assertTrue("Dropdown option '" + playeroption + "' under '" + playername + "' is not selected",
                    optionElement.isSelected());
        }
        catch (Exception e) {
            logger.error("Error occurred while selecting dropdown option '{}' under '{}': {}", playeroption, playername, e.getMessage());
            Assert.fail("Error occurred while selecting dropdown option '" + playeroption + "' under '" + playername + "': " + e.getMessage());
        }
    }
}









