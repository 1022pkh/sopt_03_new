package com.pkh.sopt_03_new.ch2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pkh.sopt_03_new.R;

/**
 * Created by kh on 2016. 10. 24..
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView;
    TextView contentView;

    public ViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.imageView1);
        titleView = (TextView)itemView.findViewById(R.id.titleTextView);
        contentView =(TextView)itemView.findViewById(R.id.contentTextView);
    }
}
