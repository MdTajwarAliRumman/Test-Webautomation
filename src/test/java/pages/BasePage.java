package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    //eta ekta method ja findElement kore and by locator er maddhome
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    // locator jeta likha lagto id,text etc etar maddhome ar lekha lagbnena get element korlei pabo
    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getPageUrl(){
       return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }
}
