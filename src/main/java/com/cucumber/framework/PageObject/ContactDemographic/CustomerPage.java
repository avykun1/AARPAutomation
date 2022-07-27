package com.cucumber.framework.PageObject.ContactDemographic;


import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ExcelReader;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import javax.annotation.Generated;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by gveenam on 10/20/2020.
 */
public class CustomerPage {

    WebDriverWait wait = new WebDriverWait(TestBase.driver,30);

    private final Logger log = LoggerHelper.getLogger(CustomerPage.class);

    public CustomerPage() {

        PageFactory.initElements(TestBase.driver, this);

    }


    @FindBy(xpath="//h2[text()='New Customer']")
    WebElement hd_PersoonAccount;

    @FindBy(xpath = "//input[contains(@class,'firstName')]")
    WebElement txt_FirstName;



    @FindBy(xpath = "//input[contains(@class,'middleName')]")
    WebElement txt_MiddleName;

    @FindBy(xpath = "//input[contains(@class,'lastName')]")
    WebElement txt_LastName;

    @FindBy(xpath = "//span[text()='Household']/parent::label/following-sibling::div//input")
    WebElement pick_Household;

    @FindBy(xpath = "//input[@inputmode='email']")
    WebElement txt_Email;

   // @FindBy(xpath = "//label[text()='Home Phone']/following-sibling::input[@type='tel']")
    @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
    WebElement txt_HomePhone;

  //  @FindBy(xpath = "//label[text()='Other Phone']/following-sibling::input[@type='tel']")
 // @FindBy(xpath = "//span[text()='Alternate Phone']/parent::label/following-sibling::input")

    @FindBy(xpath="//input[@name='PersonOtherPhone']")
    WebElement txt_AltPhone;

    @FindBy(xpath="//button[text()='Save'or @title='Save']")
    WebElement btn_Save;

    @FindBy(xpath="//button[@title='Save']")
    WebElement btn_NewSave;

    @FindBy(xpath = "//li[contains(@class,'lookup__item')]")
    List<WebElement> listOfHouseholds;

   @FindBy(xpath="//span[text()='Birthdate']/parent::label/following-sibling::div/input")
    WebElement txt_birthDate;

    @FindBy(xpath="//select[@class='slds-select picklist__label']")
    WebElement cmb_year;

    @FindBy(xpath="//a[@class='navLink nextMonth']")
    WebElement lnk_NextMonth;

    @FindBy(xpath="//a[@class='navLink prevMonth']")
    WebElement lnk_PrevMonth;

    @FindBy(xpath = "//h2[@class='monthYear']")
    WebElement currentMonth;

    @FindBy(xpath="//span[text()='Deceased Date']/parent::label/following-sibling::div/input")
    WebElement txt_DeceasedDate;

    @FindBy(xpath="//li[@class='form-element__help']")
    WebElement errorMessage;

