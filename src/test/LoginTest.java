package test;

import org.testng.annotations.Test;
import test.pages.LoginPage;
import test.pages.SecureAreaPage;


import static org.testng.AssertJUnit.assertTrue;

public class LoginTest  extends BaseTest{

    @Test(priority = 0)
    public void testSuccessfullLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue("Alert text is correct", secureAreaPage.getAlertText().contains("You logged into a secure area!"));

    }
}
