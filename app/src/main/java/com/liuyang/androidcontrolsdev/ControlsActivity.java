package com.liuyang.androidcontrolsdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControlsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);


        // 拾色器
        // http://link.fobshanghai.com/rgbcolor.htm


        // bg_edittext_a:圆角边框focus边框变色
        // https://www.cnblogs.com/guop/p/5217534.html
        /**
         * android:background="@drawable/bg_edittext_a"
         * */


        // myThemeEdittextB:改变下划线颜色
        // https://blog.csdn.net/qq_20451879/article/details/79075272
        /**
         * android:theme="@style/myThemeEdittextB"
         * */


        // 背景设为@null去除边框
        // https://www.cnblogs.com/rayray/p/3154985.html
        /**
         * android:background="@null"
         * */



    }
}
