package pageobject;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    //element_
    public WebElement getTrips(String nameTrips) {
        return Constant.WEBDRIVER.findElement(By.xpath("//li[text()='" + nameTrips + "']/../following-sibling::td"));
    }

    public WebElement getTitleTable() {
        return Constant.WEBDRIVER.findElement(By.xpath("//tbody//th"));
    }

    public WebElement getTypeSeat(String typeSeat) {
        return Constant.WEBDRIVER.findElement(By.xpath("//tbody//td[text()='" + typeSeat + "']/following-sibling::td" +
                "/a[text()='Book ticket']"));
    }

    //method_
    public TicketPricePage checkNameTrip(String nameTrips) {
        this.getTrips(nameTrips).click();
        return new TicketPricePage();
    }

    public BookTicketPage clickBtnBookTicket(String typeSeat) {
        this.getTypeSeat(typeSeat).click();
        return new BookTicketPage();
    }

    public String getTextTittleTable() {
        return this.getTitleTable().getText();
    }

}
