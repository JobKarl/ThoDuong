package TestCases;

import Constant.Constant;
import PageObject.HomePage;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromiumdriver().setup();
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC03(){
        System.out.println("TC03 - User can log out");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
        // logOut
        homePage.logOut();
        actualMsg = homePage.getWelcomeMessage();
        expectedMsg = "Welcome guest!";
        Assert.assertEquals(actualMsg,expectedMsg, "Logout failed");
    }

}
