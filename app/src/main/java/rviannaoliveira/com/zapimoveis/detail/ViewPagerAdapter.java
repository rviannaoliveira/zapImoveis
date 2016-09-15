package rviannaoliveira.com.zapimoveis.detail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import rviannaoliveira.com.zapimoveis.R;
import rviannaoliveira.com.zapimoveis.Tools;

/**
 * Created by User on 23/11/2015.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<String> urlList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public int getCount() {
        return urlList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.pager_item, view, false);

        final ImageView imageView = ButterKnife.findById(imageLayout,R.id.pager_item_imageView);

        Tools.getImageUrl(context,urlList.get(position),imageView);

        view.addView(imageLayout, 0);
        return imageLayout;
    }

    public void addAllItem(List<String> photos){
        for (String photo : photos) {
            urlList.add(photo);
        }
    }


}