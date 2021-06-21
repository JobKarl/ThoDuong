package common;
public class Mathematics {
    public String getRandomNumber(long min, long max) {
        return String.valueOf((long) ((Math.random() * (max - min)) + min));
    }
}
