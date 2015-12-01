package com.leeovo.listdemo.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.leeovo.listdemo.R;

/**
 * Created by leeovo on 2015/11/30.
 */
public class ImageSliderView extends BaseSliderView {

    public ImageSliderView (Context context){
        super(context);

    }

    @Override
    public View getView() {

        View localView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_near, null);
        bindEventAndShow(localView, (ImageView) localView);
        return localView;
    }
}
