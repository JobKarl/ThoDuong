package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import constant.Constant;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
    public String getRandomNumber(long min, long max) {
        return String.valueOf((long) ((Math.random() * (max - min)) + min));
    }
    public void scrollDownToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        //get the height of the webpage and scroll to the end
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void accept(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public void dismiss(){
        Constant.WEBDRIVER.switchTo().alert().dismiss();
    }
    public void alertMessage(){
        Constant.WEBDRIVER.switchTo().alert().getText();}
    public void moveToElement(WebElement element){
        Actions act = new Actions(Constant.WEBDRIVER);
        act.moveToElement(element);
        act.perform();
    }
    public String toDaysString(int changeDay){
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        //get current date time with Date()
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,changeDay);
        return dateFormat.format(c.getTime());
    }
}
