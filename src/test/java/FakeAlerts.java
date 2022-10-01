import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class FakeAlerts  extends Base {


    @Test
    public void fakeAlerts(){


        try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            WebElement fakeAlertButton = driver.findElement(By.id("fakealert"));
            fakeAlertButton.click();

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();

            for(String window : windowHandles){
                if(!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println(driver.findElement(By.id("dialog-text")).getText());
            driver.findElement(By.id("dialog-ok")).click();


            driver.switchTo().window(parentWindow);
            WebElement modalButton = driver.findElement(By.id("modaldialog"));
            modalButton.click();
            Set<String> windowHandles2 = driver.getWindowHandles();
            for(String window : windowHandles2){
                if(!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println(driver.findElement(By.id("dialog-text")).getText());
            driver.findElement(By.id("dialog-ok")).click();

            System.out.println("Finish!");

        }finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }

}
