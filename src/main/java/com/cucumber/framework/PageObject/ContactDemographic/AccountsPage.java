package com.cucumber.framework.PageObject.ContactDemographic;

import com.cucumber.framework.PageObject.Login.HomePage;
import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ExcelReader;
import cucumber.api.DataTable;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import sun.net.www.content.text.Generic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.List;
import java.util.Map;


/**
 * Created by gveenam on 10/8/2020.
 */
public class AccountsPage {
    private final Logger log = LoggerHelper.getLogger(HomePage.class);

    public AccountsPage() {

        PageFactory.initElements(TestBase.driver, this);

    }

    //subha addded for Etemp address validation functionality




    //subha ended

    // @FindBy(xpath = "//a[@title='Select List View']//*[local-name() = 'svg'][contains(@class,'slds-icon slds-icon-text-default')]")
    @FindBy(xpath = "//a[@title='Select List View']")
    public static WebElement lst_SelectView;


    @FindBy(xpath = "//span[text()='All Accounts']")
    WebElement lnk_AllAccounts;

    /*@FindBy(xpath = "//input[@name='Account-search-input']")
    WebElement txt_Search;*/

    @FindBy(xpath = "//input[contains(@name,'search-input')]")
    WebElement txt_Search;  //Using this search as a global search

    @FindBy(xpath = "//table[@data-aura-class='uiVirtualDataTable']")
    WebElement wt_Accounts;


    @FindBy(xpath = "//table[@data-aura-class='uiVirtualDataTable']//td[4]")
    WebElement fld_Phone;

    @FindBy(xpath = "//a[@data-refid='recordId']")
    List<WebElement> listOfAccounts;

    @FindBy(xpath = "//div[text()='Person Account']")
    WebElement lbl_PersonAccount;

    @FindBy(xpath = "//a[@data-refid='recordId']")
    //@FindBy(xpath="//a[contains(@class,'list-item') or [@data-refid='recordId']]")
    WebElement lnk_Account;

    @FindBy(xpath = "//a[text()='Details']")
    public static WebElement lnk_Details;

    @FindBy(xpath = "//button[@title='Edit Gender']")
    WebElement btn_EditGender;

    @FindBy(xpath = "//label[text()='Gender']/following-sibling::div//lightning-base-combobox-item")
    WebElement list_GenderValues;

