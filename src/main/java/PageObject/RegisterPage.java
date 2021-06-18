package PageObject;
import constant.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    private Utilities tools = new Utilities();
    //element
    public WebElement getTxtUserName = Constant.WEBDRIVER.findElement(By.cssSelector("#email"));
    public WebElement getTxtPassword = Constant.WEBDRIVER.findElement(By.cssSelector("#password"));
    public WebElement getTxtConfirmPassword = Constant.WEBDRIVER.findElement(By.cssSelector("#confirmPassword"));
    public WebElement getTxtID = Constant.WEBDRIVER.findElement(By.cssSelector("#pid"));
    public WebElement getBtnRegister = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    public WebElement getTxtMessageError = Constant.WEBDRIVER.findElement(By.cssSelector(".message error"));
    public WebElement getTxtSuccessMessage = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p"));
    public WebElement getPidValidationMessages = Constant.WEBDRIVER.findElement(By.xpath("//label[@for='pid" +
            "'][@class='validation-error']"));
    public WebElement getPwdValidationMessage = Constant.WEBDRIVER.findElement(By.xpath("//label[@for='password" +
            "'][@class='validation-error']"));
    // methods
    public void registerAcc(String username, String password, String confirmPassword, String id){
        getTxtUserName.sendKeys(username);
        getTxtPassword.sendKeys(password);
        getTxtConfirmPassword.sendKeys(confirmPassword);
        getTxtID.sendKeys(id);
        tools.scrollDownToBottom();
        getBtnRegister.click();
    }
    public String successMessage(){return getTxtSuccessMessage.getText();}
    public String pidValidationMessage(){return getPidValidationMessages.getText();}
    public String pwdValidationMessage(){return getPidValidationMessages.getText();}
    public String messageError(){return getTxtMessageError.getText();}
}
