package modules;

import org.junit.Assert;
import org.openqa.selenium.By;
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
            boolean isClickHappen = wAction.click(HomePageLocator.link_homepage);
            wVerification.assertTrue("Successfully clicked on link", isClickHappen);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking HomePage link: " + e.getMessage());
        }
    }


    public boolean verifyAllPlayerRunHeader(){
        try {
            wVerification.assertTrue("All Players Runs header is present", wAction.isElementDisplayed(HomePageLocator.lbl_allplayerrun));
            return true;
        } catch(NoSuchElementException e) {
            Assert.fail("All Players Runs header is not present");
            return false;
        }
    }

    public void clickPlayerNameLink(String playername){
        try {
            boolean isClickHappen = wAction.click(By.xpath(String.format(HomePageLocator.link_player,playername)));
            wVerification.assertTrue("Successfully clicked on Player Name Link", isClickHappen);
        }
        catch(Exception e){
            Assert.fail("Error occurred while clicking Player Name link: " + e.getMessage());
        }
    }
}

