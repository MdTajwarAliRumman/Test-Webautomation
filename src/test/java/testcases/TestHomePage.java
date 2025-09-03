package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {
    //Homepage er eleement gulo access korte home page er object create kora lagbe
    HomePage homePage = new HomePage();

    @Test
    public void testHomePageUrl() {
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageUrl(), homePage.url);
    }

    @Test
    public void testHomePageTitle() {
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }
}
