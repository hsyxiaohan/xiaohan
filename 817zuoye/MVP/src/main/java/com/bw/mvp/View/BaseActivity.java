package com.bw.mvp.View;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.mvp.Presenter.IPresenter;

public
/**
 * 8.12lx
 * Date:2021/8/12
 * Time:14:38
 * author:HanXiaoYang
 * Describe:
 */
abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity,IView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.destroy();
            mPresenter = null;
        }
    }
}
