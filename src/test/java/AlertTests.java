import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class AlertTests {
    public static void main(String[] args) {

        secondAlertTest();


    }

    public static void firstAlertTest() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromeDriver();
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

    public static void secondAlertTest() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromeDriver();
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

    public static boolean isAlertOpened(ChromeDriver driver) {

        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }

    }

}

