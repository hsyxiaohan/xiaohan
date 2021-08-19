package com.bw.a817zuoye.Presenter;

import com.bw.a817zuoye.Bean.LoginBean;
import com.bw.a817zuoye.CallBack.LoginCallBack;
import com.bw.a817zuoye.Contract.LoginContract;
import com.bw.mvp.Presenter.BasePresenter;

public
/**
 * 8.17zuoye
 * Date:2021/8/19
 * Time:8:30
 * author:HanXiaoYang
 * Describe:
 */
class LoginPresenter extends BasePresenter<LoginContract.ILoginModel,LoginContract.ILoginView> {

    public LoginPresenter(LoginContract.ILoginModel mModel, LoginContract.ILoginView mView) {
        super(mModel, mView);
    }

    public void login(String username,String password){
        mModel.login(username, password, new LoginCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                mView.Success(loginBean);
            }
        });
    }
}
