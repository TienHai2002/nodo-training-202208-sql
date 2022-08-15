package chuong2;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageFormat1 {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE,dd MMMMM yyyy");
        String message = MessageFormat.format(
                "Hello{0}! Today is {1}.", args[0],
                dateFormat.format(Calendar.getInstance().getTime())
        );
        System.out.println(message);
    }
}
