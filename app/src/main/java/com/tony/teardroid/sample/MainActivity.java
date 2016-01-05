package com.tony.teardroid.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.tony.teardroid.common.adpter.BaseAdapterHelper;
import com.tony.teardroid.common.adpter.MultiItemTypeSupport;
import com.tony.teardroid.common.adpter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lst_content)
    ListView lstContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<String> data = new ArrayList<>();
        for (int i=0; i<10; i++){
            data.add(String.valueOf(i));
        }

        MultiItemTypeSupport<String> multiItemTypeSupport = new MultiItemTypeSupport<String>() {
            @Override
            public int getLayoutId(int position, String o) {
                if (position%2 == 0)
                    return  R.layout.item_view_one;
                return R.layout.item_view_two;
            }

            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, String o) {
                if (position%2 == 0)
                    return  R.layout.item_view_one;
                return R.layout.item_view_two;
            }
        };

        QuickAdapter<String> adapter = new QuickAdapter<String>(this, multiItemTypeSupport, data) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {

            }
        };
        adapter.showIndeterminateProgress(true);
        lstContent.setAdapter(adapter);
    }
}
