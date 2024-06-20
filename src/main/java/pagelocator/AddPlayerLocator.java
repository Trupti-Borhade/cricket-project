package pagelocator;

import org.openqa.selenium.By;

public class AddPlayerLocator {

    public static By link_addplayer = By.xpath("//a[text()='Add New Player']");

    public static By lbl_addNewPlayer = By.xpath("//*[contains(text(),'Add new Player')]");

    public static By lbl_playername = By.xpath("//*[contains(text(),'Player Name')]");

    public static By lbl_playercountry = By.xpath("//*[contains(text(),'Player Country')]");

    public static By lbl_playergender =By.xpath("//*[contains(text(),'Player Gender')]");

    public static By lbl_playeryear =By.xpath("//*[contains(text(),'Player Year')]");

    public static By btn_addplayer = By.xpath("//button[contains(text(),'Add Player')]");

    public static By txtbox_playername = By.xpath("//input[@id='playername']");

    public static By txtbox_playeryear = By.xpath("//input[@id='playerYear']");

    public static By select_playername = By.xpath("//*[contains(text(),'Player Name')]/..//select");

    public static By select_playername_option = By.xpath("//option[text()='Player11 - IND']");

    public static By select_country = By.xpath("//*[contains(text(),'Player Country')]/..//select");

    public static By select_country_option = By.xpath("//option[text()='India']");

    public static By lbl_male = By.xpath("//input[@value='Male']");

    public static By lbl_female = By.xpath("//input[@value='Female']");

    public static By alerttxt_id = By.xpath("//div[@id = 'errormsg']");

}

