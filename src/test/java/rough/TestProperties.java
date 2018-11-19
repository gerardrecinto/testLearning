package test.java.rough;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestProperties{

    public static void main(String[] args) throws IOException {
        //System.out.println(System.getProperties("user.dir"));
        Properties config = new Properties();
        Properties OR = new Properties();

        FileInputStream fis = new FileInputStream("/Users/gerardrecinto/Desktop/udemy/src/test/java/gerard/resources/properties/Config.properties");
        config.load(fis);
        fis = new FileInputStream("/Users/gerardrecinto/Desktop/udemy/src/test/java/gerard/resources/properties/Config.properties");
        OR.load(fis);
        System.out.println(OR.getProperty("bmlBtn"));
    }

}