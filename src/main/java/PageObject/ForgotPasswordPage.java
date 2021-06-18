package PageObject;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //element
    public WebElement getTxtEmailAddress = Constant.WEBDRIVER.findElement(By.cssSelector("#email"));
    public WebElement getBtnSendInstruction = Constant.WEBDRIVER.findElement(By.xpath("//p/input[@type='submit']"));
    public WebElement getValidateMessage = Constant.WEBDRIVER.findElement(By.className("validation-error"));

    //methods
    public void sendInstruction (String emailAddress){
        getTxtEmailAddress.sendKeys(emailAddress);
        getBtnSendInstruction.click();
    }
    public String validateMessage(){return getValidateMessage.getText();}
}
