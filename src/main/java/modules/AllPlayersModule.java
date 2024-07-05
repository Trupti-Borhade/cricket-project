package modules;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AllPlayersLocator;
import utils.WebAction;
import utils.WebVerification;

import java.io.IOException;


public class AllPlayersModule {
    private static final Logger logger = LoggerFactory.getLogger(AllPlayersModule.class.getName());

    public WebDriver driver;
    public WebAction wAction;
    public WebVerification wVerification;

    public AllPlayersModule(WebDriver driver) {
        this.driver = driver;
        wAction = new WebAction(this.driver);
        wVerification = new WebVerification();
    }

    public void clickAllPlayersLink() {
        try {
//            WebElement linkElement = driver.findElement(AllPlayersLocator.link_allplayer);
//            linkElement.click();
            boolean isClickHappen = wAction.click(AllPlayersLocator.link_allplayer);
            wVerification.assertTrue("Successfully clicked on Add Run Link", isClickHappen);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking All Players link: " + e.getMessage());
        }
    }

    public boolean verifyViewAllPlayersHeader() {
        try {
//            WebElement headerElement = wAction.getElement(AllPlayersLocator.lbl_viewallplayers);
            wVerification.assertTrue("View All Players header is present",wAction.isElementDisplayed(AllPlayersLocator.lbl_viewallplayers));
            return true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("View All Players header is not present");
            return true;
        }
    }

    public boolean verifyAllPlayersLabels(){
        boolean isBooleanPresent = false;
        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playerid);
            wVerification.assertTrue("Player ID label is present", wAction.isElementDisplayed(AllPlayersLocator.lbl_playerid));
            isBooleanPresent = true;
        }
        catch(NoSuchElementException e) {
            wVerification.assertFail("Player ID label is not present");
        }

        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playername);
            wVerification.assertTrue("Player Name label is present", wAction.isElementDisplayed(AllPlayersLocator.lbl_playername));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
           wVerification.assertFail("Player Name label is not present");
        }

        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playercountry);
            wVerification.assertTrue("Player Country label is present", wAction.isElementDisplayed(AllPlayersLocator.lbl_playercountry));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Player Country label is not present");
        }

        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playergender);
            wVerification.assertTrue("Player Gender label is present",  wAction.isElementDisplayed(AllPlayersLocator.lbl_playergender));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Player Gender label is not present");
        }

        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playeryear);
            wVerification.assertTrue("Player Year label is present", wAction.isElementDisplayed(AllPlayersLocator.lbl_playeryear));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Player Year label is not present");
        }

        try {
//            WebElement elm = driver.findElement(AllPlayersLocator.lbl_action);
            wVerification.assertTrue("Action label is present", wAction.isElementDisplayed(AllPlayersLocator.lbl_action));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Action label is not present");
        }
        return isBooleanPresent;
    }


    public boolean verifyAllPlayerDeleteButton() {
        try {
//            WebElement buttonElement = driver.findElement(AllPlayersLocator.btn_deleteplayer);
            wVerification.assertTrue("Delete button is present", wAction.isElementDisplayed(AllPlayersLocator.btn_deleteplayer));
            return true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("Delete button is not present under action");
            return false;
        }
    }

    public void clickDeletePlayerButton(String buttonName,String playerName) throws IOException {
        WebElement Element = wAction.getElement(AllPlayersLocator.btn_clickdeleteplayer);
        wAction.click(AllPlayersLocator.btn_clickdeleteplayer);
//        Element.click();
        logger.info("Clicked on '{}' button under '{}'", buttonName, playerName);
    }

    public void verifyElementNotPresentUnderAllPlayer(String elementText, String headerText){
        try {
            wAction.getElement(AllPlayersLocator.lbl_playergender);

           wAction.getElement(AllPlayersLocator.txt_femalegender);

            logger.warn("Element '{}' is present under '{}'", elementText, headerText);
        }
        catch (NoSuchElementException e) {
            logger.info("Element '{}' is not present under '{}'", elementText, headerText);
        }
    }
}
