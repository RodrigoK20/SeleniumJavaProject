package test;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import test.pages.HomePage;
import test.pages.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rodrigo.Viscarra\\Desktop\\javaSelenium\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();
        goHome();
        homePage = new HomePage(driver);
    }

    //Execute multiple methods
    @BeforeMethod
    public void goHome(){
        //Launch the site
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

    //Execute this method when the test are executed
//    @AfterMethod
//    public void takeScreenshot(){
//        TakesScreenshot camera = (TakesScreenshot) driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//
//        try{
//            Files.move(screenshot, new File("src/screenshots/test.png"));
//        }
//
//        catch (IOException e){
//            e.printStackTrace();
//        }
//
//        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
//    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus()){

            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try
            {
                Files.move(screenshot, new File("src/screenshots/" + result.getName() + ".png"));
            }

            catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
