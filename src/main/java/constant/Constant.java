package constant;

import common.FormatDate;
import common.Mathematics;
import org.openqa.selenium.WebDriver;

public class Constant {
    private static final FormatDate formatDate = new FormatDate();
    private static final Mathematics math = new Mathematics();
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railway2.somee.com/";
    public static final String USERNAME = "thanhle@logigear.com";
    public static String registerUsername = math.getRandomNumber(1,100)+ formatDate.formatDateString()+"test@logigeear.com";
    public static final String registerPassword ="12345678";
    public static final String registerID = "1231254215";
    public static final String notSameConfirmPassword = "123456789";
}
