package pagelocator;

import org.openqa.selenium.By;

public class HomePageLocator {

 public static By link_homepage=By.xpath("//a[text()='HomePage']");

 public static By lbl_allplayerrun = By.xpath("//*[contains(text(),' All Players Runs')]");

 public static String link_player = "//td[a[text()='%s']]";


}
