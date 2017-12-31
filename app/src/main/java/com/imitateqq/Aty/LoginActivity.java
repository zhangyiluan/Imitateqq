package com.imitateqq.Aty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imitateqq.R;
import com.imitateqq.net.GetCode;
import com.imitateqq.net.Login;
import com.imitateqq.tools.Config;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
    @InjectView(R.id.username_inputbox)
    EditText etPhoneNumber;
    @InjectView(R.id.security_btn)
    Button btnGetCode;
    @InjectView(R.id.password_inputbox)
    EditText etCode;
    @InjectView(R.id.login_btn)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etPhoneNumber.getText())) {
                    Toast.makeText(LoginActivity.this, R.string.phone_num_can_not_be_empty, Toast.LENGTH_SHORT).show();
                    ;
                    return;
                }
                final ProgressDialog pd = ProgressDialog.show(LoginActivity.this, getResources().getString(R.string.connecting), getResources().getString(R.string.connecting_to_server));
                new GetCode(etPhoneNumber.getText().toString(), new GetCode.SuccessCallback() {
                    @Override
                    public void onSuccess() {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, R.string.suc_to_get_code, Toast.LENGTH_SHORT).show();

                    }
                }, new GetCode.FailCallback() {
                    @Override
                    public void onFail() {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, R.string.fail_to_get_code, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etPhoneNumber.getText())) {
                    Toast.makeText(LoginActivity.this, R.string.phone_num_can_not_be_empty, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etCode.getText())) {
                    Toast.makeText(LoginActivity.this, R.string.code_can_not_be_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                final ProgressDialog pd = ProgressDialog.show(LoginActivity.this, getResources().getString(R.string.connecting), getResources().getString(R.string.connecting_to_server));

                new Login(etPhoneNumber.getText().toString(), etCode.getText().toString(), new Login.SuccessCallback() {
                    @Override
                    public void onSuccess(String token) {
                        pd.dismiss();

                        Config.cacheToken(LoginActivity.this, token);     // 缓存token
                        Config.cachePhoneNum(LoginActivity.this, etPhoneNumber.getText().toString()); // PhoneNumbern
                        Intent i = new Intent(LoginActivity.this, LockActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.putExtra(Config.KEY_TOKEN, token);
                        i.putExtra(Config.KEY_PHONE_NUM, etPhoneNumber.getText().toString());
                        startActivity(i);

                        finish();
                    }
                }, new Login.FailCallback() {
                    @Override
                    public void onFail() {
                        pd.dismiss();

                        Toast.makeText(LoginActivity.this, R.string.fail_to_login, Toast.LENGTH_SHORT).show();
                    }
                }
                );
            }
        });
    }
}
