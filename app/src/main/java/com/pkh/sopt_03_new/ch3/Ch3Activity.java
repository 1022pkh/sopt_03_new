package com.pkh.sopt_03_new.ch3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pkh.sopt_03_new.R;

import java.util.ArrayList;

public class Ch3Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    Button addBtn;

    Ch3Adapter adapter;
    ArrayList<String> mDatas = new ArrayList<String>();;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3);


        /**
         * 1. recyclerview 초기화
         */
        editText = (EditText)findViewById(R.id.editText1);
        addBtn = (Button)findViewById(R.id.addBtn);

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
        mDatas.add(0,"List1");
        mDatas.add(0,"List2");
        mDatas.add(0,"List3");
        mDatas.add(0,"List4");
        mDatas.add(0,"List5");

        /**
         * 3. Adapter 생성 후 recyclerview에 지정
         */
        adapter = new Ch3Adapter(mDatas,deleteEvent);

        recyclerView.setAdapter(adapter);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = editText.getText().toString();

                if (temp.length() != 0 ) {
                    mDatas.add(0,temp);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
    }

    public View.OnClickListener deleteEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = recyclerView.getChildPosition(v);

            AlertDialog.Builder builder = new AlertDialog.Builder(Ch3Activity.this);     // 여기서 this는 Activity의 this

            // 여기서 부터는 알림창의 속성 설정
            builder.setMessage("삭제하시겠습니까?")        // 메세지 설정
                    .setCancelable(true)        // 뒤로 버튼 클릭시 취소 가능 설정
                    .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                        // 확인 버튼 클릭시 설정
                        public void onClick(DialogInterface dialog, int whichButton){
                            mDatas.remove(itemPosition) ;
                            // 2. listview 갱신.
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                        // 취소 버튼 클릭시 설정
                        public void onClick(DialogInterface dialog, int whichButton){
                            dialog.cancel();
                        }
                    });

            AlertDialog dialog = builder.create();    // 알림창 객체 생성
            dialog.show();    // 알림창 띄우기
        }
    };
}
