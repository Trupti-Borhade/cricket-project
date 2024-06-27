package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import modules.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesReader;

public class StepDef {
    private static final Logger logger = LoggerFactory.getLogger(StepDef.class.getName());

    public WebDriver driver;
    public AddNewPlayerModule addNewPlayerModule;
    public AddRunModule addRunModule;
    public AllPlayersModule allPlayersModule;
    public HomePageModule homePageModule;
    public ViewRunModule viewRunModule;


    @Given("I open application")
    public void i_open_application() {
        String browser = System.getProperty("browser", "firefox");
        if (browser.equalsIgnoreCase("chrome")) {
            String path = System.getProperty("user.dir") + "/driver/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            String path = System.getProperty("user.dir") + "/driver/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", path);
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        logger.info("Window maximized.");

        addNewPlayerModule = new AddNewPlayerModule(driver);
        addRunModule = new AddRunModule(driver);
        allPlayersModule = new AllPlayersModule(driver);
        homePageModule = new HomePageModule(driver);
        viewRunModule = new ViewRunModule(driver);
        driver.get(PropertiesReader.getUrl().getProperty("url"));
    }

    @And("I click on Add New Player link")
    public void iClickOnAddNewPlayerLink() {
        logger.info("Clicking on Add New Player link...");
        addNewPlayerModule.clickAddPlayerLink();
        logger.info("Clicked on Add New Player link.");
    }

    @Given("I verify current url contains {string}")
    public void i_verify_current_url_contains(String string) {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);
        Assert.assertTrue("Current URL contains '" + string + "'", currentUrl.contains(string));
    }

    @And("I verify Add new Player header text")
    public void iVerifyAddNewPlayerHeaderText() {
        logger.info("Verifying Add new Player header text");
        addNewPlayerModule.verifyAddPlayerHeader();
        logger.info("Add new Player header text verified.");
    }

    @And("I verify Player Name text")
    public void iVerifyPlayerNameText() {
        logger.info("Verifying Player Name text...");
        addNewPlayerModule.verifyAddPlayerLabels();
        logger.info("Player Name text verified.");
    }

    @And("I verify textbox under {string}")
    public void iVerifyTextboxUnderLabels(String label) {
        logger.info("Verifying textbox under label: " + label);
        addNewPlayerModule.verifyTextBoxUnderLabels(label);
    }

    @And("I verify Player Country text")
    public void iVerifyPlayerCountryText() {
        logger.info("Verifying Player Country text...");
        addNewPlayerModule.verifyAddPlayerLabels();
        logger.info("Player Country text verified.");
    }

    @And("I verify dropdown under {string}")
    public void iVerifyDropdownUnderPlayerCountry(String parentElement) {
        logger.info("Verifying dropdown under: " + parentElement);
        addNewPlayerModule.verifyDropdownUnderPlayerCountry(parentElement);
    }

    @And("I verify Player Gender text")
    public void iVerifyPlayerGenderText() {
        logger.info("Verifying Player Gender text...");
        addNewPlayerModule.verifyAddPlayerLabels();
        logger.info("Player Gender text verified.");
    }

    @And("I verify Player Year text")
    public void iVerifyPlayerYearText() {
        logger.info("Verifying Player Year text...");
        addNewPlayerModule.verifyAddPlayerLabels();
        logger.info("Player Year text verified.");
    }

    @And("I verify Add Player button")
    public void iVerifyAddPlayerButton() {
        logger.info("Verifying Add Player button...");
        addNewPlayerModule.verifyAddPlayerButton();
        logger.info("Add Player button verification complete.");
    }


    @And("I enter {string} with {string}")
    public void i_enter_with(String value, String locator) {
        addNewPlayerModule.addPlayerInfo(value, locator);
        logger.info("Entered '{}' into input field with locator '{}'", value, locator);
    }

    @Given("I select dropdown option {string} under {string}")
    public void i_select_dropdown_option_under(String option, String country) {
        logger.info("Selecting dropdown option '{}' under country '{}'", option, country);
        addNewPlayerModule.selectDropdownByCountry(option, country);
    }

    @Given("I select dropdown {string} under {string}")
    public void i_select_option_under_againstcountry(String option, String country) {
        logger.info("Selecting dropdown option '{}' under country '{}'", option, country);
        addRunModule.selectDropdownByCountry(option, country);
    }


