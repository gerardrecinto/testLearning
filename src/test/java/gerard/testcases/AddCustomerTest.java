package gerard.testcases;
import com.relevantcodes.extentreports.LogStatus;
import gerard.base.TestBase;
import gerard.resources.utilities.TestUtil;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class AddCustomerTest extends TestBase {
    @Test(dataProviderClass = TestUtil.class, dataProvider="dp")
    public void addCustomerTest(Hashtable<String,String> data){

        if(!data.get("runmode").equals("Y")){

            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        }
        click("addCustBtn_CSS");
        type("firstname_CSS",data.get("firstname"));
        type("lastname_CSS", data.get("lastname"));
        type("postcode_CSS", data.get("postcode"));
        try {
            Thread.sleep(500);
        } catch(Throwable t){}
        test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.screenshotName));

        click("addBtn_CSS");
        try {
            Thread.sleep(500);
        } catch(Throwable t){}
        test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.screenshotName));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept();
       /* Alert alert = driver.switchTo().alert();
        if(alert != null){
            alert.accept();
        }*/


    }




}
