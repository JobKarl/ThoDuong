package TestCases;

import Constant.Constant;
import PageObject.HomePage;
import PageObject.TicketPricePage;
import PageObject.TimeTablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckPriceTableTest {
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
    public void TC05() {
        System.out.println("TC05 - User can navigate to price list by clicking on check price");
        HomePage homePage = new HomePage();
        homePage.open();
        TimeTablePage checkPrice = homePage.gotoTimeTable();
        TicketPricePage checkName = new TicketPricePage();
        checkPrice.CheckPriceSG_PT();

        System.out.println();
    }
}
