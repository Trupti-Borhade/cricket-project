package pagelocator;

import org.openqa.selenium.By;

public class AddRunLocator {
    public static By link_addrun = By.xpath("//a[text()='Add Run']");

    public static By lbl_addrun = By.xpath("//td[contains(text(),'Add Run')]");

    public static By lbl_name = By.xpath("//*[contains(text(),'Player Name')]");

    public static By lbl_againstcountry = By.xpath("//*[contains(text(),'Against Country')]");

    public static By lbl_run = By.xpath("//td[text()='Run']");

    public static By lbl_balls = By.xpath("//td[contains(text(),'Balls')]");

    public static By lbl_fours = By.xpath("//td[contains(text(),'Fours')]");

    public static By lbl_sixes = By.xpath("//td[contains(text(),'Sixes')]");

    public static By lbl_inning = By.xpath("//td[contains(text(),'Inning Date')]");

    public static By select_playername = By.xpath("//*[contains(text(),'Player Name')]/..//select");

    public static By select_playername_option = By.xpath("//option[text()='Player11 - IND']");

    public static By dropdown_playername = By.xpath("//select[@id='playername']");

    public static By select_country = By.xpath("//*[contains(text(),'Against Country')]/..//select");

    public static By select_country_option = By.xpath("//option[text()='Australia']");

    public static By txt_run = By.xpath("//*[text()='Run']");

    public static By txtbox_run_id = By.id("playerrun");

    public static By txtbox_ball_id = By.id("playerballs");

    public static By txtbox_four_id = By.id("playerfours");

    public static By txtbox_six_id = By.id("playersixes");

    public static By txtbox_date = By.xpath("//input[@id='playerYear']");

    public  static By btn_addrun = By.xpath("//button[contains(text(),'Add Run')]");
}
