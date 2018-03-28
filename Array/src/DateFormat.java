/**
 * Created by abhimanyus on 3/28/18.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
    public static String[] getOrdinalSuffix( String value [])
    {
        String formattedDateArr[] = new String[value.length];
        String formattedDate ="";

        for(int i=0;i<value.length;i++) {
            String s[] = value[i].split(" ");
            String month="";
            String day= s[0].replaceAll("[^0-9]", "");
            day = day.length()==1?"0"+day:day;
            int monthName = getMonth(s[1]);
            if(String.valueOf(monthName).length()!=2)
                month = String.valueOf(monthName).contains("0")?String.valueOf(monthName):"0"+String.valueOf(monthName);
            else
                month =  String.valueOf(monthName);
            formattedDate = s[2]+"-"+month+"-"+ day;
            formattedDateArr[i] = formattedDate;

        }
        return formattedDateArr;
    }


    private static int getMonth(String monthName) {
        Date date=null;
        try {
            date = new SimpleDateFormat("MMMM").parse(monthName);
        } catch (ParseException e) {

        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH)+1;
    }
    public static void main(String[] args)  {
        String argss[] = {"20th Oct 2052","6th Jun 1933","26th May 1960"};
        System.out.println(Arrays.toString(getOrdinalSuffix(argss)));


    }
}



