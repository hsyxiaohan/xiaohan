package com.bw.a817zuoye.Model;

import com.bw.a817zuoye.Api;
import com.bw.a817zuoye.Bean.LoginBean;
import com.bw.a817zuoye.CallBack.LoginCallBack;
import com.bw.a817zuoye.Contract.LoginContract;
import com.bw.a817zuoye.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public
/**
 * 8.17zuoye
 * Date:2021/8/19
 * Time:8:29
 * author:HanXiaoYang
 * Describe:
 */
class LoginModel implements LoginContract.ILoginModel {
    @Override
    public void login(String username, String password, LoginCallBack callBack) {
        RetrofitManager.getInstance().getRetrofit(Api.url)
                .create(Api.class)
                .login(username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void destroy() {

    }
}
