import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateForm {
    public static void main(String[] args) {
        fillFormDetails();
    }

    public static void fillFormDetails()  {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/html5-form-test.html");
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//           js.executeScript("arguments[0].value = arguments[1]",
//                    driver.findElement(By.id("date-time-picker")), "2022-14-07T14:00");
//            Thread.sleep(3000);

            WebElement form = driver.findElement(By.id("HTMLFormElements"));
            WebElement newdate =  driver.findElement(By.id("date-picker"));
            newdate.sendKeys("07/14/2022");
            WebElement date = driver.findElement(By.cssSelector("label[for=\"date-picker\"]"));
            System.out.println(date.getText());

            WebElement newTimeDate =  driver.findElement(By.id("date-time-picker"));

            newTimeDate.clear();
            newTimeDate.sendKeys("07142022");
            newTimeDate.sendKeys(Keys.TAB);
            newTimeDate.sendKeys("1515PM");

            WebElement email =  driver.findElement(By.id("email-field"));
            email.sendKeys("marcel.pista966@e-uvt.ro");

            WebElement newMonth =  driver.findElement(By.id("month-field"));

            newMonth.sendKeys("07");
            newMonth.sendKeys(Keys.TAB);
            newMonth.sendKeys("2023");

            WebElement newNumber =  driver.findElement(By.id("number-field"));
            newNumber.clear();
            newNumber.sendKeys("52");
            newNumber.sendKeys(Keys.UP);

            form.submit();
        } catch (Exception | Error e) {
            System.out.println("Am intrat in catch ");
            System.out.println(e);
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }


}
