package PageObject;
import constant.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage{
    //objects
    Utilities tools = new Utilities();
    //element
    public WebElement getFilterDepartSt = Constant.WEBDRIVER.findElement(By.name("FilterDpStation"));
    public WebElement getFilterArriveSt = Constant.WEBDRIVER.findElement(By.name("FilterArStation"));
    public WebElement getFilterDepartDate = Constant.WEBDRIVER.findElement(By.name("FilterDpDate"));
    public WebElement getFilterStatus = Constant.WEBDRIVER.findElement(By.name("FilterStatus"));
    public WebElement getBtnApplyFilter = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    public WebElement getBtnCancel;
    public WebElement getTicket (String departFrom,String arriveAt,String seatType,String departDate, int amountTicket
            ,String status) {
        return Constant.WEBDRIVER.findElement(By.xpath("//tr/td[text()='" + departFrom + "" +
                "']/following-sibling::td[text()='" + arriveAt + "']/following-sibling::td[text()='" + seatType +
                "']/following-sibling::td[text()='" + departDate + "']/following-sibling::td[text()" +
                "='" + status + "']/following-sibling::td[text()='" + amountTicket + "']/following-sibling::td/input[@type" +
                "='button']/.."));
    }
    //methods
    void selectDepartDate(String date){
        Select drpDate =new Select(getFilterDepartDate);
        drpDate.selectByValue(date);
    }
    void selectDepartFrom(String city){
        Select drpDepartFrom = new Select(getFilterDepartSt);
        drpDepartFrom.selectByVisibleText(city);
    }
    void selectArriveAt(String city){
        Select drpArriveAt = new Select(getFilterArriveSt);
        drpArriveAt.selectByVisibleText(city);
    }
    void selectStatusTicket(String status){
        Select drpTicketAmount = new Select(getFilterStatus);
        drpTicketAmount.selectByValue(status);
    }
    void clickBtnApplyFilter(){
        getBtnApplyFilter.click();
    }
    public void buyTicket(String departFrom, String arriveAt, String date, String status){
        this.selectDepartFrom(departFrom);
        this.selectArriveAt(arriveAt);
        this.selectDepartDate(date);
        this.selectStatusTicket(status);
        getBtnApplyFilter.click();
    }
    public void deleteTicket(String departFrom,String arriveAt,String seatType,String departDate, int amountTicket
            ,String status){
        getBtnCancel = Constant.WEBDRIVER.findElement(By.xpath("//tr/td[text()='"+departFrom+"" +
                "']/following-sibling::td[text()='"+arriveAt+"']/following-sibling::td[text()='"+seatType+
                "']/following-sibling::td[text()='"+departDate+"']/following-sibling::td[text()" +
                "='"+status+"']/following-sibling::td[text()='"+amountTicket+"']/following-sibling::td/input[@type" +
                "='button']"));
        getBtnCancel.click();
        tools.accept();
    }
}
