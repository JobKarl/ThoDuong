package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    public String formatDateString() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, 4);
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mddyyyy");
        //convert calendar to date
        return dateFormat.format(cal.getTime());
    }

    public String formatDate() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, 4);
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
        //convert calendar to date
        return dateFormat.format(cal.getTime());
    }

    public String formatTime() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, 4);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss");
        //convert calendar to date
        return dateFormat.format(cal.getTime());
    }
}
