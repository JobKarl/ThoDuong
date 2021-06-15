package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //element contact
    protected WebElement getEmailLink = Constant.WEBDRIVER.findElement(By.xpath("//p/a"));

    //method getEmailLink

    public void gotoEmailLink() {
        getEmailLink.click();
    }
}
