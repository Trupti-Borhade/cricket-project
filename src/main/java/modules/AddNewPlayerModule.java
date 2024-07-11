package modules;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AddPlayerLocator;
import utils.WebAction;
import utils.WebVerification;

import java.io.IOException;
import java.time.Duration;


public class AddNewPlayerModule {

    private static final Logger logger = LoggerFactory.getLogger(AddNewPlayerModule.class.getName());

    public WebDriver driver;
    public WebAction wAction;
    public WebVerification wVerification;

    public AddNewPlayerModule(WebDriver driver) {
        this.driver = driver;
        wAction = new WebAction(this.driver);
        wVerification = new WebVerification();
    }

    public void clickAddPlayerLink() {
        try {
            boolean isClickHappen = wAction.click(AddPlayerLocator.link_addplayer);
            wVerification.assertTrue("Successfully clicked on Add Player Link", isClickHappen);
        } catch (Exception e) {
            wVerification.assertFail("Error occurred while clicking Add Player link: " + e.getMessage());
        }
    }

    public boolean verifyAddPlayerHeader() {
        try {
            wVerification.assertTrue("Add Player header is present", wAction.isElementDisplayed(AddPlayerLocator.lbl_addNewPlayer));
            return true;
        } catch (NoSuchElementException e) {
            wVerification.assertFail("Add Player header is not present");
            return false;
        }
    }

    public boolean verifyAddPlayerLabels() {
        boolean isBooleanPresent = false;
        try {
            wVerification.assertTrue("Player Name label is present", wAction.isElementDisplayed(AddPlayerLocator.lbl_playername));
            isBooleanPresent = true;
        } catch (NoSuchElementException e) {
            wVerification.assertFail("Player Name label is not present");

        }
        try {
            wVerification.assertTrue("Player Country label is present", wAction.isElementDisplayed(AddPlayerLocator.lbl_playercountry));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Player Country label is not present");
        }
        try {
            wVerification.assertTrue("Player Gender label is present", wAction.isElementDisplayed(AddPlayerLocator.lbl_playergender));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Player Gender label is not present");
        }
        try {
            wVerification.assertTrue("Player Year label is present",  wAction.isElementDisplayed(AddPlayerLocator.lbl_playeryear));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Player Year label is not present");
        }
        return isBooleanPresent;
    }

    public boolean verifyAddPlayerButton() {
        try {
            wVerification.assertTrue("Add Player button is present", wAction.isElementDisplayed(AddPlayerLocator.btn_addplayer));
             return true;
        } catch (NoSuchElementException e) {
            wVerification.assertFail("Add Player button is not present");
            return false;
        }
    }

    public void verifyDropdownUnderPlayerCountry(String parentElement) {
        try {
            WebElement dropdown = new Select(wAction.getElement(AddPlayerLocator.select_country)).getFirstSelectedOption();
            logger.info("Dropdown element is found: " + parentElement);
            wVerification.assertTrue("Dropdown is found under the specified element: " + parentElement, wAction.isElementDisplayed(dropdown));
        } catch (Exception e) {
            wVerification.assertFail("Error occurred while verifying dropdown: " + e.getMessage());
        }
    }

    public void addPlayerInfo(String value, String locator) {
        WebElement inputField;
        switch(locator) {
            case "playername":
                inputField = wAction.getElement(AddPlayerLocator.txtbox_playername);
                break;
            case "playerYear":
                inputField = wAction.getElement(AddPlayerLocator.txtbox_playeryear);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator: " + locator);
        }
        wAction.enterData(inputField,value);
        logger.info("Entered text '{}' into input field with locator '{}'", value, locator);
    }


    public void verifyTextBoxUnderLabels(String label) {
        WebElement parent;
        WebElement textbox=null;
        try {
            if (label.equals("Player Name")) {
                logger.info("Parent element text: " + wAction.getElement(AddPlayerLocator.lbl_playername).getText());
                textbox = wAction.getElementUsingParent(wAction.getElement(AddPlayerLocator.lbl_playername),AddPlayerLocator.txtbox_playername);
            } else if (label.equals("Player Year")) {
                logger.info("Parent element text: " + wAction.getElement(AddPlayerLocator.lbl_playeryear).getText());
                textbox = wAction.getElementUsingParent(wAction.getElement(AddPlayerLocator.lbl_playeryear),AddPlayerLocator.txtbox_playeryear);
            } else {
                logger.error("Invalid label provided: " + label);
            }
        }catch (Exception e) {
            wVerification.assertTrue("Textbox is not found under the specified element: " + label, wAction.isElementDisplayed(textbox));
        }
        }

