package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ChangePasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;

public class TC09_ChangePwd extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePwd = new ChangePasswordPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoChangePasswordPage();
        actualMsg = changePwd.changePassword(Constant.registerPassword, Constant.newPassword, Constant.newPassword);
        expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to change new password or wrong message");
    }
}
