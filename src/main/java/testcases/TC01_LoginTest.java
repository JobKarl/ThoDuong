package testcases;

import pageobject.HomePage;
import pageobject.LoginPage;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;


public class TC01_LoginTest extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC01(Method method) {
        startTest(method.getName(), "TC01 - User can log into Railway with valid username and password");
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        String actualMsg = loginPage.login(System.getenv("username"), System.getenv("password")).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed");
    }
}
