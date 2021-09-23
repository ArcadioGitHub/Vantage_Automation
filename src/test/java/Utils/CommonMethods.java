package Utils;

import java.util.Calendar;

public class CommonMethods {

    public static String randomStringDate(){
        Calendar calendar = Calendar.getInstance();
        String alias = String.valueOf(calendar.getTimeInMillis());

        for(int i=0; i<5; i++){
            alias = alias+1;
        }
        return alias;
    }
}
