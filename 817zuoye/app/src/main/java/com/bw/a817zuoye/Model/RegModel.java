package com.bw.a817zuoye.Model;

import android.util.Log;

import com.bw.a817zuoye.Api;
import com.bw.a817zuoye.App;
import com.bw.a817zuoye.Bean.RegBean;
import com.bw.a817zuoye.CallBack.RegCallBack;
import com.bw.a817zuoye.Contract.RegContract;
import com.bw.a817zuoye.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:26
 * author:HanXiaoYang
 * Describe:
 */
class RegModel implements RegContract.IRegModel {
    private static final String TAG = "RegModel";
    @Override
    public void Reg(String username, String password, String repassword, Observer<RegBean> callBack) {
        RetrofitManager.getInstance().getRetrofit("https://www.wanandroid.com/")
                .create(Api.class)
                .reg(username,password,repassword)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(callBack);

    }

    @Override
    public void destroy() {

    }
}
