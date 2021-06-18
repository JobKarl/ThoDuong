package PageObject;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    //Locators
    private final By txtUserName = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUserName);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }
    public WebElement getBtnRegister = Constant.WEBDRIVER.findElement(By.xpath("//a[@href='Register.cshtml']"));
    public WebElement getBtnForgotPassword = Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Account" +
            "/ForgotPassword.cshtml']"));

    public HomePage login(String username, String password) {
//Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
//Land on Hone page
        return new HomePage();
    }
    public void gotoForgotPasswordPage(){
        getBtnForgotPassword.click();
    }
    public void gotoRegisterPage(){
        getBtnRegister.click();
    }
    public String getErrorMsg(){
        return getLblLoginErrorMsg().getText();
    }
}