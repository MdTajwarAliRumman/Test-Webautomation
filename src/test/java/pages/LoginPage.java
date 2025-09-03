package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
//jekono page er khetre page specific locator ar methods gulo likhe rakhte hobe ja oi page er jonno bnoraddo !!
   public By signup_nameField = By.xpath("//input[@placeholder='Name']");
   public By signup_email = By.xpath("//input[@data-qa='signup-email']");
   public By signup_btn = By.xpath("//button[normalize-space()='Signup']");
   public By login_email = By.xpath("//input[@data-qa='login-email']");
   public By login_pass = By.xpath("//input[@placeholder='Password']");
   public By Login_btn = By.xpath("//button[normalize-space()='Login']");
   public By error_msg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

   public void navigateToLoginPage(){
      homePage.clickOnElement(homePage.login_signup);
   }
}
