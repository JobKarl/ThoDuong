package testcases;

import common.ExistElement;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;

public class TC16_CancelTicket extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final MyTicketPage myTicket = new MyTicketPage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        //go to MyTicketPage
        homePage.gotoMyTicketPage();
        //cancel the ticket
        myTicket.deleteTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "6/30/2021", 1, "New");
        Assert.assertEquals(0, myTicket.getTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner",
                "6/30/2021", 1, "New").size(), "Ticket was not deleted");
    }
}
