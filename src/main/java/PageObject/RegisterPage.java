package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    //locator
    private final By _txtUserName = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtID = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@type='submit']");
    private final By _txtMessageError = By.xpath("//p[@class='message error']");
    private final By _txtSuccessMessage = By.xpath("//div[@id='content']/p");

    //element
    protected WebElement getTxtUserName(){
        return Constant.WEBDRIVER.findElement(_txtUserName);
    }
    protected WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    protected WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(_txtConfirmPassword);}
    protected WebElement getTxtID () { return Constant.WEBDRIVER.findElement(_txtID);}
    protected  WebElement getBtnRegister(){return Constant.WEBDRIVER.findElement(_btnRegister);}
    protected WebElement getTxtMessageError(){return Constant.WEBDRIVER.findElement(_txtMessageError);}
    protected WebElement getTxtSuccessMessage(){ return Constant.WEBDRIVER.findElement(_txtSuccessMessage);}
    // methods
    public RegisterPage registerAcc(String username, String password, String confirmPassword, String id){
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtID().sendKeys(id);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        //get the height of the webpage and scroll to the end
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getBtnRegister().click();
        return new RegisterPage();
    }
public String getSuccessMessage(){return this.getTxtSuccessMessage().getText();}
}
