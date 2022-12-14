package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    //Scrolls until paragraph with index specified is in view
    //@param index 1-based
    public void scrollToParagraph(int index){

        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        while(getNumberOfParagraphsPresent() < index){
                jsExecutor.executeScript(script);
        }

    }

    public int getNumberOfParagraphsPresent(){
       return driver.findElements(textBlocks).size();
       //List<WebElement> allItems = driver.findElements(textBlocks);
        // System.out.println(allItems);

    }

}
