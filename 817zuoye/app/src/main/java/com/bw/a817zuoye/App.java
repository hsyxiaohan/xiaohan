package com.bw.a817zuoye;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:54
 * author:HanXiaoYang
 * Describe:
 */
class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
