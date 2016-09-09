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
            holder.address.setText(immobile.getAddress().toString());
            holder.subType.setText(immobile.getSubType());
            holder.price.setText(Tools.getPriceFormat(immobile.getPriceSell()));
            holder.subTypeSale.setText(immobile.getSubTypeSale());
            holder.detail.setText(immobile.toString());
            Tools.getImageUrl(context,immobile.getUrlImagem(),holder.image);
            holder.linearLayout.setOnClickListener(eventShowDetail);
            holder.linearLayout.setTag(immobile.getCod());
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
        this.list.addAll(list);
        this.notifyItemInserted(this.list.size());
        this.notifyDataSetChanged();
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
        TextView subType, price,address, detail,subTypeSale;
        ImageView image;
        LinearLayout linearLayout;

        private RecyclerHolder(View itemView) {
            super(itemView);
            subType = ButterKnife.findById(itemView,R.id.sub_type_immobile);
            price = ButterKnife.findById(itemView,R.id.price);
            address = ButterKnife.findById(itemView,R.id.address);
            subTypeSale = ButterKnife.findById(itemView,R.id.sub_type_sale);
            image = ButterKnife.findById(itemView,R.id.image);
            linearLayout = ButterKnife.findById(itemView,R.id.linear_layout_zap);
            detail = ButterKnife.findById(itemView,R.id.detail);
        }

    }
}
