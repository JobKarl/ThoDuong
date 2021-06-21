package testcases;

import common.FormatDate;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BookTicketPage;
import pageobject.HomePage;
import pageobject.LoginPage;

public class TC14_BookTicket extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final BookTicketPage bookTicket = new BookTicketPage();
    private final LoginPage loginPage = new LoginPage();
    private String actualMsg;
    private String expectedMsg;

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        //login
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));
        //bookTicket
        homePage.gotoBookTicketPage();
        actualMsg = bookTicket.buyTicket("6/30/2021", "Sài Gòn", "Nha Trang", "Soft bed with " +
                "air conditioner", "1");
        expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive message");
        //check ticket's information
        Assert.assertTrue(bookTicket.getBookedTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner",
                "6/30/2021", 1).isDisplayed(), "Wrong ticket's information is displayed");

    }
}
