package common;

import constant.Constant;

public class PopupMessage {
    public void accept(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public void dismiss(){
        Constant.WEBDRIVER.switchTo().alert().dismiss();
    }
    public void alertMessage(){
        Constant.WEBDRIVER.switchTo().alert().getText();}
}
