package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;

public class TC07_CreateAccount extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerAccount = new RegisterPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");
        homePage.open();
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, Constant.registerPassword, Constant.registerPassword,
                Constant.registerID);
        actualMsg = registerAccount.successMessage();
        expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "user failed to register new account");
    }
}
