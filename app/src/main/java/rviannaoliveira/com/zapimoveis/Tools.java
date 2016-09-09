package rviannaoliveira.com.zapimoveis;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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

    public static void getImageUrl(Context context, String url, ImageView image){
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.image_not_found)
                .error(R.drawable.zap300)
                .fit()
                .into(image);
    }
    public static boolean stringNotNullNotEmpty(String string) {
        if (string == null) {
            return false;
        }
        String stringNotSpace = string.trim();
        return stringNotSpace.length() > 0 && !string.isEmpty();

    }
}
