package com.jusenr.gradletest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("tag", BuildConfig.DOMAIN_NAME);


        TextView tv_version_name = (TextView) findViewById(R.id.tv_version_name);
        TextView tv_version_code = (TextView) findViewById(R.id.tv_version_code);
        ImageView iv_image = (ImageView) findViewById(R.id.iv_image);
        ImageView iv_image1 = (ImageView) findViewById(R.id.iv_image1);

        tv_version_name.setText(String.format("VersionName %s", BuildConfig.VERSION_NAME));
        tv_version_code.setText(String.format("VersionName %d", BuildConfig.VERSION_CODE));
        Glide.with(this)
                .load(BuildConfig.DOMAIN_NAME + "58pic/17/89/50/55a65ec4979a9_1024.jpg")
                .into(iv_image)
                .onLoadFailed(getResources().getDrawable(R.mipmap.ic_launcher));
        Glide.with(this)
                .load(BuildConfig.DOMAIN_NAME + "00/19/98/16pic_1998000_b.jpg")
                .into(iv_image1)
                .onLoadFailed(getResources().getDrawable(R.mipmap.ic_launcher));

    }
}
