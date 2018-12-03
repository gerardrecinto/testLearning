package gerard.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    @BeforeSuite
    public void setUp(){
        FileInputStream fis;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\properties\\Config.properties");
            try{
                config.load(fis);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\properties\\OR.properties");
            try {
                OR.load(fis);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        //TODO later
        if (config.getProperty("browser").equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\gerard\\resources\\executables\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (config.getProperty(("browser")).equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "\\src\\test\\java\\gerard\\resources\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("ie")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\java\\gerard\\resources\\executables\\IEDriverServer.exe");
        }


        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }


}
