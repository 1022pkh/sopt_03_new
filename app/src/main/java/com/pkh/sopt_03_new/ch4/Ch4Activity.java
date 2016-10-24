package com.pkh.sopt_03_new.ch4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;
import java.util.Locale;

public class Ch4Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;

    ArrayList<String> mDatas = new ArrayList<String>();;
    LinearLayoutManager mLayoutManager;
    Ch4Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch4);


        /**
         * 1. recyclerview 초기화
         */
        editText = (EditText)findViewById(R.id.editText1);

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
        mDatas.add(0,"이경호");
        mDatas.add(0,"홍석정");
        mDatas.add(0,"이재현");
        mDatas.add(0,"김유정");
        mDatas.add(0,"박경현");
        mDatas.add(0,"이경욱");
        mDatas.add(0,"양용기");
        mDatas.add(0,"안드로이드");
        mDatas.add(0,"서버");
        mDatas.add(0,"iOS");

        /**
         * 3. Adapter 생성 후 recyclerview에 지정
         */
        adapter = new Ch4Adapter(mDatas);
        recyclerView.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
}
