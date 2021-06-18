package TestCases;

import constant.Constant;
import Common.Utilities;
import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Set1Test extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final Utilities tools = new Utilities();
    private final RegisterPage registerAccount = new RegisterPage();
    private final ChangePasswordPage changePwd = new ChangePasswordPage();
    private final ForgotPasswordPage forgotPwd = new ForgotPasswordPage();
    private final BookTicketPage bookTicket = new BookTicketPage();
    private final TimeTablePage timeTable = new TimeTablePage();
    private final MyTicketPage myTicket = new MyTicketPage();
    public String actualMsg;
    public String expectedMsg;

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        homePage.logOut();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox\n");
        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        actualMsg = loginPage.getErrorMsg();
        expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
        loginPage.getTxtUsername().clear();
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password.");
        loginPage.login(Constant.USERNAME, tools.getRandomNumber(10000000, 1000000000));
        actualMsg = loginPage.getErrorMsg();
        expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        loginPage.gotoBookTicketPage();
        actualMsg = loginPage.getTitlePage();
        expectedMsg = "Safe Railway - Login";
        Assert.assertEquals(actualMsg, expectedMsg.trim(), "Login page is not displayed.");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times.");
        for (int i = 1; i < 5; i++) {
            loginPage.login(Constant.USERNAME, tools.getRandomNumber(10000000, 1000000000));
            loginPage.getTxtUsername().clear();
        }
        actualMsg = loginPage.getErrorMsg();
        expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to " +
                "login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed or displayed wrong message.");
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        //check page tab is displayed
        Assert.assertTrue(homePage.getTabMyTicket().isDisplayed(), "MyTicket tab is not present.");
        Assert.assertTrue(homePage.getTabLogout().isDisplayed(), "Logout tab is not present.");
        Assert.assertTrue(homePage.getTabChangePassWord().isDisplayed(), "ChangePassword tab is not present.");
        //check My ticket page opens
        homePage.gotoMyTicketPage();
        actualMsg = Constant.WEBDRIVER.getTitle();
        expectedMsg = "Safe Railway - My Ticket";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Myticket page is opended");
        // check ChangePassword page opens
        homePage.gotoChangePasswordPage();
        actualMsg = Constant.WEBDRIVER.getTitle();
        expectedMsg = "Safe Railway - Change Password";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Changepassword page is opended.");
    }

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, Constant.registerPassword, Constant.registerPassword,
                Constant.registerID);
        actualMsg = registerAccount.successMessage();
        expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "user failed to register new account");
    }

    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");
        homePage.open();
        homePage.gotoChangePasswordPage();
        actualMsg = changePwd.changePassword(Constant.registerPassword, Constant.newPassword, Constant.newPassword);
        expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to change new password");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with " +
                "\"Password\"");
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, Constant.registerPassword,
                Constant.notSameConfirmPassword, Constant.registerID);
        actualMsg = registerAccount.messageError();
        expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive error message or receive another message");
    }

    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        homePage.logOut();
        homePage.gotoRegisterPage();
        registerAccount.registerAcc(Constant.registerUsername, "", "", "");
        //Message above forms
        actualMsg = registerAccount.messageError();
        expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive error message or different message");
        //Message at password fields
        actualMsg = registerAccount.pwdValidationMessage();
        expectedMsg = "Invalid password length.";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive error message or different message");
        //Message at PID fields
        actualMsg = registerAccount.pidValidationMessage();
        expectedMsg = "Invalid ID length.";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive error message or different message");
    }

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        homePage.gotoBookTicketPage();
        actualMsg = bookTicket.buyTicket("5", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "User failed to receive message");
        //check ticket's information
        Assert.assertTrue(bookTicket.getBookedTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner",
                tools.toDaysString(5), 1).isDisplayed(), "Wrong ticket's information is displayed");

    }

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train " +
                "timetable\" page");
        homePage.gotoTimeTable();
        timeTable.clickButtonTimeTable("Huế", "Sài Gòn", "book ticket");
        actualMsg = bookTicket.getDrpDepartFrom().getText();
        expectedMsg = "Huế";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong depart from");
        actualMsg = bookTicket.getDrpArriveAt().getText();
        expectedMsg = "Sài Gòn";
        Assert.assertEquals(actualMsg.trim(), expectedMsg, "Wrong arrive at");
    }

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        homePage.gotoMyTicketPage();
        myTicket.deleteTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner", tools.toDaysString(5), 1, "New");
        Assert.assertTrue(myTicket.getTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner",
                tools.toDaysString(5), 1, "New").isDisplayed(), "Ticket was not deleted");

    }
}
