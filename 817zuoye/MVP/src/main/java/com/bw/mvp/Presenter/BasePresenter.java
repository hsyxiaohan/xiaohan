package com.bw.mvp.Presenter;

import com.bw.mvp.Model.IModel;
import com.bw.mvp.View.IView;

import io.reactivex.disposables.Disposable;

public
/**
 * 8.12lx
 * Date:2021/8/12
 * Time:14:31
 * author:HanXiaoaYang
 * Describe:
 */
class BasePresenter<M extends IModel,V extends IView> implements IPresenter{

    protected M mModel;
    protected V mView;
    protected Disposable disposable;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void destroy() {
        if (mModel != null){
            mModel.destroy();
            mModel = null;
        }
        if (!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
