package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilitiesViews {

    public static String toFloatFormatPercentage(float value) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern( "% ####,##" );
        String strValue = df.format(value);
        return strValue;
    }

    public static String toFormatterDate(LocalDate date) {
        if (date != null){
            String formatDate = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        return date.format(formatter);
        }else{
            return "";
        }
    }
}
