package test;

import org.testng.annotations.Test;
import test.pages.ContextMenuPage;
import test.pages.DynamicLoadingPage;

public class NavigationTest extends BaseTest{

    @Test
    public void testNavigator(){
        ContextMenuPage contextMenuPage = homePage.clickContext();

        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");

    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().swichToTab("New Window");
    }
}
