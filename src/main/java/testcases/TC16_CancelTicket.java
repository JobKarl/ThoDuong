package testcases;

import common.ExistElement;
import common.FormatDate;
import constant.Constant;
import dataobject.TicketInformation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;

import java.lang.reflect.Method;

import static common.extentreport.ExtentTestManager.startTest;

public class TC16_CancelTicket extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final MyTicketPage myTicket = new MyTicketPage();
    private final LoginPage loginPage = new LoginPage();
    private final FormatDate formatDate = new FormatDate();
    private final TicketInformation inf = new TicketInformation();

    @Test
    public void TC16(Method method) {
        startTest(method.getName(), "TC16 - User can cancel a ticket");
        System.out.println("TC16 - User can cancel a ticket");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        //go to MyTicketPage
        homePage.gotoMyTicketPage();
        //cancel the ticket
        myTicket.deleteTicket(inf.departFrom[0], inf.arriveAt[1], inf.typeSeat[5], formatDate.formatDate(), 1, inf.status[0]);
        Assert.assertFalse(myTicket.checkTicketExist(inf.departFrom[0], inf.arriveAt[1], inf.typeSeat[5],
                formatDate.formatDate(), 1, inf.status[0]));
    }
}
