package pageobject;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class GeneralPage {

    //Element
    public WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']"));
    }

    public WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Logout']"));
    }

    public WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong"));
    }

    public WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']"));
    }

    public WebElement getTitle() {
        return Constant.WEBDRIVER.findElement(By.tagName("title"));
    }

    public WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']"));
    }

    public WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']"));
    }

    public WebElement getTicketPrice() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage" +
                ".cshtml']"));
    }

    public WebElement getFQA() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='#']"));
    }

    public WebElement getContact() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']"));
    }

    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']"));
    }

    public WebElement getTabChangePassWord() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']"));
    }

    //Method
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void logOut() {
        this.getTabLogout().click();
    }

    public void gotoTimeTable() {
        this.getTabTimeTable().click();
    }

    public void gotoBookTicketPage() {
        this.getBookTicket().click();
    }

    public void gotoBookPricePage() {
        this.getTicketPrice().click();
    }

    public void gotoFQAPage() {
        this.getFQA().click();
    }

    public void gotoContactPage() {
        this.getContact().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassWord().click();
    }

    public String getTitlePage() {
        return this.getTitle().getText();
    }
}
