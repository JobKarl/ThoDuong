package TestCases;

import Constant.Constant;
import PageObject.HomePage;
import PageObject.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
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
    public void TC03() {
        System.out.println("TC04 - User can register new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage register = homePage.gotoRegisterPage();
        String actualMsg = register.registerAcc(Constant.registerUsername,Constant.registerPassword,Constant.registerPassword,Constant.registerID).getSuccessMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg,expectedMsg,"User registered failed!");

    }
}
