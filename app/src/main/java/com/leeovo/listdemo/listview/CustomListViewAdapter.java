package com.leeovo.listdemo.listview;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeovo.listdemo.R;

/**
 * Created by leeovo on 2015/11/25.
 *
 */
public class CustomListViewAdapter extends BaseAdapter{

    private Context context = null;
    private LayoutInflater mInflater;


    public CustomListViewAdapter(Context context){

        this.context = context;
        mInflater = LayoutInflater.from(context);

    }

    public Context getContext() {
        return context;
    }

    private CustomListCellData[] data = new CustomListCellData[]{

            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "1"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "2"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "3"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "4"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "5"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "6"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "7"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "8"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "9"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "10"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "11"),
            new CustomListCellData("爱旋转", "奋斗的刚子", R.drawable.bdtj_icon, "12")
    };

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public CustomListCellData getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;


        if (convertView == null){
            convertView = mInflater.inflate(R.layout.custom_listcell, parent, false);
            Log.e("itemcreat","ture");
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.dec = (TextView) convertView.findViewById(R.id.dec);
            viewHolder.paiming = (TextView) convertView.findViewById(R.id.paiming);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);



            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        CustomListCellData data = getItem(position);

        int a = Integer.parseInt(data.getPaiming());

        if (a < 4){
           viewHolder.paiming.setTextColor(Color.parseColor("#ce2a23"));
        } else {
            viewHolder.paiming.setTextColor(Color.parseColor("#000000"));
        }

        viewHolder.icon.setImageResource(data.getIconID());
        viewHolder.name.setText(data.getName());
        viewHolder.dec.setText(data.getDec());
        viewHolder.paiming.setText(data.getPaiming());
        return convertView;

    }

    private final class ViewHolder{
        TextView name;
        TextView dec;
        TextView paiming;
        ImageView icon;

    }



}
