package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private WebDriver driver;

    private By btnExample = By.xpath("//*[@id=\"content\"]/div/a[1]");

    private By startButton = By.cssSelector("#start button");

    private By loadingIndicator = By.id("loading");

    private By textResult = By.id("finish");
    public DynamicLoadingPage(WebDriver driver){
        this.driver =  driver;

    }

    public void clickExample(){
        driver.findElement(btnExample).click();
    }

    public void clickStart(){
        driver.findElement(startButton).click();

        //Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT10.345S"));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

        //Fluent wait
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText(){
        return driver.findElement(textResult).getText();
    }
}
