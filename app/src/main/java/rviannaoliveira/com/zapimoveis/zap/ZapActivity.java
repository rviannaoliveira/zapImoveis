package rviannaoliveira.com.zapimoveis.zap;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rviannaoliveira.com.zapimoveis.R;

public class ZapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zap);
        this.showFragment();
    }

    public void showFragment() {
        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new ZapFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}