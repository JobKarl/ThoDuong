package PageObject;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {
    //element contact
    public WebElement getEmailLink() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p/a"));
    }

    //method getEmailLink

    public void gotoEmailLink() {
        this.getEmailLink().click();
    }
}
