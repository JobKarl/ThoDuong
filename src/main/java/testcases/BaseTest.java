package testcases;

import common.FormatDate;
import common.logs.Log;
import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private final FormatDate formatTime = new FormatDate();

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws Exception {
        System.out.println("Pre-condition");
        Log.info("Tests is starting!");
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            Constant.WEBDRIVER = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            Constant.WEBDRIVER = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            WebDriverManager.edgedriver().setup();
            Constant.WEBDRIVER = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is invalid");
        }
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        System.out.println("Post-condition");
        Log.info("Tests are ending!");
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) Constant.WEBDRIVER;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("D://Job/SATT/image/failure handler/" + result.getName() + "-" + formatTime.formatTime() + ".png"));
        }
        Constant.WEBDRIVER.quit();
    }

    public WebDriver getDriver() {
        return Constant.WEBDRIVER;
    }
}
