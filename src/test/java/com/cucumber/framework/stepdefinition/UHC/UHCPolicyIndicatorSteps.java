package com.cucumber.framework.stepdefinition.UHC;

import com.cucumber.framework.PageObject.ContactDemographic.AccountsPage;
import com.cucumber.framework.PageObject.ContactDemographic.ConfirmCallerAuthenticationPage;
import com.cucumber.framework.PageObject.ContactDemographic.CustomerPage;
import com.cucumber.framework.PageObject.Login.HomePage;
import com.cucumber.framework.PageObject.Login.LoginPage;
import com.cucumber.framework.PageObject.Login.QuickSearchPage;
import com.cucumber.framework.PageObject.UHC.EmployerDetailsPage;
import com.cucumber.framework.utility.ExcelReader;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by gveenam on 2/5/2021.
 */
public class UHCPolicyIndicatorSteps {

    LoginPage loginPage=new LoginPage();
    AccountsPage accountsPage=new AccountsPage();
    HomePage homePage=new HomePage();
    QuickSearchPage quickSearchPage=new QuickSearchPage();
    ConfirmCallerAuthenticationPage confirmAuthentication=new ConfirmCallerAuthenticationPage();
    CustomerPage customerPage=new CustomerPage();
    EmployerDetailsPage employerDetailsPage=new EmployerDetailsPage();




    @When("^navigates to the Customer Page$")
    public void navigatesToTheCustomerPage() throws Throwable {
        if(confirmAuthentication.IsConfirmAuthenticationPageDisplayed()) {
            confirmAuthentication.confirmAuthentication("Yes");
        }

    }







    @Then("^able to see the \"([^\"]*)\" Policy Indicator as Checked$")
    public void ableToSeeThePolicyIndicatorAsChecked(String plan) throws Throwable {
        if(customerPage.getIndicator(plan)==null){
      //      Assert.fail("UHC System is down");
        }
        else{
        //    Assert.assertEquals(customerPage.getIndicator(plan),"Found",plan+" Policy indicator should be Checked");
        }
    }

    @When("^the customer not have \"([^\"]*)\" Policy Coverage$")
    public void theCustomerNotHavePolicyCoverage(String plan) throws Throwable {

        homePage.navigateToQuickSearch();
        quickSearchPage.searchWithMemberNumber(ExcelReader.getCellData("IneligibleMemberNumber"));
        if(confirmAuthentication.IsConfirmAuthenticationPageDisplayed()) {
            confirmAuthentication.confirmAuthentication("Yes");
        }

    }

    @Then("^able to see the \"([^\"]*)\" Policy Indicator as Unchecked$")
    public void ableToSeeThePolicyIndicatorAsUnchecked(String plan) throws Throwable {
        if(customerPage.getIndicator(plan)==null){
            Assert.fail(" OSB System is down");
        }
        else{
         //   Assert.assertEquals(customerPage.getIndicator(plan),"No",plan+" Policy indicator should be UnChecked");
        }

    }

    @Given("^there is an Customer have \"([^\"]*)\" Policy Coverage$")
    public void thereIsAnCustomerHavePolicyCoverage(String arg0) throws Throwable {
        loginPage.loginAsAgent("GRS");


        homePage.navigateToQuickSearch();
        quickSearchPage.searchWithMemberNumberAndLastName(ExcelReader.getCellData("MemberNumber"),ExcelReader.getCellData("LastName"));
      //  quickSearchPage.clickContactInQuickSearchList(ExcelReader.getCellData("LastName"));
    }

    @And("^navigates to the Employer Details$")
    public void navigatesToTheEmployerDetails() throws Throwable {

        customerPage.navigateToEmployerDetails();

    }

    @Then("^able to see GRS Employer details$")
    public void ableToSeeGRSEmployerDetails() throws Throwable {
     employerDetailsPage.verifyEmployerDetails();
    }

    @Then("^verify Personalization Treatments tab is visible$")
    public void verifyPersonalizationTreatmentsTabIsVisible() {
    customerPage.verifyPersonalizationTreatmentsTabIsVisible();
    }
}
