package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;

    private By contentBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public String doubleClickBox(String value){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contentBox)).perform();
        String textAlert = getAlertText();

        if(textAlert == value){
            confirmAlertJs();
            return textAlert;
        }

        return textAlert;

    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void confirmAlertJs(){
        driver.switchTo().alert().accept();
    }


}
