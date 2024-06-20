package modules;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.HomePageLocator;

public class HomePageModule {

    private static final Logger logger = LoggerFactory.getLogger(HomePageModule.class.getName());

    WebDriver driver;
    public HomePageModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomePageLink() {
        try{
            WebElement linkElement = driver.findElement(HomePageLocator.link_homepage);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("HomePage link clicked successfully.");
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking HomePage link: " + e.getMessage());
            logger.warn("Error occurred while clicking HomePage link: " + e.getMessage());
        }
    }


    public boolean verifyAllPlayerRunHeader(){
        try {
            WebElement headerElement = driver.findElement(HomePageLocator.lbl_allplayerrun);
            Assert.assertTrue("All Players Runs header is present", headerElement.isDisplayed());
            logger.info("All Players Runs header is found.");
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("All Players Runs header is not present");
            logger.warn("All Players Runs header is not found.");
            return false;
        }
    }

    public void verifyHomePageLabels(){
        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_statistics);
            Assert.assertTrue("Current Statistics label is present", elm.isDisplayed());
            logger.info("Current Statistics label is present");
        } catch(NoSuchElementException e){
            Assert.fail("Current Statistics label is not present");
            logger.warn("Current Statistics label is not present");
        }

        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_maxfours);
            Assert.assertTrue("Maximum Fours label is present", elm.isDisplayed());
            logger.info("Maximum Fours label is present");
        } catch(NoSuchElementException e){
            Assert.fail("Maximum Fours label is not present");
            logger.warn("Maximum Fours label is not present");
        }

        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_maxsix);
            Assert.assertTrue("Maximum Sixes label is present", elm.isDisplayed());
            logger.info("Maximum Sixes label is present");
        } catch(NoSuchElementException e){
            Assert.fail("Maximum Sixes label is not present");
            logger.warn("Maximum Sixes label is not present");
        }

        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_maxrun);
            Assert.assertTrue("Maximum Run label is present", elm.isDisplayed());
            logger.info("Maximum Run label is present");
        } catch(NoSuchElementException e){
            Assert.fail("Maximum Run label is not present");
            logger.warn("Maximum Run label is not present");
        }

        try {
        WebElement elm = driver.findElement(HomePageLocator.lbl_playername);
            Assert.assertTrue("Player Name label is present", elm.isDisplayed());
            logger.info("Player Name label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Name label is not present");
            logger.warn("Player Name label is not present");
        }

        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_playercountry);
            Assert.assertTrue("Player Country label is present", elm.isDisplayed());
            logger.info("Player Country label is present");
        } catch(NoSuchElementException e) {
            Assert.fail("Player Country label is not present");
            logger.warn("Player Country label is not present");
        }

        try {
            WebElement elm = driver.findElement(HomePageLocator.lbl_totalrun);
            Assert.assertTrue("Total Run label is present", elm.isDisplayed());
            logger.info("Total Run label is present");
        } catch(NoSuchElementException e){
            Assert.fail("Total Run label is not present");
            logger.warn("Total Run label is not present");
        }
    }

    public void clickPlayerNameLink(String playername){
        try {
            WebElement linkElement = driver.findElement(HomePageLocator.link_player);
            linkElement.click();
            Assert.assertTrue("Successfully clicked on link", true);
            logger.info("Clicked on '{}' link successfully.", playername);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking Player Name link: " + e.getMessage());
            logger.warn("Error occurred while clicking Player Name link: " + e.getMessage());
        }


    }





}

