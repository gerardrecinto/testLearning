package rough;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestProperties{

    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        Properties OR = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/gerard/resources/properties/Config.properties");
        config.load(fis);
        fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/gerard/resources/properties/OR.properties");
        OR.load(fis);
        System.out.println(OR.getProperty("bmlBtn"));
    }

}