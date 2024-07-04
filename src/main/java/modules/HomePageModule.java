package modules;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.HomePageLocator;
import utils.WebAction;
import utils.WebVerification;

public class HomePageModule {

    private static final Logger logger = LoggerFactory.getLogger(HomePageModule.class.getName());


    public WebDriver driver;
    public WebAction wAction;
    public WebVerification wVerification;

    public HomePageModule(WebDriver driver) {
        this.driver = driver;
        wAction = new WebAction(this.driver);
        wVerification = new WebVerification();
    }

    public void clickHomePageLink() {
        try{
//            WebElement linkElement = driver.findElement(HomePageLocator.link_homepage);
//            linkElement.click();
            boolean isClickHappen = wAction.click(HomePageLocator.link_homepage);
            wVerification.assertTrue("Successfully clicked on link", isClickHappen);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking HomePage link: " + e.getMessage());
        }
    }


    public boolean verifyAllPlayerRunHeader(){
        try {
//            WebElement headerElement = driver.findElement(HomePageLocator.lbl_allplayerrun);
            wVerification.assertTrue("All Players Runs header is present", wAction.isElementDisplayed(HomePageLocator.lbl_allplayerrun));
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("All Players Runs header is not present");
            return false;
        }
    }

    public void clickPlayerNameLink(String playername){
        try {
//            WebElement linkElement = driver.findElement(HomePageLocator.link_player);
//            linkElement.click();
//            Assert.assertTrue("Successfully clicked on link", true);
            boolean isClickHappen = wAction.click(HomePageLocator.link_player);
            wVerification.assertTrue("Successfully clicked on Player Name Link", isClickHappen);
            logger.info("Clicked on '{}' link successfully.", playername);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking Player Name link: " + e.getMessage());
        }


    }

}

