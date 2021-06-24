package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ChangePasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC09_ChangePwd extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePwd = new ChangePasswordPage();

    @Test
    public void TC09(Method method) {
        startTest(method.getName(), "TC09 - User can change password");
        System.out.println("TC09 - User can change password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        homePage.gotoChangePasswordPage();
        String actualMsg = changePwd.changePassword(System.getenv("password"), System.getenv("newpassword"), System.getenv(
                "newpassword"));
        String expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to change new password or wrong message");
    }
}
