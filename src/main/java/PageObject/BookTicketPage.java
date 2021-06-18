package PageObject;

import constant.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    //objects.
    private final Utilities tools = new Utilities();

    //element
    public WebElement getDrpDepartDate() {
        return Constant.WEBDRIVER.findElement(By.name("Date"));
    }

    public WebElement getDrpDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.name("DepartStation"));
    }

    public WebElement getDrpArriveAt() {
        return Constant.WEBDRIVER.findElement(By.name("ArriveStation"));
    }

    public WebElement getDrpSeatType() {
        return Constant.WEBDRIVER.findElement(By.name("SeatType"));
    }

    public WebElement getDrpTicketAmount() {
        return Constant.WEBDRIVER.findElement(By.name("TicketAmount"));
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement getHeadLine() {
        return Constant.WEBDRIVER.findElement(By.xpath("//h1[@align='center']"));
    }

    public WebElement getBookedTicket(String departStation, String arriveStation, String seatType, String date,
                                      int amount) {
        tools.scrollDownToBottom();
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='" + departStation + "']/following-sibling::td[text" +
                "()='" + arriveStation + "']/following-sibling::td[text()='" + seatType + "']/following-sibling::td[text()='" + date + "']/following-sibling::td[text()='" + amount + "']/.."));
    }

    //method
    void selectDepartDate(String value) { //value is 4-30, respectively 3-30days ahead
        Select drpDate = new Select(getDrpDepartDate());
        drpDate.selectByValue(value);
    }

    void selectDepartFrom(String city) {
        Select drpDepartFrom = new Select(getDrpDepartFrom());
        drpDepartFrom.selectByVisibleText(city);
    }

    void selectArriveAt(String city) {
        Select drpArriveAt = new Select(getDrpArriveAt());
        drpArriveAt.selectByVisibleText(city);
    }

    void selectSeatType(String typeSeat) {
        Select drpSeatType = new Select(getDrpSeatType());
        drpSeatType.selectByVisibleText(typeSeat);
    }

    void selectTicketAmount(String num) {
        Select drpTicketAmount = new Select(getDrpTicketAmount());
        drpTicketAmount.selectByValue(num);
    }

    public String buyTicket(String departDate, String departFrom, String arriveAt, String seatType,
                            String ticketAmount) {
        this.selectDepartDate(departDate);
        this.selectDepartFrom(departFrom);
        this.selectArriveAt(arriveAt);
        this.selectSeatType(seatType);
        tools.scrollDownToBottom();
        this.selectTicketAmount(ticketAmount);
        this.getBtnBookTicket().click();
        this.getHeadLine().getText();
        return this.getHeadLine().getText();
    }

}
