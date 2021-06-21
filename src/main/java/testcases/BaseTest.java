package testcases;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeMethod
//    @Parameters("browser")
    public void beforeMethod(){
        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
//        if (browser.equalsIgnoreCase("firefox")) {
//            //create firefox instance
//            WebDriverManager.firefoxdriver().setup();
//            Constant.WEBDRIVER = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("chrome")) {
//            //set path to chromedriver.exe
//            WebDriverManager.chromedriver().setup();
//            Constant.WEBDRIVER = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("Edge")) {
//            //set path to Edge.exe
//            WebDriverManager.edgedriver().setup();
//            Constant.WEBDRIVER = new EdgeDriver();
//        } else {
//            //If no browser passed throw exception
//            throw new Exception("Browser is invalid");
//        }
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
