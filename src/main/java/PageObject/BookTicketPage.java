package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class BookTicketPage {

    //element
    protected WebElement getDrpDepartDate = Constant.WEBDRIVER.findElement(By.name("Date"));
    protected WebElement getDrpDepartFrom = Constant.WEBDRIVER.findElement(By.name("DepartStation"));
    protected WebElement getDrpArriveAt = Constant.WEBDRIVER.findElement(By.name("ArriveStation"));
    protected WebElement getDrpSeatType = Constant.WEBDRIVER.findElement(By.name("SeatType"));
    protected WebElement getDrpTicketAmount = Constant.WEBDRIVER.findElement(By.name("TicketAmount"));
    protected WebElement getBtnBookTicket = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    protected WebElement getHeadLine = Constant.WEBDRIVER.findElement(By.xpath("//h1[@align='center']"));
    //method
     void selectDepartDate(int value){ //value is 4-30, respectively 3-30days ahead
        Select drpDate =new Select(getDrpDepartDate);
        drpDate.selectByValue("\""+value+"\"");
    }
     void selectDepartFrom(String city){
        Select drpDepartFrom = new Select(getDrpDepartFrom);
        drpDepartFrom.selectByVisibleText(city);
    }
     void selectArriveAt(String city){
        Select drpArriveAt = new Select(getDrpArriveAt);
        drpArriveAt.selectByVisibleText(city);
    }
     void selectSeatType (String typeSeat){
        Select drpSeatType = new Select(getDrpSeatType);
        drpSeatType.selectByVisibleText(typeSeat);
    }
     void selectTicketAmount(int num){
        Select drpTicketAmount = new Select(getDrpTicketAmount);
        drpTicketAmount.selectByValue("\""+num+"\"");
    }
     String clickBtnBookTicket(){
        getBtnBookTicket.click();
        return getHeadLine.getText();
    }
    public void buyTicket(int departDate, String departFrom, String arriveAt, String seatType, int ticketAmount){
        this.selectDepartDate(departDate);
        this.selectDepartFrom(departFrom);
        this.selectArriveAt(arriveAt);
        this.selectSeatType(seatType);
        this.selectTicketAmount(ticketAmount);
        getBtnBookTicket.click();
        getHeadLine.getText();
    }
}
