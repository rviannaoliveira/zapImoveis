package rviannaoliveira.com.zapimoveis;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by rodrigo on 09/09/16.
 */
public class ZapApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());
    }

}