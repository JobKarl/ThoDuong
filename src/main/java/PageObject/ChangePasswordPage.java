package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {


    //elements
    protected WebElement getTxtCurrentPassword = Constant.WEBDRIVER.findElement(By.id("currentPassword"));
    protected WebElement getTxtNewPassword = Constant.WEBDRIVER.findElement(By.id("newPassword"));
    protected WebElement getTxtConfirmPassword = Constant.WEBDRIVER.findElement(By.id("confirmPassword"));
    protected WebElement getBtnChangePassword = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    protected WebElement getSuccessMessage = Constant.WEBDRIVER.findElement(By.className("message success"));
    //methods
    public String changePassword(String currentPassword, String newPassword, String confirmPassword){
        getTxtCurrentPassword.sendKeys(currentPassword);
        getTxtNewPassword.sendKeys(newPassword);
        getTxtConfirmPassword.sendKeys(confirmPassword);
        getBtnChangePassword.click();
        return getSuccessMessage.getText();
    }

}
