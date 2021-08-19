package com.bw.a817zuoye;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bw.mvp.View.BaseActivity;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;


@Route(path = "/bbb/ccc")
public class MainActivity extends BaseActivity {


    private android.widget.Button btn1;
    private android.widget.Button btn2;
    private android.widget.Button btn3;
    private android.widget.ImageView img;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        requestPermissions(new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        },100);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        img = findViewById(R.id.img);
    }

    @Override
    public void initData() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(6000);
                animatorSet.setInterpolator(new LinearInterpolator());
                ObjectAnimator translationY = ObjectAnimator.ofFloat(btn1, "translationY", 0, 200);
                ObjectAnimator translationX = ObjectAnimator.ofFloat(btn1, "translationX", 0, -100);
                ObjectAnimator rotation = ObjectAnimator.ofFloat(btn1, "rotation", 0, 360);
                animatorSet.play(translationX).after(translationY).with(rotation);
                animatorSet.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                Bitmap qrCode = CodeCreator.createQRCode("阿巴阿巴阿巴", 200, 200, bitmap);
                img.setImageBitmap(qrCode);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            if (data != null){
                String stringExtra = data.getStringExtra(Constant.CODED_CONTENT);
                showToast("扫描结果为："+stringExtra);
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}