package com.bw.a817zuoye.Contract;

import android.widget.EditText;

import com.bw.a817zuoye.Bean.RegBean;
import com.bw.a817zuoye.CallBack.RegCallBack;
import com.bw.mvp.Model.IModel;
import com.bw.mvp.View.IView;

import io.reactivex.Observer;

public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:24
 * author:HanXiaoYang
 * Describe:
 */
interface RegContract {

    interface IRegModel extends IModel{
        void Reg(String username, String password, String repassword, Observer<RegBean> regBean);
    }

    interface IRegView extends IView{
        void onSuccess(RegBean regBean);
    }

}