    public void selectGender(String gender) {
        try {
            if (gender.equals("Male")) {
                wAction.click(AddPlayerLocator.lbl_male);
                logger.info("Clicked on Male gender radio button.");
            } else {
                wAction.click(AddPlayerLocator.lbl_female);
                logger.info("Clicked on Female gender radio button.");
            }
        }
        catch(NoSuchElementException | IOException e) {
            logger.warn("Gender radio button not found.");
        }
    }

    public void verifyElementText(String elementText, String expectedText) throws IOException {
        try {
            WebElement element = wAction.getElement(AddPlayerLocator.alerttxt_id);
            String actualText = wAction.getText(element);
            logger.info("Actual text for '{}': '{}'", elementText, actualText);
            wVerification.assertEquals("'{}' is '{}'. Verification passed.",actualText, expectedText);
        }
        catch(Exception e){
            wAction.takeScreenshot();
            wVerification.assertEquals("Error occurred while verifying text for element '" + elementText + "'", expectedText, e.getMessage());
        }
    }

    public void clickAddPlayerButton() {
        try {
            wVerification.assertTrue("Add player button is present", wAction.isElementDisplayed(AddPlayerLocator.btn_addplayer));
            wAction.click(AddPlayerLocator.btn_addplayer);
            logger.info("Clicked on the 'Add Player' button.");
        } catch(NoSuchElementException e) {
            logger.warn("Add Player Button not found on the page.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Assert.assertTrue("Alert is available.", true);
            logger.info("Alert is available.");
            return true;
        } catch(Exception e) {
            Assert.assertFalse("Alert is not available.", false);
            logger.info("Alert is not available.");
            return false;
        }
    }

    public void isPopupAvailable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            wVerification.assertTrue("Popup is available", true);
            logger.info("Popup verification successful: Popup is available");
        } catch(Exception e) {
            wVerification.assertFail("Popup not available - " + e.getMessage());
            logger.error("Popup verification is not successful");
        }
    }

    public void verifyPopupText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String actualText = alert.getText();
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
            Assert.assertTrue("Alert was successfully accepted.", true);
            logger.info("Accepted the alert.");
        } catch(Exception e) {
            Assert.fail("Alert not found.");
            logger.warn("Alert not found.");
        }
    }

    public void selectDropdownByCountry(String option, String country) {
        try {
            wAction.selectDropDown(AddPlayerLocator.select_country, option);
            String expectedOptionText = option;
           wVerification.assertTrue("Dropdown option '" + expectedOptionText + "' is selected",
                    wAction.getSelectedOption(AddPlayerLocator.select_country).equals(option));
            logger.info("Verification successful: Dropdown option '{}' is selected for country '{}'", option, country);
        }catch (Exception e) {
            wVerification.assertFail("Error occurred while selecting dropdown option '" + option + "' under '" + country + "': " + e.getMessage());
            logger.error("Error occurred while selecting dropdown option '{}' under '{}': {}", option, country, e.getMessage());
        }
    }

    public void selectDropdownByPlayerName(String playeroption, String playername) throws Exception {
      try {
          if (wAction.isElementDisplayed(By.xpath(String.format(AddPlayerLocator.dropDown_Player, playeroption)))) {
              logger.info("Dropdown '{}' is displayed for player '{}'", playeroption, playername);
              Assert.assertEquals("Verify selected option", playeroption, wAction.getText(By.xpath(String.format(AddPlayerLocator.dropDown_Player, playeroption))));
              logger.info("Assertion passed: Dropdown '{}' text matches for player '{}'", playeroption, playername);
          }
      }
      catch (Exception e){
              logger.warn("Dropdown '{}' is not displayed for player '{}'", playeroption, playername);
          }
    }
}









