package com.leeovo.listdemo.base;

import android.app.Application;
import android.content.res.Configuration;
import android.provider.SyncStateContract;

/**
 * Created by leeovo on 2015/11/3.
 *@description 应用基础
 */
public class BaseApplication extends Application{

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //重新加载activity时执行onConfigurationChanged（），不是onCreate(),避免重复初始化丢失数据
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //ImageLoaderConfig.initImageLoader(this, SyncStateContract.Constants.BASE_IMAGE_CACHE);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
