package gerard.listeners;

import com.relevantcodes.extentreports.LogStatus;
import gerard.base.TestBase;
import gerard.resources.utilities.MonitoringMail;
import gerard.resources.utilities.TestConfig;
import gerard.resources.utilities.TestUtil;
import org.testng.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

    public void onTestStart(ITestResult iTestResult) {
        test = rep.startTest(iTestResult.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("Starting screenshot");
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try{
            TestUtil.captureScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
        Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase()+" PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailure(ITestResult iTestResult) {
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase()+" Failed with exception : "+iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

    }

    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP, iTestResult.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {
        MonitoringMail mail = new MonitoringMail();
        String messageBody = null;
        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_20Report/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
