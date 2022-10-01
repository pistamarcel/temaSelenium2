import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected ChromeDriver driver = null;

    @BeforeMethod()
    public void beforeMethodWithLogin() {
        driver = BrowserManager.getChromeDriverByManager();

    }



    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }


}



