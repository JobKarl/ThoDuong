package PageObject;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //element
    public WebElement getTxtEmailAddress() {
        return Constant.WEBDRIVER.findElement(By.cssSelector("#email"));
    }

    public WebElement getBtnSendInstruction() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p/input[@type='submit']"));
    }

    public WebElement getValidateMessage() {
        return Constant.WEBDRIVER.findElement(By.className("validation-error"));
    }

    //methods
    public void sendInstruction(String emailAddress) {
        this.getTxtEmailAddress().sendKeys(emailAddress);
        this.getBtnSendInstruction().click();
    }

    public String validateMessage() {
        return this.getValidateMessage().getText();
    }
}
