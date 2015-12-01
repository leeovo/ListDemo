package com.leeovo.listdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeovo.listdemo.widgets.ImageSliderView;
import com.leeovo.listdemo.R;

import com.daimajia.slider.library.SliderLayout;

/**
 * Created by leeovo on 2015/10/21.
 * 
 */
public class NearFragment extends Fragment{

    private SliderLayout mAdSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_near, null);

        mAdSlider = (SliderLayout) view.findViewById(R.id.slider);

        return view;
    }


 /*   @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mAdSlider.stopAutoCycle();
        super.onStop();
    }*/

    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        this.mAdSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        this.mAdSlider.setDuration(4000);
        this.mAdSlider.addSlider(new ImageSliderView(getContext()).image(R.drawable.hannibal));
        this.mAdSlider.addSlider(new ImageSliderView(getContext()).image(R.drawable.bigbang));
        this.mAdSlider.addSlider(new ImageSliderView(getContext()).image(R.drawable.house));
        this.mAdSlider.addSlider(new ImageSliderView(getContext()).image(R.drawable.game_of_thrones));
    }


}
