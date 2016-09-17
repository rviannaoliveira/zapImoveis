package rviannaoliveira.com.zapimoveis.detail;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import rviannaoliveira.com.zapimoveis.R;
import rviannaoliveira.com.zapimoveis.zap.ZapActivity;

/**
 * Created by rodrigo on 09/09/16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zap);
        setTitle(this.getString(R.string.detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.gradient_top));
        this.showFragment();
    }

    public void showFragment() {
        Bundle arguments = new Bundle();
        arguments.putString(ZapActivity.KEY, getIntent().getStringExtra(ZapActivity.KEY));
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(arguments);

        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, detailFragment);
        transaction.commit();
    }
}