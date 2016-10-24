package com.pkh.sopt_03_new.ch1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;

public class Ch1Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> mDatas = new ArrayList<String>();

    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch1);

        /**
         * 1. recyclerview 초기화
         */
        recyclerView = (RecyclerView)findViewById(R.id.recylerView);
        //각 item의 크기가 일정할 경우 고정
        recyclerView.setHasFixedSize(true);


        //TODO LayoutManager 초기화
        // layoutManager 설정
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        /**
         * 2. recyclerview에 보여줄 data
         */
        mDatas.add("List1");
        mDatas.add("List2");
        mDatas.add("List3");
        mDatas.add("List4");
        mDatas.add("List5");
        mDatas.add("List6");
        mDatas.add("List7");
        mDatas.add("List8");
        mDatas.add("List9");
        mDatas.add("List10");
        mDatas.add("List11");
        mDatas.add("List12");
        mDatas.add("List13");

        /**
         * 3. Adapter 생성 후 recyclerview에 지정
         */
        Ch1Adapter adapter = new Ch1Adapter(mDatas);

        recyclerView.setAdapter(adapter);
    }
}
