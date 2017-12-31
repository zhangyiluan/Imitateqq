package com.imitateqq.Aty;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.imitateqq.R;

/**
 * Created by Administrator on 2017/12/19.
 */

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();//隐藏标题栏
        TextView title = (TextView) findViewById(R.id.title_tv);
        Button button = (Button) findViewById(R.id.header_imgbtn);
        title.setText("设置");
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("");
    }
}
