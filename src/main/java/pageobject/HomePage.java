package pageobject;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //element
    public WebElement getLiCreateNewAcc() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div/a[@href='/Account/Register.cshtml']"));
    }

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public RegisterPage clickCreateAnAcc() {
        this.getLiCreateNewAcc().click();
        return new RegisterPage();
    }
}
