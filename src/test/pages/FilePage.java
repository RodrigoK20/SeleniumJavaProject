package test.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FilePage {

    private WebDriver driver;

    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");

    private By uploadFileText = By.id("uploaded-files");

    public FilePage(WebDriver driver){
        this.driver = driver;

    }
    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

/*    Provides path of file to the form then clicks Upload buttton @param
    absoultePathOfFile the complete path of the file to upload*/

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadFileText(){
        return driver.findElement(uploadFileText).getText();
    }

}
