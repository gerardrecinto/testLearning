package gerard.testcases;

import gerard.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"Login not successful");
        Thread.sleep(3000);
    }
}
