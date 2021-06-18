package PageObject;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Element
    public WebElement getTabLogin = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account" +
            "/Login.cshtml']"));
    public WebElement getTabLogout = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account" +
            "/Logout']"));
    public WebElement getLblWelcomeMessage = Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong"));
    public WebElement getTabRegister = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account" +
            "/Register.cshtml']"));
    public WebElement getTitle = Constant.WEBDRIVER.findElement(By.xpath("//title"));
    public WebElement getTabTimeTable = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='." +
            "./Page/TrainTimeListPage.cshtml']"));
    public WebElement getBookTicket = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='." +
            "./Page/BookTicketPage.cshtml']"));
    public WebElement getTicketPrice = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='." +
            "./Page/TrainPriceListPage.cshtml']"));
    public WebElement getFQA = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='#']"));
    public WebElement getContact = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']"));
    public WebElement getTabMyTicket = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page" +
            "/ManageTicket.cshtml']"));
    public WebElement getTabChangePassWord = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='." +
            "./Account/ChangePassword.cshtml']"));

    //Method
    public String getWelcomeMessage() {
        return getLblWelcomeMessage.getText();
    }

    public void gotoLoginPage() {
        getTabLogin.click();
    }

    public void gotoRegisterPage() {
        getTabRegister.click();
    }

    public void logOut() {
        getTabLogout.click();
    }

    public void gotoTimeTable() {
        getTabTimeTable.click();
    }

    public void gotoBookTicketPage() {
        getBookTicket.click();
    }

    public void gotoBookPricePage() {
        getTicketPrice.click();
    }

    public void gotoFQAPage() {
        getFQA.click();
    }

    public void gotoContactPage() {
        getContact.click();
    }

    public void gotoMyTicketPage() {
        getTabMyTicket.click();
    }

    public void gotoChangePasswordPage() {
        getTabChangePassWord.click();
    }

    public String getTitlePage() {
        return getTitle.getText();
    }

}
