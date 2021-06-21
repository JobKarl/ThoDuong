package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ExistElement {
    public boolean isElementPresent(WebElement element) {
        try{
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
