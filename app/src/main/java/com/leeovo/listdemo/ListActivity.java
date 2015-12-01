package com.leeovo.listdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;

import com.leeovo.listdemo.fragment.ActivityFragment;
import com.leeovo.listdemo.fragment.MyFragment;
import com.leeovo.listdemo.fragment.NearFragment;
import com.leeovo.listdemo.fragment.RecommendFragment;
import com.leeovo.listdemo.widgets.MyOnTouchListener;


public class ListActivity extends FragmentActivity {

    private FrameLayout mHomeContent;
    private RadioGroup mHomeRadioGroup;

    private RadioButton mHomeRecommendRb;

    private RadioButton mHomeNearRb;

    private RadioButton mHomeActivityRb;

    private RadioButton mHomeMyRb;

    private ImageButton mRecordButton;

    static final int NUM_ITEMS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecordButton = (ImageButton) findViewById(R.id.record);

        /*mRecordButton.setOnClickListener((OnClickListener) this);*/

        initView();
        initData();

        mRecordButton.setOnTouchListener(new MyOnTouchListener());

        mRecordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent record_intent = new Intent(ListActivity.this, RecordActivity.class);
                startActivity(record_intent);

            }
        });

    }

    private void initView() {

        mHomeContent = (FrameLayout) findViewById(R.id.content); //tab上方的区域
        mHomeRadioGroup = (RadioGroup) findViewById(R.id.tabbar);  //底部的四个tab
        mHomeRecommendRb = (RadioButton) findViewById(R.id.btn_recommend);
        mHomeNearRb = (RadioButton) findViewById(R.id.btn_near);
        mHomeActivityRb = (RadioButton) findViewById(R.id.btn_activity);
        mHomeMyRb = (RadioButton) findViewById(R.id.btn_my);


        //监听事件：为底部的RadioGroup绑定状态改变的监听事件
        mHomeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.btn_recommend:
                        Log.d("ceshi", "button1");
                        index = 0;
                        break;
                    case R.id.btn_near:
                        Log.d("ceshi", "button2");
                        index = 1;
                        break;
                    case R.id.btn_activity:
                        Log.d("ceshi", "button3");
                        index = 2;
                        break;
                    case R.id.btn_my:
                        Log.d("ceshi", "button4");
                        index = 3;
                        break;
                }
                //通过fragments这个adapter还有index来替换帧布局中的内容
                Fragment fragment = (Fragment) fragments.instantiateItem(mHomeContent, index);
                //一开始将帧布局中 的内容设置为第一个
                fragments.setPrimaryItem(mHomeContent, 0, fragment);
                fragments.finishUpdate(mHomeContent);

            }
        });
    }

    //第一次启动时，我们让mHomeHomeRb这个radiobutton处于选中状态。
    // 当然了，在这之前，先要在布局文件中设置其他的某一个radiobutton（只要不是mHomeHomeRb就行）
    // 的属性为android:checked="true"，才会出发下面的这个check方法切换到mHomeHomeRb
    @Override
    protected void onStart() {
        super.onStart();
        mHomeRadioGroup.check(R.id.btn_recommend);
    }

    //用adapter来管理四个Fragment界面的变化。注意，我这里用的Fragment都是v4包里面的
    FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public int getCount() {
            return NUM_ITEMS;//一共有四个Fragment
        }

        //进行Fragment的初始化
        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0://首页
                    fragment = new RecommendFragment();
                    break;
                case 1://发现
                    fragment = new NearFragment();
                    break;

                case 2://搜索
                    fragment = new ActivityFragment();
                    break;

                case 3://我的
                    fragment = new MyFragment();
                    break;
                default:
                    new RecommendFragment();
                    break;
            }

            return fragment;
        }
    };

    protected void initData() {

    }




}