    @FindBy(xpath = "//span[text()='Gender']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_Gender;

    @FindBy(xpath = "//label[text()='Gender']/following-sibling::div//input")
    WebElement txt_Gender;

    @FindBy(xpath = "//button[@title='Save']")
    WebElement btn_Save;

    //@FindBy(xpath="//span[text()='Accounts Menu']/preceding-sibling::lightning-icon//*[local-name() = 'svg']")

    @FindBy(xpath = "//span[text()='Show more actions']/preceding-sibling::lightning-primitive-icon//*[local-name() = 'svg']")
    WebElement dd_Account;

    @FindBy(xpath = "//h2[text()='New Account']")
    WebElement hd_NewAccount;

    @FindBy(xpath = "//a[@title='New']")
    WebElement lnk_New;

    // @FindBy(xpath="//span[text()='Person Account']/parent::div/preceding-sibling::div//input")
   // @FindBy(xpath = "//span[text()='Person Account']/preceding-sibling::input")
    @FindBy(xpath = "//span[text()='Customer']/preceding-sibling::input")
    WebElement chk_PersonAccount;

    // @FindBy(xpath="//span[text()='Household']/parent::div/preceding-sibling::div//input")
    @FindBy(xpath = "//span[text()='Household']/preceding-sibling::input")
    WebElement chk_Household;

    @FindBy(xpath = "//*[text()='Next']")
    WebElement btn_Next;

    @FindBy(xpath = "//a[text()='Details']")
    WebElement lnk_details;

    @FindBy(xpath = "//div[contains(@class,'appName')]")
    WebElement lbl_AppName;

    //subha added


    @FindBy(xpath = "//a[@data-refid='recordId'])")
    @CacheLookup
    WebElement lnk_searchTextLink;

    //subha ended


    @FindBy(xpath = "//button[@title='Edit Permanent Address']")
    WebElement btn_editPermanentAddress;
    @FindBy(xpath = "//label[text()='Permanent Street']")
    WebElement lbl_permanentStreet;
    @FindBy(xpath = "//label[text()='Permanent Street']/following-sibling::div/textarea")
    WebElement txt_permanentStreet;
    @FindBy(xpath = "//label[text()='Permanent City']/parent::lightning-input//div/input[@name='city']")
    WebElement txt_permanentCity;
    @FindBy(xpath = "//label[text()='Permanent City']")
    WebElement lbl_permanentCity;
    @FindBy(xpath = "//label[text()='Permanent State/Province']")
    WebElement lbl_permanentState;

    @FindBy(xpath = "//label[text()='Permanent State/Province']//parent::lightning-input/div/input[@name='province']")
    WebElement txt_permanentState;

    @FindBy(xpath = "//label[text()='Permanent Zip/Postal Code']")
    WebElement lbl_permanentZip;

    @FindBy(xpath = "//label[contains(text(),'Permanent')]//parent::lightning-input/div/input[@name='postalCode']")
    WebElement txt_permanentZip;

    @FindBy(xpath = "//label[text()='Permanent Country']")
    WebElement lbl_permanentCounty;

    @FindBy(xpath = "//label[contains(text(),'Permanent')]//parent::lightning-input/div/input[@name='country']")
    WebElement txt_permanentCountry;

    @FindBy(xpath = "//button[text()='Save' or @title='Save']")
    WebElement btn_save;

    @FindBy(xpath = "//div[text()='PO Box address can’t be used as Permanent address.']")
    WebElement txt_POBox_errorMessage;

    //////////////////Temporary Address Object//////////////////

    @FindBy(xpath = "//span[text()='Temporary Address']")
    WebElement lbl_temporaryAddress_accntsPage;

    @FindBy(xpath = "//span[text()='Edit Temporary Address']/preceding-sibling::span[contains(@class,edit)]")
    WebElement btn_edit_tempAddress;

    @FindBy(xpath = "//legend[text()='Temporary Address']")
    WebElement lbl_temporaryAddress_detailsPage;

    @FindBy(xpath = "//label[text()='Temporary  Street']/following-sibling::div/textarea")
    WebElement txt_temporaryStreet;

    @FindBy(xpath = "//label[text()='Temporary City']/following::div/input[@name='city']")
    WebElement txt_temporaryCity;

    @FindBy(xpath = "//label[text()='Temporary State/Province']/following::div/input[@name='province']")
    WebElement txt_temporaryState;

    @FindBy(xpath = "//label[contains(text(),'Temporary')]/following::div/input[@name='postalCode']")
    WebElement txt_TemporaryZip;

    @FindBy(xpath = "//label[contains(text(),'Temporary')]/following::div/input[@name='country']")
    WebElement txt_temporaryCountry;

    @FindBy(xpath = "//label[text()='Temporary City']")
    WebElement lbl_temporaryCity;

    @FindBy(xpath = "//label[text()='Temporary  Street']")
    WebElement lbl_temporaryStreet;

    @FindBy(xpath = "//label[contains(text(),'Temporary State')]")
    WebElement lbl_temporaryState;

    @FindBy(xpath = "//label[contains(text(),'Temporary Zip')]")
    WebElement lbl_temporaryZip;

    @FindBy(xpath = "//label[contains(text(),'Temporary Country')]")
    WebElement lbl_temporaryCounty;

    @FindBy(xpath = "//span[text()='Temporary Address Start Date']")
    WebElement lbl_temporaryStartDate;

    @FindBy(xpath = "//span[text()='Temporary Address End Date']")
    WebElement lbl_temporaryEndDate;

    @FindBy(xpath = "//span[text()='Edit Temporary Address']/parent::button[contains(@class,'edit')]")
    WebElement btn_editTempAddress;

    @FindBy(xpath = "//input[contains(@name,'End')]")
    WebElement txt_tempEndDate;

    @FindBy(xpath = "//input[contains(@name,'Shipping_Address_Start')]")
    WebElement txt_tempStartDate;

    @FindBy(xpath = "//span[contains(text(),'Start')]/parent::div/following-sibling::div//slot/lightning-formatted-text")
    WebElement txt_defaultStartDate;

    /*@FindBy(xpath = "//span[text()='Temporary Address']/parent::div/following-sibling::div//a/div")
    WebElement txt_tempAddress;*/

    @FindBy(xpath = "//span[text()='Edit Temporary Address Start Date']/parent::button[contains(@class,'edit')]")
    WebElement btn_editTempStartDate;

    @FindBy(xpath = "//span[text()='Edit Temporary Address End Date']/parent::button[contains(@class,'edit')]")
    WebElement btn_editTempEndDate;

    @FindBy(xpath = "//div[contains(text(),'Start Date cannot')]")
    WebElement txt_errMsgTempStartDate;

    @FindBy(xpath = "//div[contains(text(),'End Date')]")
    WebElement txt_errMsgTempEndDate;

    @FindBy(xpath = "//div[contains(text(),'Temporary Address Start')]")
    WebElement txt_errStartDateBlank;

    @FindBy(xpath = "//span[text()='Person Accounts']/following::a[@title='New']")
    WebElement btn_newPersonAcct;

    @FindBy(xpath = "//a[text()='Related']")
    WebElement btn_related;

    @FindBy(xpath = "(//div[text()='Account'])")
    WebElement header_Account;

    //@FindBy(xpath = "//div[text()='Person Account']")
    @FindBy(xpath = "//div[text()='Customer']")
    WebElement header_personAcct;

    @FindBy(xpath = "//button[contains(@title,'Close')]")
    public static WebElement btn_closeAccount;

    @FindBy(xpath = "(//span[text()='Address Information'])[1]")
    WebElement lbl_addressInformation;

    @FindBy(xpath = "//span[text()='Permanent Address']")
    WebElement lbl_permanentAddress;

    @FindBy(xpath = "//span[text()='Permanent Address']/../following-sibling::div//a")
    static WebElement txt_address_HH_Perm;

    /*@FindBy(xpath="//span[text()='Delete']/parent::button")
    WebElement btn_DeleteInPopup;*/

    @FindBy(xpath = "//span[text()='Show more actions']/preceding-sibling::lightning-primitive-icon/*[local-name() = 'svg'][@class='slds-button__icon']")
    WebElement dd_ShowMoreActions;

    @FindBy(xpath = "//button[@name='Account.New_Person_Account']")
    WebElement btn_NewPersonAccount;

    //@FindBy(xpath = "//ul[@class='uiAbstractList']/li")
   @FindBy(xpath="//a[@data-refid='recordId']")
    List<WebElement> listOfPersonAccounts;

    @FindBy(xpath="//span[contains(text(),'Customers')]/parent::span[text()='View All']")
    WebElement lnk_ViewAllPersonAccounts;

    @FindBy(xpath="//span[text()='Opportunities']/parent::span")
    WebElement lnk_ViewAllOpty;

    @FindBy(xpath = "//a[@title='Delete']")
    WebElement lnk_Delete;

    @FindBy(xpath = "//span[text()='Delete']/parent::button")
    WebElement btn_DeleteInPopup;

    @FindBy(xpath = "//span[text()='Permanent Address']/parent::div/following-sibling::div//a/div")
    List<WebElement> listPermanentAddress;

    @FindBy(xpath = "//span[text()='Temporary Address']/parent::div/following-sibling::div//a/div")
    List<WebElement> listTemporaryAddress;

    @FindBy(xpath = "//ul[contains(@class,'tabBarItems')]/li[contains(@class,'hasActions')]")
    List<WebElement> listaccount;

    @FindBy(xpath = "//li[text()]")
    WebElement pageError;

    @FindBy(xpath = "//button[@title='Close error dialog']")
    WebElement btn_closeSnagErrorPopUp;

    @FindBy(xpath = "(//div[contains(@class,'slds-sub-tabs')])[1]/ul/li[contains(@class,'slds-sub-tabs')]")
    List<WebElement> openAccountSubTab;

    @FindBy(xpath = "//span[contains(text(),'Start Date')]/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement fld_tempStartDateOutput;

    @FindBy(xpath = "//div[contains(@id,'error-message')]")
    WebElement fld_errorTempDate;

    @FindBy(xpath = "//span[@title='Address History']/parent::a")
    WebElement lnk_addressHistory;

    @FindBy(xpath = "//span[@title='Address History']")
    WebElement lbl_AddresHistory;

    @FindBy(xpath = "//div[contains(@class,'firstHeaderRow')]//span[text()='Person Accounts']")
    WebElement header_personAccount_FromHousehold;

    @FindBy(xpath = "(//span[text()='Customers']/parent::span[text()='View All'])[1]")
    WebElement btn_viewAll_PersonAccount;

    @FindBy(xpath = "(//table[contains(@class,'forceRecordLayout')])[2]//tbody/tr")
    List<WebElement> lst_personAccount;


    @FindBy(xpath = "//span[text()='Temporary Address']//parent::div/following-sibling::div//lightning-formatted-rich-text/span[text()]")
    WebElement text_personAccTempAddress;


    @FindBy(xpath = "//button[@title='Edit Temporary Address']")
    WebElement txt_HH_TemporaryAddress; //Household account

    @FindBy(xpath = "//span[text()='Temporary Address']/following::lightning-formatted-address/a")
    WebElement txt_PA_TemporaryAddress; //Person Account

    @FindBy(xpath = "//span[text()='Permanent Address']/../following-sibling::div//a")
    static WebElement txt_HH_PermanentAddress; //Household account

    @FindBy(xpath = "//span[text()='Membership Number']")
    static WebElement lbl_hh_MembershipNumber;

    @FindBy(xpath = "//button[@title='Edit Membership Number']/..//lightning-formatted-text")
    static WebElement txt_val_hh_MembershipNumber;

    @FindBy(xpath = "//div[contains(@class,'parent')]/div/span[text()='Home Phone']")
    static WebElement lbl_hh_HomePhone;

    @FindBy(xpath = "//button[@title='Edit Home Phone']/..//lightning-formatted-phone")
    static WebElement txt_val_hh_homePhone;


    @FindBy(xpath = "//span[text()='Opportunities']/ancestor::div[contains(@class,'firstHeaderRow')]/following-sibling::div//a[@title='New']")
    WebElement btn_NewOpportunity;


    @FindBy(xpath = "//input[@name='Account-search-input']")
    WebElement txt_SearchInLeftWindow;

    @FindBy(xpath = "//a[@role='option'][contains(@class,'split')]")
    List<WebElement> listOfAccounts_leftWin;

    @FindBy(linkText = "Related")
    WebElement lnk_Related;

    @FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate']")
    WebElement headerTitleRelated;

    //We found 1 potential duplicate of this Account.

    @FindBy(xpath = "//a[text()='View Duplicates']")
    WebElement lnk_ViewDuplicates;

    @FindBy(xpath="//h2[text()='Potential Duplicate Records']")
    WebElement hd_DuplicatesRecords;

    @FindBy(xpath="//tr[2]//span[@class='slds-checkbox--faux']")
    WebElement chk_SecondPerson;

    @FindBy(xpath="//button[@class='slds-button slds-button_brand nextButton']")
    WebElement btn_Next_DuplicateWindow;

   @FindBy(xpath="//div[text()='Confirm merge']")
   WebElement hd_Merge;

   @FindBy(xpath="//button[text()='Merge']")
   WebElement btn_Merge;

   @FindBy(xpath="//span[text()='View All']")
           WebElement lnk_ViewAll;

   @FindBy(xpath = "//button[@title='Close error dialog']")
           WebElement btn_closeError;


   @FindBy(xpath="//span[text()='Account Name']/parent::div/following-sibling::div//lightning-formatted-text")
   WebElement val_AccountName;


    //String expectedErrBlankStartDate1="A Temporary Address is needed when using the Temporary Address Start Date or Temporary Address End Date.";
    //String expectedErrBlankStartDate="A Temporary Address Start Date is needed when using a temporary address.";
    @FindBy(xpath = "//label[text()='Permanent State/Province']/..//div[contains(@id,'dropdown-element')]/lightning-base-combobox-item")
    List<WebElement> list_state;

    @FindBy(xpath = "//label[text()='Temporary State/Province']/..//div[contains(@id,'dropdown')]/lightning-base-combobox-item")
    List<WebElement> list_Tempstate;

    @FindBy(xpath = "//label[text()='Temporary State/Province']/..//div/input[@name='province']")
    WebElement btn_tempStateDrpDown;

    @FindBy(xpath = "//h2[text()='New Account: Household']")
    WebElement hd_NewHousehold;

    @FindBy(xpath = "//span[text()='Membership Number']/../following-sibling::input")
    WebElement txt_New_HH_MembershipNumber;

    @FindBy(xpath = "//span[text()='Home Phone']/../following-sibling::input")
    WebElement txt_New_HH_HomePhoneNumber;

    @FindBy(xpath = "//span[text()='Account Name']/../following-sibling::div//input[@role='combobox']")
    WebElement txt_New_HH_AccountName;

    @FindBy(xpath = "//a[contains(text(),'None')]")
    WebElement a_PCountry;

    @FindBy(xpath = "//a[text()='United States']")
    WebElement lst_UnitedStates;

    @FindBy(xpath = "//textarea[@placeholder='Permanent Street']")
    WebElement txt_New_HH_PStreet;

    @FindBy(xpath = "//input[@placeholder='Permanent City']")
    WebElement txt_New_HH_PCity;

    @FindBy(xpath = "//input[@placeholder='Permanent Zip/Postal Code']")
    WebElement txt_New_HH_PZip;

    @FindBy(xpath = "//div[@class='select-options']/ul/li")
    List<WebElement> lst_State_List_HH_New;

    @FindBy(xpath = "//span[text()='Customers']//following::a[@title='New']")
    WebElement btn_personAccount_new;

    @FindBy(xpath = "//label[text()='Permanent State/Province']/../div//input[contains(@id,'input') and @name='province']")
    WebElement drpdown_btn_Pstate;

    @FindBy(xpath = "//span[text()='Permanent State/Province']/../following-sibling::div//a")
    WebElement statedropdown_NewAccount;

    @FindBy(xpath = "//div[text()='Account']/following::a[text()='Related']")
    WebElement btn_related_account;

    @FindBy(xpath = "(//div[text()='Customer']/following::a[text()='Related'])[1]")
    WebElement btn_related_Customer;

    @FindBy(xpath = "//label[text()='Temporary Country']/..//input[@name='country']")
    WebElement drpDwn_TempCounty;

    @FindBy(xpath = "(//li/a[contains(@title,'None')])[3]")
    WebElement txt_None_TCountry;

    @FindBy(xpath = "//div[contains(@id,'dropdown')]/lightning-base-combobox-item")
    List<WebElement> PCountryValues;

    @FindBy(xpath = "//label[text()='Permanent Country']/..//input[@name='country']")
    WebElement btn_PermCountry;

    @FindBy(xpath = "(//div[contains(@id,'dropdown-element')])[4]/lightning-base-combobox-item")
    List<WebElement> PStateValues;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement btn_cancel;

    @FindBy(xpath="//span[text()='Partner']/preceding-sibling::input")
            WebElement chk_Partner;

    /*
        The below webelements is created for Edit button that is available in the Accountpage
        Created By: Subhashini Rajagopalan
        Date: 3/27/2021

     */
    @FindBy(xpath="//img[@title='Account']//following::button[@name='Account.Edit']")
    WebElement btn_houseHoldEdit;

    @FindBy(xpath = "//div[@class='windowViewMode-normal active lafPageHost']//following::a")
    WebElement alert_restrictEditWindow;

    @FindBy(xpath = "//button[@title='Finish']")
    WebElement btn_finishInEditRestrictAlertWindow;//input[@name='Account_Name']

    @FindBy(xpath = "//input[@name='Account_Name']")
    WebElement txt_nameFiedlInEditWindow;

    @FindBy(xpath = "//button[@title='Close this window']")
    WebElement btn_closeHouseholdEditWindow;

    String expectedErrBlankStartDate1 = "A Temporary Address is needed when using the Temporary Address Start Date or Temporary Address End Date.";
    String expectedErrBlankStartDate = "A Temporary Address Start Date is needed when using a temporary address.";
    Calendar cal = Calendar.getInstance();
    Date d;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    String dateString;




    /*
     * This method used to navigate to Accounts
     * @Author: Veena
     * @Modified Date: 10/27
     * @comments: Updated dd_Account xpath as view got change
     * @Modified By: N/A
     */

    public void createPersonAccount() {
        WaitHelper.sleep(3000);
        GenericFunctions.click(dd_Account, "Account dropdown");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnk_New, "New Account");
        WaitHelper.sleep(5000);
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_Household, "Household"));
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_PersonAccount, "Person Account"));
        GenericFunctions.jSClick(chk_PersonAccount, "Person Account");
        GenericFunctions.click(btn_Next, "Next");

    }


    @FindBy(xpath="//span[contains(@class,'topdown-radio--label')]")
    List<WebElement> listOfNewOptions;


    /*
     * This method used to navigate to Accounts
     * @Author: Veena
     * @Modified Date: 1/15
     * @comments: Updated dd_Account xpath as view got change
     * @Modified By: N/A
     */

    public void verifyOptionsAndCreatePersonAccount() {
        WaitHelper.sleep(3000);
        GenericFunctions.click(dd_Account, "Account dropdown");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnk_New, "New Account");
        WaitHelper.sleep(5000);
        Assert.assertEquals(listOfNewOptions.size(),3,"Displaying other options apart from tht Household and customer options");
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_Household, "Household"));
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_PersonAccount, "Person Account"));
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_Partner, "Partner"));
        GenericFunctions.jSClick(chk_PersonAccount, "Person Account");
        GenericFunctions.click(btn_Next, "Next");

    }
    public void clickNewPersonAccount() {
        WaitHelper.sleep(15000);
   //     GenericFunctions.click(dd_ShowMoreActions, "Show More Actions");
        WaitHelper.waitForElementPresent(btn_NewPersonAccount, "Person Account");
        log.info(GenericFunctions.isDisplayed(btn_NewPersonAccount,"New Person Account"));
        GenericFunctions.click(btn_NewPersonAccount, "New Customer");
        GenericFunctions.jSClick(btn_NewPersonAccount, "New Customer");
        WaitHelper.sleep(4000);
    }



    public void verifyPerAcctDisplaysAsChildAccount(String lastName) {
        WaitHelper.sleep(3000);
      //  GenericFunctions.jSClick(lnk_ViewAllPersonAccounts,"ViewAll Person Accounts");
        WaitHelper.sleep(4000);
       WebElement element=GenericFunctions.getElement(By.xpath("//span[contains(text(),'"+lastName+"')]"));

       Assert.assertTrue(GenericFunctions.isDisplayed(element,"Customer"),"Customer isn't added");


    }


  /*  public void verifyOptionsAndCreatePersonAccount(){
        WaitHelper.sleep(3000);
        GenericFunctions.click(dd_Account,"Account dropdown");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnk_NewAccount,"New Account");
        WaitHelper.sleep(5000);
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_Household,"Household"));
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_PersonAccount,"Person Account"));
        GenericFunctions.jSClick(chk_PersonAccount,"Person Account");
        GenericFunctions.click(btn_Next,"Next");

    }*/



    public int searchAccount(String accountName){

       // WaitHelper.pageLoadWait(30);
        WaitHelper.sleep(3000);
        //entering the opportunity name in the search field
        GenericFunctions.type(txt_Search, accountName, "Account Search");
        System.out.println("accountName(search account function) : "+accountName);

        //clicking the app name just to come of out the search field
        GenericFunctions.click(lbl_AppName, "Step off");

        System.out.println(">>>><<<<<<"+GenericFunctions.getElement(By.xpath("//a[@title='"+accountName+"']")));

        //GenericFunctions.click(GenericFunctions.getElement(By.xpath("//a[@title='"+accountName+"']")), "Link Text Name ");
        //GenericFunctions.click(lnk_searchTextLink, "Step off");
        WaitHelper.sleep(3000);
        System.out.println("listOfAccounts Size : "+listOfAccounts.size());

        return listOfAccounts.size();
    }

    public void selectView(String view) {
        WaitHelper.sleep(15000);
        GenericFunctions.click(lst_SelectView, "Account Select view");
        WaitHelper.sleep(3000);
        WaitHelper.waitForElementPresent(lnk_AllAccounts, "All Accounts");
        GenericFunctions.click(lnk_AllAccounts, "All Accounts");
        WaitHelper.sleep(3000);
    }

    public void verifyAccounts(String accountName) {
        List<WebElement> lst_AccountName = GenericFunctions.getElements(By.xpath("//a[text()='" + accountName + "']"));
        if (lst_AccountName.size() > 0) {
            for (WebElement lnk_AccountName : lst_AccountName) {
                Assert.assertEquals(GenericFunctions.getElementText(lnk_AccountName), ExcelReader.getCellData("AccountName"));
            }
        } else
            Assert.fail("No records found");
    }

    /*
     * This method used to navigate to Accounts
     * @Author: Veena
     * @Modified Date: 10/27
     * @comments: Updated Account xpath as view got change
     * @Modified By: N/A
     */


    public void navigateToPersonAccount() {
        //WaitHelper.pageLoadWait(40);
        WaitHelper.sleep(4000);
        GenericFunctions.click(lnk_Account, "Account");
        WaitHelper.sleep(3000);
    }


    public void clickEdit() {
        WaitHelper.sleep(5000);
        GenericFunctions.jSClick(btn_EditGender, "Edit Gender");
        WaitHelper.sleep(5000);
    }

    public String updateGenderAndSaveAccount(String val) {


        String gender = getGenderValue();
        GenericFunctions.jSClick(btn_EditGender, "Edit Gender");
        WaitHelper.sleep(5000);
        String newGender;
        GenericFunctions.click(txt_Gender, "Gender");
        WebElement element;
        if(val.equals("")){
            element = GenericFunctions.getElement(By.xpath("//label[text()='Gender']/following-sibling::div//lightning-base-combobox-item[@data-value='--None--']"));
        }
        if (gender == null || gender.equals("F")) {
            element = GenericFunctions.getElement(By.xpath("//label[text()='Gender']/following-sibling::div//lightning-base-combobox-item[@data-value='M']"));

            newGender = "M";
        } else {
            element = GenericFunctions.getElement(By.xpath("//label[text()='Gender']/following-sibling::div//lightning-base-combobox-item[@data-value='F']"));

            newGender = "F";
        }
        GenericFunctions.click(element, "Gender");
        clickOnSaveButton();
        WaitHelper.sleep(3000);

        return newGender;


    }


    public void navigateToDetails(){
        WaitHelper.sleep(15000);
        //WaitHelper.pageLoadWait(40);
        GenericFunctions.click(lnk_Details,"Details");
        WaitHelper.sleep(3000);




    }

    public String getGenderValue() {
        WaitHelper.sleep(4000);
        String gender = GenericFunctions.getElementText(val_Gender);

        return gender;
    }

    public void searchHouseholdAccount(String household){
        WaitHelper.sleep(4000);
        GenericFunctions.type(txt_Search,household,"Enters household");
        txt_Search.sendKeys((Keys.ENTER));
        WaitHelper.sleep(4000);
    }
    static String permanentAddress_hh;
    public static void permanentAddressInformation() {
        WaitHelper.sleep(5000);
        permanentAddress_hh = txt_HH_PermanentAddress.getAttribute("title");
        System.out.println("Permanent Address present in the household is :\n"+permanentAddress_hh);
    }


    public void verifyPermanentAddressFields() {
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_permanentStreet, "Permanent street "));
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_permanentCity, "Permanent City "));
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_permanentState, "Permanent State"));
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_permanentZip, "Permanent Zip"));
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_permanentCounty, "Permanent County"));
    }

    public void viewPermanentAddressField() {
        JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
        js.executeScript("window.scrollBy(0,150)");
        GenericFunctions.getElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        if (btn_editPermanentAddress.isEnabled() && btn_editPermanentAddress.isDisplayed())
            try {
                GenericFunctions.jSClick(btn_editPermanentAddress, "Edit button ");
                WaitHelper.sleep(3000);
                verifyPermanentAddressFields();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    String del;

    public void editAddressWithPOBox(DataTable table) {
        try {
            WaitHelper.sleep(6000);
            List<Map<String, String>> ll = table.asMaps(String.class, String.class);
            for (int i = 0; i < ll.size(); i++) {
                txt_permanentStreet.click();
                del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
                txt_permanentStreet.sendKeys(del);
                WaitHelper.sleep(4000);
                GenericFunctions.type(txt_permanentStreet, ll.get(i).get("Street"), "Enter " + ll.get(i));
                GenericFunctions.jSClick(btn_save, "Save Button ");
                WaitHelper.sleep(4000);
                String errorMessage = GenericFunctions.getElementText(txt_POBox_errorMessage);
                if (errorMessage.contains("PO Box address can’t be used as Permanent address")) {
                    System.out.println("PO Box Validation rule passed");
                    WaitHelper.sleep(4000);
                }
                GenericFunctions.jSClick(btn_closeError, "close error pop up ");
                WaitHelper.sleep(4000);

            }//add from webtable
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


    public void deletePersonAccount(String lastName) {
      /*  WebElement element = GenericFunctions.getElement(By.xpath("//a[contains(text(),'" + lastName + "')]/ancestor::tr/td//span[text()='Show Actions']"));
        GenericFunctions.jSClick(element, "Show Actions");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(lnk_Delete, "Delete");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_DeleteInPopup, "Delete");
        WaitHelper.sleep(3000);
    }*/
        try {


            for (WebElement e : listOfPersonAccounts) {
                if (GenericFunctions.getElementText(e).contains(lastName)) {
                    WebElement showMoreAction = GenericFunctions.getElement(By.xpath(".//span[text()='Show more actions']"));
                    GenericFunctions.click(showMoreAction, "Show More Action");
                    WaitHelper.waitForElementPresent(lnk_Delete, "Delete");
                    GenericFunctions.click(lnk_Delete, "Delete");
                    WaitHelper.waitForElementPresent(btn_DeleteInPopup, "Delete inPopup");
                    GenericFunctions.click(btn_DeleteInPopup, "Delete");
                    WaitHelper.sleep(4000);
                    break;


                }
            }
        }
        catch (Exception e){
            System.out.println("Account is not deleted");
        }
    }




    static String temporaryAddress_hh;

    public void printGivenTemporaryAddress() {
        WaitHelper.sleep(5000);
        temporaryAddress_hh = txt_PA_TemporaryAddress.getAttribute("title");
        log.info("The temporary address of the household account is :");
        log.info(temporaryAddress_hh);
    }



    public void enterTemporaryStartDateAsToday() {
        WaitHelper.sleep(4000);
        GenericFunctions.type(txt_tempStartDate, DateTimeHelper.getCurrentDate(), "Today's date as Temporary Start date ");
        txt_tempStartDate.sendKeys(Keys.TAB);
        WaitHelper.sleep(2000);
    }

    public void verifyTodaysDateDefaultedInTempStartDate() {
        String defaultStartDate = txt_defaultStartDate.getText();
        DateTimeHelper.changeDatePattern("MM/D/YYYY", defaultStartDate, "MM/DD/YYYY");
        Assert.assertEquals(defaultStartDate, DateTimeHelper.getCurrentDate());//default system date is 11/05/2020

    }



    public void temporaryAddressEndDateValidation() {
        System.out.println(pageError.getText());
        GenericFunctions.jSClick(btn_closeSnagErrorPopUp, "close snag error ");
        if (txt_tempEndDate.isEnabled())
            GenericFunctions.type(txt_tempEndDate, DateTimeHelper.getCurrentDate(), "Today's date as Temporary Start date ");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_save, "Save button ");
        GenericFunctions.jSClick(btn_closeSnagErrorPopUp, "close snag error ");
    }





    public void clickOnSaveButton(){
     //   WaitHelper.waitForelementclickable(btn_save,3000);
        GenericFunctions.jSClick(btn_save,"Save button ");
        WaitHelper.sleep(2000);
    }


    public void editTemporaryAddressWithPOBox(DataTable poBox) {
        if (btn_edit_tempAddress.isDisplayed() && btn_editTempAddress.isEnabled()) {
            WaitHelper.sleep(4000);
            GenericFunctions.jSClick(btn_edit_tempAddress, "Temprary address edit button ");
            WaitHelper.sleep(4000);
            del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
            txt_temporaryStreet.sendKeys(del);
            WaitHelper.sleep(4000);

            GenericFunctions.jSClick(btn_save, "Save button ");
            WaitHelper.sleep(4000);
        }
    }

    public void clickOnAccount(){
        WaitHelper.sleep(5000);
        if(lnk_Account.isDisplayed() && lnk_Account.isEnabled()){
            try{
            GenericFunctions.jSClick(lnk_Account,"click on Account");
        }
            catch (TimeoutException e){
                System.out.println(e.getMessage());
            }

            }
    }



    public void endDateLessThanStartDate() {

        GenericFunctions.type(txt_tempStartDate,DateTimeHelper.getCurrentDate(),"start date as today ");
        txt_tempStartDate.sendKeys(Keys.TAB);
        WaitHelper.sleep(4000);
        GenericFunctions.type(txt_tempEndDate, (LocalDate.now().minusDays(5)).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), "End date less than today ");
        txt_tempEndDate.sendKeys(Keys.TAB);
        WaitHelper.sleep(4000);
        clickOnSaveButton();

    }


    public void relatedNavigation() {

        if(header_Account.getText().equals("Account")){
            GenericFunctions.jSClick(btn_related_account,"Account Related ");
            WaitHelper.sleep(3000);
        }

        else if(header_personAcct.getText().equals("Customer")){
            GenericFunctions.jSClick(btn_related_Customer,"Customer related ");

        }
    }

    public void clickOnViewAllButtonFromPersonAccountUnderHousehold() {
        try{
        WaitHelper.sleep(4000);
        GenericFunctions.jSClick(btn_viewAll_PersonAccount, "View All button ");
        WaitHelper.sleep(8000);
        }
        catch (Exception e){
            log.info("No Related person account present for this household account");
        }
    }

    static String hh_homePhone, hh_membershipNumber;

    public static void HH_HomePhoneAndMembershipNumber() {
        GenericFunctions.isDisplayed(lbl_hh_MembershipNumber, "");
        GenericFunctions.isDisplayed(lbl_hh_HomePhone, "");

        hh_membershipNumber = txt_val_hh_MembershipNumber.getText();
        hh_homePhone = txt_val_hh_homePhone.getText();

        System.out.println(("Home phone number in the Household is : " + hh_homePhone));
        System.out.println(("Membership Number in the Household is : " + hh_membershipNumber));
    }


    public void viewAddressHistory() {
        WaitHelper.sleep(4000);
        GenericFunctions.isDisplayed(lbl_AddresHistory, "Address History ");

    }



    public int searchAccountInLeftwindow(String name) {
        WaitHelper.pageLoadWait(40);
        GenericFunctions.type(txt_SearchInLeftWindow, name, "Name");
        GenericFunctions.click(lbl_AppName, "Step off");
        WaitHelper.pageLoadWait(50);
        WaitHelper.sleep(3000);
        return listOfAccounts_leftWin.size();

        }


    public void navigateToRelated() {
        WaitHelper.sleep(7000);
            GenericFunctions.jSClick(btn_related,"Related");
        GenericFunctions.click(btn_related,"Related");
        WaitHelper.sleep(7000);
      //  WaitHelper.pageLoadWait(50);




    }

    public void verifyPotentialDuplicateMessage() {
        WaitHelper.sleep(15000);
      //  Assert.assertTrue(GenericFunctions.getElementText(headerTitleRelated).contains("potential duplicate of this Account"));
    }

	public void clickOnViewDuplicates() {
		WaitHelper.sleep(4000);
		GenericFunctions.jSClick(lnk_ViewDuplicates,"View Duplicates");
		WaitHelper.sleep(4000);
	}



    public void mergeDuplicates() {
        WaitHelper.sleep(4000);
        Assert.assertTrue(GenericFunctions.isDisplayed(hd_DuplicatesRecords,"Duplicate Records"),"Duplicate Records window isn't displayed");
        GenericFunctions.click(chk_SecondPerson,"Second Per Check box");
        GenericFunctions.click(btn_Next_DuplicateWindow,"Next in Duplicates window");
       // WaitHelper.pageLoadWait(50);
        WaitHelper.sleep(5000);
        btn_Next_DuplicateWindow=GenericFunctions.getElement(By.xpath("//button[@class='slds-button slds-button_brand nextButton']"));
        GenericFunctions.click(btn_Next_DuplicateWindow,"Next in Dupliates window");
        WaitHelper.sleep(3000);
       // WaitHelper.pageLoadWait(50);
        Assert.assertTrue(GenericFunctions.isDisplayed(hd_Merge,"Merge Records"),"Merge Records window is not displaying");
        GenericFunctions.click(btn_Merge,"Merge");
      //  WaitHelper.pageLoadWait(100);
        WaitHelper.sleep(5000);


    }

    public boolean ableToMerge(){
        WaitHelper.sleep(4000);
        Assert.assertTrue(GenericFunctions.isDisplayed(hd_DuplicatesRecords,"Duplicate Records"),"Duplicate Records window isn't displayed");
        return GenericFunctions.isEnabled(btn_Next_DuplicateWindow);

    }


    public void viewAllOpportunities() {
        try {
            WaitHelper.sleep(5000);
       //     if (lnk_ViewAll.isDisplayed() && lnk_ViewAll.isEnabled()) {
                GenericFunctions.jSClick(lnk_ViewAllOpty, "View All");
                WaitHelper.sleep(5000);
            }

        catch (Exception e){
            log.info("View all button is timed out");
        }
    }

    public void clickNewOpportunity() {
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_NewOpportunity, "New Opportunity");

    }

    public void selectOpportunityListItems(String view) {
        WaitHelper.sleep(15000);
        GenericFunctions.click(lst_SelectView, "Account Select view");
        WaitHelper.sleep(3000);
        WaitHelper.waitForElementPresent(lnk_AllAccounts, "All Accounts");
        GenericFunctions.click(GenericFunctions.getElement(By.xpath("//span[text()='" + view + "']")), "");
        WaitHelper.sleep(3000);
    }



    public void enterTemporaryStreetWithPostalBox() {
        try {
            if (txt_temporaryStreet.isEnabled()) {
                if (!txt_temporaryStreet.getText().equals("")) {
                    txt_temporaryStreet.clear();
                    WaitHelper.sleep(4000);
                }
                GenericFunctions.type(txt_temporaryStreet, "Postal Box", "Street ");
                WaitHelper.sleep(4000);
                GenericFunctions.jSClick(btn_save, "Save Button ");
                WaitHelper.sleep(4000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GenericFunctions.jSClick(btn_save, "Save Button ");
        WaitHelper.sleep(4000);


    }

    static String memberNumber, homePhoneNumber, HH_PermanentAddress;


    public void createNewPersonAccount(){
		WaitHelper.sleep(6000);
        GenericFunctions.jSClick(btn_personAccount_new,"new ");
	    WaitHelper.sleep(6000);
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_Household, "Household"));
        Assert.assertTrue(GenericFunctions.isDisplayed(chk_PersonAccount, "Person Account"));
        GenericFunctions.jSClick(chk_PersonAccount, "Person Account");
        GenericFunctions.click(btn_Next, "Next");


    }

    public String getHouseholdName() {
        return GenericFunctions.getElementText(val_AccountName);
    }


    public void viewAllCases() {
    }

    public int getCasesCount() {
        return 4;
    }

    public void PermanentcountryPickList(){
        GenericFunctions.jSClick(btn_PermCountry,"Permanent Country ");
        WaitHelper.sleep(3000);
       log.info("Total countries are "+PCountryValues.size());
        WaitHelper.sleep(3000);
        String beforeXpath = "(//div[contains(@id,'dropdown')]/lightning-base-combobox-item/span[2]/span)[";

        /*for(int i=1;i<=PCountryValues.size();i++){
           System.out.println(GenericFunctions.getElement(By.xpath(beforeXpath+i+"]")).getText());
           WaitHelper.sleep(2000);
        }*/

    }

    public void SelectCountry(String Country) {
      //  GenericFunctions.jSClick(btn_PermCountry, "Permanent Country ");
        WaitHelper.sleep(3000);

        String beforeXpath = "//div[contains(@id,'dropdown')]/lightning-base-combobox-item/span[2]/span[text()='";
        GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath+Country+"']")),"Country "+Country+" ");
        WaitHelper.sleep(3000);
        }


    public void statesOfSelectedCountry() {
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(drpdown_btn_Pstate, "Permanent State ");
        WaitHelper.sleep(3000);
        System.out.println("Total State are " + PStateValues.size());
        WaitHelper.sleep(3000);
        String beforeXpath = "((//div[contains(@id,'dropdown-element')])[4]/lightning-base-combobox-item/span/span)[";

        for (int i = 1; i <= PStateValues.size(); i++) {
            System.out.println(GenericFunctions.getElement(By.xpath(beforeXpath + i + "]")).getText());
            // GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath("(//div[@lightning-basecombobox_basecombobox and @role='listbox']/lightning-base-combobox-item/span/span)[3]")),"state ");
            WaitHelper.sleep(2000);
        }
    }

    public void deleteTempStartDate(){
        GenericFunctions.jSClick(btn_editTempStartDate,"edit temporary start date ");
        WaitHelper.sleep(3000);
        del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WaitHelper.sleep(4000);
        txt_tempStartDate.sendKeys(del);
        WaitHelper.sleep(2000);

    }

    public void clickOnCancel(){
        GenericFunctions.jSClick(btn_cancel,"cancel button ");
        WaitHelper.sleep(3000);
    }

     /*
     * This method used to create add the Permanent Address
     * @Author: Veena
     * @Modified By: N/A
     */


    public void addPermanentAddress(String street,String state,String city,String zip) {

                del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

                WaitHelper.sleep(4000);
                // txt_permanentStreet.sendKeys(del);
                txt_permanentStreet.clear();
                WaitHelper.sleep(4000);
                GenericFunctions.type(txt_permanentStreet,street, "Enter Street");

                if(!city.equals("")) {

                    txt_permanentCity.sendKeys(del);
                    WaitHelper.sleep(4000);
                    GenericFunctions.type(txt_permanentCity, city, "Enter City");
                }
                if(!state.equals("")) {
                    System.out.println(state);

                    GenericFunctions.jSClick(drpdown_btn_Pstate, "state drop down menu ");
                    WaitHelper.sleep(3000);
                    GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath("//lightning-base-combobox-item//span[@title='" +
                            state + "']")), "state ");
                }
                if(!zip.equals("")) {

                    txt_permanentZip.sendKeys(del);
                    WaitHelper.sleep(4000);

                        GenericFunctions.type(txt_permanentZip, zip, "Enter Zip");


                }

                WaitHelper.sleep(4000);
                GenericFunctions.jSClick(btn_save, "Save Button ");
                WaitHelper.sleep(4000);
                //test
            }


            /*
     * This method used to verify the Permanent Address
     * @Author: Veena
     * @Modified By: N/A
     */






	public void verifyPermanentAddress(String street,String state,String city,String zip){

		String address = GenericFunctions.getAttribute(txt_HH_PermanentAddress, "title", "Permanent Address");
		String addr[] = address.split("\n");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(addr[0].equalsIgnoreCase(street));
		String addr2[] = addr[1].split(",");
		sa.assertTrue(addr2[0].trim().equalsIgnoreCase(city));
		String addr3[] = addr2[1].split(" ");
		sa.assertTrue(addr3[0].equalsIgnoreCase(state));
		String addr4[] = addr3[1].split("\n");
		sa.assertTrue(addr4[0].equalsIgnoreCase(zip));

	}

    public void clickHouseholdEditButton() {
	    GenericFunctions.isDisplayed(btn_houseHoldEdit,"Edit btn ");
	    WaitHelper.sleep(2000);
	    GenericFunctions.highlightElement(btn_houseHoldEdit);
	    WaitHelper.sleep(2000);
	    GenericFunctions.jSClick(btn_houseHoldEdit,"Edit Btn ");
	    WaitHelper.sleep(5000);
    }

    public void verifyEditRestrictionAlertDisplay() {
	    WaitHelper.sleep(5000);
	    boolean isEditRestrictedWindowDisplayed = GenericFunctions.isDisplayed(alert_restrictEditWindow,"Edit Window Restriction Msg ");
	    WaitHelper.sleep(3000);

        SoftAssert sa = new SoftAssert();
	    if (isEditRestrictedWindowDisplayed) {
            GenericFunctions.highlightElement(alert_restrictEditWindow);
            WaitHelper.sleep(3000);
            GenericFunctions.isDisplayed(btn_finishInEditRestrictAlertWindow, "Finish btn ");
            WaitHelper.sleep(2000);
            GenericFunctions.highlightElement(btn_finishInEditRestrictAlertWindow);
            WaitHelper.sleep(2000);
            GenericFunctions.jSClick(btn_finishInEditRestrictAlertWindow, "Finish btn ");
            WaitHelper.sleep(2000);
            sa.assertTrue(true);
        } else {
	        sa.assertTrue(false);
        }
    }


    public void verifyHouseholEditWindowDisplay() {
        WaitHelper.sleep(5000);
        boolean isEditWindowDisplayed = GenericFunctions.isDisplayed(txt_nameFiedlInEditWindow,"Name field ");
        WaitHelper.sleep(3000);

        SoftAssert sa = new SoftAssert();
        if(isEditWindowDisplayed) {
            GenericFunctions.highlightElement(txt_nameFiedlInEditWindow);
            WaitHelper.sleep(3000);
            GenericFunctions.isDisplayed(btn_closeHouseholdEditWindow, "Close btn ");
            WaitHelper.sleep(2000);
            GenericFunctions.highlightElement(btn_closeHouseholdEditWindow);
            WaitHelper.sleep(2000);
            GenericFunctions.jSClick(btn_closeHouseholdEditWindow, "Close btn ");
            WaitHelper.sleep(2000);
            sa.assertTrue(true);
        } else {
            sa.assertTrue(false);
        }
    }




    public void byPassAddressStandardization(String aTrue) {
}

    @FindBy(xpath="//input[@name='Send_UHG_Address_Change_Letter']//following::span[@class='slds-checkbox_faux']")
    WebElement chk_SendLetter;

	@FindBy(xpath ="//legend/descendant::span[text()='Select Customer to send Letter']//following::input[1][@type='radio']/../label/descendant::span[1][@class='slds-radio_faux']")
    WebElement select_FirstCustomerToSendLetter;

	@FindBy(xpath="//input[contains(@id,'CustomerinHousehold')]")
    WebElement rnd_Customer;

	//@FindBy(xpath="//input[contains(@id,'CustomerinHousehold')]/following-sibling::label//div[@dir='ltr']")
    @FindBy(xpath="//legend/descendant::span[text()='Select Customer to send Letter']//following::input[1][@type='radio']/../label/descendant::span[2][@class='slds-form-element__label']")
    WebElement customerName;

	@FindBy(xpath="//span[contains(text(),'Send UHG')]")
    WebElement sendUHG;


public void navigateToCustomer(String name){
    WebElement customer=GenericFunctions.getElement(By.xpath("//span[text()='"+name+"'][@id='window']"));
    GenericFunctions.click(customer,"Customer");

}

@FindBy(xpath="//h3[@class='primaryField slds-truncate']//a")
WebElement lnk_LatestCase;

public void navigateToLatestCase(){
    WaitHelper.sleep(4000);
    //TestBase.driver.navigate().refresh();
    WaitHelper.sleep(5000);
    GenericFunctions.jSClick(lnk_LatestCase,"Latest case");

}
}
