    @And("I select {string} gender")
    public void iSelectGenderGender(String gender) {
        logger.info("Selecting gender: {}", gender);
        addNewPlayerModule.selectGender(gender);
        logger.info("Gender '{}' selected successfully", gender);
    }

    @And("I click on Add Player button")
    public void iClickOnAddPlayerButton() {
        logger.info("Clicking on Add Player button...");
        addNewPlayerModule.clickAddPlayerButton();
    }

    @Given("I verify popup is available")
    public void i_verify_popup_is_available() {
        logger.info("Verifying if popup is available...");
        addNewPlayerModule.isPopupAvailable();
        logger.info("Popup availability is verified");
    }

    @Given("I verify popup text {string}")
    public void i_verify_popup_text(String expectedText) {
        logger.info("Verifying popup text...");
        addNewPlayerModule.verifyPopupText(expectedText);
    }

    @Given("I accept popup")
    public void i_accept_popup() {
        logger.info("Accepting popup...");
        addNewPlayerModule.acceptPopup();
        logger.info("Accepted popup");
    }

    @And("I verify alert is available")
    public void iVerifyAlertIsAvailable() {
        logger.info("Verifying if alert is available...");
        addNewPlayerModule.isAlertAvailable();
    }

    @And("I verify {string} is {string}")
    public void iVerifyIs(String elementText, String expectedText) {
        addNewPlayerModule.verifyElementText(elementText, expectedText);
    }

    @And("I click on All Players link")
    public void iClickOnAllPlayersLink() {
        logger.info("Clicking on All Players link...");
        allPlayersModule.clickAllPlayersLink();
        logger.info("Clicked on All Players link.");
    }


    @And("I verify View All Players header text")
    public void iVerifyViewAllPlayersHeaderText() {
        logger.info("Verifying View All Players header text");
        allPlayersModule.verifyViewAllPlayersHeader();
        logger.info("View All Players header text verified.");
    }


    @And("I verify {string} not present under {string}")
    public void iVerifyNotPresentUnder(String elementText, String headerText) {
        allPlayersModule.verifyElementNotPresentUnderAllPlayer(elementText, headerText);
        logger.info("Verification passed: Element '{}' is not present under '{}'", elementText, headerText);
    }

    @And("I verify Player ID text")
    public void iVerifyPlayerIDText() {
        logger.info("Verifying Player ID text...");
        allPlayersModule.verifyAllPlayersLabels();
        logger.info("Player ID text verified.");
    }

    @And("I verify Delete button under Actions")
    public void iVerifyDeleteButtonUnderActions() {
        logger.info("Verify if Delete button under Actions is present....");
        allPlayersModule.verifyAllPlayerDeleteButton();
    }


    @And("I click on {string} button under {string}")
    public void iClickOnButtonUnderPlayerName(String buttonName, String playerName) {
        logger.info("Clicking on Delete button under player name....");
        allPlayersModule.clickDeletePlayerButton(buttonName, playerName);
    }

    @And("I click on Add Run link")
    public void iClickOnAddRunLink() {
        logger.info("Clicking on Add Run link...");
        addRunModule.clickAddRunLink();
        logger.info("Clicked on Add Run link.");
    }

    @And("I verify Add Run header text")
    public void iVerifyAddRunHeaderText() {
        logger.info("Verifying Add Run header text...");
        addRunModule.verifyAddRunHeader();
    }

    @And("I verify exact {string} text")
    public void iVerifyExactText(String run) {
        addRunModule.verifyExactRunText(run);
    }

    @And("I verify Add Run button")
    public void iVerifyAddRunButton() {
        logger.info("Verifying Add Run button...");
        addRunModule.verifyAddRunButton();
        logger.info("Add Run button verification complete.");
    }

    @And("I click on Add Run button")
    public void iClickOnAddRunButton() {
        logger.info("Clicking Add Run button...");
        addRunModule.clickAddRunButton();
    }

    @And("I enter {string} using {string}")
    public void iEnterRunUsingtxtboxId(String value, String locator) {
        addRunModule.addPlayerRunInfo(value, locator);
        logger.info("Entered '{}' into input field with locator '{}'", value, locator);

    }

