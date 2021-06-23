package pageobject;

import common.InteractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import constant.Constant;

public class ChangePasswordPage extends GeneralPage {
    //Objects.
    private final InteractPage interactPage = new InteractPage();

    //elements
    public WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(By.id("currentPassword"));
    }

    public WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(By.id("newPassword"));
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(By.id("confirmPassword"));
    }

    public WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement getSuccessMessage() {
        return Constant.WEBDRIVER.findElement(By.className("success"));
    }

    //methods
    public String changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        interactPage.scrollDownToBottom();
        this.getBtnChangePassword().click();
        return this.getSuccessMessage().getText();
    }

}
