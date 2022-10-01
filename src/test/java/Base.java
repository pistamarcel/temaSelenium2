import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class Base {
    protected static RemoteWebDriver driver = null;

    @BeforeMethod()
    public void beforeMethodWithLogin() throws MalformedURLException {
        driver = BrowserManager.getRemoteChromeDriver();

    }



    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }


}



