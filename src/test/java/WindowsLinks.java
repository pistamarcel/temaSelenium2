import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowsLinks  extends Base{

    @Test
    public    void firstTwoPages()  {

        try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/windows-test.html");


            List <WebElement> links = driver.findElements(By.cssSelector("div ul:first-child li a"));
            links.get(0).click();

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();

            for (String window : windowHandles) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
           List<WebElement> category = driver.findElements(By.cssSelector("#combo1 option"));

            for( int i = 0; i < category.size();  i++ ){
                category.get(i).click();
                Thread.sleep(3000);
                if(i==0){
                    List<WebElement> languages = driver.findElements(By.cssSelector("#combo2 option"));

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 1 este: " + languages.get(0).getText());

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 2 este: " + languages.get(1).getText());

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 3 este: "  + languages.get(2).getText());
                    System.out.println("-------------------------------------------");
                }else {
                    List<WebElement> languages = driver.findElements(By.cssSelector("#combo2 option"));

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 1 este: " + languages.get(0).getText());

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 3 este: " + languages.get(1).getText());

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 3 este: " + languages.get(2).getText());

                    System.out.println("Pentru categoria "+category.get(i).getText()+" optiunea numarul 4 este: " + languages.get(3).getText());
                    System.out.println("-------------------------------------------");
                }

            }
            driver.close();
            driver.switchTo().window(parentWindow);

            links.get(1).click();
            Set<String> windowHandles2 = driver.getWindowHandles();
            for(String window : windowHandles2){
                if(!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            WebElement dynamicAtributes = driver.findElement(By.id("jsattributes"));
            System.out.println(dynamicAtributes.getText());
            String nextId = dynamicAtributes.getAttribute("nextid");
            System.out.println("nextid initial: " + nextId);
            WebElement button = driver.findElement(By.xpath("//div[@class=\"centered\"]//button[@onclick=\"setNewAttrib()\"]"));


            for (int i = 0; i < 5; i++) {
                button.click();
                System.out.println("Custom attribute value: " + dynamicAtributes.getAttribute("custom-" + nextId));
                nextId = dynamicAtributes.getAttribute("nextid");
                System.out.println("nextid current: " + nextId);
            }
             driver.close();
             driver.switchTo().window(parentWindow);
             driver.close();
        }catch (Exception | Error e){
            System.out.println("Am intrat in catch");
        }finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }


    @Test
    public  void thirdLink(){

        try {
            driver = BrowserManager.getChromeDriverByManager();
            driver.get("https://testpages.herokuapp.com/styled/windows-test.html");


            List <WebElement> links = driver.findElements(By.cssSelector("div ul:first-child li a"));
            links.get(2).click();

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for(String window : windowHandles){
                if(!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            WebElement firstButton = driver.findElement(By.id("alertexamples"));
            firstButton.click();
            Alert firstAlert = driver.switchTo().alert();
            System.out.println(firstAlert.getText());
            firstAlert.accept();


            WebElement secondButton = driver.findElement(By.id("confirmexample"));
            for (int i = 0; i <= 1; i++) {
                secondButton.click();
                System.out.println("Is alert open after click on button: " + AlertTests.isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if (i == 0) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }

                System.out.println(driver.findElement(By.id("confirmexplanation")).getText());
                System.out.println("Is alert open after is has been closed: " + AlertTests.isAlertOpened(driver));
                System.out.println("--------------------------");

            }

            WebElement thirdButton = driver.findElement(By.id("promptexample"));
            for (int i = 0; i <= 1; i++) {
                thirdButton.click();
                System.out.println("Is alert open after click on button: " + AlertTests.isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if (i == 0) {

                    alert.sendKeys("Am schimbat textul");
                    alert.accept();

                } else {
                    alert.dismiss();
                }

                System.out.println(driver.findElement(By.id("promptexplanation")).getText());
                System.out.println("Is alert open after is has been closed: " + AlertTests.isAlertOpened(driver));
                System.out.println("--------------------------");
            }
    }catch (Exception | Error e){
        }finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Am inchis driverul");
            }
        }
    }





}



