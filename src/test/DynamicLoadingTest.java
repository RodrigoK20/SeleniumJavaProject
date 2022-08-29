package test;

import org.testng.annotations.Test;
import test.pages.DynamicLoadingPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicLoadingTest extends BaseTest{

    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample();
        dynamicLoadingPage.clickStart();
        String result = dynamicLoadingPage.getLoadedText();
        assertEquals(result, "Hello World!");

    }
}