    @FindBy(xpath = "//span[text()='Email Verified Date']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_emailVerificationDate;

    @FindBy(xpath = "//span[text()='Age']/parent::div/following-sibling::div//lightning-formatted-number")
    WebElement val_age;

    @FindBy(xpath="//span[@class='pillText']")
    WebElement txt_householdName;


    //Elemetns in Edit View
//@FindBy(xpath="//input[@name='PersonHomePhone']")
    @FindBy(xpath="//label[text()='Alternate Phone']/ancestor::force-record-layout-row/preceding-sibling::force-record-layout-row//input[@name='Phone']")
WebElement txt_HomePhoneEditView;

    @FindBy(xpath="//input[@name='PersonOtherPhone']")
    WebElement txt_AltPhoneEditView;
    @FindBy(xpath="//input[@name='Deceased_Date__pc']")
    WebElement txt_DeceasedDateEditView;

    @FindBy(xpath="//input[@name='PersonBirthdate']")
    WebElement txt_BirthDateEditView;

    @FindBy(xpath="//input[@name='PersonEmail']")
    WebElement txt_EmailEditView;

    @FindBy(xpath="//div[contains(@id,'help-message') or contains(@id,'error-message')]")
    WebElement msg_HelpEditView;

    @FindBy(xpath="//li[@class='form-element__help']")
    WebElement msg_HelpNewView;

    @FindBy(xpath = "(//lightning-formatted-name[text()='Jane Jones']/following::div//lightning-formatted-text)[3]")
    WebElement txt_pa_membershipNumber;

    @FindBy(xpath = "//lightning-formatted-name[text()='testS']/following::div//lightning-formatted-phone/a")
    WebElement txt_pa_homePhone;




    @FindBy(xpath = "(//h1[text()='Customers']/ancestor::div[contains(@class,'slds-page-header')]/following-sibling::div//tbody)[2]/tr")
    List<WebElement> lst_personAccount;

    @FindBy(xpath = "//span[@class='slds-show_inline-block']/following-sibling::span[text()='Customers']")
    WebElement subtab_personAccount;



    @FindBy(xpath = "//span[text()='Membership Number']/parent::label/following-sibling::input")
    WebElement txt_MembershipNumber;

    @FindBy(xpath = "//span[text()='Membership Number']")
    WebElement lbl_MembershipNumber;

    @FindBy(xpath="//div[@class='slds-col slds-align-middle']")
    WebElement msg_DuplicateContacts;

    @FindBy(linkText = "View Duplicates")
    WebElement lnk_ViewDuplicates;

    @FindBy(xpath="//div[text()='Account Name:']/following-sibling::div/span")
    WebElement lbl_AccountNameInDuplicatesWindow;

    @FindBy(xpath="//button[@title='Close this window']")
    WebElement btn_CloseDuplicateWindow;

   // @FindBy(xpath="//span[text()='Home Phone']/parent::div/following-sibling::div//lightning-formatted-phone/a")

    @FindBy(xpath="//span[text()='Home Phone']/parent::div/following-sibling::div//span/span")
    WebElement val_HomePhone;

    @FindBy(xpath="//span[text()='Alternate Phone']/parent::div/following-sibling::div//lightning-formatted-phone/a")
    WebElement val_AltPhone;

    @FindBy(xpath="//span[text()='Gender Verified Date']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_GenderVerifiedDate;

    @FindBy(xpath="//span[text()='Gender']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_Gender;


    @FindBy(xpath="//button[@title='Edit Alternate Phone']")
    WebElement btn_EditAltPhone;

    @FindBy(xpath="//span[text()='Edit Home Phone']/preceding-sibling::span")
    WebElement btn_EditHomePhone;

    @FindBy(xpath="//span[text()='Edit Gender']/preceding-sibling::span")
    WebElement btn_EditGender;

    @FindBy(xpath="//span[text()='Edit Gender Verified Date']/preceding-sibling::span")
    WebElement btn_GenderVerifiedDate;

    @FindBy(xpath="//span[text()='Edit Email Verified Date']/preceding-sibling::span")
    WebElement btn_EmailVerifiedDate;


    @FindBy(xpath="//label[text()='Gender']/following-sibling::div//input")
    WebElement txt_Gender;

    @FindBy(xpath="//span[text()='Gender']/parent::span/following-sibling::div//a")
    WebElement txt_GenderNew;


    @FindBy(xpath="//span[text()='Gender Verified Date']/parent::label/following-sibling::div//input")
    WebElement txt_GenderVerifiedNew;

    @FindBy(xpath="//span[text()='Email Verified Date']/parent::label/following-sibling::div//input")
    WebElement txt_EmailVerifiedNew;

    @FindBy(xpath="//input[@name='Email_Verified_Date__pc']")
    WebElement txt_EmailVerifiedDate;

    @FindBy(xpath="//input[@name='Gender_Verified_Date__pc']")
    WebElement txt_GenderVerifiedDate;

    @FindBy(xpath="//span[contains(text(),'Missing Demographic Data')]/parent::div/following-sibling::div//img/parent::span")
    WebElement fld_MissingDemograhicData;

    @FindBy(xpath="//span[text()='Email']/parent::div/following-sibling::div//emailui-formatted-email-wrapper//a")
    WebElement val_Email;



    //Person Account Fields

    @FindBy(xpath="//span[text()='Title']/parent::span/following-sibling::div//a")
    WebElement cmb_Title;

    @FindBy(xpath="//ul[@class='scrollable']/li[@role='presentation']")
    List<WebElement> listOfTitle;

    @FindBy(xpath="//span[text()='Preferred Channel']/parent::span/following-sibling::div//a")
    WebElement cmb_PreferredChannel;

    @FindBy(xpath="//span[text()='Best Call Time']/parent::span/following-sibling::div//a")
    WebElement cmb_BestCallTime;

    @FindBy(xpath="//span[text()='Preferred Language']/parent::span/following-sibling::div//a")
    WebElement cmb_PreferredLanguage;

    @FindBy(xpath = "//span[text()='Do Not Call']/parent::label/following-sibling::input")
    WebElement chk_DoNotCall;

    @FindBy(xpath="//span[text()='Do Not Email']/parent::label/following-sibling::input")
    WebElement chk_DoNotEmail;

    @FindBy(xpath="//span[text()='Do Not Mail']/parent::label/following-sibling::input")
    WebElement chk_DoNotMail;

    //Person Account Header
    @FindBy(xpath="//p[text()='Membership Number']/following-sibling::p//lightning-formatted-text")
    WebElement hd_MembershipNumber;

    @FindBy(xpath="//p[text()='Birthdate']/following-sibling::p//lightning-formatted-text")
    WebElement hd_BirthDate;


    @FindBy(xpath="//p[contains(text(),'Home Phone')]/following-sibling::p//a")
    WebElement hd_HomePhone;


    @FindBy(xpath="//p[contains(text(),'Alternate Phone')]/following-sibling::p//a")

    WebElement hd_AlternatePhone;

    @FindBy(xpath="//p[contains(text(),'Permanent Address')]/following-sibling::p//a")
    //@FindBy(xpath="//p[contains(text(),'Permanent Address')]/following-sibling::p//lightning-formatted-rich-text/span")
    WebElement hd_PermanentAddress;

   // @FindBy(xpath="//p[contains(text(),'Temporary Address')]/following-sibling::p//a")
    @FindBy(xpath="//p[contains(text(),'Temporary Address')]/following-sibling::p//lightning-formatted-rich-text/span")
    WebElement hd_TemporaryAddress;

  //  @FindBy(xpath="//span[text()='Permanent Address']/parent::div/following-sibling::div//lightning-formatted-rich-text/span")
    @FindBy(xpath="//span[text()='Permanent Address']/parent::div/following-sibling::div//lightning-formatted-address/a")
    WebElement val_PermanentAddress;

    @FindBy(xpath="//span[text()='Temporary Address']/parent::div/following-sibling::div//lightning-formatted-rich-text/span")
    WebElement val_TemporaryAddress;

    @FindBy(xpath="//span[text()='Membership Number']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_MembershipNumber;

    @FindBy(xpath="//span[text()='Birthdate']/parent::div/following-sibling::div//lightning-formatted-text")
    WebElement val_BirthDate;

    @FindBy(xpath = "//span[text()='Show more actions']/ancestor::button")
    WebElement btn_ShowMoreActions;

    @FindBy(xpath="//a[@name='Delete']")
    WebElement lnk_Delete;

    @FindBy(xpath="//button[@title='Delete']")
    WebElement btn_DeleteInPopup;

    @FindBy(xpath = "//p[text()='Permanent Address']/../p/slot//a")
    static WebElement val_permanentAddress_topField;

    @FindBy(xpath = "//span[text()='Household']/parent::div/following-sibling::div/span//a")
    WebElement btn_household;

    @FindBy(xpath = "//p[text()='Membership Number']/parent::div/p/slot/lightning-formatted-text")
    WebElement val_membershipNumber_KeyField;

    @FindBy(xpath = "//p[text()='Birthdate']/parent::div/p/slot/lightning-formatted-text")
    WebElement val_birthDate_KeyField;

    @FindBy(xpath = "//div[text()='Customer']")
    WebElement hd_PersonAccount;

    @FindBy(xpath = "//button[@name='Delete']")
    WebElement btn_deleteHH;

    @FindBy(xpath = "//button[@title='Delete']")
    WebElement btn_delete_sure;

    @FindBy(xpath="//span[text()='Household']/parent::label/following-sibling::div//input")
    WebElement txt_householdNameNew;

    @FindBy(xpath="//span[text()='Household']/parent::div/following-sibling::div/span/span")
    WebElement val_HouseholdInNewAct_ExistingHH;

    @FindBy(xpath = "//span[text()='Save']/parent::button[contains(@class,'publisherShareButton')]")
    WebElement btn_SaveActHH;

    @FindBy(xpath = "//h2[text()='Similar Records Exist']")
    WebElement msg_SimilarRecordsExist;

    @FindBy(xpath="//input[@name='middleName']")
    WebElement txt_MiddleNameInEditView;

    @FindBy(xpath = "(//span[text()='Membership Number']/../following-sibling::div/span//lightning-formatted-text)[2]")
    WebElement txt_PA_MembershipNumber;

    @FindBy(xpath = "//h1[@title='Customers']/following::div//p//span[1]")
    WebElement number_customers;

    @FindBy(xpath="//span[text()='Show more actions']")
    WebElement nvg_ShowMoreActions;

    @FindBy(xpath="//button[@name='Account.New_Opportunity']")
    WebElement btn_NewOpportunity;

    @FindBy(xpath="//span[text()='New Opportunity']")
    WebElement lst_NewOpportunity;

    @FindBy(xpath = "(//span[text()='Home Phone']/../following-sibling::div/span//lightning-formatted-phone/a)[2]")
    WebElement txt_PA_HomePhone;

    @FindBy(xpath="//div[contains(text(),'UHC Policy')]/following-sibling::*")
    WebElement lbl_UHCPolicy;

    @FindBy(xpath = "//span[text()='Membership Details']")
    WebElement btn_MembershipDetails;





    @FindBy(xpath="//div[contains(text(),'MetLife Policy')]")
    WebElement lbl_MetlifePolicy;

    @FindBy(xpath="//div[contains(text(),'Medicare RX')]")
    WebElement lbl_MedicareRxPolicy;

    @FindBy(xpath="//button[text()='Edit']")
    WebElement btn_Edit;


    @FindBy(xpath="//p[text()='Age']/following-sibling::p//lightning-formatted-number")
    WebElement val_AgeInHeader;

    @FindBy(xpath="//span[text()='Age']/parent::div/following-sibling::div//lightning-formatted-number")
    WebElement val_Age;

    @FindBy(xpath = "//li/a[@data-label='Siebel Service Requests']")
    WebElement lnkSection_siebelServiceRequest;

    //@FindBy(xpath = "//li/a[@data-label='Details']")
    @FindBy(xpath="//li/a[@data-label='Breeze Details']") // change as per US3427462
    WebElement lnkSection_details;

    @FindBy(xpath = "//a[@data-label='Siebel Service Requests']")
    WebElement tab_SiebelServiceRequests;

    //subha added 04/11/2021

    @FindBy(xpath = "//li/a[@data-label='Related']")
    WebElement lnkSection_related;

    @FindBy(xpath = "//button[@name='Account.New_Person_Account']//following::div[@class='slds-tabs_card']//following::a[@data-tab-value='relatedListsTab']")
    WebElement lnkSection_relatedHHlevel;
    @FindBy(xpath="//*[text()='Preferred Language']/../following-sibling::*//lightning-formatted-text")
            WebElement val_PreferredLang;

    /////// Updated as part of US3415724 opportunity changes in customer screen//////
    @FindBy(xpath ="//h2/a/span[text()='Opportunities']//following::dd[1]")
    WebElement Val_stage;

    @FindBy(xpath ="//h2/a/span[text()='Opportunities']//following::dd[2]")
    WebElement Val_productfamily;

    public void clickLinkSectionRelatedAtCustLevel() {
        WaitHelper.sleep(5000);
        GenericFunctions.isDisplayed(lnkSection_related,"Related section ");
        WaitHelper.sleep(2000);
        GenericFunctions.highlightElement(lnkSection_related);
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnkSection_related,"Related section ");
        WaitHelper.sleep(2000);
    }

    public void clickLinkSectionRelatedAtHouseholdLevel() {
        WaitHelper.sleep(5000);
        GenericFunctions.isDisplayed(lnkSection_relatedHHlevel,"Related section ");
        WaitHelper.sleep(2000);
        GenericFunctions.highlightElement(lnkSection_relatedHHlevel);
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnkSection_relatedHHlevel,"Related section ");
        WaitHelper.sleep(2000);
    }

    //subha added

    public void clickLinkSectionSeibelServiceRequest() {
        WaitHelper.sleep(5000);
        GenericFunctions.isDisplayed(lnkSection_siebelServiceRequest,"Seibel Service Request section ");
        WaitHelper.sleep(2000);
        GenericFunctions.highlightElement(lnkSection_siebelServiceRequest);
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnkSection_siebelServiceRequest,"Seibel Service Request section ");
        WaitHelper.sleep(2000);
    }

    public void clickLinkSectionDetails() {
        WaitHelper.sleep(5000);
        GenericFunctions.isDisplayed(lnkSection_details,"Details section ");
        WaitHelper.sleep(2000);
        GenericFunctions.highlightElement(lnkSection_details);
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(lnkSection_details,"Details section ");
        WaitHelper.sleep(2000);
    }











    //[span[text()='date']]



    public void enterPersonAccountDetails(){

        WaitHelper.sleep(4000);
      /*  GenericFunctions.type(txt_FirstName,GenericFunctions.randomString(4),"First Name");
        GenericFunctions.type(txt_MiddleName,GenericFunctions.randomString(1),"Middle Name");
        GenericFunctions.type(txt_LastName,GenericFunctions.randomString(4),"Last Name");*/

         GenericFunctions.type(txt_FirstName,ExcelReader.getCellData("FirstName"),"First Name");
        GenericFunctions.type(txt_MiddleName,ExcelReader.getCellData("MiddleName"),"Middle Name");
        GenericFunctions.type(txt_LastName,ExcelReader.getCellData("LastName"),"Last Name");
        GenericFunctions.type(txt_Email, ExcelReader.getCellData("Email"),"Email");
       /* GenericFunctions.type(txt_HomePhone,ExcelReader.getCellData("HomePhone"),"HomePhone");
        GenericFunctions.type(txt_OtherPhone,ExcelReader.getCellData("OtherPhone"),"OtherPhone");
*/

    }

    public void saveAccount(){
      //  if(GenericFunctions.isDisplayed(btn_Save,"Save")) {
        WaitHelper.sleep(6000);
            GenericFunctions.jSClick(btn_Save, "Save");
       // }
       // else{
            GenericFunctions.jSClick(btn_SaveActHH,"Save");
            WaitHelper.sleep(5000);
            if(GenericFunctions.isDisplayed(msg_SimilarRecordsExist,"View Duplicates")|| GenericFunctions.isDisplayed(lnk_ViewDuplicates,"view Duplicated")){
                GenericFunctions.click(btn_Save, "Save");
                GenericFunctions.click(btn_SaveActHH,"Save");
            }
       // }
       // WaitHelper.pageLoadWait(40);
        WaitHelper.sleep(4000);
    }

    public void verifyAccountsDisplayedUnderHouseholdPick(String personAccount){
        GenericFunctions.jSClick(pick_Household,"Household Picklist");
        WaitHelper.sleep(3000);
        for(WebElement e:listOfHouseholds){
            String householdName=GenericFunctions.getElementText(e);
            Assert.assertNotEquals(householdName,personAccount);
        }

    }

    public void setHousehold(String householdName){
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(pick_Household,"Household Picklist");
        WaitHelper.sleep(3000);
        WebElement household;
        if(householdName==null || householdName.equals("")){
            household=GenericFunctions.getElement(By.xpath("//li[contains(@class,'lookup__item ')][1]//a"));
        }
        else {
            GenericFunctions.type(txt_householdNameNew,householdName,"HouseholdName");
            WaitHelper.sleep(3000);
            String element="//mark[contains(text(),'"+householdName+"')]";
            household = GenericFunctions.getElement(By.xpath(element));
        }
        GenericFunctions.click(household,"Household");
    }

    public void selectHoushold(String householdName) {
        WebElement household;
        if(householdName.equals("")){
             household=GenericFunctions.getElement(By.xpath("//li[contains(@class,'lookup__item ')][1]//a"));
        }
        else {
            household = GenericFunctions.getElement(By.xpath("//div[text()='" + householdName + "']/ancestor::a"));
        }
        GenericFunctions.click(household,"Household");
    }

    public void homePhoneFieldValidation(String homePh) {

        //Home Phone Validation
        String invPhoneNumber = "333333333333";
       // WaitHelper.pageLoadWait(3000);
        WaitHelper.sleep(4000);
        //  long number = (long) Math.floor(Math.random() * 90000000000L) + 10000000000L;
        GenericFunctions.type(txt_HomePhoneEditView, invPhoneNumber, "Home Phone");
        GenericFunctions.click(btn_Save, "Save");
       // WaitHelper.pageLoadWait(30);

        WaitHelper.sleep(4000);
        //Error Message capture
        Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Please enter a valid Home Phone"));
        GenericFunctions.type(txt_HomePhoneEditView, homePh, "HomePhone");


    }


    //subha added isDisplayed and highlight function on 03/26/2021
    public void clickEdit(){
        WaitHelper.sleep(5000);
        GenericFunctions.isDisplayed(btn_Edit,"Edit ");
        WaitHelper.sleep(2000);
        GenericFunctions.highlightElement(btn_Edit);
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_Edit,"Edit");
        WaitHelper.sleep(5000);
    }

