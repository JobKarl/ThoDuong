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

public class TC15_ClickBookTick_atTimeTablePage extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final BookTicketPage bookTicket = new BookTicketPage();
    private final TimeTablePage timeTable = new TimeTablePage();
    private final LoginPage loginPage = new LoginPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train " +
                "timetable\" page");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        //click Timetable
        homePage.gotoTimeTable();
        //click book ticket button
        timeTable.clickButtonTimeTable("Huế", "Sài Gòn", "Book ticket");
        //checkpoint
        actualMsg = bookTicket.getTxtDepartFrom("Huế").getText();
        expectedMsg = "Huế";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong depart from");
        actualMsg = bookTicket.getTxtArriveAt("Sài Gòn").getText();
        expectedMsg = "Sài Gòn";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong arrive at");
    }
}
