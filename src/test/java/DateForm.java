import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

public class DateForm {
    public static void main(String[] args) throws InterruptedException{
        fillFormDetails();
    }

    public static void fillFormDetails() throws InterruptedException {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromeDriver();
   qq         driver.get("https://testpages.herokuapp.com/styled/html5-form-test.html");

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].value = arguments[1]",
                    driver.findElement(By.id("date-picker")), "14-07-2022");
            Thread.sleep(3000);
            WebElement newdate =  driver.findElement(By.id("date-picker"));


            WebElement date = driver.findElement(By.cssSelector("label[for=\"date-picker\"]"));
            System.out.println(date.getText());




//



        } catch (Exception | Error e) {
            System.out.println("Am intrat in catch ");;
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }


}
