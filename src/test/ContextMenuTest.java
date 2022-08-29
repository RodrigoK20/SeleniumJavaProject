package test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import test.pages.AlertsPage;
import test.pages.ContextMenuPage;
import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest{

    @Test
    public void testContextDoubleClick() {

    try {
       ContextMenuPage contextMenuPage = homePage.clickContext();
       String result = contextMenuPage.doubleClickBox("You selected a context menu");
       Thread.sleep(3000);
       assertEquals(result, "You selected a context menu");

    } catch (Exception e) {
        throw new RuntimeException(e);
    }


    }
}