    public void altPhoneFieldValidation(String altPhone) {


        GenericFunctions.scrollDownVertically();
       // number = (long) Math.floor(Math.random() * 90000000000L) + 10000000000L;

        String invPhoneNumber = "111111111111";

        GenericFunctions.type(txt_AltPhone,invPhoneNumber, "Alt Phone");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(txt_Email,"Step off");
        WaitHelper.sleep(4000);
        GenericFunctions.scrollDownVertically();
        GenericFunctions.click(btn_NewSave, "Save");
        // WaitHelper.pageLoadWait(30);
        WaitHelper.sleep(6000);

        //Error Message capture
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_AltPhone, altPhone, "Alt Phone");


        /*GenericFunctions.type(txt_AltPhoneEditView,invPhoneNumber, "Alt Phone");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(txt_EmailEditView,"Step off");
        WaitHelper.sleep(4000);
        GenericFunctions.jSClick(btn_Save, "Save");
       // WaitHelper.pageLoadWait(30);
        WaitHelper.sleep(6000);
        //Error Message capture
        Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Please enter a valid Alternate Phone"));
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_AltPhoneEditView, altPhone, "Alt Phone");
*/


    }

    public void emailFieldValidation(String email) {


        //Email Validation

        String invalidEmail="testuser.com";
        GenericFunctions.type(txt_Email, invalidEmail, "Email");
        GenericFunctions.click(btn_NewSave, "Save");
       // WaitHelper.pageLoadWait(30);
        WaitHelper.sleep(3000);
      //  GenericFunctions.scrollDownVertically();
        GenericFunctions.type(txt_Email, "testuser"+GenericFunctions.randomString(1)+"@gmail.com", "Email");
        GenericFunctions.click(txt_AltPhone,"Step off");
        GenericFunctions.click(btn_NewSave, "Save");
    }

    public void dobFieldValidation(String birthdate){

        //BirthDate
        String invalidDOB="11/20/1880";
      GenericFunctions.type(txt_BirthDateEditView,invalidDOB,"Date Of Birth");
      GenericFunctions.click(btn_Save,"Save");
        WaitHelper.sleep(3000);

       // WaitHelper.pageLoadWait(40);
      Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Please enter a valid date of birth"));

      //Greater than Deceased Date
 /*   GenericFunctions.type(txt_BirthDateEditView,DateTimeHelper.addDays(DateTimeHelper.convertDate(ExcelReader.getCellData("DeceasedDate")),1),"Date of birth");
    GenericFunctions.click(btn_Save,"Save");*/
   // WaitHelper.pageLoadWait(30);
    //Added to handle stale element exception
   /* msg_HelpEditView=GenericFunctions.getElement(By.xpath("//div[contains(@id,'help-message') or contains(@id,'error-message')]"));
    Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Please enter a valid date of birth"));
*/
    //Greater than today
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_BirthDateEditView,DateTimeHelper.addDays(DateTimeHelper.getCurrentDate(),1),"Date of birth");
        GenericFunctions.click(btn_Save,"Save");
      //  WaitHelper.pageLoadWait(30);
        WaitHelper.sleep(5000);
        //Added to handle stale element exception
        msg_HelpEditView=GenericFunctions.getElement(By.xpath("//div[contains(@id,'help-message') or contains(@id,'error-message')]"));
       // Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Please enter a valid date of birth"));

        Assert.assertTrue(GenericFunctions.getElementText(msg_HelpEditView).contains("Date of Death must be today or in the past and after their birthdate"));


        GenericFunctions.type(txt_BirthDateEditView,DateTimeHelper.convertDate(birthdate),"Birth Date");
        WaitHelper.sleep(2000);
        GenericFunctions.click(txt_AltPhoneEditView,"Step off");


    }

    public void enterDeceasedDateInEditView(String dod){
     GenericFunctions.type(txt_DeceasedDateEditView,DateTimeHelper.convertDate(dod),"Deceased Date");
     GenericFunctions.click(txt_EmailEditView,"Step off");

    }

    public String getEmailVerificationDate(){

       return GenericFunctions.getElementText(val_emailVerificationDate);

    }

    public void verifyRecordType() {

        WaitHelper.waitForElementPresent(hd_PersoonAccount,"Customer");
        WaitHelper.sleep(5000);
        Assert.assertTrue(GenericFunctions.isDisplayed(hd_PersoonAccount,"Customer"));


    }

    public void verifyHouseholdAutoFills(String householdName) {
        Assert.assertTrue(GenericFunctions.getElementText(val_HouseholdInNewAct_ExistingHH).equalsIgnoreCase(householdName));
    }

    public String getAge(){
       return GenericFunctions.getElementText(val_age);
    }




    String temporaryAddress_pa;
    public void clickOnPersonAccountFromList() {
        WaitHelper.sleep(10000);
        int row = lst_personAccount.size();
        System.out.println("Total child accounts under the person account are : "+row);
        String beforeXpath = "//h1[text()]/ancestor::div[contains(@class,'header')]/following::div//tbody/tr[";
        String afterXpath = "]/th/span/a";

        for (int i = 1; i <= row; i++) {
            String accountName = GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println(accountName);
            GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)), +i + " child account " + accountName + " ");
            WaitHelper.sleep(5000);
            try {
                if (!GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Customers")) {
                    System.out.println("Its a household account. Check for Person Account ");
                    GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
                }
                else
                if (GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Customers")) {
                    System.out.println("Its a person account");
                    temporaryAddress_pa = GenericFunctions.getElement(By.xpath("(//lightning-formatted-name[text()='" + accountName + "']/following::slot[@slot='outputField']//span)[4]")).getText();
                    System.out.println(temporaryAddress_pa);
                    if (AccountsPage.temporaryAddress_hh.equals(temporaryAddress_pa)) {
                        System.out.println("Cascaded successfully");
                    }
                }
                else
                if (GenericFunctions.getElement(By.xpath("//span[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Account")) {
                    System.out.println("household account");
                }
            }
            catch(NullPointerException e ){
                System.out.println("No person account was found");
            }
            GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
        }
    }



    String permanentAddress_pa;
    public void permanentAddressCascadeToPersonAccount(){
        int row = lst_personAccount.size();
        System.out.println("Total child accounts under the person account are : "+row);
        String beforeXpath = "//h1[text()]/ancestor::div[contains(@class,'header')]/following::div//tbody/tr[";
        String afterXpath = "]/th/span/a";
        for (int i = 1; i <= row; i++) {
            String accountName = GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println(accountName);
            GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)), +i + " child account " + accountName + " ");
            WaitHelper.sleep(5000);
            try {
                if (!GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Person Account")) {
                    System.out.println("Its a household account. Check for Person Account ");
                    GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
                }
                else
                if (GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Person Account")) {
                    System.out.println("Its a person account");
                    permanentAddress_pa = GenericFunctions.getElement(By.xpath("(//lightning-formatted-name[text()='" + accountName + "']/following::slot[@slot='outputField']//span)[3]")).getText();
                    System.out.println(AccountsPage.permanentAddress_hh);
                    if (AccountsPage.permanentAddress_hh.equals(permanentAddress_pa)) {
                        System.out.println("Cascaded successfully");
                    }
                }
                else
                if (GenericFunctions.getElement(By.xpath("//span[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Account")) {
                    System.out.println("household account");
                }
            }
            catch(NullPointerException e ){
                System.out.println("No person account was found");
            }
            GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
        }
    }


    String membershipNumber_pa,homePhone_pa;
    public void VerifyMembershipAndHomePhoneCascade(){
        int row = lst_personAccount.size();
        System.out.println("Total child accounts under the person account are : "+row);
        String beforeXpath = "//h1[text()]/ancestor::div[contains(@class,'header')]/following::div//tbody/tr[";
        String afterXpath = "]/th/span/a";
        for (int i = 1; i <= row; i++) {
            String accountName = GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println(accountName);
            GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)), +i + " child account " + accountName + " ");
            WaitHelper.sleep(5000);
            try {
                if (!GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Person Account")) {
                    System.out.println(("Its a household account. Check for Person Account "));
                    GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
                }
                else
                if (GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Person Account")) {
                    System.out.println(("Its a person account"));
                    membershipNumber_pa = GenericFunctions.getElement(By.xpath("(//lightning-formatted-name[text()='"+accountName+"']/following::div//lightning-formatted-text)[3]")).getText();
                    System.out.println(membershipNumber_pa);
                    homePhone_pa = GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='"+accountName+"']/following::div//lightning-formatted-phone/a")).getText();
                    System.out.println(homePhone_pa);
                    if (membershipNumber_pa.equals(AccountsPage.txt_val_hh_MembershipNumber) && homePhone_pa.equals(AccountsPage.txt_val_hh_homePhone)) {
                        System.out.println("Cascaded successfully");
                    }
                }
                else
                if (GenericFunctions.getElement(By.xpath("//span[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Account")) {
                    System.out.println("household account");
                }
            }
            catch(NullPointerException e ){
                System.out.println("No person account was found");
            }
            GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
        }
    }


    public void navigateToRelatedViewPAAndVerifyAddressHistory(){
            int row = lst_personAccount.size();
            System.out.println("Total child accounts under the person account are : "+row);
            String beforeXpath = "//h1[text()]/ancestor::div[contains(@class,'header')]/following::div//tbody/tr[";
            String afterXpath = "]/th/span/a";
            String xpathRelated = "(//a[text()='Related'])[";
            String xpathAddressHistory = "(//span[@title='Address History'])[";
            for (int i = 1; i <= row; i++) {
                String accountName = GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)).getText();
                System.out.println(accountName);
                GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)), +i + " child account " + accountName + " ");
                WaitHelper.sleep(5000);
                try {

                GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(xpathRelated + i+1+"]")),"Related tab ");
                    WaitHelper.sleep(5000);
                    GenericFunctions.isDisplayed(GenericFunctions.getElement(By.xpath(xpathAddressHistory+i+1+"]")),"Address History ");
                }
                catch(NullPointerException e ){
                    System.out.println("No address history was found");
                }
                GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
            }
        }

    public void setFirstName(String firstName) {
        WaitHelper.sleep(4000);
        GenericFunctions.type(txt_FirstName,firstName,"First Name");
    }

    public void setLastName(String lastName){
        GenericFunctions.type(txt_LastName,lastName,"First Name");
    }

    public void setEmail(String email){

        if(email.equals("")){
            String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
            txt_Email.sendKeys(del);
        }
        else {
            WaitHelper.sleep(2000);
            GenericFunctions.type(txt_Email, email, "Email");
            WaitHelper.sleep(3000);
        }
        GenericFunctions.click(txt_FirstName,"Step off");
    }

    public void setMemberNumber(String memberNumber){
        GenericFunctions.type(txt_MembershipNumber,memberNumber,"MemberNumber");

    }
   public void setHomePhone(String homePhone){
        GenericFunctions.type(txt_HomePhone,homePhone,"HomePhone");
        GenericFunctions.click(txt_AltPhone,"Step off");
    }

    public boolean verifyDuplicateContactExistMessage(){
       WaitHelper.sleep(6000);
       if(!GenericFunctions.isDisplayed(msg_DuplicateContacts,"Duplicate Contacts")){
           return false;
       }

       return GenericFunctions.getElementText(msg_DuplicateContacts).contains("The record you're about to create looks like a duplicate. Open an existing record instead?");


    }

    public void viewDuplicates(String name) {
        GenericFunctions.click(lnk_ViewDuplicates,"View Duplicates");
        WaitHelper.sleep(12000);


    }
    public void closeDuplicatContactWindow(){
        GenericFunctions.click(btn_CloseDuplicateWindow,"CloseduplicateWindow");
        WaitHelper.pageLoadWait(40);
        WaitHelper.sleep(4000);

    }

    public void clickEditAltPhone(){

        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_EditAltPhone,"Alt Phone");
      //  WaitHelper.pageLoadWait(50);
        WaitHelper.sleep(6000);
    }







    public void setAltPhone(String altPhone){
       // WaitHelper.waitForElementVisible(txt_AltPhoneEditView,30,2);

        GenericFunctions.scrollDownVertically();
        if(altPhone.equals("")){
            GenericFunctions.clear(txt_AltPhone,"Alt Phone Edit View");
        }
        else
            GenericFunctions.type(txt_AltPhone,altPhone,"Alt Phone Edit view");

        GenericFunctions.click(txt_Email,"Step off");
        WaitHelper.sleep(3000);

    }
    public void verifyDemographicMissingAlertText(String message){
        WaitHelper.sleep(4000);


            if (!message.equals("")) {
                Assert.assertTrue(GenericFunctions.getElementText(fld_MissingDemograhicData).contains(message),"Missing Demographic information is not presented as expected");            } else {
            }



    }

    public String getGenderVerifiedDate(){
        WaitHelper.sleep(5000);
        return GenericFunctions.getElementText(val_GenderVerifiedDate);

    }



    public void setEmailVerifiedDate(String date){
        if(date.equals("")){
            GenericFunctions.clear(txt_EmailVerifiedDate,"Email Verified Date");
        }
        else{
            GenericFunctions.type(txt_EmailVerifiedDate,DateTimeHelper.convertDate(date),"Email Verified Date");
        }

    }

    public String getAltPhoneNumber(){
        if(GenericFunctions.isDisplayed(val_AltPhone,"Alt Phone value")){
            return GenericFunctions.getElementText(val_AltPhone);
        }
        return null;
    }


    public String getGender(){
        WaitHelper.sleep(4000);
        String gender=GenericFunctions.getElementText(val_Gender);

        return  gender;
    }

    public void setGenerVerifiedField(String generVerifiedField) {
       GenericFunctions.type(txt_GenderVerifiedDate,generVerifiedField,"Gender Verified Field");
       GenericFunctions.click(txt_AltPhoneEditView,"Step off");
    }


    public String getEmail() {
        if(GenericFunctions.isDisplayed(val_Email,"Email value")) {
          return   GenericFunctions.getElementText(val_Email);
        }
        return null;
    }

    public void verifyTitlePicklist() {
        SoftAssert sa=new SoftAssert();

        //Title validation
        GenericFunctions.click(cmb_Title,"Title");
        WaitHelper.sleep(3000);
        ArrayList<String> actual=new ArrayList();
        ArrayList<String> expected=new ArrayList<>(Arrays.asList("","Mr", "Ms", "Mrs", "Miss", "Dr", "Judge", "Brother", "Col", "Cpt", "Lt Col", "Father", "Rabbi", "Lt", "Rev", "Major", "Sister", "Pastor", "Prof"));
        String act="";
        for(WebElement e:listOfTitle){
            actual.add(GenericFunctions.getElementText(e));
            act=act+",\""+GenericFunctions.getElementText(e)+"\"";
        }

        sa.assertEquals(actual,expected,"Title Picklist shoule match with the expected list");

        GenericFunctions.jSClick(listOfTitle.get(1),"Title");

        sa.assertAll();





    }

    public void verifyAllDemographicFieldsExist(){
        WaitHelper.sleep(3000);
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(cmb_Title,"Title"),"Title is not displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_FirstName,"FirstName"),"First Name isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_MiddleName,"MiddleName"),"Middle Name isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_LastName,"lastName"),"Last Name isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_GenderNew,"Gender"),"Gender isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_Email,"Email"),"Email isn't displayed");
        //sa.assertTrue(GenericFunctions.isDisplayed(txt_birthDate,"BirthDate"),"Birth date isn't displayed");
       // sa.assertTrue(GenericFunctions.isDisplayed(txt_DeceasedDate,"DeceasedDate"),"Deceased Date isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(pick_Household,"HouseholdName"),"Household name isn't dispalyed");
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_MembershipNumber,"Membership Number"),"Membership Number isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_GenderVerifiedNew,"Gender Verified Date"),"Gender verified date isn't displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(txt_EmailVerifiedNew,"Email Verified Date"),"Email verified date isn't displayed");
       sa.assertAll();

    }

    public void verifyCommunicationProfileFields(){
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(cmb_BestCallTime,"Best Call Time"),"Best Call Time should be displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(cmb_PreferredChannel,"Preferred Channel"),"Preferred Channel should be displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(cmb_PreferredLanguage,"Preferred Launguage"),"Preferred Launguage should be displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(chk_DoNotCall,"Do Not Call"),"Do Not Call should be displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(chk_DoNotEmail,"Do Not Email"),"Do Not Email should be displayed");
        sa.assertTrue(GenericFunctions.isDisplayed(chk_DoNotMail,"Do Not Mail"),"Do Not Mail should be displayed");
      sa.assertAll();

    }

    public void verifyPersonAccountHeader(){
        SoftAssert sa=new SoftAssert();
        log.info("Verifying Person Account Header");
        sa.assertEquals(GenericFunctions.getElementText(val_MembershipNumber),GenericFunctions.getElementText(hd_MembershipNumber));
        sa.assertEquals(GenericFunctions.getElementText(val_BirthDate),GenericFunctions.getElementText(hd_BirthDate));
       /* if(val_TemporaryAddress.equals("")){
            sa.assertFalse(GenericFunctions.isDisplayed(hd_TemporaryAddress,"Temporary Address in Header"));
        }
        else{
            sa.assertEquals(GenericFunctions.getElementText(val_TemporaryAddress),GenericFunctions.getElementText(hd_TemporaryAddress));
        }*/



        if(!GenericFunctions.isDisplayed(val_PermanentAddress,"Permanent Address")){
            sa.assertFalse(GenericFunctions.isDisplayed(hd_PermanentAddress,"Permanent Address in Header"));
        }
        else{
       //uncomment below
           sa.assertTrue(GenericFunctions.getAttribute(val_PermanentAddress,"title","").replaceAll("\r","").replaceAll("\n","").equalsIgnoreCase(GenericFunctions.getElementText(hd_PermanentAddress).replaceAll("\n","").replaceAll("\r","")));
        }

        sa.assertEquals(GenericFunctions.getElementText(val_AgeInHeader),GenericFunctions.getElementText(val_Age));

       sa.assertAll();
        log.info("Person Account Header fields are get displayed properly");

    }
    public static String pAddress_PAccount_topField;
    public static void capture_PermanentAddress_From_SecondaryFields(){
        pAddress_PAccount_topField = val_permanentAddress_topField.getAttribute("title");
        System.out.println("Person account Permanent address is "+pAddress_PAccount_topField);
    }

    public void deletePersonAccount(){
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_ShowMoreActions,"Show More Actions");
        WaitHelper.sleep(2000);
        GenericFunctions.click(lnk_Delete,"Delete");
        WaitHelper.sleep(2000);
        GenericFunctions.click(btn_DeleteInPopup,"Delete in Popup");
    }

    // subha isdisplayed and highlighted method on 03/12/2021
    public void navigateTHouseHold(){
        WaitHelper.sleep(8000);
        GenericFunctions.isDisplayed(btn_household,"Household link ");
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(btn_household);
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_household,"Household ");
        WaitHelper.sleep(6000);
    }


    public static String membershipNumber,birthDate;
    public void keyFieldValueCapture(){
        membershipNumber = val_membershipNumber_KeyField.getText();
        birthDate = val_birthDate_KeyField.getText();
        pAddress_PAccount_topField = val_permanentAddress_topField.getAttribute("title");
        //capture_PermanentAddress_From_SecondaryFields();

    }

    public boolean checkIfPersonAccount(){
        WaitHelper.sleep(4000);
        return GenericFunctions.isDisplayed(hd_PersonAccount,"Person account ");


    }

    public void enterPersonAccountLastName(){
        try {
            WaitHelper.sleep(4000);
            GenericFunctions.type(txt_LastName, (ExcelReader.getCellData("LastName") + (GenericFunctions.randomString(3).toLowerCase())), "Last Name ");
          //  WaitHelper.sleep(4000);
            GenericFunctions.type(txt_FirstName, (GenericFunctions.randomString(1).toUpperCase()) + (GenericFunctions.randomString(5).toLowerCase()), "First Name ");
           // WaitHelper.sleep(4000);
            //GenericFunctions.jSClick(txt_MiddleName,"middle name ");
	      //  WaitHelper.sleep(2000);
            GenericFunctions.jSClick(btn_Save, "Save");
            WaitHelper.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void verifyCascading(){
	   if( GenericFunctions.getElement(By.xpath("(//p/slot/lightning-formatted-text[text()='"+AccountsPage.memberNumber+"'])[1]")).getText()
       .equals(AccountsPage.memberNumber))
	   {
            System.out.println("Membership number is same");
        }
    }

    public void verifyMembershipNumberCascading() {
        try {
            System.out.println(txt_PA_MembershipNumber.getText());
            if (AccountsPage.memberNumber.equals(txt_PA_MembershipNumber.getAttribute("text"))) {
                System.out.println("Membership number is same");
            }

            String phoneNumber_PA = txt_PA_HomePhone.getText().replaceAll("[\\D]", "");
            System.out.println(phoneNumber_PA);
            if (phoneNumber_PA.equals(AccountsPage.homePhoneNumber)) {
                System.out.println("Home Phone number number is same");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHouseholdAccount()  {
        try {
            WaitHelper.sleep(4000);
            GenericFunctions.jSClick(btn_deleteHH, "delete household ");
            WaitHelper.sleep(2000);
            GenericFunctions.jSClick(btn_delete_sure, "delete sure ");
            WaitHelper.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }


    public void temporaryAddressCascadeToPersonAccount(){
        WaitHelper.sleep(6000);
        String text = number_customers.getText();
        int row = Integer.parseInt(text.replaceAll("[^\\d]", " ").trim());
        System.out.println("Total child accounts under the person account are : "+row);
        String beforeXpath = "//h1[text()]/ancestor::div[contains(@class,'header')]/following::div//tbody/tr[";
        String afterXpath = "]/th/span/a";
        for (int i = 1; i <= row; i++) {
            String accountName = GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println(accountName);
            GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath(beforeXpath + i + afterXpath)), +i + " child account " + accountName + " ");
            WaitHelper.sleep(5000);
            try {
                if (!GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Customer")) {
                    System.out.println("Its a household account. Check for Person Account ");
                    GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
                }
                else
                if (GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Customer")) {
                    System.out.println("Its a person account");
                    GenericFunctions.jSClick(AccountsPage.lnk_Details,"details");
                    temporaryAddress_pa = GenericFunctions.getElement(By.xpath("//lightning-formatted-name[text()='" + accountName + "']/../following::span[text()='Temporary Address']/../following-sibling::div//a")).getAttribute("title");
                    if (AccountsPage.temporaryAddress_hh.equals(temporaryAddress_pa)) {
                        System.out.println("Cascaded successfully");
                    }
                }
                else
                if (GenericFunctions.getElement(By.xpath("//span[text()='" + accountName + "']/ancestor::h1/div")).getText().equals("Account")) {
                    System.out.println("household account");
                }
            }
            catch(NullPointerException e ){
                System.out.println("No person account was found");
            }
            GenericFunctions.jSClick(subtab_personAccount, "sub tab person account ");
            WaitHelper.sleep(5000);
        }
    }

    public void setMiddleNameInEditView(String middleName){
        GenericFunctions.type(txt_MiddleNameInEditView,middleName,"Middle Name");

    }

    //@FindBy(xpath="//a[@title='New']")

    @FindBy(xpath="//button[text()='New Case']")
    WebElement btn_NewCase;

    @FindBy(linkText = "Cases")
    WebElement lnk_Cases;

    @FindBy(xpath="//span[text()='Cases']/ancestor::header/following-sibling::div//a")
    WebElement lnk_ShowMoreActions;

    @FindBy(xpath="//button[text()='Update Date Of Birth']")
    WebElement btn_DateOfBirth;


    /*
     * This method used to create a case
     * @Author: Veena
     * @Modified By: Veena
     */




    public void clickOnNewCase() {
     /*   WaitHelper.sleep(10000);
        GenericFunctions.jSClick(lnk_ShowMoreActions,"Cases");
        WaitHelper.sleep(6000);
        GenericFunctions.jSClick(btn_NewCase,"New Case");
        GenericFunctions.click(btn_NewCase,"New Case");
        WaitHelper.sleep(5000);*/
        WaitHelper.sleep(9000);
     GenericFunctions.jSClick(btn_NewCase,"New Case");
        GenericFunctions.click(btn_NewCase,"New Case");
     WaitHelper.sleep(4000);
    }

    @FindBy(xpath="//tr[1]//lightning-primitive-cell-factory[@data-label='Date']//lightning-formatted-text")
    WebElement val_DateInFieldHistory;

    @FindBy(xpath="//tr[1]//lightning-primitive-cell-factory[@data-label='Field']//lightning-formatted-text")
    WebElement val_FieldInFieldHistory;

    @FindBy(xpath="//tr[1]//lightning-primitive-cell-factory[@data-label='Original Value']//lightning-formatted-text")
    WebElement val_OriginalValueFieldHistory;


    @FindBy(xpath="//tr[1]//lightning-primitive-cell-factory[@data-label='New Value']//lightning-formatted-text")
    WebElement val_NewValueFieldHistory;

    @FindBy(xpath = "//span[text()='Person Account History']")
    WebElement lbl_PersonAccountHistory;

    @FindBy(xpath="//div[contains(text(),'UHC Policy')]/following-sibling::lightning-icon")
    WebElement lbl_UHCIndicator;

    @FindBy(xpath="//div[contains(text(),'Medicare RX')]/following-sibling::lightning-icon")
    WebElement lbl_MedicareRxIndicator;

    @FindBy(xpath="//div[contains(text(),'MetLife Policy')]/following-sibling::lightning-icon")
    WebElement lbl_MetlifeIndicator;

    //subha started 2/27/2021
    @FindBy(xpath="//h2/a/span[text()='Opportunities']//following::h3[1]")
    @CacheLookup
    WebElement custCare_opportunityLink;
    //subha ends

    public void verifyFieldHistory(String enabled,String fieldName,String oldVal,String newVal){
        WaitHelper.sleep(9000);
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_PersonAccountHistory,"Person Account History"),"Person Account History isn't displayed");
        if(Boolean.parseBoolean(enabled)){

           String date= GenericFunctions.getElementText(val_DateInFieldHistory).split(",")[0].trim();
           sa.assertEquals(date,DateTimeHelper.getCurrentDateEST(),"Date should be current date");

           sa.assertTrue(fieldName.equalsIgnoreCase(GenericFunctions.getElementText(val_FieldInFieldHistory)));

            sa.assertTrue(oldVal.equalsIgnoreCase(GenericFunctions.getElementText(val_OriginalValueFieldHistory)));
            sa.assertTrue(newVal.equalsIgnoreCase(GenericFunctions.getElementText(val_NewValueFieldHistory)));

        }
        else{
            sa.assertFalse(fieldName.equalsIgnoreCase(GenericFunctions.getElementText(val_FieldInFieldHistory)));
        }

    }

    /*
     * This method used to create an opportunity
     * @Author: Veena
     * @Modified By: N/A
     */



    public void clickNewOpportunity(){
        //WaitHelper.sleep(10000);
        //GenericFunctions.jSClick(btn_NewOpportunity,"New Opportunity");
        //subha changed click function jsClick function

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='Account.New_Opportunity']")));

        if(GenericFunctions.isDisplayed(btn_NewOpportunity,"New Opportunity")){
            GenericFunctions.jSClick(btn_NewOpportunity,"New Opportunity");
        } else {
            GenericFunctions.jSClick(nvg_ShowMoreActions, "Show More Actions");
            GenericFunctions.jSClick(lst_NewOpportunity, "New Opportunity");
            WaitHelper.sleep(5000);
        }
    }

    @FindBy(xpath = "//span[text()='Cases']/parent::span")
    WebElement btn_viewAllCases;

/*
     * This method used to verify if any cases exist for the customer
     * @Author: Veena
     * @Modified By: N/A
     */

    public boolean casesExist() {
        return GenericFunctions.isDisplayed(btn_viewAllCases,"View AllCases");
    }

    /*
     * This method used to view All the cases
     * @Author: Veena
     * @Modified By: N/A
     */

    public void viewAllCases() {
        GenericFunctions.scrollDownVertically();
        GenericFunctions.jSClick(btn_viewAllCases,"View All Cases");
        WaitHelper.sleep(4000);
    }

    public void address_Verify_NFR(){
        if(AccountsPage.HH_PermanentAddress.equals(hd_PermanentAddress.getAttribute("title"))){
            System.out.println("Address is same ");

        }
    }

    public Map<String,String> getContactInfo() {
        Map<String,String> contactInfo=new HashMap<>();
        GenericFunctions.click(btn_EditGender,"Edit");
        GenericFunctions.getElementText(txt_FirstName);

        return contactInfo;
    }



    /*
     * This method used to get the UHC Policy Indicator
     * @Author: Veena
     * @Modified By: N/A
     */

    public String getIndicator(String plan){

        if(plan.equalsIgnoreCase("UHC")) {
            Assert.assertTrue(GenericFunctions.isDisplayed(lbl_UHCPolicy, "UHC Policy"));

            return GenericFunctions.getAttribute(lbl_UHCIndicator, "title", "UHC Indicator");
        }
        else if(plan.equalsIgnoreCase("Metlife")){
            Assert.assertTrue(GenericFunctions.isDisplayed(lbl_MetlifePolicy,"Metlife Policy"));
            return GenericFunctions.getAttribute(lbl_MetlifeIndicator,"title","Metlife Indicator");


        }
        else if(plan.equalsIgnoreCase("MedicareRx")){
            Assert.assertTrue(GenericFunctions.isDisplayed(lbl_MedicareRxPolicy,"Metlife Policy"));
            return GenericFunctions.getAttribute(lbl_MedicareRxIndicator,"title","Metlife Indicator");
        }

        return  null;
    }

    /*
* This method is used to click Membership details button
* @Author : Kalpana
* @Modified By : N/A
* */

    public void clickMemberShipDetailsButton(){
        //WaitHelper.waitForelementclickable(btn_ShowMoreActions,6000);
        GenericFunctions.jSClick(btn_ShowMoreActions,"Show More Actions button");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_MembershipDetails,"Membership details button");
    }





    //subha added for clicking the opportunity link present in Customer page
    //Date: 2/27/2021
    public void clickOpportunityLinkFromCustomerPage() {
        GenericFunctions.isDisplayed(custCare_opportunityLink,"Opportunity Link ");
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(custCare_opportunityLink);
        WaitHelper.sleep(3000);
        GenericFunctions.click(custCare_opportunityLink,"Opportunity Link ");
        WaitHelper.sleep(2000);
    }
    @FindBy(xpath="//h2[text()=' MetLife Warning']")
    WebElement hd_MetlifeWarning;

    @FindBy(xpath="//h2[text()=' UHC Warning']")
    WebElement hd_UHCWarning;

    @FindBy(xpath="//input[@name='birthDate']")
    WebElement txt_PersonBirthDate;

    @FindBy(xpath="//button[text()='Update']")
    WebElement btn_update;

    @FindBy(xpath="//h2[@class='slds-text-heading_small']")
    WebElement dobErrorMessage;

    public String updateDateOfBirth(String date){
        WaitHelper.waitForElementPresent(btn_Edit,"Date of Birth");
        GenericFunctions.click(btn_Edit,"Date of Birth");
        WaitHelper.waitForElementVisible(btn_update,40);

       // WebElement disabledButton=GenericFunctions.getElement(By.xpath("//button[@disabled][text()='Update']"));
        WaitHelper.waitForElementVisible(txt_PersonBirthDate, 30);
        GenericFunctions.type(txt_PersonBirthDate, date, "Date of birth");
        WaitHelper.sleep(5000);

        GenericFunctions.jSClick(btn_Save,"Save");



        if(GenericFunctions.isDisplayed(dobErrorMessage,"Error Message")){
       // Assert.assertTrue(GenericFunctions.isDisplayed(disabledButton,"Disabled Date of Birth"));
            String errorMessage= GenericFunctions.getElementText(dobErrorMessage);
            return errorMessage;

        }



        return null;



    }

    public String getBirthDate(){

        return GenericFunctions.getElementText(val_BirthDate);
    }


    //------------------------------------------------------------------------------------------------//
    // US3328062 - SF - Add membership details view to Opportunity page
    //------------------------------------------------------------------------------------------------//

    @FindBy(xpath="//li[@title='Membership Details']")
    WebElement tab_MembershipDetails;

    @FindBy(xpath="//span[text()='Membership#']/parent::div//following-sibling::div/span")
    static WebElement txt_MembershipId;

    @FindBy(xpath="//span[text()='Membership Status']/parent::div//following-sibling::div/span")
    static WebElement txt_MembershipStatus;

    //@FindBy(xpath="//span[text()='AARP Memberhsip#']/parent::div//following-sibling::div/div")
    @FindBy(xpath="//span[text()='AARP Membership#']/parent::div//following-sibling::div/span")
    static WebElement txt_AARPMembershipId;

    @FindBy(xpath="//span[text()='Expiration Date']/parent::div//following-sibling::div/span")
    static WebElement txt_MembershipExpirationDate;

    @FindBy(xpath="//span[text()='Auto-Renewal Indicator']/parent::div//following-sibling::div/span")
    static WebElement txt_AutoRenewalIndicator;

    @FindBy(xpath="//span[text()='Enrollment Date']/parent::div//following-sibling::div/span")
    static WebElement txt_EnrollmentDate;

    @FindBy(xpath="//span[text()='Last Payment Date']/parent::div//following-sibling::div/span")
    static WebElement txt_LastPaymentDate;

    @FindBy(xpath="//span[text()='Phone']/parent::div//following-sibling::div/span")
    static WebElement txt_Phone;

    @FindBy(xpath="//span[text()='Last Payment Amount']/parent::div//following-sibling::div/span")
    static WebElement txt_LastPaymentAmount;

    @FindBy(xpath="//span[text()='Address']/parent::div//following-sibling::div/span")
    static WebElement txt_memberAddress;

    @FindBy(xpath="//*[text()='Available Treatments']")
    private WebElement availableTreatmentsLabel;

    @FindBy(xpath="//*[@data-component-id='personalizationTreatmentComponent']")
    private WebElement personaliZationTreatMentComponent;













    public void clickMembershipDetailsTab(){
        WaitHelper.sleep(5000);
        GenericFunctions.jSClick(tab_MembershipDetails,"Membership Details");
        WaitHelper.sleep(3000);
    }

    public static String membershipId;
    public static String membershipStatus;
    public static String memAARPMembershipId;
    public static String membershipExpirationDate;
    public static String autoRenewalIndicator;
    public static String enrollmentDate;
    public static String lastPaymentDate;
    public static String phoneNumber;
    public static String lastPaymentAmount;
    public static String memberAddress;

    public static void getMembershipDetails(){
        WaitHelper.sleep(3000);
        membershipId = txt_MembershipId.getText();
        membershipStatus = txt_MembershipStatus.getText();
        memAARPMembershipId = txt_AARPMembershipId.getText();
        membershipExpirationDate = txt_MembershipExpirationDate.getText();
        autoRenewalIndicator = txt_AutoRenewalIndicator.getText();
        enrollmentDate = txt_EnrollmentDate.getText();
        lastPaymentDate = txt_LastPaymentDate.getText();
        phoneNumber = txt_Phone.getText();
        lastPaymentAmount = txt_LastPaymentAmount.getText();
        memberAddress = txt_memberAddress.getText();


        System.out.println("Membership Id: " +membershipId);
        System.out.println("Membership Status: " +membershipStatus);
        System.out.println("AARP Membership I: " +memAARPMembershipId);
        System.out.println("Membership Expiration Date: " +membershipExpirationDate);
        System.out.println("Auto-Renewal Indicator: " +autoRenewalIndicator);
        System.out.println("Enrollment Date: " +enrollmentDate);
        System.out.println("Last Payment Date: " +lastPaymentDate);
        System.out.println("Phone Number: " +phoneNumber);
        System.out.println("Last Payment Amount: " +lastPaymentAmount);
    }




    /*This method is to click on the Siebel Service Requests tab
        * @Author : Kalpana*/
    public void clickSiebelServiceRequestTab(){
        WaitHelper.sleep(4000);
        GenericFunctions.click(tab_SiebelServiceRequests,"Siebel Service Requests");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(tab_SiebelServiceRequests,"Siebel Service Requests");
        WaitHelper.sleep(5000);
    }

    //------------------------------------------------------------------------------------------------//
    // US3389116 - SF - Ability to see Home Phone on Opp highlights panel (VENKAT)
    //------------------------------------------------------------------------------------------------//

    @FindBy(xpath="//p[text()='Home Phone']/following-sibling::*/descendant::span[text()!='Click to dial']")
    static WebElement val_Customer_HomePhone;

    public static String customerHomePhone;
    public static void getHomePhoneFromCustomerPage(){
        WaitHelper.sleep(3000);
        customerHomePhone =  val_Customer_HomePhone.getText();
    }

    @FindBy(xpath="//a[text()='Auxiliary Parties']")
    WebElement lnk_AuxiliaryParties;

    public void navigateToAuxiliaryParties() {
        WaitHelper.sleep(5000);
        WaitHelper.waitForElementVisible(lnk_AuxiliaryParties,30);
        GenericFunctions.click(lnk_AuxiliaryParties,"AuxiliaryParties");
        WaitHelper.sleep(5000);
    }

    public String getLanguagePreference() {

        return GenericFunctions.getElementText(val_PreferredLang);
    }

    public void updateAddressAndVerifyErrorMessages(){

    }


    @FindBy(xpath="//button[text()='More']")
    WebElement btn_MoreTabs;


    @FindBy(xpath="//span[text()='Employer Details']/parent::a")
    WebElement lnk_EmployerDetails;

    @FindBy(xpath="//a[text()='Employer Details']")
    WebElement lnk_Employer;

    public void navigateToEmployerDetails(){

        GenericFunctions.click(lnk_Employer,"employer detail");
        GenericFunctions.click(btn_MoreTabs,"More Tabs");
        WaitHelper.sleep(4000);
        GenericFunctions.click(lnk_EmployerDetails,"employer details");
        WaitHelper.sleep(4000);

    }

    public void verifyPersonalizationTreatmentsTabIsVisible(){

        WaitHelper.waitForElementVisible(personaliZationTreatMentComponent, 30);

        Assert.assertTrue(GenericFunctions.isDisplayed(personaliZationTreatMentComponent, "Personalization Treatment"));

        new WebDriverWait(TestBase.driver, 30).until(ExpectedConditions.textToBePresentInElement(availableTreatmentsLabel, "Available Treatments"));
        String text = GenericFunctions.getElementText(availableTreatmentsLabel);
        Assert.assertEquals(text, "Available Treatments");

    }

    /////// Updated as part of US3415724 opportunity changes in customer screen//////

    public void verifyProductfamilyinopportunity(){


        GenericFunctions.highlightElement(Val_productfamily);
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(Val_stage);
        WaitHelper.sleep(3000);
        WebElement optystage;
        WebElement optyproductfamily;
        optystage=GenericFunctions.getElement(By.xpath("//h2/a/span[text()='Opportunities']//following::dd[1]"));
        optyproductfamily=GenericFunctions.getElement(By.xpath("//h2/a/span[text()='Opportunities']//following::dd[2]"));

        if(optyproductfamily.getText().equals("Medicare Supplement")||optyproductfamily.getText().equals("Medicare Rx")||optyproductfamily.getText().equals("Medicare Advantage"))

        {
            if(optystage.getText().equals("Regulatory Eligibility")||optystage.getText().equals("Needs Assessment")||optystage.getText().equals("Enrollment Offer")||optystage.getText().equals("Ineligible")||optystage.getText().equals("Rate Quote")||optystage.getText().equals("Enrollment"))

                System.out.println("Product family is updated as per stage of the opportunity ");
            System.out.println(("Opportunity stage is : " + Val_stage.getText()));
            System.out.println(("Opportunity family is :  : " + Val_productfamily.getText()));

        }

    }


}
