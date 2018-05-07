package com.jusenr.gradletest2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {


    private Context mContext;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;
        final View mainView = findViewById(R.id.rl_main);
        findViewById(R.id.tv_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAtLocation(mainView, Gravity.BOTTOM, 0, 0);
            }
        });

        showPop();
    }

    private void showPop() {
        View viewphoto = LayoutInflater.from(this).inflate(R.layout.poppop, null);
        WindowManager winManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = winManager.getDefaultDisplay().getWidth();
        int height = winManager.getDefaultDisplay().getHeight();
//        mPopupWindow = new PopupWindow(viewphoto, width, height);
        mPopupWindow = new PopupWindow(viewphoto, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);
        //处理虚拟按键挡住window
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        TextView img_pz = (TextView) viewphoto.findViewById(R.id.img_pz);//拍照
        img_pz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mPopupWindow) {
                    mPopupWindow.dismiss();
                }
                Toast.makeText(mContext, "拍照", Toast.LENGTH_SHORT).show();
            }
        });
        TextView img_xc = (TextView) viewphoto.findViewById(R.id.img_xc);//相册
        img_xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mPopupWindow) {
                    mPopupWindow.dismiss();
                }
                Toast.makeText(mContext, "相册", Toast.LENGTH_SHORT).show();
            }
        });
        viewphoto.findViewById(R.id.imag_quxiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mPopupWindow) {
                    mPopupWindow.dismiss();
                }
                Toast.makeText(mContext, "dismiss", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
