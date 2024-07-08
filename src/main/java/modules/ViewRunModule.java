package modules;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pagelocator.ViewRunLocator;
import utils.WebAction;
import utils.WebVerification;

import java.io.IOException;



public class ViewRunModule {
    private static final Logger logger = LoggerFactory.getLogger(ViewRunModule.class.getName());

    public WebDriver driver;
    public WebAction wAction;
    public WebVerification wVerification;

    public ViewRunModule(WebDriver driver) {
        this.driver = driver;
        wAction = new WebAction(this.driver);
        wVerification = new WebVerification();
    }


    public boolean verifyViewRunHeader(String viewrun) {
        try {
            String headerEle = String.format(ViewRunLocator.lbl_viewrun.toString(),viewrun);
            System.out.println(headerEle);
            WebElement element = wAction.getElement(By.xpath(headerEle));
            wVerification.assertTrue("View Run header is present", element.isDisplayed());
//            wVerification.assertTrue("View Run header is present", wAction.isElementDisplayed(By.xpath(String.format(ViewRunLocator.lbl_viewrun,headerElement))));
            return true;
        } catch(NoSuchElementException e) {
            wVerification.assertFail("View Run header is not present");
            return false;
        }
    }

    public boolean verifyViewRunLabels() {
        boolean isBooleanPresent = false;
        try {
//            WebElement elm = wAction.getElement(ViewRunLocator.lbl_playername);
            wVerification.assertTrue("Player Name is present", wAction.isElementDisplayed(ViewRunLocator.lbl_playername));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
           wVerification.assertFail("Player Name label is not present");
        }

        try {
//            WebElement elm = driver.findElement(ViewRunLocator.lbl_totalrun);
            wVerification.assertTrue("Total Run is present", wAction.isElementDisplayed(ViewRunLocator.lbl_totalrun));
            isBooleanPresent = true;
        } catch(NoSuchElementException e) {
            Assert.fail("Total Run label is not present");
        }
        return isBooleanPresent;
    }


    public void clickDeletePlayersRunButton(String buttonName, String headerRun) throws IOException {
//        WebElement Element = wAction.getElement(ViewRunLocator.btn_deleteplayerrun);
        wAction.click(By.xpath(String.format(ViewRunLocator.btn_deleteplayerrun,headerRun)));
//        Element.click();
        logger.info("Clicked on '{}' button under '{}'", buttonName, headerRun);
    }

    public void clickPlayerName(String sectionElement, String webElement) throws IOException {
        WebElement section = wAction.getElement(ViewRunLocator.lbl_playername);
        String lblPlayer = String.format(ViewRunLocator.lbl_player.toString(),sectionElement);
        WebElement element = section.findElement(By.xpath(lblPlayer));
        wVerification.assertTrue("Player name should be clickable after click",element.isEnabled());
        element.click();
       // wAction.click(By.xpath(String.valueOf(ViewRunLocator.lbl_playername)));
//        element.click();
    }

//        if(wAction.isElementDisplayed(By.xpath(String.format(AddPlayerLocator.dropDown_Player, playeroption)))){
//            wAction.click(By.xpath(String.format(AddPlayerLocator.dropDown_Player, playeroption)));
//            Assert.assertEquals("Verify selected option", playeroption, wAction.getText(By.id(playeroption)));
//        }



}





