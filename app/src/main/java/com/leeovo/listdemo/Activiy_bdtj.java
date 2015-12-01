package com.leeovo.listdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.leeovo.listdemo.listview.CustomListViewAdapter;

/**
 * Created by leeovo on 2015/11/16.
 *
 */
public class Activiy_bdtj extends Activity{

    private ListView custom_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdtj);

        custom_list = (ListView) findViewById(R.id.listView);
        custom_list.setAdapter(new CustomListViewAdapter(this));

    }

}
