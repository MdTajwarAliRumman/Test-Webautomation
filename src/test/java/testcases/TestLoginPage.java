package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadLoginTestPage() {
        loginPage.navigateToLoginPage();
    }

    @Test
    public void testLoginWithValidCreds() {

        loginPage.writeOnElement(loginPage.login_email, "nogases958@lanipe.com");
        loginPage.writeOnElement(loginPage.login_pass, "12345678");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertTrue(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertFalse(loginPage.is_Element_Visible(loginPage.login_email));
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.writeOnElement(loginPage.login_email, "nogases958@lanipe.com");
        loginPage.writeOnElement(loginPage.login_pass, "123456");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_Element_Visible(loginPage.login_email));
    }

    @Test
    public void loginWithInvalidCreds() {
        loginPage.writeOnElement(loginPage.login_email, "nogases958lanipe.com");
        loginPage.writeOnElement(loginPage.login_pass, "123456");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_Element_Visible(loginPage.login_email));
    }

    @Test
    public void testLoginWithValidPassAndInvalidMail() {
        loginPage.writeOnElement(loginPage.login_email, "nogases958@la.com");
        loginPage.writeOnElement(loginPage.login_pass, "12345678");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_Element_Visible(loginPage.login_email));
    }

    @Test
    public void testLoginWithoutCreds() {
        loginPage.writeOnElement(loginPage.login_email, "");
        loginPage.writeOnElement(loginPage.login_pass, "");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.login_email).getAttribute("validationMessage"), "Please fill in this field.");
        Assert.assertFalse(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_Element_Visible(loginPage.login_email));
    }

    @Test
    public void testLoginWithoutPassAndwithEmail() {
        loginPage.writeOnElement(loginPage.login_email, "nogases958@lanipe.com");
        loginPage.writeOnElement(loginPage.login_pass, "");
        loginPage.clickOnElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.login_pass).getAttribute("validationMessage"), "Please fill in this field.");
        Assert.assertFalse(homePage.is_Element_Visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_Element_Visible(loginPage.login_email));
    }
}
