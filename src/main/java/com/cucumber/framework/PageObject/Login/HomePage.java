package com.cucumber.framework.PageObject.Login;


import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;

import com.cucumber.framework.utility.ExcelReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage {


    private final Logger log = LoggerHelper.getLogger(HomePage.class);

    @FindBy(xpath = "//span[@class='uiImage']")
    WebElement img_User;

    @FindBy(linkText = "Log Out")
    WebElement lnk_LogOut;

    @FindBy(xpath = "//a[@title='Accounts']")
    WebElement lnk_Accounts;


    @FindBy(xpath = "//div[contains(@class,'slds-media slds-listbox')]/a[@title='Accounts']")
    WebElement lnk_AccountsMenuItem;

    @FindBy(xpath = "//a[@title='Contacts']")
    WebElement lnk_Contacts;

    @FindBy(xpath = "//span[contains(@class,'uiOutputText')]")
    WebElement lbl_ViewName;

    @FindBy(xpath = "//a[@title='Opportunities']")
    WebElement lnk_Opportunities;

    @FindBy(xpath = "//a[@title='Leads']")
    WebElement lnk_Leads;

    @FindBy(xpath = "//a[@title='Tasks']")
    WebElement lnk_Tasks;

    @FindBy(xpath = "//a[@title='Cases']")
    WebElement lnk_Cases;

    @FindBy(xpath = "//lightning-icon/following-sibling :: span[text()='QuickSearch']")

    //@FindBy(xpath="//span[text()='Quick Search'][contains(@class,'menu')]")
    WebElement lnk_QuickSearch;


    //subha added the below webelement QuickSearch button that present in the status bar window

    @FindBy(xpath="//button[@class='bare slds-button slds-utility-bar__action slds-truncate uiButton']//following::span[text()='QuickSearch']")
    @CacheLookup
    WebElement btn_QuickSearch;

    @FindBy(xpath = "//a/span[@title='My In-Progress Cases']//following::a/span[1][text()='More']")
    WebElement link_MoreForCaseApplet;

    @FindBy(xpath="//table/tbody/tr/td[8]")
    List<WebElement> txt_CaseStatus;

    /*For Appointments Applet*/

    @FindBy(xpath="//h2/a/span[@title='Appointments with Licenses']")
    WebElement applet_AppointmentWithLicense;

    @FindBy(xpath="//h2/a/span[@title='Appointments that need attention']")
    WebElement applet_AppointmentThatNeedAttention;


    //subha ended


    @FindBy(xpath = "//a[@title='Accounts']//*[local-name() = 'svg'][contains(@class,'slds-icon slds-icon-text-default')]")
    WebElement dd_Accounts;

    @FindBy(xpath = "//span[text()='New Account']")
    WebElement lnk_NewAccount;

    @FindBy(xpath = "//span[text()='Person Account']/parent::div/preceding-sibling::div/input")
    WebElement rnd_PersonAccount;

    @FindBy(xpath = "//span[text()='Next']/parent::input")
    WebElement btn_Next;

    @FindBy(xpath = "//h2[text()='New Account']")
    WebElement hd_NewAccount;


   // @FindBy(xpath = "//button[@title='Show Navigation Menu']//*[local-name() = 'svg'][@class='slds-button__icon']")

    @FindBy(xpath = "//div/descendant::button[@aria-label='Show Navigation Menu']")
    WebElement DD_SideNavigation;

    @FindBy(xpath = "//div[contains(@class,'appName')]")
    WebElement lbl_AppName;

    @FindBy(xpath = "//li[@class='slds-listbox__item']")
    List<WebElement> listOftabs;


    @FindBy(xpath="//h1/a[@class='profile-link-label']")
    WebElement lnk_ProfileLinkUser;

    @FindBy(xpath = "//div[contains(@class,'slds-media slds-listbox')]/a[@title='Opportunities']")
    WebElement lnk_opportunityMenuItem;

    @FindBy(xpath = "//a[@title='Home']")
    WebElement lnk_Home;


    @FindBy(xpath = "//a[@title='Opportunities']")
    WebElement lnk_Opportunity;

    /*@FindBy(xpath = "//div[contains(@class,'slds-media slds-listbox')]/a[@title='Home']")
    WebElement lnk_Home;*/

    @FindBy(xpath = "//div[@id='navMenuList']/div/ul/li")
    List<WebElement> navigationMenu;

    @FindBy(xpath = "//li[@data-aura-class='navexConsoleTabItem']/a[contains(@class,'label-action')]/following-sibling :: div/button")
    List<WebElement> lst_OpenTabs;

    @FindBy(xpath = "(//div[contains(@class,'slds-sub-tabs')])[1]/ul/li[contains(@class,'slds-sub-tabs')]")
    List<WebElement> openAccountSubTab;

    @FindBy(xpath = "//button[contains(@title,'Close')]")
    WebElement btn_closeAccount;

    @FindBy(xpath = "//div//span[text()='Setup']//preceding-sibling :: lightning-icon")
    WebElement btn_Setup;

    @FindBy(xpath = "//div[@role='menu']//li[@id='related_setup_app_home']")
    WebElement lbl_SetupOption;

    //App Launcher objects
    @FindBy(xpath = "//span[text()='App Launcher']/parent :: div")
    WebElement btn_AppLauncher;

    @FindBy(xpath = "//label[text()='Search apps and items...']//parent::lightning-input//following-sibling::div//input[@type='search']")
    WebElement txt_AppLauncherSearch;

    @FindBy(xpath = "//div//b[text()='Campaigns']")
    WebElement lnk_AppLauncherCampaigns;

    @FindBy(xpath = "//div[contains(@class,'selectedListItem')]/a/span")
    public WebElement menu_openItem;

    @FindBy(xpath = "//div//b[text()='Marketing Source Codes']")
    WebElement lnk_MarketingSourceCodes;

    @FindBy(xpath = "//c-custom-last-name-link/a")
    private WebElement firstCUstomerInSearchResults;

    @FindBy(xpath = "//b[text()='Announcements']")
    private WebElement AnnouncementsTab;

    @FindBy(xpath = "//button[contains(@class, 'AppLauncherHeader')]")
    private WebElement appLauncherGrid;

    @FindBy(xpath = "//input[contains(@placeholder,'Search apps and items')]")
    private WebElement appLauncherSearchTextBox;
    @FindBy(xpath = "//p//*[text()='Customer Care']")
    private WebElement customerCareButton;

    @FindBy(xpath = "//div[contains(text(), 'Initiates Search')]")
    private WebElement searchButtonToolTipText;
    @FindBy(xpath = "//button[text()='Search']/following::button[contains(@aria-describedby, 'tooltip')]")
    private WebElement searchButtonTooltipButton;







    public HomePage() {

        PageFactory.initElements(TestBase.driver, this);

    }



    public void logout(){
        GenericFunctions.click(img_User,"Image User");
        WaitHelper.waitForElementVisible(lnk_LogOut,40);
        GenericFunctions.click(lnk_LogOut,"Logout");

    }


    /*
     * This method used to navigate to Accounts
     * @Author: Veena
     * @Modified Date: 10/27
     * @comments: View got changed to Salesforce App
     * @Modified By: N/A
     */


    public void navigateToAccounts(){
        WaitHelper.sleep(5000);
        if(DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
            GenericFunctions.click(DD_SideNavigation,"Side Navigation");

        try {
          //  WaitHelper.waitForElementVisible(lnk_AccountsMenuItem, 40, 3);
            WaitHelper.sleep(5000);
            GenericFunctions.jSClick(lnk_AccountsMenuItem, "Accounts Menu Item");
       //     WaitHelper.waitForElement(lbl_ViewName, 40);
            WaitHelper.sleep(4000);
            GenericFunctions.click(lnk_Accounts,"Accounts");
	        WaitHelper.sleep(4000);
           // Assert.assertEquals(GenericFunctions.getElementText(lbl_ViewName), "Accounts");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /*
     * This method used to verify the App Name
     * @Author: Veena
     * @Created Date: 10/28
     * @comments: N/A
     * @Modified By: N/A
     */

    public void verifyAppName(){
        WaitHelper.sleep(6000);

        Assert.assertTrue(GenericFunctions.getElementText(lbl_AppName).equalsIgnoreCase("Customer Care"),"AppName should be Customer care");
        log.info("App Name matches with Customer Care");
    }

    /*
     * This method used to verify the existing tabs
     * @Author: Veena
     * @Created Date: 10/28
     * @comments: N/A
     * @Modified By: N/A
     */

    public void verifyTabs() {
        WaitHelper.sleep(3000);
        GenericFunctions.click(DD_SideNavigation, "Side Navigation");
        WaitHelper.sleep(3000);
        List<String> expTabs = new ArrayList<>(Arrays.asList("Home", "Accounts", "Tasks", "Opportunities"));
        List<String> actTabs = new ArrayList<>();
        for (WebElement e : listOftabs) {
            actTabs.add(GenericFunctions.getElementText(e));

        }
        Assert.assertTrue(actTabs.containsAll(actTabs), "Home,Account,Tasks and Opportunities tabs should be displayed");
        log.info("Home,Accounts,Tasks tabs are displaying as expected");

    }

    public void navigateToContacts() {
        WaitHelper.waitForElementVisible(lnk_Accounts, 40);
        WaitHelper.sleep(3000);

        GenericFunctions.jSClick(lnk_Contacts, "Contacts");
        WaitHelper.waitForElementVisible(lbl_ViewName, 40);
        WaitHelper.sleep(6000);
        Assert.assertEquals(GenericFunctions.getElementText(lbl_ViewName), "Contacts");

    }

    public void navigateToLeads() {
        WaitHelper.waitForElementVisible(lnk_Accounts, 40);
        WaitHelper.sleep(3000);

        GenericFunctions.jSClick(lnk_Leads, "Contacts");
        WaitHelper.waitForElementVisible(lbl_ViewName, 40);
        WaitHelper.sleep(4000);
        Assert.assertEquals(GenericFunctions.getElementText(lbl_ViewName), "Leads");

    }

    public void navigateToOpportunities() {
        WaitHelper.waitForElementVisible(lnk_Accounts, 40);
        WaitHelper.sleep(3000);

        GenericFunctions.jSClick(lnk_Opportunities, "Contacts");
        WaitHelper.waitForElementVisible(lbl_ViewName, 40);
        WaitHelper.sleep(4000);
      //  Assert.assertEquals(GenericFunctions.getElementText(lbl_ViewName), "Leads");

    }


    public void verifyUserLoggedIn() {
        WaitHelper.waitForElementVisible(lnk_Accounts, 50);
        WaitHelper.sleep(3000);
        Assert.assertTrue(GenericFunctions.isDisplayed(lnk_Accounts, "Accounts"), "Login");
        log.info("User Logged in Successfully");
    }

    public void selectNewPersonAccount() {
    }

    /*This function is to navigate to Tasks
     * @Author: Kalpana
     */
    public void navigateToTasks() {

        if (DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
            GenericFunctions.jSClick(DD_SideNavigation, "Side Navigation");

        try {
            WaitHelper.sleep(4000);
            GenericFunctions.jSClick(lnk_Tasks, "Tasks");
            WaitHelper.pageLoadWait(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void navigateToCases() {

        if (DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
            GenericFunctions.jSClick(DD_SideNavigation, "Side Navigation");

        try {
            WaitHelper.sleep(4000);
            GenericFunctions.jSClick(lnk_Cases, "Cases ");
            WaitHelper.pageLoadWait(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public String getOwner() {
        GenericFunctions.click(img_User, "Image User");
        WaitHelper.sleep(3000);
        return GenericFunctions.getElementText(lnk_ProfileLinkUser);

    }

    public void navigateToOpportunity() {
        WaitHelper.sleep(5000);
        if (DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
            GenericFunctions.click(DD_SideNavigation, "Side Navigation");

        try {
            //  WaitHelper.waitForElementVisible(lnk_AccountsMenuItem, 40, 3);
            WaitHelper.sleep(5000);
            GenericFunctions.jSClick(lnk_opportunityMenuItem, "Opportunity Menu Item");
            //     WaitHelper.waitForElement(lbl_ViewName, 40);
            WaitHelper.sleep(4000);
            GenericFunctions.click(lnk_Opportunity, "Opportunity");
            WaitHelper.pageLoadWait(30);
            // Assert.assertEquals(GenericFunctions.getElementText(lbl_ViewName), "Accounts");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void navigateToHome() {
        WaitHelper.sleep(5000);
        if (DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
            GenericFunctions.click(DD_SideNavigation, "Side Navigation");

        try {

            WaitHelper.sleep(9000);

            GenericFunctions.click(lnk_Home, "Home");
            WaitHelper.sleep(4000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void navigateToCustomerCareTab() {

        GenericFunctions.jSClick(appLauncherGrid, "App Launcher Button");
        WaitHelper.sleep(4000);
        GenericFunctions.type(appLauncherSearchTextBox, "Customer Care", "App Launcher Text Box");
        WaitHelper.sleep(4000);
        GenericFunctions.jSClick(customerCareButton, "Customer Care Button");
        WaitHelper.sleep(10000);
    }





    public void selectNavigationMenu(String menuOption) {

        try {

            List<WebElement> menu = GenericFunctions.getElements(By.xpath("//div[@id='navMenuList']/div/ul/li"));
            for (WebElement option : menu) {

                if (menuOption.equals(option.getText()))

                    GenericFunctions.jSClick(option, "menu " + menuOption + " ");
                GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath("//li/div/a[@title='" + menuOption + "']")), "");
                WaitHelper.sleep(4000);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void clickMenuDropDown() {
        try {
            if (DD_SideNavigation.isDisplayed() && DD_SideNavigation.isEnabled())
                GenericFunctions.click(DD_SideNavigation, "Side Navigation");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*This function is to close all the open tabs from previous session
    * @Created By : mkalpana*/
    public void closeOpenTabs(){
        try {
            for (WebElement e : lst_OpenTabs) {
                GenericFunctions.click(e, "Open Tab");
            }
        }
        catch(Exception e){
            System.out.println("No open tabs");
        }
    }

    /*This function is to click on Setup button and navigate to Setup page
   * @Created by : mkalpana*/
    public void navigateToSetup(){
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_Setup,"Setup button");
        try {
            GenericFunctions.isDisplayed(lbl_SetupOption, "Setup Option");
            GenericFunctions.click(lbl_SetupOption, "Setup option");
            WaitHelper.sleep(6000);
            GenericFunctions.switchToRecentOpenedWindow();
            WaitHelper.sleep(3000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*This function is to navigate to Quick Search page
   * @Created by : mkalpana*/
    public void navigateToQuickSearch(){
     //   GenericFunctions.click(DD_SideNavigation, "Side Navigation");
        try {
            WaitHelper.sleep(10000);
            GenericFunctions.click(lnk_QuickSearch, "Quick Search");
            WaitHelper.sleep(10000);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void verifySearchButtonToolTip(String text){
        WaitHelper.sleep(5000);
        GenericFunctions.mouseHover(searchButtonTooltipButton, "search Button Tool tip Button");
        WaitHelper.sleep(3000);
         String actualText = GenericFunctions.getElementText(searchButtonToolTipText);
         Assert.assertEquals(text, actualText, "Search Button Tooltip Text");
    }


    /*
     * This function is to click the Quick Searrch button the is available in the status bar of the window
     * Created By: Subhashini Rajagopalan
     * Date: 2/16/2021
     * */

    public void clickQuickSearchPresentInStatusBar(){
       try {

            GenericFunctions.click(btn_QuickSearch, "Quick Search From Status Bar ");
            WaitHelper.sleep(6000);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    /*This function is to navigate to Campaigns from App Launcher
    * @Created by : mkalpana*/
    public void navigateToCampaigns(){
        GenericFunctions.jSClick(btn_AppLauncher,"App Launcher");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_AppLauncherSearch,"Campaigns","Search for Campaigns");
        WaitHelper.sleep(2000);
        GenericFunctions.click(lnk_AppLauncherCampaigns,"Campaigns link");
        WaitHelper.sleep(4000);
    }

    public void navigateToMarketingSourceCode() {
        try {
            GenericFunctions.jSClick(btn_AppLauncher, "App Launcher");
            WaitHelper.sleep(6000);
            GenericFunctions.type(txt_AppLauncherSearch, "Marketing Source Codes", "Search for Marketing Source Codes");
            WaitHelper.sleep(6000);
            GenericFunctions.click(lnk_MarketingSourceCodes, "Marketing source code link");
            WaitHelper.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FindBy(xpath="//a[@aria-selected='true']/ancestor::li/following-sibling::li//button[contains(@title,'Close')]")
    List<WebElement> listOfSubTabsToTheActiveRight;

    @FindBy(xpath="//a[@aria-selected='true'][contains(@class,'label-action')]/ancestor::li//button[contains(@title,'Close')]")
    WebElement btn_ActiveTabClose;


    public void closeRightSubTabsToActiveTab(){
        for(WebElement e:listOfSubTabsToTheActiveRight){
            GenericFunctions.click(e,"Close");
            WaitHelper.sleep(2000);
        }

    }

    //changed click to jSClick
    public void closeActiveTab(){
        try {
            WaitHelper.sleep(4000);
            GenericFunctions.jSClick(btn_ActiveTabClose, "Active Tab");
            WaitHelper.sleep(4000);
        }
        catch (Exception e){
            log.info("Not able to close them");
        }
    }

    @FindBy(xpath="//a[@role='tab'][contains(@class,'tabHeader slds-context-bar__label-action')]")
    WebElement tab;

    public void navigateToRightTab() {
        WaitHelper.sleep(4000);
        GenericFunctions.click(tab,"Tab");
        WaitHelper.sleep(4000);
    }

    public void navigateToFirstCustomerInSearchResults(){
        GenericFunctions.click(firstCUstomerInSearchResults, "First Customer In Search Result");
    }

    public void verifyAnnouncementTabIsVisible(){
        //WaitHelper.waitForTexttobePresentinelement(AnnouncementsTab,"Announcements", 30);
        WaitHelper.sleep(10000);
        GenericFunctions.switchToFrameUsingWebelement(TestBase.driver.findElement(By.xpath("//iframe[contains(@name, 'vfFrameId')]")));
        GenericFunctions.switchToFrameById("theIframe");
        Assert.assertTrue(GenericFunctions.isDisplayed(AnnouncementsTab, "Announcement Tab"));
        GenericFunctions.switchToDefaultFrame();
    }

    //------------------------------------------------------------------------------------------------//
    // US3495519 - SF - Update Product Family selection to LWC choice options (VENkAT)
    //------------------------------------------------------------------------------------------------//

    @FindBy(xpath="//a[text()='Demographic Highlights']")
    WebElement lnk_homepage_DemographicHighlights;

    public void verifyDemographicHighlightsLinkDisplayedInHomePage(){
        WaitHelper.sleep(3000);
        GenericFunctions.isDisplayed(lnk_homepage_DemographicHighlights,"Demographic Highlights");

        String demographicHighlights = lnk_homepage_DemographicHighlights.getAttribute("href");
        GenericFunctions.verifyLink(demographicHighlights);
    }


    public void clickMoreLinkUnderCasesApplet() {
        GenericFunctions.isDisplayed(link_MoreForCaseApplet,"More link under cases applet ");
        GenericFunctions.highlightElement(link_MoreForCaseApplet);
        GenericFunctions.jSClick(link_MoreForCaseApplet,"More link ");
    }

    public void checkDisplayedCaseStatusUnderInProgressCases() {
        GenericFunctions.verifyMultipleTextsHavingSameValue(txt_CaseStatus,"In Progress");
    }


    public void clickAppointmentWithLicenseApplet() {
        GenericFunctions.isDisplayed(applet_AppointmentWithLicense,"Appointment with license ");
        GenericFunctions.highlightElement(applet_AppointmentWithLicense);
        GenericFunctions.jSClick(applet_AppointmentWithLicense,"Appointment with License link ");
    }

    public void clickAppointmentThatNeedAttentionApplet() {
        GenericFunctions.isDisplayed(applet_AppointmentThatNeedAttention,"Appointment that need attention ");
        GenericFunctions.highlightElement(applet_AppointmentThatNeedAttention);
        GenericFunctions.jSClick(applet_AppointmentThatNeedAttention,"Appointment that need attention link ");
    }


    @FindBy(xpath="//div[@data-component-id='flexipage_richText']//descendant::span[text()='Welcome to Breeze!']")
    WebElement applet_WelcomeToBreeze;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[4]/a[text() = 'WWE Toolbar']")
    WebElement breezeApplet_link_WWEToolbar;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[5]/a[text()='Breeze Training Documentation ']")
    WebElement breezeApplet_link_BreezeTrainingDocumentation;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[6]/a[text()='Customer Care Zone']")
    WebElement breezeApplet_link_CustomerCareZone;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[7]/a[text()='Delta']")
    WebElement breezeApplet_link_Delta;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[8]/a[text()='Demographic Highlights']")
    WebElement breezeApplet_link_DemographicsHighlights;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[9]/a[text()='IKE']")
    WebElement breezeApplet_link_IKE;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[10]/a[text()='My Dashboard']")
    WebElement breezeApplet_link_MyDashboards;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[11]/a[text()='Part D Secondary Drug Lookup']")
    WebElement breezeApplet_link_PartDSecondaryDruglookup;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[12]/a[text()='SHIP Information']")
    WebElement breezeApplet_link_ShipInformation;

    @FindBy(xpath="//div[@data-component-id='flexipage_richText']/div/div/p[13]/a[text()='UHG Hub']")
    WebElement breezeApplet_link_UHGHub;

    public void verifyLinksInBreezeApplet() {

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_WWEToolbar,"Link WWE Toolbar"));

        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_WWEToolbar,"Link WWE Toolbar"));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_BreezeTrainingDocumentation,"Link Breeze Training Documentation "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_CustomerCareZone,"Link Customer Care Zone "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_Delta,"Link Delta "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_DemographicsHighlights,"Link Demographic Highlights "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_IKE,"Link IKE "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_MyDashboards,"Link My Dashboards "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_PartDSecondaryDruglookup,"Link Part D Secondary Drug Lookup "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_ShipInformation,"Link SHIP Information "));
        sa.assertTrue(GenericFunctions.isDisplayed(breezeApplet_link_UHGHub,"Link UHG hub "));

        sa.assertAll();

    }

}



