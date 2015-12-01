package com.leeovo.listdemo.widgets;

import android.graphics.ColorMatrixColorFilter;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by leeovo on 2015/10/29.
 */
/*为了使图片按钮按下和弹起状态不同，采用过滤颜色的方法.按下的时候让图片颜色变淡*/
public class MyOnTouchListener implements View.OnTouchListener {

    public final  float[] BT_SELECTED=new float[]
                    { 1, 0, 0, 0, -75,
                    0, 1, 0, 0, -75,
                    0, 0, 1, 0, -75,
                    0, 0, 0, 1, 0 };

    public final float[] BT_NOT_SELECTED=new float[]
                    { 1, 0, 0, 0, 0,
                    0, 1, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0 };
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
            v.setBackgroundDrawable(v.getBackground());
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
            v.setBackgroundDrawable(v.getBackground());

        }
        return false;
    }

}