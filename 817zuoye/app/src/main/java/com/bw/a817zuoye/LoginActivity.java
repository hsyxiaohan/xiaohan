package com.bw.a817zuoye;

import android.Manifest;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.a817zuoye.Bean.LoginBean;
import com.bw.a817zuoye.Contract.LoginContract;
import com.bw.a817zuoye.Model.LoginModel;
import com.bw.a817zuoye.Presenter.LoginPresenter;
import com.bw.mvp.View.BaseActivity;


@Route(path = "/aaa/bbb")
public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:57
 * author:HanXiaoYang
 * Describe:
 */
class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {
    private android.widget.EditText loginUsername;
    private android.widget.EditText loginPassword;
    private android.widget.Button login;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        login = findViewById(R.id.login);
        mPresenter = new LoginPresenter(new LoginModel(),this);
    }

    @Override
    public void initData() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(loginUsername.getText().toString(),loginPassword.getText().toString());
            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void Success(LoginBean loginBean) {
        if (loginBean.getErrorCode() != -1){
            ARouter.getInstance().build("/bbb/ccc").navigation();
        }else {
            showToast("登陆失败");
        }
    }
}
