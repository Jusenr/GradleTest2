package com.jusenr.gradletest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("tag", BuildConfig.DOMAIN_NAME);


        TextView tv_version_name = (TextView) findViewById(R.id.tv_version_name);
        TextView tv_version_code = (TextView) findViewById(R.id.tv_version_code);

        tv_version_name.setText(String.format("VersionName %s", BuildConfig.VERSION_NAME));
        tv_version_code.setText(String.format("VersionName %d", BuildConfig.VERSION_CODE));
    }
}
