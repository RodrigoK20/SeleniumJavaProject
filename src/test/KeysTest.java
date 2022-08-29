package test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import test.pages.KeyPressesPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class KeysTest extends BaseTest{

    @Test(priority = 0)
    public void testBackSpace(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE!");
    }

    @Test
    public void testPi(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
    }


}
