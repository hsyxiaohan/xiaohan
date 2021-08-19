package com.bw.a817zuoye.Presenter;

import android.util.Log;

import com.bw.a817zuoye.Bean.RegBean;
import com.bw.a817zuoye.CallBack.RegCallBack;
import com.bw.a817zuoye.Contract.RegContract;
import com.bw.mvp.Presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:31
 * author:HanXiaoYang
 * Describe:
 */
class RegPresenter extends BasePresenter<RegContract.IRegModel,RegContract.IRegView> {
    public RegPresenter(RegContract.IRegModel mModel, RegContract.IRegView mView) {
        super(mModel, mView);
    }

    public void Reg(String username,String password,String repassword){
        mModel.Reg(username, password, repassword, new Observer<RegBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull RegBean regBean) {
                mView.onSuccess(regBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("TAG", "onError: "+e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
