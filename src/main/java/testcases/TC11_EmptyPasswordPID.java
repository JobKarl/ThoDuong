package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.RegisterPage;

public class TC11_EmptyPasswordPID extends BaseTest{
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerAccount = new RegisterPage();
    private String expectedMsg;
    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        homePage.open();
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, "", "", "");
        //Message above forms
        String actualMsg = registerAccount.messageError();
        expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "User failed to receive error message or different message");
        //Message at password fields
        actualMsg = registerAccount.pwdValidationMessage();
        expectedMsg = "Invalid password length.";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "User failed to receive error message or different message");
        //Message at PID fields
        actualMsg = registerAccount.pidValidationMessage();
        expectedMsg = "Invalid ID length.";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "User failed to receive error message or different message");
    }
}
