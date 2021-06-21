package testcases;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;

public class TC06_AdditionalPage_WhenLogin extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        //check page tab is displayed
        Assert.assertTrue(homePage.getTabMyTicket().isDisplayed(), "MyTicket tab is not present.");
        Assert.assertTrue(homePage.getTabLogout().isDisplayed(), "Logout tab is not present.");
        Assert.assertTrue(homePage.getTabChangePassWord().isDisplayed(), "ChangePassword tab is not present.");
        //check My ticket page opens
        homePage.gotoMyTicketPage();
        actualMsg = Constant.WEBDRIVER.getTitle();
        expectedMsg = "Safe Railway - My Ticket";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Myticket page is opended");
        // check ChangePassword page opens
        homePage.gotoChangePasswordPage();
        actualMsg = Constant.WEBDRIVER.getTitle();
        expectedMsg = "Safe Railway - Change Password";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Changepassword page is opended.");
    }
}
