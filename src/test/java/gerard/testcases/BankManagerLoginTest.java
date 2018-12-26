package gerard.testcases;

import com.relevantcodes.extentreports.LogStatus;
import gerard.base.TestBase;
import gerard.resources.utilities.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws InterruptedException {
       try {
           log.debug("Inside Login Test");
           Thread.sleep(3000);

           click("bmlBtn_CSS");

           Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Login not successful");
           log.debug("login successfful");
           // Assert.fail("Login not successful");
           // Reporter.log("login successful");
           // Reporter.log("<a target=\"_blank\" href=\"abcd.jpg\">Screenshot</a>");
           //Reporter.log("<br>");
       } catch (Throwable t){

       }
    }
}
