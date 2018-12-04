package gerard.testcases;

import gerard.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Thread.sleep(3000);
    }
}
