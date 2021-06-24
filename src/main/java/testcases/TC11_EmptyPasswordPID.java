package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.RegisterPage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC11_EmptyPasswordPID extends BaseTest{
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerAccount = new RegisterPage();

    @Test
    public void TC11(Method method) {
        startTest(method.getName(), "TC11 - User can't create account while password and PID fields are empty");
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        homePage.open();
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, "", "", "");
        //Message above forms
        String actualMsg = registerAccount.messageError();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
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
