package pageobject;

import common.Utilities;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //objects =
    private Utilities tools = new Utilities();
    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(By.cssSelector("#username"));
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(By.xpath("//fieldset//input[@value='Login']"));
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']"));
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href='Register.cshtml']"));
    }

    public WebElement getBtnForgotPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Account/ForgotPassword.cshtml']"));
    }

    public HomePage login(String username, String password) {
//Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        tools.scrollDownToBottom();
        this.getBtnLogin().click();
//Land on Hone page
        return new HomePage();
    }

    public void gotoForgotPasswordPage() {
        this.getBtnForgotPassword().click();
    }

    public void gotoRegisterPage() {
        this.getBtnRegister().click();
    }

    public String getErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }
}