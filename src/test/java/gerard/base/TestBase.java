package gerard.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
            fis = new FileInputStream("C:\\Users\\grecinto\\Desktop\\testLearning\\src\\test\\java\\gerard\\resources\\properties\\Config.properties");
            try{
                config.load(fis);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



        try {
            fis = new FileInputStream("C:\\Users\\grecinto\\Desktop\\testLearning\\src\\test\\java\\gerard\\resources\\properties\\OR.properties");
            try {
                OR.load(fis);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }


    @AfterSuite
    public void tearDown(){

    }


}
