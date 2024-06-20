package modules;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.AllPlayersLocator;


public class AllPlayersModule {
    private static final Logger logger = LoggerFactory.getLogger(AllPlayersModule.class.getName());

    WebDriver driver;
    public AllPlayersModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAllPlayersLink() {
        try {
            WebElement linkElement = driver.findElement(AllPlayersLocator.link_allplayer);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("All Players link clicked successfully.");
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking All Players link: " + e.getMessage());
            logger.warn("Error occurred while clicking All Players link: " + e.getMessage());
        }
    }

    public boolean verifyViewAllPlayersHeader() {
        try {
            WebElement headerElement = driver.findElement(AllPlayersLocator.lbl_viewallplayers);
            Assert.assertTrue("View All Players header is present", headerElement.isDisplayed());
            logger.info("View All Players header is found.");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("View All Players header is not present");
            logger.warn("View All Players header is not found.");
            return false;
        }
    }

    public void verifyAllPlayersLabels(){
        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playerid);
            Assert.assertTrue("Player ID label is present", elm.isDisplayed());
            logger.info("Player ID label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player ID label is not present");
            logger.warn("Player ID label is not present");
        }

        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playername);
            Assert.assertTrue("Player Name label is present", elm.isDisplayed());
            logger.info("Player Name label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Name label is not present");
            logger.warn("Player Name label is not present");
        }

        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playercountry);
            Assert.assertTrue("Player Country label is present", elm.isDisplayed());
            logger.info("Player Country label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Country label is not present");
            logger.warn("Player Country label is not present");
        }

        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playergender);
            Assert.assertTrue("Player Gender label is present", elm.isDisplayed());
            logger.info("Player Gender label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Gender label is not present");
            logger.warn("Player Gender label is not present");
        }

        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_playeryear);
            Assert.assertTrue("Player Year label is present", elm.isDisplayed());
            logger.info("Player Year label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Year label is not present");
            logger.warn("Player Year label is not present");
        }

        try {
            WebElement elm = driver.findElement(AllPlayersLocator.lbl_action);
            Assert.assertTrue("Action label is present", elm.isDisplayed());
            logger.info("Action label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Action label is not present");
            logger.warn("Action label is not present");
        }
    }


    public boolean verifyAllPlayerDeleteButton() {
        try {
            WebElement buttonElement = driver.findElement(AllPlayersLocator.btn_deleteplayer);
            Assert.assertTrue("Delete button is present", buttonElement.isDisplayed());
            logger.info("Delete button is present under action");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("Delete button is not present under action");
            logger.warn("Delete button is not present under action");
            return false;
        }
    }

    public void clickDeletePlayerButton(String buttonName,String playerName){
        WebElement Element = driver.findElement(AllPlayersLocator.btn_clickdeleteplayer);
        Element.click();

        logger.info("Clicked on '{}' button under '{}'", buttonName, playerName);
    }

    public void verifyElementNotPresentUnderAllPlayer(String elementText, String headerText){
        try {
            driver.findElement(AllPlayersLocator.lbl_playergender);

            driver.findElement(AllPlayersLocator.txt_femalegender);

            logger.warn("Element '{}' is present under '{}'", elementText, headerText);
        }
        catch (NoSuchElementException e) {
            logger.info("Element '{}' is not present under '{}'", elementText, headerText);
        }
    }





}
