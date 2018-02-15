package utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.Calendar;
import java.util.Date;


public class Utility {

    public static final int DAY_TEXT      = 0;
    public static final int MONTH_TEXT    = 1;
    public static final int DAY_NUMBER    = 2;
    public static final int YEAR_NUMBER   = 5;
    public static final int MONTH_NUMBER  = 6;

    public static String[] icons =
            {       "01d"
                    ,"02d"
                    ,"03d"
                    ,"04d"
                    ,"09d"
                    ,"10d"
                    ,"11d"
                    ,"13d"
                    ,"01n"
                    ,"02n"
                    ,"03n"
                    ,"04n"
                    ,"09n"
                    ,"10n"
                    ,"11n"
                    ,"13n"
            };

    public static Drawable getIcon(Context context, String idIcon){
        int resourceId;
        Drawable drawable;
        for(int i=0; i<icons.length;i++){
            if(idIcon.equalsIgnoreCase(icons[i])){
                resourceId = context.getResources().getIdentifier("ic_a"+idIcon, "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                return drawable;
            }
        }
        resourceId = context.getResources().getIdentifier("ic_drop_cloud", "drawable", context.getPackageName());
        drawable = context.getResources().getDrawable(resourceId);
        return drawable;
    }

    public static String getTypeDateUnit(long dateTimeStamp, int TYPE){
        Date time = new Date(dateTimeStamp*1000);
        String timeString;
        switch (TYPE) {
            case DAY_TEXT:
                timeString = (String) android.text.format.DateFormat.format("EEE", time);//Thu
                break;
            case DAY_NUMBER:
                timeString = (String) android.text.format.DateFormat.format("dd", time); //20
                break;
            case MONTH_TEXT:
                timeString = (String) android.text.format.DateFormat.format("MMM", time);//Jun
                break;
            case MONTH_NUMBER:
                Calendar cal = Calendar.getInstance();
                cal.setTime(time);
                int month = cal.get(Calendar.MONTH)+1;
                timeString = ""+(month<10?("0"+month):(month));
                break;
            case YEAR_NUMBER:
                timeString = (String) android.text.format.DateFormat.format("yyyy", time);
                break;
            default:
                timeString = "-9";
                break;
        }
        return timeString;
    }
}