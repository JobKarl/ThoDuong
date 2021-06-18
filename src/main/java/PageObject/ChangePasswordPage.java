package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import constant.Constant;
public class ChangePasswordPage extends GeneralPage{

    //elements
    public WebElement getTxtCurrentPassword = Constant.WEBDRIVER.findElement(By.id("currentPassword"));
    public WebElement getTxtNewPassword = Constant.WEBDRIVER.findElement(By.id("newPassword"));
    public WebElement getTxtConfirmPassword = Constant.WEBDRIVER.findElement(By.id("confirmPassword"));
    public WebElement getBtnChangePassword = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    public WebElement getSuccessMessage = Constant.WEBDRIVER.findElement(By.className("message success"));
    //methods
    public String changePassword(String currentPassword, String newPassword, String confirmPassword){
        getTxtCurrentPassword.sendKeys(currentPassword);
        getTxtNewPassword.sendKeys(newPassword);
        getTxtConfirmPassword.sendKeys(confirmPassword);
        getBtnChangePassword.click();
        return getSuccessMessage.getText();
    }

}
