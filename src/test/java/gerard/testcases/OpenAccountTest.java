package gerard.testcases;

import com.relevantcodes.extentreports.LogStatus;
import gerard.base.TestBase;
import gerard.resources.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class OpenAccountTest extends TestBase {
    @Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
    public void openAccountTest(Hashtable<String,String> data) throws InterruptedException {

        if(!data.get("runmode").equals("Y")){

            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        }

        click("openaccount_CSS");
        select("customer_CSS", data.get("customer"));
        select("currency_CSS", data.get("currency"));
        click("process_CSS");
        try {
            Thread.sleep(500);
        } catch(Throwable t){}
        test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.screenshotName));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

}
