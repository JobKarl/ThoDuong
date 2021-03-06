package pageobject;

import common.InteractPage;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private InteractPage interactPage = new InteractPage();

    //element
    public WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='email']"));
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(By.id("password"));
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(By.id("confirmPassword"));
    }

    public WebElement getTxtID() {
        return Constant.WEBDRIVER.findElement(By.id("pid"));
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement getTxtMessageError() {
        return Constant.WEBDRIVER.findElement(By.className("message"));
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
        interactPage.scrollDownToBottom();
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
