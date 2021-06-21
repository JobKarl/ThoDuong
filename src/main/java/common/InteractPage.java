package common;

import constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractPage {
    public void scrollDownToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        //get the height of the webpage and scroll to the end
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void moveToElement(WebElement element){
        Actions act = new Actions(Constant.WEBDRIVER);
        act.moveToElement(element);
        act.perform();
    }
}
