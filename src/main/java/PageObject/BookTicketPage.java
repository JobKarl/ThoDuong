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
    public WebElement getDrpDepartDate = Constant.WEBDRIVER.findElement(By.name("Date"));
    public WebElement getDrpDepartFrom = Constant.WEBDRIVER.findElement(By.name("DepartStation"));
    public WebElement getDrpArriveAt = Constant.WEBDRIVER.findElement(By.name("ArriveStation"));
    public WebElement getDrpSeatType = Constant.WEBDRIVER.findElement(By.name("SeatType"));
    public WebElement getDrpTicketAmount = Constant.WEBDRIVER.findElement(By.name("TicketAmount"));
    public WebElement getBtnBookTicket = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    public WebElement getHeadLine = Constant.WEBDRIVER.findElement(By.xpath("//h1[@align='center']"));
    public WebElement getBookedTicket;
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
    public String buyTicket(int departDate, String departFrom, String arriveAt, String seatType, int ticketAmount){
        this.selectDepartDate(departDate);
        this.selectDepartFrom(departFrom);
        this.selectArriveAt(arriveAt);
        this.selectSeatType(seatType);
        tools.scrollDownToBottom();
        this.selectTicketAmount(ticketAmount);
        getBtnBookTicket.click();
        getHeadLine.getText();
        return getHeadLine.getText();
    }
    public WebElement bookedTicket(String departStation,String arriveStation,String seatType,String date,int amount){
        return getBookedTicket = Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+departStation+"']/following" +
                "-sibling::td[text" +
                "()='"+arriveStation+"']/following-sibling::td[text()='"+seatType+"']/following-sibling::td[text()='"+date+"']/following-sibling::td[text()='"+amount+"']/.."));
    }
}
