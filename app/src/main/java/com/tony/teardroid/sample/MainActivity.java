package com.tony.teardroid.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.edt_introduce)
    EditText mEdtIntroduce;
    @Bind(R.id.lyt_introduce)
    LinearLayout mLytIntroduce;
    private List<String> listId = new ArrayList<>();
    private List<String> listName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLytIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdtIntroduce.requestFocus();
            }
        });
    }
}
