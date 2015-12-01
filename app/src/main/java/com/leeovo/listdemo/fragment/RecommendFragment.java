package com.leeovo.listdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.leeovo.listdemo.Activity_tuijian1;
import com.leeovo.listdemo.Activiy_bdtj;
import com.leeovo.listdemo.R;
import com.leeovo.listdemo.widgets.SlidingSwitcherView;
import com.leeovo.listdemo.widgets.search.Search_Activity;

/**
 * Created by leeovo on 2015/10/21.
 *
 *
 */
public class RecommendFragment extends Fragment implements OnClickListener{

    private ImageButton btn_search;

    private ImageButton btn_share;

    private ImageButton btn_tuijian1;

    private TextView bdtj_biaoti;
    private Button bdtj_more;
    private TextView ycgq_biaoti;
    private TextView ycgq_more;

    private ScrollView mScrollView;

    private SlidingSwitcherView mSliding;

    private SlidingSwitcherView mSliding1;

    private float xDown;
    private float xMove;
    private float xUp;

    private float yDown;
    private float yMove;
    private float yUp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend, null);

        btn_search = (ImageButton) view.findViewById(R.id.search_button);
        btn_share = (ImageButton) view.findViewById(R.id.share_button);

        btn_tuijian1 = (ImageButton) view.findViewById(R.id.btn_tuijian1);

        mScrollView = (ScrollView) view.findViewById(R.id.scrollView);

        mSliding = (SlidingSwitcherView) view.findViewById(R.id.slidingLayout);


        bdtj_biaoti = (TextView) view.findViewById(R.id.bdtj_biaoti);
        bdtj_more = (Button) view.findViewById(R.id.bdtj_more);
        ycgq_biaoti = (TextView) view.findViewById(R.id.ycgq_biaoti);
        ycgq_more = (TextView) view.findViewById(R.id.ycgq_more);


        btn_search.setOnClickListener(this);
        btn_tuijian1.setOnClickListener(this);

        bdtj_biaoti.setOnClickListener(this);
        bdtj_more.setOnClickListener(this);
        ycgq_biaoti.setOnClickListener(this);
        ycgq_more.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v){

        switch (v.getId()){

            case R.id.search_button:
                Intent search_intent = new Intent(getActivity(), Search_Activity.class);
                getActivity().startActivity(search_intent);
                break;

            case R.id.bdtj_more:
                Intent bdtj_intent = new Intent(getActivity(), Activiy_bdtj.class);
                getActivity().startActivity(bdtj_intent);
                break;

            case R.id.btn_tuijian1:
                if(SlidingSwitcherView.getweiyi()){
                    Intent tuijian1_intent = new Intent(getActivity(), Activity_tuijian1.class);
                    getActivity().startActivity(tuijian1_intent);
                }

                break;

            default:
                break;

        }

    }






    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }

}


/*

mSliding.setOnTouchListener(new View.OnTouchListener() {
@Override
public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
        case MotionEvent.ACTION_MOVE:
        yMove = event.getRawY();
        xMove = event.getRawX();
        if (yMove > xMove){
        mScrollView.requestDisallowInterceptTouchEvent(false);
        }
        else {
        mScrollView.requestDisallowInterceptTouchEvent(true);
        }
        break;
        }
        return false;
        }
        });

*/
