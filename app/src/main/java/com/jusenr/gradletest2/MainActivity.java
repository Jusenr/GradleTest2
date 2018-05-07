package com.jusenr.gradletest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jusenr.toolslibrary.log.logger.Logger;
import com.jusenr.toolslibrary.utils.DateUtils;
import com.jusenr.toolslibrary.utils.ToastUtils;

/**
 * 测试
 */
public class MainActivity extends AppCompatActivity {
//    @see [http://tx.haiqq.com/uploads/allimg/150401/200234AJ-5.jpg]
//    @see [http://pic.qiantucdn.com/58pic/17/89/50/55a65ec4979a9_1024.jpg]
//    @see [http://pic1.16pic.com/00/19/98/16pic_1998000_b.jpg]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("tag", BuildConfig.DOMAIN_NAME);

        TextView tv_version_name = (TextView) findViewById(R.id.tv_version_name);
        TextView tv_version_code = (TextView) findViewById(R.id.tv_version_code);
        TextView tv_build_type = (TextView) findViewById(R.id.tv_build_type);
        ImageView iv_image = (ImageView) findViewById(R.id.iv_image);
        ImageView iv_image1 = (ImageView) findViewById(R.id.iv_image1);
        ImageView iv_image2 = (ImageView) findViewById(R.id.iv_image2);
        TextView tv_domain_name = (TextView) findViewById(R.id.tv_domain_name);
        TextView tv_is_just_test = (TextView) findViewById(R.id.tv_is_just_test);
        TextView tv_log_debug = (TextView) findViewById(R.id.tv_log_debug);
        TextView tv_flavor = (TextView) findViewById(R.id.tv_flavor);

        tv_version_name.setText(String.format("VERSION_NAME: %s", BuildConfig.VERSION_NAME));
        tv_version_code.setText(String.format("VERSION_CODE: %d", BuildConfig.VERSION_CODE));
        tv_build_type.setText(String.format("BUILD_TYPE: %s", BuildConfig.BUILD_TYPE));
        tv_flavor.setText(String.format("FLAVOR: %s", BuildConfig.FLAVOR));
        Glide.with(this)
                .load(BuildConfig.DOMAIN_NAME + "58pic/17/89/50/55a65ec4979a9_1024.jpg")
                .into(iv_image)
                .onLoadFailed(getResources().getDrawable(R.mipmap.ic_launcher));
        Glide.with(this)
                .load(BuildConfig.DOMAIN_NAME + "00/19/98/16pic_1998000_b.jpg")
                .into(iv_image1)
                .onLoadFailed(getResources().getDrawable(R.mipmap.ic_launcher));
        Glide.with(this)
                .load(BuildConfig.DOMAIN_NAME + "uploads/allimg/150401/200234AJ-5.jpg")
                .into(iv_image2)
                .onLoadFailed(getResources().getDrawable(R.mipmap.ic_launcher));
        tv_domain_name.setText(String.format("DOMAIN_NAME: %s", BuildConfig.DOMAIN_NAME));
        tv_is_just_test.setText(String.format("IS_JUST_TEST: %b", BuildConfig.IS_JUST_TEST));
        tv_log_debug.setText(String.format("LOG_DEBUG: %b", BuildConfig.LOG_DEBUG));

        findViewById(R.id.btn_curweeks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weekInMills = DateUtils.getWeekInMills(System.currentTimeMillis() / 1000);
                String format = String.format("当前是第%d周", weekInMills);
                ToastUtils.showAlertToast(getApplicationContext(), format);
                Logger.i(format);
            }
        });

        findViewById(R.id.btn_showLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.showViewer();
            }
        });
        findViewById(R.id.btn_sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SMSActivity.class));
            }
        });
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TestActivity.class));
            }
        });
    }
}
