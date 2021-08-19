package com.bw.a817zuoye;

import com.bw.a817zuoye.Bean.LoginBean;
import com.bw.a817zuoye.Bean.RegBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public
/**
 * 8.17zuoye
 * Date:2021/8/18
 * Time:16:20
 * author:HanXiaoYang
 * Describe:
 */
interface Api {

    @POST("user/register")
    @FormUrlEncoded
    Observable<RegBean> reg(@Field("username")String username,@Field("password")String password,@Field("repassword")String repassword);

     String url="https://www.wanandroid.com/";

     @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("username")String username,@Field("password")String password);
}
