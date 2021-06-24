package testcases;

import common.FormatDate;
import constant.Constant;
import dataobject.TicketInformation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BookTicketPage;
import pageobject.HomePage;
import pageobject.LoginPage;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC14_BookTicket extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final BookTicketPage bookTicket = new BookTicketPage();
    private final LoginPage loginPage = new LoginPage();
    private final FormatDate formatDate = new FormatDate();
    private final TicketInformation inf = new TicketInformation();
    @Test
    public void TC14(Method method) {
        startTest(method.getName(), "TC14 - User can book 1 ticket at a time");
        System.out.println("TC14 - User can book 1 ticket at a time");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        //bookTicket
        homePage.gotoBookTicketPage();
        String actualMsg = bookTicket.buyTicket(formatDate.formatDate(), inf.departFrom[0], inf.arriveAt[1], inf.typeSeat[5], "1");
        String expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive message");
        //check ticket's information
        Assert.assertTrue(bookTicket.getBookedTicket(inf.departFrom[0], inf.arriveAt[1], inf.typeSeat[5],
                formatDate.formatDate(), 1), "Wrong ticket's information is displayed");

    }
}
