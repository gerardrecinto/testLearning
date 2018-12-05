package gerard.testcases;
import org.testng.annotations.Test;
public class AddCustomerTest  {
    @Test(dataProvider="getData")
    public void addCustomer(String firstName, String lastName, String postCode){

    }

    public Object[][] getData(){

    }

}
