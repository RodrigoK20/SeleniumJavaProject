package test.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage {

    private WebDriver driver;
    private By alertButton = By.cssSelector("#content > div > ul > li:nth-child(1) > button");
    private By alertPrompt = By.cssSelector("#content > div > ul > li:nth-child(3) > button");

    private By resultTextDisplayed = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAlertButton(){
       driver.findElement(alertButton).click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String getTextResult(String nameAlert){
        String value = driver.findElement(resultTextDisplayed).getText();

        if(value == nameAlert)
        {
            return value;
        }

       return value;
    }

    public void clickAlertPrompt(){
        driver.findElement(alertPrompt).click();
    }

    public String getTextPrompt(){
       return driver.switchTo().alert().getText();
    }
    public void sendPromptValue(String text){
       driver.switchTo().alert().sendKeys(text);
       driver.switchTo().alert().accept();
    }


}
