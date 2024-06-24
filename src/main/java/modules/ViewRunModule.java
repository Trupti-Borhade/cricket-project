package modules;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.ViewRunLocator;

public class ViewRunModule {
    private static final Logger logger = LoggerFactory.getLogger(ViewRunModule.class.getName());

    WebDriver driver;
    public ViewRunModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomePageLink() {
        try{
            WebElement linkElement = driver.findElement(ViewRunLocator.link_homepage);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("HomePage link clicked successfully.");
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking HomePage link: " + e.getMessage());
            logger.warn("Error occurred while clicking HomePage link: " + e.getMessage());
        }
    }

    public boolean verifyViewRunHeader() {
        try {
            WebElement headerElement = driver.findElement(ViewRunLocator.lbl_viewrun);
            Assert.assertTrue("View Run header is present", headerElement.isDisplayed());
            logger.info("View Run header is found.");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("View Run header is not present");
            logger.warn("View Run header is not found.");
            return false;
        }
    }

    public void verifyViewRunLabels() {
        try {
            WebElement elm = driver.findElement(ViewRunLocator.lbl_playername);
            Assert.assertTrue("Player Name is present", elm.isDisplayed());
            logger.info("Player Name label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Name label is not present");
            logger.warn("Player Name label is not present");
        }

        try {
            WebElement elm = driver.findElement(ViewRunLocator.lbl_totalrun);
            Assert.assertTrue("Total Run is present", elm.isDisplayed());
            logger.info("Total Run label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Total Run label is not present");
            logger.warn("Total Run label is not present");
        }
    }

    public boolean verifyRunDeleteButton() {
        try {
            WebElement buttonElement = driver.findElement(ViewRunLocator.btn_deleterun);
            Assert.assertTrue("Delete button is present under action", buttonElement.isDisplayed());
            logger.info("Delete button is present under action");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("Delete button is not present under action");
            logger.warn("Delete button is not present under action");
            return false;
        }
        }


    public void clickDeleteRunButton(){
        try {
            WebElement buttonElement = driver.findElement(ViewRunLocator.btn_deleterun);
            Assert.assertTrue("Delete button is present under action", buttonElement.isDisplayed());
            buttonElement.click();
            logger.info("Clicked on the 'Delete' button.");
        } catch(NoSuchElementException e) {
            logger.warn("Delete button not found on the page.");
        }
    }


    public void clickDeletePlayersRunButton(String buttonName, String headerRun) {
        WebElement Element = driver.findElement(ViewRunLocator.btn_deleteplayerrun);
        Element.click();
        logger.info("Clicked on '{}' button under '{}'", buttonName, headerRun);
    }

    public void clickPlayerName(String sectionElement, String webElement) {
        WebElement section = driver.findElement(ViewRunLocator.lbl_playername);
        WebElement element = section.findElement(ViewRunLocator.lbl_player);
        element.click();
        logger.info("Clicked on '{}' under '{}'", sectionElement, webElement);
        Assert.assertTrue("Player name should be clickable after click", element.isEnabled());

    }

}




