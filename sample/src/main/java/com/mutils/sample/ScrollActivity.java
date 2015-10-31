package com.mutils.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import com.mutils.library.view.ScrollListView;

/**
 * Created by chao on 2015/10/31.
 */
public class ScrollActivity extends AppCompatActivity {
    private ScrollListView scrollLV;
    private ScrollView mainSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initView();

    }

    private void initView() {
        scrollLV = (ScrollListView) findViewById(R.id.scrollLV);
        mainSV = (ScrollView) findViewById(R.id.mainSV);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (int i = 0; i < 10; i++) {
            arrayAdapter.add("item-" + i + "");
        }
        scrollLV.setAdapter(arrayAdapter);
        mainSV.smoothScrollTo(0, 0);
    }
}
