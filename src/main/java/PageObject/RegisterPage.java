package PageObject;

import constant.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private Utilities tools = new Utilities();

    //element
    public WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='email']"));
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(By.className("password"));
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(By.className("confirmPassword"));
    }

    public WebElement getTxtID() {
        return Constant.WEBDRIVER.findElement(By.className("pid"));
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement getTxtMessageError() {
        return Constant.WEBDRIVER.findElement(By.className("message error"));
    }

    public WebElement getTxtSuccessMessage() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p"));
    }

    public WebElement getPidValidationMessages() {
        return Constant.WEBDRIVER.findElement(By.xpath("//label[@for='pid'][@class='validation-error']"));
    }

    public WebElement getPwdValidationMessage() {
        return Constant.WEBDRIVER.findElement(By.xpath("//label[@for='password'][@class='validation-error']"));
    }

    // methods
    public void registerAcc(String username, String password, String confirmPassword, String id) {
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        tools.scrollDownToBottom();
        this.getTxtID().sendKeys(id);
        this.getBtnRegister().click();
    }

    public String successMessage() {
        return this.getTxtSuccessMessage().getText();
    }

    public String pidValidationMessage() {
        return this.getPidValidationMessages().getText();
    }

    public String pwdValidationMessage() {
        return this.getPidValidationMessages().getText();
    }

    public String messageError() {
        return this.getTxtMessageError().getText();
    }
}
