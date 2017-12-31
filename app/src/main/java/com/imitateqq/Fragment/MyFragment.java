package com.imitateqq.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.imitateqq.Aty.SettingActivity;
import com.imitateqq.R;

/**
 * Created by mummyding on 15-8-14.
 */
public class MyFragment extends Fragment {
    private TextView setting;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_my_fragment,null);
        TextView title = (TextView) view.findViewById(R.id.title_tv);
        Button button = (Button) view.findViewById(R.id.header_imgbtn);
        title.setText("我");
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("");
        setting=(TextView)view.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
                                       @Override public void onClick(View view) {
                                           Intent intent = new Intent(getActivity(), SettingActivity.class);
                                           startActivity(intent);
                                       }
        });
        return view;
    }

}
