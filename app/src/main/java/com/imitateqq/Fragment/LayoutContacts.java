package com.imitateqq.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imitateqq.Adapter.AdapterUserItem;
import com.imitateqq.Aty.AtyAddUser;
import com.imitateqq.CustomerView.PicAndTextBtn;
import com.imitateqq.R;
import com.imitateqq.util.UserItemMsg;

import java.util.ArrayList;
import java.util.List;


public class LayoutContacts extends Fragment {

    private View rootView;
    private Context context;
    private List<UserItemMsg> groupMsgList;
    private List<UserItemMsg> contactMsgList;
    private PicAndTextBtn patbBarGroup;
    private PicAndTextBtn patbBarContact;
    private RecyclerView rvGroup;
    private RecyclerView rvContact;
    private TextView add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_contact_fragment, container, false);
        this.context = inflater.getContext();
        initGroupViews();
        initContactViews();

        add=(TextView)rootView.findViewById(R.id.header_imgbtn_con);
        add.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AtyAddUser.class);
                startActivity(intent);
            }
        });


        return rootView;
    }

    private void initGroupViews() {
        patbBarGroup = (PicAndTextBtn) rootView.findViewById(R.id.patb_bar_groups);
        rvGroup = (RecyclerView) rootView.findViewById(R.id.rv_list_groups);

        groupMsgList = new ArrayList<>();

//        loadGroups();

        AdapterUserItem adapterGroup = new AdapterUserItem(context, groupMsgList);
        rvGroup.setLayoutManager(new LinearLayoutManager(context));
        rvGroup.setAdapter(adapterGroup);

        patbBarGroup.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvGroup.getVisibility() == View.VISIBLE) {
                    rvGroup.setVisibility(View.GONE);
                    patbBarGroup.setImageView(R.drawable.shink);
                } else {
                    rvGroup.setVisibility(View.VISIBLE);
                    patbBarGroup.setImageView(R.drawable.rise);
                }
            }
        });
    }

    private void initContactViews() {
        patbBarContact = (PicAndTextBtn) rootView.findViewById(R.id.patb_bar__contacts);
        rvContact = (RecyclerView) rootView.findViewById(R.id.rv_list_contacts);

        contactMsgList = new ArrayList<UserItemMsg>();

//        loadFriends();
        UserItemMsg msgListItem1 =  new UserItemMsg(R.drawable.avatar,001,"MummyDing","小怪兽喜欢奥特曼","");
        contactMsgList.add(msgListItem1);
        UserItemMsg msgListItem2 =  new UserItemMsg(R.drawable.avatar_01,002,"我","超级美少女战士","");
        contactMsgList.add(msgListItem2);

        AdapterUserItem adapterContact = new AdapterUserItem(context, contactMsgList);
        rvContact.setLayoutManager(new LinearLayoutManager(context));
        rvContact.setAdapter(adapterContact);

        patbBarContact.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvContact.getVisibility() == View.VISIBLE) {
                    rvContact.setVisibility(View.GONE);
                    patbBarContact.setImageView(R.drawable.shink);
                } else {
                    rvContact.setVisibility(View.VISIBLE);
                    patbBarContact.setImageView(R.drawable.rise);
                }
            }
        });
    }


}
