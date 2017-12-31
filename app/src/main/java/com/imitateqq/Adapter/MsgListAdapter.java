package com.imitateqq.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.imitateqq.R;
import com.imitateqq.CustomerView.AvatarImageView;
import com.imitateqq.Item.MsgListItem;

import java.util.List;

/**
 * Created by mummyding on 15-8-14.
 */
public class MsgListAdapter extends ArrayAdapter<MsgListItem> {
    Context context;
    public MsgListAdapter(Context context, int resource, List<MsgListItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MsgListItem msgListItem = getItem(position);
        View view;
        ViewHolder viewHolder = new ViewHolder();

        if(convertView == null){
            view = View.inflate(context, R.layout.msg_list_item,null);
            viewHolder.avatarImageView = (AvatarImageView) view.findViewById(R.id.msg_avatar);
            viewHolder.nickname = (TextView) view.findViewById(R.id.msg_nickname);
            viewHolder.msg_info = (TextView) view.findViewById(R.id.msg_info);
            viewHolder.msg_num = (TextView) view.findViewById(R.id.msg_number);
            viewHolder.time = (TextView) view.findViewById(R.id.msg_time);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        setViewData(viewHolder,msgListItem);
        return view;
    }
    void setViewData(ViewHolder viewHolder,MsgListItem msgListItem) {
        viewHolder.avatarImageView.setImageResource(msgListItem.getAvatar_img());
        viewHolder.nickname.setText(msgListItem.getNickname());
        viewHolder.msg_num.setText(msgListItem.getMsg_number());
        viewHolder.msg_info.setText(msgListItem.getMsg_info());
        viewHolder.time.setText(msgListItem.getTime());
    }
    class ViewHolder{
        AvatarImageView avatarImageView;
        TextView nickname;
        TextView msg_info;
        TextView time;
        TextView msg_num;
    }
}
