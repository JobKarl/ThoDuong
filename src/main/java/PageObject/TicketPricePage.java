package PageObject;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    //element_
    public WebElement getTrips;
    public WebElement getTitleTable = Constant.WEBDRIVER.findElement(By.xpath("//tbody//th"));
    public WebElement getTypeSeat;
    //method_
    public TicketPricePage checkNameTrip(String nameTrips){
        getTrips = Constant.WEBDRIVER.findElement(By.xpath("//li[text()='"+nameTrips+"']/../following-sibling::td"));
        getTrips.click();
        return new TicketPricePage();
    }
    public String checkTitleTable(){return getTitleTable.getText();}
    public BookTicketPage clickBtnBookTicket(String typeSeat){
        getTypeSeat = Constant.WEBDRIVER.findElement(By.xpath("//tbody//td[text()='"+typeSeat+"']/following-sibling::td/a[text()='Book ticket']"));
        getTypeSeat.click();
        return new BookTicketPage();
    }
    public String getTextTilteTable (){return getTitleTable.getText();}

}
