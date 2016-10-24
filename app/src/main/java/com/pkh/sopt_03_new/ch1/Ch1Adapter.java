package com.pkh.sopt_03_new.ch1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;

/**
 * Created by kh on 2016. 10. 24..
 */
public class Ch1Adapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<String> itemDatas;

    public Ch1Adapter(ArrayList<String> itemDatas) {
        this.itemDatas = itemDatas;
    }

    @Override
    //ViewHolder 생성
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

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
