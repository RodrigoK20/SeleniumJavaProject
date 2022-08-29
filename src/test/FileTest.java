package test;

import org.testng.annotations.Test;
import test.pages.FilePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileTest extends BaseTest{

    @Test
    public void testFileUpload(){
        FilePage filePage = homePage.clickFileUpload();
        filePage.uploadFile("C:\\Users\\Rodrigo.Viscarra\\Desktop\\javaSelenium\\src\\driver\\chromedriver.exe");
        assertEquals(filePage.getUploadFileText(), "chromedriver.exe","error");
    }
}
