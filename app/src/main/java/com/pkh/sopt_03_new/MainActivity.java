package com.pkh.sopt_03_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pkh.sopt_03_new.ch1.Ch1Activity;
import com.pkh.sopt_03_new.ch2.Ch2Activity;
import com.pkh.sopt_03_new.ch3.Ch3Activity;
import com.pkh.sopt_03_new.ch4.Ch4Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button chBtn1;
    Button chBtn2;
    Button chBtn3;
    Button chBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 버튼 초기화
         */
        chBtn1 = (Button)findViewById(R.id.moveCh1);
        chBtn2 = (Button)findViewById(R.id.moveCh2);
        chBtn3 = (Button)findViewById(R.id.moveCh3);
        chBtn4 = (Button)findViewById(R.id.moveCh4);

        /**
         * 클릭 이벤트 부여
         * 여러개의 버튼에 클릭이벤트를 부여할 경우
         * onclickListener를 interface를 하여
         * 하나의 onClick 콜백메스드에서 작업하면 좋다.
         */
        chBtn1.setOnClickListener(this);
        chBtn2.setOnClickListener(this);
        chBtn3.setOnClickListener(this);
        chBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        /**
         * switch 문을 통해서
         * 각 id에 해당하는 메소드를 실행할 수 있도록 한다.
         */
        Intent intent;
        switch (view.getId()){
            case R.id.moveCh1:
                intent = new Intent(getApplicationContext(), Ch1Activity.class);
                startActivity(intent);
                break;
            case R.id.moveCh2:
                intent = new Intent(getApplicationContext(), Ch2Activity.class);
                startActivity(intent);
                break;
            case R.id.moveCh3:
                intent = new Intent(getApplicationContext(), Ch3Activity.class);
                startActivity(intent);
                break;
            case R.id.moveCh4:
                intent = new Intent(getApplicationContext(), Ch4Activity.class);
                startActivity(intent);
                break;
        }

    }
}
