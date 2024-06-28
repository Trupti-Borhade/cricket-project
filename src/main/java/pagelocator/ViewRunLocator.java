package pagelocator;

import org.openqa.selenium.By;


public class ViewRunLocator {


   public static By link_homepage=By.xpath("//a[text()='HomePage']");

   public static By lbl_player = By.xpath("//td[a[text()='Player21']]");

   public static By lbl_viewrun = By.xpath("//*[contains(text(),' View Run [Player21]')]");

   public static By lbl_totalrun = By.xpath("//*[contains(text(),'Total Run')]");

   public static By lbl_playername = By.xpath("//*[contains(text(),'Player Name')]");

   public static By lbl_date = By.xpath("//*[contains(text(),'Date')]");

   public static By lbl_againstcountry = By.xpath("//*[contains(text(),'Against Country')]");

   public static By lbl_run = By.xpath("//td[text()='Run']");

   public static By lbl_four_six = By.xpath("//*[contains(text(),'Four/Sixes')]");

   public static By lbl_balls = By.xpath("//td[contains(text(),'Balls')]");

   public static By lbl_action = By.xpath("//td[contains(text(),'Actions')]");

   public static By btn_deleterun = By.xpath("//button[contains(text(), 'Delete')]");

   public static By btn_deleteplayerrun = By.xpath("//td[text()='90']//following::button[contains(text(),'Delete')][1]");

}
