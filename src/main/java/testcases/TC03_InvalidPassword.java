package testcases;

import common.Mathematics;
import pageobject.HomePage;
import pageobject.LoginPage;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC03_InvalidPassword extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final Mathematics math = new Mathematics();

    @Test
    public void TC03(Method method) {
        startTest(method.getName(), "TC03 - User cannot log into Railway with invalid password.");
        System.out.println("TC03 - User cannot log into Railway with invalid password.");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), math.getRandomNumber(10000000, 1000000000));
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
    }
}
