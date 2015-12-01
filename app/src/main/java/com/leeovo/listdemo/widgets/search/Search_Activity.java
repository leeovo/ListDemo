package com.leeovo.listdemo.widgets.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leeovo.listdemo.ListActivity;
import com.leeovo.listdemo.R;

/**
 * Created by leeovo on 2015/10/28.
 */


public class Search_Activity extends BaseActivity{

        private EditText et_search;

        private IconCenterEditText icet_search;

        private Button btn_back ;


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        iniView();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(Search_Activity.this, ListActivity.class);
                startActivity(intent_back);
            }
        });




    }*/





        @Override
        public void iniView() {
            setContentView(R.layout.search);

            //et_search = (EditText) findViewById(R.id.et_search);
            icet_search = (IconCenterEditText) findViewById(R.id.icet_search);
            btn_back = (Button) findViewById(R.id.btn_search_cancel);

            // 实现TextWatcher监听即可
            icet_search.setOnSearchClickListener(new IconCenterEditText.OnSearchClickListener() {
                @Override
                public void onSearchClick(View view) {
                    Toast.makeText(Search_Activity.this, "i'm going to seach", Toast.LENGTH_SHORT).show();
                }
            });

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent_back = new Intent(Search_Activity.this, ListActivity.class);
                    startActivity(intent_back);*/
                    finish();

                }
            });
        }

}



