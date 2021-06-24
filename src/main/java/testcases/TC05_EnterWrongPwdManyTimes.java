package testcases;

import common.Mathematics;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC05_EnterWrongPwdManyTimes extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private Mathematics math = new Mathematics();

    @Test
    public void TC05(Method method) {
        startTest(method.getName(), "TC05 - System shows message when user enters wrong password several times.");
        System.out.println("TC05 - System shows message when user enters wrong password several times.");
        homePage.open();
        homePage.gotoLoginPage();
        for (int i = 1; i < 5; i++) {
            loginPage.login(System.getenv("username"), math.getRandomNumber(10000000, 1000000000));
            loginPage.getTxtUsername().clear();
        }
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to " +
                "login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
    }
}