    @And("I verify dropdown element under {string}")
    public void iVerifyDropdownElementUnderPlayerName(String parentElement) {
        addRunModule.verifyDropdownUnderPlayerName(parentElement);
    }

    @And("I verify dropdown option {string} under {string}")
    public void iVerifyDropdownOptionUnderPlayerName(String optionText, String dropdownIdentifier) {
        addRunModule.verifyDropdownOptionUnderPlayerName(optionText, dropdownIdentifier);
    }

    @And("I verify Against Country label")
    public void iVerifyAgainstCountryLabel() {
        logger.info("Verifying Against Country label...");
        addRunModule.verifyAddRunLabels();
        logger.info("Against Country label verified...");
    }

    @And("I verify Balls label")
    public void iVerifyBallsLabel() {
        logger.info("Verifying Balls label...");
        addRunModule.verifyAddRunLabels();
        logger.info("Balls label verified...");
    }

    @And("I verify Fours label")
    public void iVerifyFoursLabel() {
        logger.info("Verifying Fours label...");
        addRunModule.verifyAddRunLabels();
        logger.info("Fours label verified...");
    }

    @And("I verify Sixes label")
    public void iVerifySixesLabel() {
        logger.info("Verifying Sixes label...");
        addRunModule.verifyAddRunLabels();
        logger.info("Sixes label verified...");
    }

    @And("I verify Inning Date label")
    public void iVerifyInningDateLabel() {
        logger.info("Verifying Inning Date label...");
        addRunModule.verifyAddRunLabels();
        logger.info("Inning Date label verified...");
    }

    @And("I select dropdown option {string} under {string} label")
    public void iSelectDropdownOptionUnderLabel(String playeroption, String playername) {
        logger.info("Selecting dropdown option '{}' under country '{}'", playeroption, playername);
        addNewPlayerModule.selectDropdownByPlayerName(playeroption, playername);
    }


    @And("I click on HomePage link")
    public void iClickOnHomePageLink() {
        logger.info("Clicking on HomePage link...");
        homePageModule.clickHomePageLink();
        logger.info("Clicked on HomePage link.");
    }

    @And("I verify All Players Runs header text")
    public void iVerifyAllPlayersRunsHeaderText() {
        logger.info("Verifying All Players Runs header text...");
        homePageModule.verifyAllPlayerRunHeader();
        logger.info("All Players Runs header text verified.");
    }

    @And("I verify {string} header text")
    public void iVerifyViewRunHeaderText(String viewrun) {
        logger.info("Verifying {} header text...", viewrun);
        viewRunModule.verifyViewRunHeader();
        logger.info("{} header text verified.", viewrun);
    }

    @And("I verify {string} under {string}")
    public void iVerifyLabelsUnderViewRun(String runinfo, String header) {
        logger.info("Verifying '{}' under '{}'...", runinfo, header);
        viewRunModule.verifyViewRunLabels();
        logger.info("Label '{}' under module '{}' verified.", runinfo, header);
    }

    @And("I click on {string} link")
    public void iClickOnPlayerNameLink(String playername) {
        homePageModule.clickPlayerNameLink(playername);
    }

    @And("I refresh application")
    public void iRefreshApplication() {
        logger.info("Refreshing the application...");
        addNewPlayerModule.iRefreshApplication();
    }

    @And("I click on {string} button under {string} header")
    public void iClickOnButtonUnderHeader(String buttonName, String headerRun) {
        viewRunModule.clickDeletePlayersRunButton(buttonName, headerRun);
        logger.info("Clicked on '{}' button under '{}'", buttonName, headerRun);

    }

    @And("I click on {string} under {string}")
    public void iClickOnUnder(String sectionElement, String webElement) {
        viewRunModule.clickPlayerName(sectionElement, webElement);

    }

    @And("I verify {string} under {string} label")
    public void iVerifyUnderLabel(String string, String string2) {
        WebElement section = driver.findElement(By.xpath("//*[contains(text(),'" + string2 + "')]"));
        WebElement element = section.findElement(By.xpath("//*[text()='" + string + "']"));

        if (element.isDisplayed()) {
            logger.info("'{}' under '{}' is present.", string, string2);
        } else {
            logger.warn("'{}' under '{}' is not present.", string, string2);
        }
    }

}



