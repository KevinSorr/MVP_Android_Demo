package com.kell.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kell.bean.User;
import com.kell.view.R;

import java.util.List;

/**
 * Created by ydm on 2016/10/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<User> users;
    private Context context;
    private LayoutInflater inflater;


    public RecyclerViewAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.userInfo.setText(users.get(position).getUname() + "," + users.get(position).getUpwd());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView userInfo;

        public RecyclerViewHolder(View view) {
            super(view);
            userInfo = (TextView) view.findViewById(R.id.user_info);
        }
    }

    public void updateUI(){
       notifyItemChanged(getItemCount() - 1);
    }
}
