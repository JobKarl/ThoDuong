package PageObject;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage {
    //element
    protected WebElement getTimeofTrip;
    protected WebElement getBtn;

    //methods
    public String getTimeTrip(String departStation, String arriveStation, String time) {
        getTimeofTrip= Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+departStation+"']/following-sibling::td[text()='"+arriveStation+"']/../td[count(//th[text()='"+time+"']/preceding-sibling::th)+1]"));
        getTimeofTrip.getText();
        return getTimeofTrip.getText();
    }
    public TicketPricePage clickButtonTimeTable(String departStation,String arriveStation,String button){
        getBtn =Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+departStation+"']/following-sibling::td[text()='"+arriveStation+"']/../td[count(//th[text()='"+button+"']/preceding-sibling::th)+1]"));
        getBtn.click();
        return new TicketPricePage();
    }
}
