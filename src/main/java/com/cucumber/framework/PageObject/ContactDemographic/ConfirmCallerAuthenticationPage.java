package com.cucumber.framework.PageObject.ContactDemographic;

import com.cucumber.framework.PageObject.Login.HomePage;
import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ConfirmCallerAuthenticationPage {
    private final Logger log = LoggerHelper.getLogger(HomePage.class);
    public ConfirmCallerAuthenticationPage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    @FindBy(xpath = "//span[text()='Customer Interaction']/preceding-sibling :: span")
    WebElement radiobtn_CustomerCall;

    @FindBy(xpath = "//span[text()='Field Agent Interaction']/preceding-sibling :: span")
    WebElement radiobtn_FieldAgentCall;

    @FindBy(xpath = "//span[text()='Provided Interaction']/preceding-sibling :: span")
    WebElement radiobtn_ProviderCall;

    @FindBy(xpath = "//b[text()='Confirm Authentication']")
    WebElement lbl_ConfirmAuthentication;

   /* @FindBy(xpath = "//input[@name='Check_Authenticated']")
    WebElement chk_ConfirmAuthentication;

    @FindBy(xpath = "//button[@title='Next']")
    WebElement btn_Next;*/

    @FindBy(xpath = "//span[text()='Open Activities']")
    WebElement lnk_OpenActivities;

    @FindBy(xpath = "//b[text()='Name: ']")
    WebElement lbl_Name;

    @FindBy(xpath = "//b[text()='Membership Information: ']")
    WebElement lbl_MembershipNumber;

    @FindBy(xpath = "//b[text()='Birth Date: ']")
    WebElement lbl_Birthdate;

    @FindBy(xpath = "//b[text()='Address']")
    WebElement lbl_Address;

    @FindBy(xpath = "//button[@title='Bypass']")
    WebElement btn_Bypass;

    @FindBy(xpath = "//button[@title='Authenticated']")
    WebElement btn_Authenticated;

    @FindBy(xpath = "//button[@title='Not Authenticated']")
    WebElement btn_NotAuthenticated;

    /*This function is to verify all fields in Confirm Caller Authentication Page
   * @Author: Kalpana
   */
    public void verifyAllFields(){
        WaitHelper.sleep(3000);
            SoftAssert sa=new SoftAssert();
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_CustomerCall,"Customer Call"));
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_FieldAgentCall,"Field Agent Call"));
        sa.assertTrue(GenericFunctions.isDisplayed(radiobtn_ProviderCall,"Provider Call"));
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_ConfirmAuthentication,"Confirm Authentication Label"));
        //sa.assertTrue(GenericFunctions.isDisplayed(chk_ConfirmAuthentication,"Confirm Authentication check box"));
        //sa.assertTrue(GenericFunctions.isDisplayed(btn_Next,"Next"));
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_Name,"Name"));
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_MembershipNumber,"MembershipNumber"));
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_Birthdate,"Birthdate"));
        sa.assertTrue(GenericFunctions.isDisplayed(lbl_Address,"Address"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_Bypass,"Bypass button"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_Authenticated,"Authenticated"));
        sa.assertTrue(GenericFunctions.isDisplayed(btn_NotAuthenticated,"Not Authenticated"));
        sa.assertAll();
    }

    /*This function is to select Caller type
   * @Author: Kalpana
   */
    public void selectCallerType(String callerType){
        WaitHelper.sleep(3000);
        if(callerType.equalsIgnoreCase("Provider Call")){
            log.info("The caller type is Provider Call");
            GenericFunctions.jSClick(radiobtn_ProviderCall,"Provider Call ");
        }
        else if(callerType.equalsIgnoreCase("Field Agent Call")){
            log.info("The caller type is Field Agent Call");
            GenericFunctions.jSClick(radiobtn_FieldAgentCall,"Field Agent Call ");
        }
        else{
            log.info("The caller type is Customer Call");
            GenericFunctions.jSClick(radiobtn_CustomerCall,"Customer Call ");
        }

    }

    /*This function is to confirm the Authentication
   * @Author: Kalpana
   */
    public void confirmAuthentication(String authentication){
        if(authentication=="Yes") {
            GenericFunctions.jSClick(btn_Authenticated,"Authenticated button");
            WaitHelper.sleep(2000);
        }
        else if(authentication =="No"){
            GenericFunctions.jSClick(btn_NotAuthenticated, "Next button");
            WaitHelper.sleep(2000);
        }
        else{
            GenericFunctions.jSClick(btn_Bypass,"Bypass");
            WaitHelper.sleep(2000);
        }
    }

    public boolean IsConfirmAuthenticationPageDisplayed(){
        WaitHelper.sleep(4000);
        return GenericFunctions.isDisplayed(btn_Authenticated,"Confirm Authentication Page");
    }

}
