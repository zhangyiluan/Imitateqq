package com.imitateqq.Aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.imitateqq.Fragment.LayoutChats;
import com.imitateqq.Fragment.LayoutContacts;
import com.imitateqq.Fragment.MyFragment;
import com.imitateqq.R;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    private FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private View mainView , slideView;
    private RadioButton msg_rbtn;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initData();


    }
    void initData(){
         msg_rbtn = (RadioButton) findViewById(R.id.msg_rbtn);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        msg_rbtn.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);

        fragmentTransaction.add(R.id.fragment, new LayoutChats());
        fragmentTransaction.commit();
    }

    void switchFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.msg_rbtn:
                switchFragment(new LayoutChats());
                break;
            case R.id.contact_rbtn:
                switchFragment(new LayoutContacts());
                break;
            case R.id.qzone_rbtn:
                switchFragment(new MyFragment());
                break;
        }
    }


}
