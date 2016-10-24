package com.pkh.sopt_03_new.ch4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kh on 2016. 10. 24..
 */
public class Ch4Adapter extends RecyclerView.Adapter<ViewHolder> {
    /**
     * 이번 심화과정1
     * 필터기능을 사용해보는 것입니다.
     * 쉽게 생각해서....
     * 항목데이터를 하나의 객체(A)에 저장해둡니다
     * 그리고 검색창에 데이터를 입력할 때마다 항목 데이터가 저장된 객체(A)에서 찾아서
     * 찾은 객체만 따로 모아 객체(B)를 만드는 것이죠
     * 최종적으로는 따로 모은 객체(B)를 뿌려주는 것이죠
     *
     */

    ArrayList<String> totalDatas; // 전체 데이터를 가지고 있는 곳
    ArrayList<String> arSrc; // 화면에 뿌려줄 데이터를 가지고 있는 곳

    public Ch4Adapter(ArrayList<String> itemDatas) {
        arSrc = itemDatas;

        this.totalDatas = new ArrayList<String>();
        this.totalDatas.addAll(arSrc);

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
        holder.textView.setText(arSrc.get(position));

    }

    @Override
    public int getItemCount() {
        return (arSrc != null) ? arSrc.size() : 0;
    }

    // Filter Class
    public void filter(String charText) {
        /**
         * 검색창에 입력한 데이터를 가져오는 것이죠
         * 밑에 toLowerCase()의 경우에는 소문자로 바꿔주는 함수죠
         * 대소문자 구분없이 검색하도록 넣어준 것입니다
         * 만약 대소문자 구분하여 검색하려면 toLowerCase()부분을 제거해주시면 됩니다!
         */
        charText = charText.toLowerCase(Locale.getDefault());

        //먼저 arSrc객체를 비워줍니다.
        arSrc.clear();


        //입력한 데이터가 없을 경우에는 모든 데이터항목을 출력해줍니다.
        if (charText.length() == 0) {
            arSrc.addAll(totalDatas);
        }
        //입력한 데이터가 있을 경우에는 일치하는 항목들만 찾아 출력해줍니다.
        else
        {

            for (int i = 0; i < totalDatas.size() ; i++)
            {
                String wp = totalDatas.get(i);

                if (wp.toLowerCase(Locale.getDefault()).contains(charText))
                {
                    arSrc.add(totalDatas.get(i));

                }
            }
        }

        notifyDataSetChanged();
    }
}
