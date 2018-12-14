package gerard.testcases;
import gerard.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class AddCustomerTest extends TestBase {
    @Test(dataProvider="getData")
    public void addCustomer(String postCode, String lastName, String firstName){
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();

    }

    @DataProvider(name="getData")
    public Object[][] getData() {

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        Hashtable<String,String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

            table = new Hashtable<String,String>();

            for (int colNum = 0; colNum < cols; colNum++) {


                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                //data[rowNum - 2][colNum] = table.values().toArray(new String[colNum])[colNum];


            }
            String[] a = table.values().toArray(new String[cols-1]);
            for (int i = 0; i< a.length; i++){
                data[rowNum-2][i] = a[i];
            }

        }

        return data;

    }


}
