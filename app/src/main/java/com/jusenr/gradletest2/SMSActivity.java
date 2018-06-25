package com.jusenr.gradletest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class SMSActivity extends AppCompatActivity implements SMSSDK.VerifyCodeReadListener {
    private EventHandler eventHandler;
    private EditText mEtPhone;
    private EditText mEtCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        SMSSDK.setAskPermisionOnReadContact(true);

        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable) data;
                    String msg = throwable.getMessage();
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);


        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtCode = (EditText) findViewById(R.id.et_sms_verification_code);
        findViewById(R.id.btn_send_verification_code).setOnClickListener(v -> {
            String phone = mEtPhone.getText().toString().trim();
            String code = mEtCode.getText().toString().trim();
            if (!TextUtils.isEmpty(phone)) {
                SMSSDK.getVerificationCode("+86", phone, (s, s1) -> {
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    return false;
                });
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(v -> {

        });
    }

    @Override
    public void onReadVerifyCode(String s) {
        mEtCode.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
