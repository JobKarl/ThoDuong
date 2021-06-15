package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    //locator
    private final By liCreateNewAcc = By.xpath("//div/a[@href='/Account/Register.cshtml']");
    //element
    protected WebElement getLiCreateNewAcc(){
        return Constant.WEBDRIVER.findElement(liCreateNewAcc);
    }
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
    public RegisterPage clickCreateAnAcc(){
        this.getLiCreateNewAcc().click();
        return new RegisterPage();
    }
}
