package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ChangePasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC10_NotSameConfirmPwd extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerAccount = new RegisterPage();

    @Test
    public void TC10(Method method) {
        startTest(method.getName(), "TC10 - User can't create account with \\\"Confirm password\\\" is not the same with \" +\n" +
                "                \"\\\"Password\\\"");
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with " +
                "\"Password\"");
        homePage.open();
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, Constant.registerPassword, Constant.notSameConfirmPassword, Constant.registerID);
        String actualMsg = registerAccount.messageError();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "User failed to receive error message or receive another " +
                "message");
    }
}
