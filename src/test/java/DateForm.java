import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

public class DateForm {
    public static void main(String[] args) {
        fillFormDetails();
    }

    public static void fillFormDetails()  {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/html5-form-test.html");


            WebElement reset = driver.findElement(By.cssSelector("input[type=\"reset\"]"));
            WebElement color= driver.findElement(By.id("colour-picker"));
            WebElement form = driver.findElement(By.id("HTMLFormElements"));
            WebElement newdate =  driver.findElement(By.id("date-picker"));
            WebElement date = driver.findElement(By.cssSelector("label[for=\"date-picker\"]"));
            color.sendKeys("#6cab0d");
            WebElement newTimeDate =  driver.findElement(By.id("date-time-picker"));
            WebElement email =  driver.findElement(By.id("email-field"));
            WebElement newMonth =  driver.findElement(By.id("month-field"));
            WebElement newNumber =  driver.findElement(By.id("number-field"));

            for(int i = 0; i <= 1; i++) {
                newdate.sendKeys("07/14/2022");
                System.out.println(date.getText());
                newTimeDate.sendKeys("07-14-2022");
                newTimeDate.sendKeys(Keys.TAB);
                newTimeDate.sendKeys("1400PM");
                email.sendKeys("marcel.pista966@e-uvt.ro");
                newMonth.sendKeys("07");
                newMonth.sendKeys(Keys.TAB);
                newMonth.sendKeys("2022");
                newNumber.clear();
                newNumber.sendKeys("52");
                if (i == 0) {
                    form.submit();
                    WebElement backToFormButton = driver.findElement(By.id("back_to_form"));
                    backToFormButton.click();
                } else {
                    reset.click();
                    System.out.println("Am resetat formularul cu calendar");
                }

            }

        } catch (Exception | Error e) {
            System.out.println("Am intrat in catch ");
            if (driver != null) {
                File file = driver.getScreenshotAs(OutputType.FILE);
                File destfile = new File("C:\\Users\\marce\\IdeaProjects\\DateFormError.png");
                try {
                    FileUtils.copyFile(file, destfile);
                } catch (IOException ex) {
                    System.out.println("Screenshot copy failed.");
                }

            } else {
                System.out.println("Driver instance failed to create succesfully!");
            }
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }


}
