package com.liuyang.androidcontrolsdev;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class MyApp extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        //多dex支持，解决65536问题
        MultiDex.install(this);

    }


}
