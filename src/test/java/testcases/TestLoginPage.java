package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void testLoginWithValidCreds(){
        loginPage.writeOnElement(loginPage.login_email,"nogases958@lanipe.com");
        loginPage.writeOnElement(loginPage.login_pass,"12345678");
        loginPage.clickOnElement(loginPage.Login_btn);

        Assert.assertTrue(homePage.getElement(homePage.logout_btn).isDisplayed());
        Assert.assertFalse(loginPage.getElement(loginPage.login_email).isDisplayed());    }

    @Test
    public void testSignup(){


    }
}
