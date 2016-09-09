package rviannaoliveira.com.zapimoveis;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by rodrigo on 09/09/16.
 */
public class Tools {
    public static String getPriceFormat(String priceSell) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return format.format( Integer.valueOf(priceSell));
    }
}
