package testcases;

import common.FormatDate;
import common.InteractPage;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BookTicketPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.TimeTablePage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC15_ClickBookTick_atTimeTablePage extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final BookTicketPage bookTicket = new BookTicketPage();
    private final TimeTablePage timeTable = new TimeTablePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC15(Method method) {
        startTest(method.getName(), "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        //click Timetable
        homePage.gotoTimeTable();
        //click book ticket button
        timeTable.clickButtonTimeTable("Huế", "Sài Gòn", "Book ticket");
        //checkpoint
        String actualMsg = bookTicket.getTxtDepartFrom("Huế").getText();
        String expectedMsg = "Huế";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong depart from");
        actualMsg = bookTicket.getTxtArriveAt("Sài Gòn").getText();
        expectedMsg = "Sài Gòn";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong arrive at");
    }
}
