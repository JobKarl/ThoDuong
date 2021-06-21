package testcases;

import pageobject.HomePage;
import pageobject.LoginPage;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginTest extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
