package TestCases;
import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass
    public void beforeMethod(){
        WebDriverManager.edgedriver().setup();
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new EdgeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterClass
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
