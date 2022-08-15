package chuong2;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringinSwitch {
    public static void main(String[] args) {
        StringinSwitch statement = new StringinSwitch();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is " + statement.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE) + 1);
        System.out.println("tomorow is " + statement.getTypeOfDay(calendar));
    }
    String getTypeOfDay(Calendar calendar) {
        String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
        switch (type) {
            case "Th 2":
                return "Start of work week";
            case "Th 3":
                return "Start of work week";
            case "Th 4":
                return "Midweek";
            case "Th 5":
                return "Midweek";
            case "Th 6":
                return "End of work week";
            case "Th 7":
                return "End of work week";
            case "CN":
                return "Weekend";
        }
        return "Unknow";
    }


}
