package com.liuyang.androidcontrolsdev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent in = new Intent(this, LoginActivity.class);
//        this.startActivity(in);


//        Intent in = new Intent(this, ControlsActivity.class);
//        this.startActivity(in);


        Intent in = new Intent(this, NavActivity.class);
        this.startActivity(in);


    }
}
