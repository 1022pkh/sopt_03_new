package com.pkh.sopt_03_new.ch2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;

public class Ch2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ItemDatas> mDatas;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch2);

        recyclerView = (RecyclerView)findViewById(R.id.recylerView);

        //각 item의 크기가 일정할 경우 고정
        recyclerView.setHasFixedSize(true);


        //TODO LayoutManager 초기화
        // layoutManager 설정
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        mDatas = new ArrayList<ItemDatas>();
        mDatas.add(new ItemDatas(R.drawable.ic_teach,"title1","content1"));
        mDatas.add(new ItemDatas(R.drawable.ic_hobby,"title2","content2"));
        mDatas.add(new ItemDatas(R.drawable.ic_ready,"title3","content3"));
        mDatas.add(new ItemDatas(R.drawable.ic_teach,"title4","content4"));
        mDatas.add(new ItemDatas(R.drawable.ic_hobby,"title5","content5"));
        mDatas.add(new ItemDatas(R.drawable.ic_ready,"title6","content6"));
        mDatas.add(new ItemDatas(R.drawable.ic_teach,"title7","content7"));
        mDatas.add(new ItemDatas(R.drawable.ic_hobby,"title8","content8"));
        mDatas.add(new ItemDatas(R.drawable.ic_ready,"title9","content9"));
        mDatas.add(new ItemDatas(R.drawable.ic_teach,"title10","content10"));
        mDatas.add(new ItemDatas(R.drawable.ic_hobby,"title11","content11"));
        mDatas.add(new ItemDatas(R.drawable.ic_ready,"title12","content12"));

        Ch2Adapter adapter = new Ch2Adapter(mDatas,clickEvent);


        recyclerView.setAdapter(adapter);
    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            String temp = mDatas.get(itemPosition).content;
            Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();
        }
    };

}
