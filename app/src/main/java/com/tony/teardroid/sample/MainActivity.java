package com.tony.teardroid.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tony.teardroid.common.util.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.e(123);
        LogUtils.e("TAG", 123);
    }
}
