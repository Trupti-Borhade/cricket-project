package pagelocator;

import org.openqa.selenium.By;


public class ViewRunLocator {

   public static String lbl_player = "//td[a[text()='%s']]";

   public static String lbl_viewrun = "//*[contains(text(),'View Run [%s]')]";

   public static By lbl_totalrun = By.xpath("//*[contains(text(),'Total Run')]");

   public static By lbl_playername = By.xpath("//*[contains(text(),'Player Name')]");

   public static String btn_deleteplayerrun = "//td[text()='%s']//following::button[contains(text(),'Delete')][1]";

}
