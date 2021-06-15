package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin= By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='../Page/TrainTimeListPage.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='../Page/BookTicketPage.cshtml']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='../Page/TrainPriceListPage.cshtml']");
    private final By tabFQA = By.xpath("//div[@id='menu']//a[@href='#']");
    private final By title = By.xpath("//title");
    //Element
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){
        return  Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getTabRegister(){return Constant.WEBDRIVER.findElement(tabRegister);}
    protected WebElement getTitle(){ return Constant.WEBDRIVER.findElement(title);}
    protected WebElement getTabTimeTable(){return Constant.WEBDRIVER.findElement(tabTimeTable);}
    protected WebElement getBookTicket(){return Constant.WEBDRIVER.findElement(tabBookTicket);}
    protected WebElement getTicketPrice(){return Constant.WEBDRIVER.findElement(tabTicketPrice);}
    protected WebElement getFQA(){return Constant.WEBDRIVER.findElement(tabFQA);}
    protected WebElement getContact = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']"));
    protected WebElement getTabMyTicket = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page" +
            "/ManageTicket.cshtml']"));

    //Method
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public GeneralPage logOut(){
        this.getTabLogout().click();
        return new HomePage();
    }
    public TimeTablePage gotoTimeTable(){
        this.getTabTimeTable().click();
        return new TimeTablePage();
    }
    public BookTicketPage gotoBookTicketPage(){
        this.getBookTicket().click();
        return new BookTicketPage();
    }
    public TicketPricePage gotoBookPricePage(){
        this.getTicketPrice().click();
        return new TicketPricePage();
    }
    public FQAPage gotoFQAPage(){
        this.getFQA().click();
        return new FQAPage();
    }
    public ContactPage gotoContactPage(){
        getContact.click();
        return new ContactPage();
    }
    public MyTicketPage gotoMyTicket(){
        getTabMyTicket.click();
        return new MyTicketPage();
    }
    public String getTitlePage(){return this.getTitle().getText();}
}
