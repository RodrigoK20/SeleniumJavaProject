package test;

import org.testng.annotations.Test;
import test.pages.AlertsPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AlertsTest extends BaseTest{

    @Test(priority = 0)
    public void testEnterAlertsScreen(){

        try
        {
            AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
            alertsPage.clickAlertButton();
            Thread.sleep(3000);
            alertsPage.acceptAlert();
            String result = alertsPage.getTextResult("You successfully clicked an alert");
            assertEquals(result, "You successfully clicked an alert");
        }

        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(priority = 1)
    public void testAlertPrompt(){

        try {
           AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
           alertsPage.clickAlertPrompt();
           assertEquals(alertsPage.getTextPrompt(), "I am a JS prompt");
           Thread.sleep(3000);
           alertsPage.sendPromptValue("150");
           Thread.sleep(3000);
           String result = alertsPage.getTextResult("You entered: 150");
           assertEquals(result, "You entered: 150");
        }

        catch(InterruptedException e){
            throw  new RuntimeException(e);

        }
    }
}
