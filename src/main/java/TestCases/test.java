package TestCases;

import PageObject.HomePage;
import PageObject.LoginPage;
import constant.Constant;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends BaseTest{
    HomePage homePage = new HomePage();
    private String actualMsg;
    private String expectedMsg;
    LoginPage loginPage = new LoginPage();
    @Test(priority = 0)
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        homePage.logOut();
    }
}
