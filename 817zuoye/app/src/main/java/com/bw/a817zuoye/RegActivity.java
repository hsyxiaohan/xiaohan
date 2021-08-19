package com.bw.a817zuoye;

import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.a817zuoye.Bean.RegBean;
import com.bw.a817zuoye.Contract.RegContract;
import com.bw.a817zuoye.Model.RegModel;
import com.bw.a817zuoye.Presenter.RegPresenter;
import com.bw.mvp.View.BaseActivity;

import io.reactivex.Observer;
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
 * Time:10:06
 * author:HanXiaoYang
 * Describe:
 */
class RegActivity extends BaseActivity<RegPresenter> implements RegContract.IRegView {
    private android.widget.EditText regUsername;
    private android.widget.EditText regPassword;
    private android.widget.EditText regRepassword;
    private android.widget.Button reg;
    private static final String TAG = "RegActivity";
    @Override
    public int bindLayout() {
        return R.layout.activity_reg;
    }

    @Override
    public void initView() {
        regUsername = findViewById(R.id.reg_username);
        regPassword = findViewById(R.id.reg_password);
        regRepassword = findViewById(R.id.reg_repassword);
        reg = findViewById(R.id.reg);
        mPresenter = new RegPresenter(new RegModel(),this);
    }

    @Override
    public void initData() {
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.Reg(regUsername.getText().toString(),regPassword.getText().toString(),regRepassword.getText().toString());

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
    public void onSuccess(RegBean regBean) {
        if (regBean.getErrorCode() != -1){
            ARouter.getInstance().build("/aaa/bbb").navigation();
        }else {
            showToast("注册失败");
        }
    }
}
