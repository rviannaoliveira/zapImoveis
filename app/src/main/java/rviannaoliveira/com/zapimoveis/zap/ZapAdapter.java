package rviannaoliveira.com.zapimoveis.zap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rviannaoliveira.com.zapimoveis.R;
import rviannaoliveira.com.zapimoveis.Tools;
import rviannaoliveira.com.zapimoveis.detail.DetailActivity;
import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 08/09/16.
 */
public class ZapAdapter extends  RecyclerView.Adapter<ZapAdapter.RecyclerHolder>{
    private LayoutInflater inflater;
    private List<Immobile> list = new ArrayList<>();
    private Activity context;

    ZapAdapter(Activity context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ZapAdapter.RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_immobile, parent, false);
        return  new RecyclerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ZapAdapter.RecyclerHolder holder, int position) {
        if (!list.isEmpty()) {
            Immobile immobile = list.get(position);
            holder.address.setText(immobile.getAddress().getTextAddress());
            holder.subType.setText(immobile.getSubType());
            holder.price.setText(Tools.getPriceFormat(immobile.getPriceSell()));
            holder.subTypeSale.setText(immobile.getSubTypeSale());
            holder.detail.setText(immobile.getTextImmobile());
            Tools.getImageUrl(context,immobile.getUrlImage(),holder.image);
            holder.linearLayout.setOnClickListener(eventShowDetail);
            holder.linearLayout.setTag(immobile.getCod());
            holder.linearLayoutSub.setBackgroundResource(R.drawable.gradient_top);
            holder.linearLayoutSale.setBackgroundResource(R.drawable.gradient_bottom);
        }
    }

    private View.OnClickListener eventShowDetail = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle arguments = new Bundle();
            arguments.putString(ZapActivity.KEY,String.valueOf(view.getTag()));
            Intent detail = new Intent(context,DetailActivity.class);
            detail.putExtras(arguments);
            context.startActivity(detail);
        }
    };

    public void addAll(List<Immobile> list){
        for(Immobile immobile : list){
            this.list.add(immobile);
            this.notifyDataSetChanged();
        }
    }

    public void clear(){
        this.list.clear();
        this.notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    class RecyclerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sub_type_immobile)
        TextView subType;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.address)
        TextView address;
        @BindView(R.id.detail)
        TextView detail;
        @BindView(R.id.sub_type_sale)
        TextView subTypeSale;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.linear_layout_subtype)
        LinearLayout linearLayoutSub;
        @BindView(R.id.linear_layout_sale)
        LinearLayout linearLayoutSale;
        @BindView(R.id.linear_layout_zap)
        LinearLayout linearLayout;

        private RecyclerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
