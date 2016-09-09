package rviannaoliveira.com.zapimoveis.zap;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import rviannaoliveira.com.zapimoveis.R;

public class ZapActivity extends AppCompatActivity {
    public final static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zap);
        this.showFragment();
        throw  new RuntimeException();
    }

    public void showFragment() {
        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new ZapFragment());
        transaction.commit();
    }
}
