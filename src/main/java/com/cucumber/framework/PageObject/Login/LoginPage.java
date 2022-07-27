package com.cucumber.framework.PageObject.Login;

import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.framework.utility.PropertyFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginPage {

    private final Logger log = LoggerHelper.getLogger(LoginPage.class);
    public static PropertyFileReader configProps = new PropertyFileReader("/src/main/resources/configfile/config.properties");


    @FindBy(xpath = "//input[@id='username']")
    WebElement txt_UserName;

    @FindBy(xpath="//input[@id='password']")
    WebElement txt_Password;

    @FindBy(xpath="//input[@id='Login']")
    WebElement btn_Login;

    @FindBy(xpath = "//button[contains(@class, 'slds-button')]")
    WebElement btn_Finish;
    @FindBy(xpath = "//span[@title='Sales']")
    WebElement lbl_Sales;

    @FindBy(linkText = "Remind Me Later")
    WebElement lnk_RemindMeLater;

    @FindBy(partialLinkText = "Register")
    WebElement lnk_DoNotRegister;

    @FindBy(xpath = "//div[contains(@class,'appName')]")
    WebElement lbl_AppName;
    public LoginPage() {

        PageFactory.initElements(TestBase.driver, this);

    }



    public void loginAsAgent(){
      /* String userName = System.getProperty("UserName");
        String password = System.getProperty("Password");



        GenericFunctions.type(txt_UserName,userName,"UserName");
        GenericFunctions.type(txt_Password,password,"Password");
        WaitHelper.sleep(4000);
        GenericFunctions.click(btn_Login,"Login");*/

        String userName=null;
        String password=null;
        System.out.println("Environment : "+System.getProperty("environment"));
        String tagName =System.getProperty("Tag");
        System.out.println("Tag Name ------"+tagName);
        if(System.getProperty("environment").equals("QA")) {
            userName = configProps.getProperty(tagName+"_UserName_QA");
            password = configProps.getProperty(tagName+"_Password_QA");
        }
        else if(System.getProperty("environment").equalsIgnoreCase("Training")) {
            userName = configProps.getProperty(tagName+"_UserName_Training");
            password = configProps.getProperty(tagName+"_Password_Training");
        }
        else if(System.getProperty("environment").equalsIgnoreCase("Prod")) {
            userName = configProps.getProperty("UserName_PROD");
            password = configProps.getProperty("Password_PROD");
        }
        else if (System.getProperty("environment").equalsIgnoreCase("ProdStage")){
            userName = configProps.getProperty(tagName+"_UserName_ProdStage");
            password = configProps.getProperty(tagName+"_Password_ProdStage");
        }
        else if(System.getProperty("environment").equalsIgnoreCase("PreQA")){
            userName = configProps.getProperty(tagName+"_UserName_PreQA");
            password = configProps.getProperty(tagName+"_Password_PreQA");
        }else if(System.getProperty("environment").equalsIgnoreCase("PQA")){
            userName = configProps.getProperty(tagName+"_UserName_PQA");
            password = configProps.getProperty(tagName+"_Password_PQA");
        }

        System.out.println("UserName -----"+userName);
        System.out.println("Password -----"+password);

        GenericFunctions.type(txt_UserName,userName,"UserName");
        GenericFunctions.type(txt_Password,password,"Password");
        WaitHelper.sleep(4000);
        GenericFunctions.click(btn_Login,"Login");

        acceptUHCLegalBanner();
    }
    public void acceptUHCLegalBanner(){
     /* if(!GenericFunctions.isDisplayed(lbl_AppName,"App Name")){*/

            WaitHelper.waitForElementClickable(btn_Finish, 100);
            WaitHelper.sleep(10000);
            //  if(GenericFunctions.isDisplayed(btn_Finish,"Finish")) {
            GenericFunctions.scrollDownVertically();
            //GenericFunctions.click(btn_Finish, "Finish");
            GenericFunctions.jSClick(btn_Finish, "Next");
            //  }
            WaitHelper.sleep(3000);
            if (GenericFunctions.isDisplayed(lnk_DoNotRegister, "Dont register")) {
                GenericFunctions.click(lnk_DoNotRegister, "Dont Register");
            }
//        TestBase.readCookie();
       // }

    }

    public void verifyLoginPageDisplayed(){
        WaitHelper.waitForElementVisible(btn_Login,40);
        WaitHelper.sleep(4000);
        Assert.assertTrue(GenericFunctions.isDisplayed(btn_Login,"Login"));

    }



    public void LoginAsAdmin() {
        String userName;
        String password;
        if(System.getProperty("environment").equals("QA")) {
            userName = configProps.getProperty("Admin_UserName_QA");
            password = configProps.getProperty("Admin_Password_QA");

            GenericFunctions.type(txt_UserName, userName, "UserName");
            GenericFunctions.type(txt_Password, password, "Password");
            WaitHelper.sleep(4000);
            GenericFunctions.click(btn_Login, "Login");
        }
        acceptUHCLegalBanner();
    }

    public static String userName;
   /* public void LoginAsSalesAgent() {

        String password;
        if(System.getProperty("environment").equals("QA")) {
            userName = configProps.getProperty("SalesAgentUserName_QA");
            password = configProps.getProperty("SalesAgentPassword_QA");
        }
        else if(System.getProperty("environment").equalsIgnoreCase("Training")) {
            userName = configProps.getProperty("TrainingSalesUserName");
            password = configProps.getProperty("TrainingSalesPassword");
        }
        else{
            userName = configProps.getProperty("SalesAgentUserName_PreQA");
            password = configProps.getProperty("SalesAgentPassword_PreQA");
        }

        GenericFunctions.type(txt_UserName,userName,"UserName");
        GenericFunctions.type(txt_Password,password,"Password");
        WaitHelper.sleep(4000);
        GenericFunctions.click(btn_Login,"Login");
    }*/

    public void loginAsService() {
        String userName;
        String password;
        if(System.getProperty("environment").equals("QA")) {
            userName = configProps.getProperty("Service_UserName_QA");
            password = configProps.getProperty("Service_Password_QA");

            GenericFunctions.type(txt_UserName, userName, "UserName");
            GenericFunctions.type(txt_Password, password, "Password");
            WaitHelper.sleep(4000);
            GenericFunctions.click(btn_Login, "Login");
        }
        acceptUHCLegalBanner();
    }

    public void loginAsFLM() {
        String userName;
        String password;
        if(System.getProperty("environment").equals("QA")) {
            userName = configProps.getProperty("FLM_UserName_QA");
            password = configProps.getProperty("FLM_Password_QA");

            GenericFunctions.type(txt_UserName, userName, "UserName");
            GenericFunctions.type(txt_Password, password, "Password");
            WaitHelper.sleep(4000);
            GenericFunctions.click(btn_Login, "Login");
        }
        acceptUHCLegalBanner();
    }

    public void loginAsAgent(String agentType){

        String userName=null;
        String password=null;
        String environment = System.getProperty("environment");
        System.out.println("Environment : "+System.getProperty("environment"));

            userName = configProps.getProperty("Regression_UserName_QA");
            password = configProps.getProperty("Regression_Password_QA");




        GenericFunctions.type(txt_UserName,userName,"UserName");
        GenericFunctions.type(txt_Password,password,"Password");
        WaitHelper.sleep(4000);
        GenericFunctions.click(btn_Login,"Login");

        acceptUHCLegalBanner();
    }

}
