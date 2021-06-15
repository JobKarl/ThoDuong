package TestCases;

import Constant.Constant;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GotoLoginByLinkCreateAnAcc {
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
    public void TC02(){
        System.out.println("TC02-User can navigate to register page by clicking on Create An Account at HomePage");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickCreateAnAcc();
    }
}
