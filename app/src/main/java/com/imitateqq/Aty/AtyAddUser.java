package com.imitateqq.Aty;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.imitateqq.R;

/**
 * Created by Administrator on 2018/1/6.
 */

public class AtyAddUser extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout_add_user);
        TextView title = (TextView) findViewById(R.id.title_tv);
        Button button = (Button) findViewById(R.id.header_imgbtn);
        title.setText("添加");
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("");
    }
}