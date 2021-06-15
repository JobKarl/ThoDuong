package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {

    //element_
    protected WebElement getTrips;
    protected WebElement getTitleTable = Constant.WEBDRIVER.findElement(By.xpath("//tbody//th"));
    protected WebElement getTypeSeat;
    //method_
    public TicketPricePage checkNameTrip(String nameTrips){
        getTrips = Constant.WEBDRIVER.findElement(By.xpath("//li[text()='"+nameTrips+"']/../following-sibling::td"));
        getTrips.click();
        return new TicketPricePage();
    }
    public String checkTitleTable(){return getTitleTable.getText();}
    public BookTicketPage clickBtnBookTicket(String typeSeat){
        getTypeSeat = Constant.WEBDRIVER.findElement(By.xpath("//tbody//td[text()='"+typeSeat+"']/following-sibling::td/a[text()='Book ticket']"));
        return new BookTicketPage();
    }
}
