package pagelocator;

import org.openqa.selenium.By;

public class AllPlayersLocator {

   public static By link_allplayer= By.xpath("//a[text()='All Players']");

   public static By lbl_viewallplayers = By.xpath("//*[contains(text(),'View All Players')]");

   public static By lbl_playerid = By.xpath("//*[contains(text(),'Player ID')]");

   public static By lbl_playername = By.xpath("//*[contains(text(),'Player Name')]");

   public static By lbl_playercountry = By.xpath("//*[contains(text(),'Player Country')]");

   public static  By lbl_playergender =By.xpath("//*[contains(text(),'Player Gender')]");

   public static By lbl_playeryear =By.xpath("//*[contains(text(),'Player Year')]");

   public static By lbl_action = By.xpath("//td[contains(text(),'Actions')]");

//   public static By txt_playername = By.xpath("//*[text()='Player21']");

   public static String txt_playername = "//*[text()='%S']";

   public static By txt_femalegender = By.xpath("//*[text()='FeMale']");

   public static By btn_deleteplayer = By.xpath("//button[contains(text(), 'Delete')]");

   public static String btn_clickdeleteplayer = "//td[a[text()='%s']]//following::button[contains(text(),'Delete')][1]";

 }
