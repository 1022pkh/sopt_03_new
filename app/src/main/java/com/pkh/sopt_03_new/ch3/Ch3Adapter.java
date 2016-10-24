package com.pkh.sopt_03_new.ch3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;

/**
 * Created by kh on 2016. 10. 24..
 */
public class Ch3Adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<String> itemDatas;
    View.OnClickListener mOnClickListener;

    public Ch3Adapter(ArrayList<String> itemDatas,View.OnClickListener mOnClickListener) {
        this.itemDatas = itemDatas;
        this.mOnClickListener = mOnClickListener;

    }

    @Override
    //ViewHolder 생성
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        itemView.setOnClickListener(mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(itemDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return (itemDatas != null) ? itemDatas.size() : 0;
    }
}
