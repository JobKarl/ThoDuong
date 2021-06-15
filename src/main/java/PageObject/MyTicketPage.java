package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    //element
    protected WebElement getFilterDepartSt = Constant.WEBDRIVER.findElement(By.name("FilterDpStation"));
    protected WebElement getFilterArriveSt = Constant.WEBDRIVER.findElement(By.name("FilterArStation"));
    protected WebElement getFilterDepartDate = Constant.WEBDRIVER.findElement(By.name("FilterDpDate"));
    protected WebElement getFilterStatus = Constant.WEBDRIVER.findElement(By.name("FilterStatus"));
    protected WebElement getBtnApplyFilter = Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));

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
}
