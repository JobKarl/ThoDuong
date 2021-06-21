package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    public String formatDateString(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("mmddyyyy");
        return dateFormat.format(date);
    }
    public String formatDate(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE,4);
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("mm/DD/YYYY");
        //convert calendar to date
        return null;
    }
}
