package test;

import org.testng.annotations.Test;
import test.pages.InfiniteScrollPage;
import test.pages.LargeAndDeepDomPage;

public class JavaScriptTest extends BaseTest{

    @Test
    public void testScrollToTable(){
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){

        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(50);
    }

}
