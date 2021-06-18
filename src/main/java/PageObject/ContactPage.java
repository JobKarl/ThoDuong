package PageObject;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage{
    //element contact
    public WebElement getEmailLink = Constant.WEBDRIVER.findElement(By.xpath("//p/a"));

    //method getEmailLink

    public void gotoEmailLink() {
        getEmailLink.click();
    }
}
