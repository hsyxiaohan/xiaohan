package com.bw.a817zuoye.Contract;

import com.bw.a817zuoye.Bean.LoginBean;
import com.bw.a817zuoye.CallBack.LoginCallBack;
import com.bw.mvp.Model.IModel;
import com.bw.mvp.View.IView;

public
/**
 * 8.17zuoye
 * Date:2021/8/19
 * Time:8:27
 * author:HanXiaoYang
 * Describe:
 */
interface LoginContract {

    interface ILoginModel extends IModel{
        void login(String username, String password, LoginCallBack callBack);
    }

    interface ILoginView extends IView{
        void Success(LoginBean loginBean);
    }

}
