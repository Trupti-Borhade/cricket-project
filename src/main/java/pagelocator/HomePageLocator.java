package pagelocator;

import org.openqa.selenium.By;

public class HomePageLocator {
 public static By link_homepage=By.xpath("//a[text()='HomePage']");

 public static By lbl_statistics = By.xpath("//b[text()='Current Statistics']");

 public static By lbl_maxrun = By.xpath(" //td[text()='Maximum Run']");

 public static By lbl_maxfours = By.xpath("//td[text()='Maximum Fours']");

 public static By lbl_maxsix = By.xpath("//td[text()='Maximum Six']");

 public static By lbl_allplayerrun = By.xpath("//*[contains(text(),' All Players Runs')]");

 public static By lbl_playername = By.xpath("//*[contains(text(),'Player Name')]");

 public static By lbl_playercountry = By.xpath("//*[contains(text(),'Player Country')]");

 public static By lbl_totalrun = By.xpath("//*[contains(text(),'Total Run')]");

// public static By link_player = By.xpath("//td[a[text()='Player21']]");

 public static String link_player = "//td[a[text()='%S']]";


}
