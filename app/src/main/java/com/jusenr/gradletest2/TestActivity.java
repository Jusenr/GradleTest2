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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private LinearLayout mMainView;
    private TextView mTvText;

    private Context mContext;
    private PopupWindow mPopupWindow;
    private PopupWindow mPopupWindow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;
        mMainView = findViewById(R.id.rl_main);
        mTvText = findViewById(R.id.tv_text);
        findViewById(R.id.tv_pop).setOnClickListener(v -> {
            if (mPopupWindow == null) {
                showPop();
            }
            mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        });
        findViewById(R.id.tv_pop1).setOnClickListener(v -> {
            if (mPopupWindow1 == null) {
                showPop1();
            }
            mPopupWindow1.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        });

    }

    private void showPop() {
        View viewphoto = LayoutInflater.from(this).inflate(R.layout.poppop, null);
        mPopupWindow = new PopupWindow(viewphoto, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);
        //处理虚拟按键挡住window
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        //拍照
        viewphoto.findViewById(R.id.img_pz).setOnClickListener(v -> Toast.makeText(mContext, "拍照", Toast.LENGTH_SHORT).show());
        //相册
        viewphoto.findViewById(R.id.img_xc).setOnClickListener(v -> Toast.makeText(mContext, "相册", Toast.LENGTH_SHORT).show());
        viewphoto.findViewById(R.id.imag_quxiao).setOnClickListener(v -> {
            mPopupWindow.dismiss();
            Toast.makeText(mContext, "dismiss", Toast.LENGTH_SHORT).show();
        });
    }

    private void showPop1() {
        View viewphoto = LayoutInflater.from(this).inflate(R.layout.poppop, null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mTvText.getLayoutParams();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = layoutParams.height;

        mPopupWindow1 = new PopupWindow(viewphoto, width, height);
        mPopupWindow1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景
        mPopupWindow1.setOutsideTouchable(true);
        mPopupWindow1.setFocusable(true);
        mPopupWindow1.setTouchable(true);
        //处理虚拟按键挡住window
        mPopupWindow1.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        //拍照
        viewphoto.findViewById(R.id.img_pz).setOnClickListener(v -> Toast.makeText(mContext, "拍照", Toast.LENGTH_SHORT).show());
        //相册
        viewphoto.findViewById(R.id.img_xc).setOnClickListener(v -> Toast.makeText(mContext, "相册", Toast.LENGTH_SHORT).show());
        viewphoto.findViewById(R.id.imag_quxiao).setOnClickListener(v -> {
            mPopupWindow1.dismiss();
            Toast.makeText(mContext, "dismiss", Toast.LENGTH_SHORT).show();
        });
    }

}
