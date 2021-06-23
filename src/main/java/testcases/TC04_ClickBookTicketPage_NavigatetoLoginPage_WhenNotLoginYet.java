package testcases;

import common.Mathematics;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;

public class TC04_ClickBookTicketPage_NavigatetoLoginPage_WhenNotLoginYet extends BaseTest {
    private final HomePage homePage = new HomePage();

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        homePage.open();
        homePage.gotoBookTicketPage();
        String actualMsg = Constant.WEBDRIVER.getTitle();
        String expectedMsg = "Safe Railway - Login";
        Assert.assertEquals(actualMsg, expectedMsg.trim(), "Login page is not displayed.");
    }
}
