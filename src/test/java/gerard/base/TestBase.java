package gerard.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    /*
     WebDriver
     Properties
     Logs
     ExtentReports
     DB
     Excel
     Mail
     */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    @BeforeSuite
    public void setUp(){
        if(driver==null) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\properties\\Config.properties");
                try {
                    config.load(fis);
                    log.debug("Config loaded!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\properties\\OR.properties");
                try {
                    OR.load(fis);
                    log.debug("OR loaded!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //TODO later
            if (config.getProperty("browser").equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\gerard\\resources\\executables\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (config.getProperty(("browser")).equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equals("ie")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\executables\\IEDriverServer.exe");
            }

        }
        driver.get(config.getProperty("testsiteurl"));
        log.debug("Navigated to " + config.getProperty("testsiteurl"));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    @AfterSuite
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }


}
