package testcases;

import pageobject.HomePage;
import pageobject.LoginPage;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_BlankUsername extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox\n");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login("", System.getenv("password"));
        actualMsg = loginPage.getErrorMsg();
        expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
    }
}
