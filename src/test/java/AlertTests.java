import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AlertTests extends Base{

    @Test
    public void firstAlertTest() {

        try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement firstButton = driver.findElement(By.id("alertexamples"));
            firstButton.click();
            Alert firstAlert = driver.switchTo().alert();
            System.out.println(firstAlert.getText());
            firstAlert.accept();
            System.out.println("Is alert open after it has been closed: " + isAlertOpened(driver));


        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }

    }
    @Test
    public void secondAlertTest() {

        try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            WebElement secondButton = driver.findElement(By.id("confirmexample"));
            for (int i = 0; i <= 1; i++) {
                secondButton.click();
                System.out.println("Is alert open after click on button: " + isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if (i == 0) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }

                System.out.println(driver.findElement(By.id("confirmexplanation")).getText());
                System.out.println("Is alert open after is has been closed: " + isAlertOpened(driver));
                System.out.println("--------------------------");

            }


        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }

        }

    }
    @Test
    public  void thirdAlertTest(){

       try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

           WebElement thirdButton = driver.findElement(By.id("promptexample"));
           for (int i = 0; i <= 1; i++) {
               thirdButton.click();
               System.out.println("Is alert open after click on button: " + isAlertOpened(driver));
               Alert alert = driver.switchTo().alert();
               if (i == 0) {

                   alert.sendKeys("Am schimbat textul");
                   alert.accept();
                   System.out.println(driver.findElement(By.id("promptreturn")).getText());

               } else {
                   alert.dismiss();
               }

               System.out.println(driver.findElement(By.id("promptexplanation")).getText());
               System.out.println("Is alert open after is has been closed: " + isAlertOpened(driver));
               System.out.println("--------------------------");

           }

       }catch(Exception | Error e){
           System.out.println("Am intrat in blocul de catch ");

       }finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }


    public static boolean isAlertOpened(RemoteWebDriver driver) {

        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }

    }

}

