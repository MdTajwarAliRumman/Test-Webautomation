package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    //jehetu data provide korbe tai, testNG er data provider eta
    @DataProvider(name = "invalidCredentialsSet")
    public static Object invalidUserCredentials() {

        Object[][] data = {
                {"sakinob431@dpwev.com", "123456", "Your email or password is incorrect!", ""},
                {"nogases958@lani", "123456", "Your email or password is incorrect!", ""},
                {"nogases958@lanip", "12345678", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill in this field."},
                {"sakinob431@dpwev.com", "", "", "Please fill in this field."}

        };
        return data;
    }
}
