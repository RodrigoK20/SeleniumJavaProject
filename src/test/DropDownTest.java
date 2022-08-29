package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.pages.DropdownPage;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DropDownTest extends BaseTest{

   @Test
    public void testSelectOption(){
       DropdownPage dropDownPage = homePage.clickDropDown();
       String option = "Option 1";
       dropDownPage.selectFromDropDown(option);
       List<String> selectedOptions = dropDownPage.getSelectedOptions();
       Assert.assertEquals(selectedOptions.size(), 1);
       Assert.assertTrue(selectedOptions.contains(option), "Option 1");
   }
}
