package com.cucumber.framework.PageObject.Login;

import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.framework.utility.ExcelReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class QuickSearchPage {
    private final Logger log = LoggerHelper.getLogger(HomePage.class);

    public QuickSearchPage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    WebDriverWait wait = new WebDriverWait(TestBase.driver,30);

    @FindBy(xpath = "//span[text()='Member Number']/preceding-sibling :: span")
    WebElement radiobtn_MemberNumber;

    @FindBy(xpath = "//span[text()='Phone Number']/preceding-sibling :: span")
    WebElement radiobtn_PhoneNumber;

    @FindBy(xpath = "//span[text()='Name & Zip']/preceding-sibling :: span")
    WebElement radiobtn_NameAndZip;

    @FindBy(xpath = "//span[text()='Name, Zip & DOB']/preceding-sibling :: span")
    WebElement radiobtn_NameAndDOB;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement btn_BreezeSearch;

    @FindBy(xpath = "//button[text() = 'AARP Search']")
    WebElement btn_AARPSearch;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement btn_Reset;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement txt_FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement txt_LastName;

    @FindBy(xpath = "//input[@name='birthDate']")
    WebElement txt_DateOfBirth;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement txt_PhoneNumber;

    @FindBy(xpath = "//input[@name='state']")
    WebElement fld_State;

    @FindBy(xpath = "//input[@name='uhcMemberNumber']")
    WebElement txt_MemberNumber;

    @FindBy(xpath = "//input[@name='zipCode']")
    WebElement txt_ZipCode;

    @FindBy(xpath = "//button[text()='Next']")
    WebElement btn_Next;

    @FindBy(xpath = "//button[text()='Previous']")
    WebElement btn_Previous;

    @FindBy(xpath = "//tr[1]/td[@data-label='Last name']//a")
    WebElement lst_SearchResult;

    //@FindBy(xpath = "//p[contains(@style,'red')]/label[contains(text(),'Valid search combinations are as below')]")
    @FindBy(xpath = "//div[text()='Complete this field.']")
    WebElement lbl_ValidCombinations;

    @FindBy(xpath = "//h2/span[text()='Breeze Search Results']")
    WebElement lbl_SalesforceSearchResult;

    @FindBy(xpath = "//h2/span[text()='Search Criteria']")
    WebElement lbl_ToStepOff;

    @FindBy(xpath = "//div/h2/span[text()='AARP Search Results']")
    WebElement lbl_KonexSearchResult;

    @FindBy(xpath = "//button[@title='Create New Customer']")
    WebElement btn_CreateCustomer;

    //@FindBy(xpath = "//p/label[text()='No Results Found.']")
    @FindBy(xpath="//span[text()='Breeze Search Results']/ancestor::div[contains(@class, 'slds-card__header')]/following-sibling::div/descendant::label")
    WebElement lbl_NoSearchResults;

    @FindBy(xpath = "//button[@title='Create New Customer']")
    WebElement btn_CreateNewCustomer;

    /*This method is to verify the fields in the Quick Search Page
    * @Author : Kalpana*/
    public void verifyAllFields() {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_MemberNumber, "Member Number Radio button"));
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_PhoneNumber, "Phone Number Radio button"));
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_NameAndZip, "Name And Zip Radio button"));
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_NameAndDOB, "Name And DOB Radio button"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_BreezeSearch, "Search"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_AARPSearch, "AARP Search"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_Reset, "Reset"));
        sa.assertAll();
    }

    /*This method is to search with Member number
    * @Author : Kalpana*/
    public void searchWithMemberNumber(String memberNumber) {
        GenericFunctions.jSClick(radiobtn_MemberNumber, "MemberNumber Radio button");
        WaitHelper.sleep(3000);
        Assert.assertTrue(GenericFunctions.isDisplayed(txt_MemberNumber, "Member Number text box"));
        GenericFunctions.type(txt_MemberNumber, memberNumber, "MemberNumber text box");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        GenericFunctions.jSClick(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(8000);
        if (GenericFunctions.isDisplayed(lst_SearchResult, "Search Results")) {
            log.info("Member Number exists");
            GenericFunctions.jSClick(lst_SearchResult, "Record in Search Results");
            WaitHelper.sleep(2000);
            //GenericFunctions.switchToRecentOpenedWindow();
        } else if (GenericFunctions.isDisplayed(lbl_ValidCombinations, "Valid Combinations txt")) {
            Assert.fail("Invalid Combination is entered");
        } else {
            log.info("Member Number does not exist");
        }
    }

    /*This function is to reset the quick search
   * @Author : mkalpana*/
    public void clickReset() {
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_Reset, "Reset button");
        WaitHelper.sleep(2000);
        GenericFunctions.jSClick(btn_Reset,"Reset button");
        WaitHelper.sleep(2000);
    }

    /*******************************************************************************
     * VALID SEARCH COMBINATIONS
     *******************************************************************************/

    /*This function is to search for a contact with Phone Number
   * @Author : mkalpana*/
    public void enterMemberNumber(String memberNumber) {
        GenericFunctions.jSClick(radiobtn_MemberNumber, "MemberNumber Radio button");
        WaitHelper.sleep(4000);
        GenericFunctions.type(txt_MemberNumber, memberNumber, "Member Number");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with Phone Number
    * @Author : mkalpana*/
    public void enterPhoneNumber(String phoneNumber) {
        GenericFunctions.jSClick(radiobtn_PhoneNumber, "PhoneNumber Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_PhoneNumber, phoneNumber, "Phone Number");
        GenericFunctions.click(lbl_ToStepOff, "Step off");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with LastName,FirstName and Zip code
    * @Author : mkalpana*/
    public void enterLastNameFirstNameZip(String lastName, String firstName, String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name And Zip Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_ZipCode, zip, "Zip Code");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with LastName,FirstName and DOB
   * @Author : mkalpana*/
    public void enterLastNameFirstNameDOB(String lastName, String firstName, String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    public void enterLastNameFirstNameDOBZip(String lastName, String firstName, String dob, String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio button");
           WaitHelper.sleep(3000);
                GenericFunctions.type(txt_FirstName, firstName, "First Name");
                GenericFunctions.type(txt_LastName, lastName, "Last Name");
                GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
                GenericFunctions.type(txt_ZipCode, zip, "Zip Code");
                GenericFunctions.click(lbl_ToStepOff, "Step Off");
                WaitHelper.sleep(3000);
                GenericFunctions.click(btn_BreezeSearch, "Search button");
                WaitHelper.sleep(3000);
           }

    /*This function is to search for a contact with LastName and DOB
   * @Author : mkalpana*/
    public void enterLastNameDOB(String lastName, String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /************************************************************************************
     * INVALID SEARCH COMBINATIONS
     ************************************************************************************/

    /*This function is to search for a contact with LastName and Zip
   * @Author : mkalpana*/
    public void enterLastNameZip(String lastName, String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name and Zip Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_ZipCode, zip, "Zip code");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with LastName and FirstName
  * @Author : mkalpana*/
    public void enterLastNameFirstName(String lastName, String firstName) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name and Zip Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(10000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(10000);
    }

    /*This function is to search for a contact with FirstName and DOB
  * @Author : mkalpana*/
    public void enterFirstNameDOB(String firstName, String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with FirstName and Zip
  * @Author : mkalpana*/
    public void enterFirstNameZip(String firstName, String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name and Zip Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_ZipCode, zip, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with DOB
  * @Author : mkalpana*/
    public void enterDOB(String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with Zip
  * @Author : mkalpana*/
    public void enterZip(String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name and Zip Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_ZipCode, zip, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with LastName
  * @Author : mkalpana*/
    public void enterLastName(String lastName) {
        GenericFunctions.jSClick(radiobtn_NameAndZip, "Name and Zip Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_LastName, lastName, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with FirstName
  * @Author : mkalpana*/
    public void enterFirstName(String firstName) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio Button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "Date Of Birth");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }

    /*************************************************************************************
     * VALIDATE THE RESULTS
     *************************************************************************************/
    /*This function is to validate the search
  * @Author : mkalpana
  * @Modified Date :12/8/2020 */
    public boolean validateSearch() {
        WaitHelper.sleep(6000);
        Assert.assertTrue(GenericFunctions.isDisplayed(btn_CreateCustomer, "Create Customer"));
        if (GenericFunctions.isDisplayed(lst_SearchResult, "Search Results")) {
            if (GenericFunctions.isDisplayed(lbl_KonexSearchResult, "AARP Search Results label")) {
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_SalesforceSearchResult, "Salesforce Search Results label"));
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_NoSearchResults, "Salesforce No Results found message"));
                List<String> expectedColumns = Arrays.asList("Member Number", "First name", "Last name", "Date of Birth", "Zipcode", "Address", "Membership Status", "Membership Expiration Date");
                for (String actualColumns : expectedColumns) {
                    WebElement searchColumn = TestBase.driver.findElement(By.xpath("//span[@title='" + actualColumns + "']"));
                    Assert.assertTrue(GenericFunctions.isDisplayed(searchColumn, actualColumns));
                }
                log.info("Contact exists in Konex");
            } else {
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_SalesforceSearchResult, "Salesforce Search Results label"));
                List<String> expectedColumns = Arrays.asList("Member Number", "First name", "Last name", "Date of Birth", "Zipcode", "Address", "State");
                for (String actualColumns : expectedColumns) {
                    WebElement searchColumn = TestBase.driver.findElement(By.xpath("//span[@title='" + actualColumns + "']"));
                    Assert.assertTrue(GenericFunctions.isDisplayed(searchColumn, actualColumns));
                }
                log.info("Contact exists in Salesforce");
            }
            return true;
        } else {
            if (GenericFunctions.isDisplayed(lbl_NoSearchResults, "No Search Results displayed")) {
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_SalesforceSearchResult, "Salesforce Search Results label"));
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_KonexSearchResult, "AARP Search Results label"));
                log.info("Contact does not exist in Salesforce and Konex");
            } else {
                Assert.assertTrue(GenericFunctions.isDisplayed(lbl_ValidCombinations, "Valid combinations error message"));
                log.info("Invalid format entered");
            }
            return false;
        }
    }

    /*This function is to validate the invalid Search Combinations
  * @Author : mkalpana*/
    public void invalidSearchCombinations(){
        WaitHelper.sleep(10000);
        //GenericFunctions.click(btn_Search,"Search button");
        WaitHelper.sleep(2000);
        Assert.assertTrue(GenericFunctions.isDisplayed(lbl_ValidCombinations,"Valid Combinations Error Message"));
    }

    /*This function is to click on the contact in quick search list
 * @Author : mkalpana
 * @Modified Date :12/8/2020 */
    public void clickContactInQuickSearchList(String lastName){
        WaitHelper.sleep(2000);
        if(GenericFunctions.isDisplayed(lst_SearchResult,"Search Results")){
            log.info("Contact exists");
            if(!lastName.isEmpty()) {
                WebElement element=GenericFunctions.getElement(By.xpath("//a[text()='"+lastName+"']"));
                GenericFunctions.jSClick(element,"LastName");
            }
            else{
                GenericFunctions.jSClick(lst_SearchResult, "Record in Search Results");
            }
            WaitHelper.sleep(2000);
            //GenericFunctions.switchToRecentOpenedWindow();
        }
        else if(GenericFunctions.isDisplayed(lbl_ValidCombinations,"Valid Combinations txt")){
            Assert.fail("Invalid Combination is entered");
        }
        else{
            Assert.fail("Contact does not exist");
        }
    }

    /*This function is to find the number of records in Quick Search List
* @Author : mkalpana
* @Modified Date :12/8/2020 */
    public void numberOfRecordsInSearchList(){
        List<WebElement> rows = TestBase.driver.findElements(By.xpath("//table/tbody/tr"));
        int row_count = rows.size();
        if(row_count==1){
            log.info("Single Record displayed");
            Assert.assertFalse(GenericFunctions.isDisplayed(btn_Next,"Next"));
            Assert.assertFalse(GenericFunctions.isDisplayed(btn_Previous,"Previous"));
        }
        else if(row_count>1){
            log.info("Multiple Records displayed");
            if(row_count >= 20){
                Assert.assertTrue(GenericFunctions.isDisplayed(btn_Next,"Next"));
                Assert.assertTrue(GenericFunctions.isDisplayed(btn_Previous,"Previous"));
            }
        }
        else{
            log.info("No Record displayed");
            Assert.assertFalse(GenericFunctions.isDisplayed(btn_Next,"Next"));
            Assert.assertFalse(GenericFunctions.isDisplayed(btn_Previous,"Previous"));
        }
    }

    /****************************************************************************************
     * KONNEX SEARCH
     ****************************************************************************************/
    /*This function is to perform Konnex search for a contact with Member number
     * @Author : mkalpana*/
    public void konnexSearchWithMemberNumber(String memberNumber){
        GenericFunctions.jSClick(radiobtn_MemberNumber,"MemberNumber Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_MemberNumber, memberNumber, "Member Number");
        GenericFunctions.click(lbl_ToStepOff, "step off");
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_AARPSearch, "AARP Search button");
        WaitHelper.sleep(8000);
    }

    /*This function is to perform Konnex search for a contact with Phone Number using Breeze button
     * @Author : subhashini
     * @Modified by : mkalpana
     * @Modified Date :04/15/2021 */

    public void konexSearchWithPhoneNumberUsingBreezeButton(String phoneNumber){
        System.out.println("Phone Number : "+phoneNumber);
        GenericFunctions.jSClick(radiobtn_PhoneNumber,"Phone Number Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_PhoneNumber, phoneNumber, "Phone Number");
        GenericFunctions.click(lbl_ToStepOff, "Step off");
        WaitHelper.sleep(10000);
        GenericFunctions.jSClick(btn_BreezeSearch, "Breeze Search button");
        WaitHelper.sleep(10000);
    }



    /*This function is to perform Konnex search for a contact with Phone Number
    * @Author : mkalpana
    * @Modified Date :12/8/2020 */
    public void konnexSearchWithPhoneNumber(String phoneNumber){
        GenericFunctions.jSClick(radiobtn_PhoneNumber,"Phone Number Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_PhoneNumber, phoneNumber, "Phone Number");
        GenericFunctions.click(lbl_ToStepOff, "Step off");
        WaitHelper.sleep(10000);
        GenericFunctions.jSClick(btn_AARPSearch, "Search button");
        WaitHelper.sleep(10000);
    }

    /*This function is to perform Konnex search for a contact with LastName,FirstName and Zip code
    * @Author : mkalpana
    * @Modified Date :12/8/2020 */
    public void konnexSearchWithLastNameFirstNameZip(String lastName,String firstName,String zip){
        GenericFunctions.jSClick(radiobtn_NameAndZip,"Phone Number Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_ZipCode, zip, "Zip Code");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(10000);
        GenericFunctions.jSClick(btn_AARPSearch, "Search button");
        WaitHelper.sleep(10000);
    }

    /*This function is to validate the Konnex search
 * @Author : mkalpana
 * @Modified Date :12/8/2020 */
    public void validateKonnexSearch(){
        WaitHelper.sleep(6000);
        if(GenericFunctions.isDisplayed(lst_SearchResult,"Search Results")){
            Assert.assertTrue(GenericFunctions.isDisplayed(lbl_KonexSearchResult,"AARP Search result"));
            log.info("Contact exists in Konex");
        }
        else {
            if(GenericFunctions.isDisplayed(lbl_ValidCombinations,"Valid Combinations error message")){
                log.info("Invalid format entered");
            }

            else{
                log.info("Contact does not exist in Konex");
            }
        }
    }

    /*This function is to click Create New Customer button
     * @Author : Subhashini Rajagopalan
     * @Created Date : 02/19/2021*/

    public void verifyDisplayOfCreatNewCustomerButton() {
        GenericFunctions.isDisplayed(btn_CreateNewCustomer,"Create New Customer");
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(btn_CreateNewCustomer);
        WaitHelper.sleep(3000);
    }

    public void clickCreateNewCustomer() {
        GenericFunctions.isDisplayed(btn_CreateNewCustomer,"Create New Customer");
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(btn_CreateNewCustomer);
        WaitHelper.sleep(3000);
        GenericFunctions.jSClick(btn_CreateNewCustomer,"Create New Customer button ");
        WaitHelper.sleep(3000);
    }

    //******************************************************************************************//
    // US3291413: SF - "Create Customer" from AARP search results and perform dedupe/merge
    // US3291413 - [Continued] SF - "Create Customer" from AARP search results and perform dedupe/merge
    // WEB ELEMENTS
    //******************************************************************************************//

    @FindBy(xpath="//button[@name='updateBreeze']")
    WebElement btn_UpdateBreeze;

    @FindBy(xpath="//button[@name='updateBreeze']//following::lightning-helptext")
    WebElement icon_UpedateBreezeHelpIcon;

    @FindBy(xpath="//div[text()='Select Breeze Record with no Membership# and AARP Record with Membership#']")
    WebElement msg_UpdateBreezeHelpText;

    @FindBy(xpath="//tr[1]/td[@role='gridcell']//following::span[text()='Select Item 1']")
    List<WebElement> rb_BreezeAndAAPRSearchRecord1;

    //@FindBy(xpath="//h2[text()='Confirm']")
    @FindBy(xpath="//h2[text()='Confirm Breeze Update']")
    WebElement lbl_UpdateBreezeConfirm;

    //@FindBy(xpath="//button[@name='cancel']")
    @FindBy(xpath="//button[@title='Not Authenticated']")
    WebElement btn_UpdateBreezeCancel;

    @FindBy(xpath="//span[text()='Breeze Search Results']")
    WebElement lbl_BreezeSearchResults;

    public void updateBreezeButtonValidationsAndMerge(String confirmMerge){

        WaitHelper.sleep(5000);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(GenericFunctions.isEnabled(btn_UpdateBreeze));

        GenericFunctions.mouseHover(icon_UpedateBreezeHelpIcon,"Update Breeze Help Icon");
        softAssert.assertTrue(GenericFunctions.isDisplayed(msg_UpdateBreezeHelpText,"Help Text"));

        for(WebElement option:rb_BreezeAndAAPRSearchRecord1){
            WaitHelper.sleep(3000);
            GenericFunctions.jSClick(option,"Radio Option");
        }

        WaitHelper.sleep(3000);
        softAssert.assertTrue(GenericFunctions.isEnabled(btn_UpdateBreeze));
        GenericFunctions.jSClick(btn_UpdateBreeze,"Update Breeze");

        if (confirmMerge.equalsIgnoreCase("No")){
            WaitHelper.sleep(3000);
            GenericFunctions.click(lbl_UpdateBreezeConfirm,"Confirm Step Off");
            GenericFunctions.jSClick(btn_UpdateBreezeCancel,"No");

            softAssert.assertTrue(GenericFunctions.isDisplayed(lbl_BreezeSearchResults,"Breeze Search Results"));
        } else {
            log.error("Should not merge member due to test data constraint");
        }

        softAssert.assertAll();
    }

    /*
     * Created for DOB validation check
     * Author: Subhashini Rajagopalan
     * Date: 3/22/2021
     *
     * */

    @FindBy(xpath="//div[contains(text(),'Your entry does not match the allowed format mm/dd/yyyy')]")
    WebElement dob_ErrMsg01;

    @FindBy(xpath="//div[contains(text(),'Your entry month should be between 01 and 12')]")
    WebElement dob_ErrMsg02;

    @FindBy(xpath="//div[contains(text(),'Invalid Date Of Birth')]")
    WebElement dob_ErrMsg03;

    @FindBy(xpath="//div[contains(text(),'Your entry date should be between 01 and 31')]")
    WebElement dob_ErrMsg04;


    public void errMsgForInvalidDateFired() {
        WaitHelper.sleep(3000);
        if (GenericFunctions.isDisplayed(dob_ErrMsg01, "Error Messsage ") ||
                GenericFunctions.isDisplayed(dob_ErrMsg02, "Error Message ") ||
                GenericFunctions.isDisplayed(dob_ErrMsg03, "Error Message ") ||
                GenericFunctions.isDisplayed(dob_ErrMsg04, "Error Message ")) {
            SoftAssert sa = new SoftAssert();
            sa.assertTrue(true);
        }
    }

    /*This function is modified to add the radio button functionality
    @Modified by : mkalpana
    @Modified date : 04/15/2021
     */
    public void enterLastNameFirstNameDOBWithoutSlashes(String fname,String lname, String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB,"Name and DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, fname, "First Name ");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_LastName, lname,"Last Name ");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_DateOfBirth, dob, "DOB ");
        WaitHelper.sleep(2000);
        txt_DateOfBirth.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Create New Customer']")));
    }

    public void enterLastNameFirstNameDOBWithoutSlashes(String fname,String lname,String zipcode, String dob) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB,"Name and DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, fname, "First Name ");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_LastName, lname,"Last Name ");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_ZipCode, zipcode,"Zipcode ");
        WaitHelper.sleep(2000);
        GenericFunctions.type(txt_DateOfBirth, dob, "DOB ");
        WaitHelper.sleep(2000);
        txt_DateOfBirth.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Create New Customer']")));

        WaitHelper.sleep(5000);
            if (GenericFunctions.isDisplayed(lst_SearchResult, "Search Results")) {
                log.info("Member Number exists");
                GenericFunctions.jSClick(lst_SearchResult, "Record in Search Results");
                WaitHelper.sleep(2000);

            } else if (GenericFunctions.isDisplayed(lbl_ValidCombinations, "Valid Combinations txt")) {
                Assert.fail("Invalid Combination is entered");
            } else {
                log.info("Member Number does not exist");
            }
    }

    public void validationDateOfBirthWithoutSlashes() {
        GenericFunctions.jSClick(radiobtn_NameAndDOB,"Name And DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.isDisplayed(txt_DateOfBirth,"DOB ");
        GenericFunctions.highlightElement(txt_DateOfBirth);
        WaitHelper.sleep(2000);
        System.out.println("Date of Birth : " + txt_DateOfBirth.getAttribute("value"));
        String formattedDate = txt_DateOfBirth.getAttribute("value");
        SoftAssert sa = new SoftAssert();
        if(formattedDate.equals(ExcelReader.getCellData("SystemExpectDate"))) {
            sa.assertTrue(true);
        } else {
            sa.assertTrue(false);
        }
        sa.assertAll();

    }


    public void validateDOBFieldWithSlashes() {
        GenericFunctions.jSClick(radiobtn_NameAndDOB,"Name And DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.isDisplayed(txt_DateOfBirth,"Date of Birth ");
        WaitHelper.sleep(3000);
        GenericFunctions.highlightElement(txt_DateOfBirth);
        WaitHelper.sleep(3000);
        String dobValue = GenericFunctions.getElementText(txt_DateOfBirth);
        WaitHelper.sleep(3000);
        System.out.println("DOB value : "+dobValue);
        GenericFunctions.isDisplayed(lbl_NoSearchResults," Search Results ");
        WaitHelper.sleep(3000);
    }

    /*This function is to search for a contact with LastName and DOB
   * @Author : Veena*/
    public void enterLastNameDOBZip(String lastName, String dob,String zip) {
        GenericFunctions.jSClick(radiobtn_NameAndDOB, "Name and DOB Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_DateOfBirth, dob, "Date Of Birth");
        GenericFunctions.type(txt_ZipCode,zip,"Zip Code");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(3000);
        GenericFunctions.click(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(3000);
    }


    public void breezeSearchWithLastNameFirstNameZip(String lastName,String firstName,String zip){
        GenericFunctions.jSClick(radiobtn_NameAndZip,"Phone Number Radio button");
        WaitHelper.sleep(3000);
        GenericFunctions.type(txt_FirstName, firstName, "First Name");
        GenericFunctions.type(txt_LastName, lastName, "Last Name");
        GenericFunctions.type(txt_ZipCode, zip, "Zip Code");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        WaitHelper.sleep(10000);
        clickSearch();
    }

    public void clickSearch() {
        GenericFunctions.jSClick(btn_BreezeSearch, "Search button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Create New Customer']")));
    }


    public void searchWithMemberNumberAndLastName(String memberNumber, String lastName) {
        GenericFunctions.jSClick(radiobtn_MemberNumber, "MemberNumber Radio button");
        WaitHelper.sleep(3000);
        Assert.assertTrue(GenericFunctions.isDisplayed(txt_MemberNumber, "Member Number text box"));
        GenericFunctions.type(txt_MemberNumber, memberNumber, "MemberNumber text box");
        GenericFunctions.click(lbl_ToStepOff, "Step Off");
        GenericFunctions.jSClick(btn_BreezeSearch, "Search button");
        WaitHelper.sleep(8000);
        if (GenericFunctions.isDisplayed(lst_SearchResult, "Search Results")) {
            log.info("Member Number exists");
            if(lastName!=""){
                GenericFunctions.jSClick(GenericFunctions.getElement(By.xpath("//a[text()='"+lastName+"']")),"lastName");
            }

            GenericFunctions.jSClick(lst_SearchResult, "Record in Search Results");
            WaitHelper.sleep(2000);
            //GenericFunctions.switchToRecentOpenedWindow();
        } else if (GenericFunctions.isDisplayed(lbl_ValidCombinations, "Valid Combinations txt")) {
            Assert.fail("Invalid Combination is entered");
        } else {
            log.info("Member Number does not exist");
        }
    }
}



