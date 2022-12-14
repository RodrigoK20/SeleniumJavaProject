package test.pages;

import com.sun.java.swing.plaf.windows.resources.windows;
import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void swichToTab(String tabTitle){
       java.util.Set<String> windows = driver.getWindowHandles();
       System.out.println("Numbers of tabs:" + windows.size());
       System.out.println("Windows handles:");
       windows.forEach(System.out::println);

       for(String window: windows){
           System.out.println("Switching to window:" + window);
           driver.switchTo().window(window);

           System.out.println("Current window title: " + driver.getTitle());

           if(tabTitle.equals(driver.getTitle())){
               break;
           }
       }

    }
}
