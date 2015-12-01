package com.leeovo.listdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.leeovo.listdemo.R;

/**
 * Created by leeovo on 2015/10/21.
 */
public class ActivityFragment extends Fragment {



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_activity, null);

            return view;
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


