package com.cucumber.framework.PageObject.UHC;

import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.GenericFunctions;
import com.cucumber.framework.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import sun.net.www.content.text.Generic;

import java.util.*;

/**
 * Created by gveenam on 6/28/2021.
 */
public class EmployerDetailsPage {
    @FindBy(xpath="//a[contains(text(),'MV')]")
    WebElement planCode;

    @FindBy(xpath="//td[text()='Eligibility']")
    WebElement eligibility;

    @FindBy(xpath="//td[text()='RDC']")
    WebElement RDC;
    @FindBy(xpath="//td[text()='Underwriting']")
    WebElement Underwriting	;
    @FindBy(xpath="//td[text()='PECE']")
    WebElement PECE;
    @FindBy(xpath="//td[text()='Tobacco']")
    WebElement tobacco;

    @FindBy(xpath="//th[@class='slds-cell-wrap']")
    List<WebElement> susidyProfileVals;

    @FindBy(xpath="//a[text()='Subsidy Profile']")
    WebElement lnkSubsidyProfile;


    public EmployerDetailsPage(){
        PageFactory.initElements(TestBase.driver,this);
    }






    public void verifyEmployerDetails(){



        HashMap<String,ArrayList<String>> employerFields= new HashMap<>();

        employerFields.put("Employer", new ArrayList(Arrays.asList("Name","Number","Branch","Account Type")));
        employerFields.put("Employer Payment Dates", new ArrayList(Arrays.asList("Payment Start Date","Payment Stop Date","Open Enrollment Start","Open Enrollment Stop","Paid thru date","Guaranteed Effective Date")));
        employerFields.put("Membership", new ArrayList(Arrays.asList("Duration","Gift","Kit Request Date","Kit Reply by Date")));


        SoftAssert sa=new SoftAssert();

        for(Map.Entry<String,ArrayList<String>> entry:employerFields.entrySet()){

            WebElement element= GenericFunctions.getElement(By.xpath("//a[text()='"+entry.getKey()+"']"));
            GenericFunctions.click(element,entry.getKey());
            WaitHelper.sleep(5000);
            ArrayList<String> fields=entry.getValue();
            for(String field:fields){
               WebElement fieldelement= GenericFunctions.getElement(By.xpath("//span[contains(text(),'"+field+"']"));
               sa.assertTrue(GenericFunctions.isDisplayed(fieldelement,field),field+"is not displayed");
            }
        }

        GenericFunctions.click(GenericFunctions.getElement(By.xpath("//a[text()='Plans']")),"Plans");
        WaitHelper.sleep(5000);

        GenericFunctions.click(planCode,"PlanCode");
        WaitHelper.sleep(2000);

        sa.assertTrue(GenericFunctions.isDisplayed(eligibility,"eligibility"));
        sa.assertTrue(GenericFunctions.isDisplayed(RDC,"RDC"));
        sa.assertTrue(GenericFunctions.isDisplayed(Underwriting,"Underwriting"));
        sa.assertTrue(GenericFunctions.isDisplayed(PECE,"PECE"));
        sa.assertTrue(GenericFunctions.isDisplayed(tobacco,"tobacco"));


        GenericFunctions.click(lnkSubsidyProfile,"SubsidyProfile");

        ArrayList<String> actValues=new ArrayList<>();

        for(WebElement element:susidyProfileVals){
            actValues.add(GenericFunctions.getElementText(element));

        }

       sa.assertTrue(actValues.containsAll(Arrays.asList("Type","Start Date","Stop Date","Amount","Subsidy Resp. Contrib",
                "Retiree Amt","Ret Resp. Contrib","Non Retiree Amt","Non Ret Resp. Contrib","Plans")));


    }
}
