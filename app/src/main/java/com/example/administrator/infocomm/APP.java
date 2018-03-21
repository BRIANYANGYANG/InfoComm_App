package com.example.administrator.infocomm;

import android.app.Application;

import com.dreamlive.cn.clog.CollectLog;


/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class APP  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();


        //自定义日志存放路径,
        //这儿示例就只传了sd根目录下的dreamlivemeng(/storage/emulated/0/dreamlivemeng)，把错误日志写到这个目录下
        CollectLog clog = CollectLog.getInstance();
        clog.init(this, "/sdcard/infocomm/log" );
    }



}
