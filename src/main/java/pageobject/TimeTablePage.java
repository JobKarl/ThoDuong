package pageobject;

import common.InteractPage;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    //objects
    private final InteractPage interactPage = new InteractPage();
    //element
    public WebElement getTimeofTrip(String departStation, String arriveStation, String time) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='" + departStation + "']/following-sibling" +
                "::td[text()='" + arriveStation + "']/../td[count(//th[text()='" + time + "']/preceding-sibling::th)+1]"));
    }

    public WebElement getBtn(String departStation, String arriveStation, String button) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='" + departStation + "']/following-sibling::td[text" +
                "()='" + arriveStation + "']/../td[count(//th[text()='" + button + "']/preceding-sibling::th)+1]/a"));
    }

    //methods
    public String getTimeTrip(String departStation, String arriveStation, String time) {
        return this.getTimeofTrip(departStation, arriveStation, time).getText();
    }

    public void clickButtonTimeTable(String departStation, String arriveStation, String button) {
        interactPage.scrollDownToBottom();
        this.getBtn(departStation, arriveStation, button).click();
    }
}
