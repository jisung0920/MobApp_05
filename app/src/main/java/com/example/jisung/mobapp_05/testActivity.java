package com.example.jisung.mobapp_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class testActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }
    public void B_onClick(View v){
        if (v.getId() == R.id.b2) {
            Toast toastView = Toast.makeText(this,"위치지정 메세지 창입니다.",Toast.LENGTH_SHORT);
            toastView.setGravity(Gravity.LEFT | Gravity.TOP,10,20);//x좌표, y좌표
            toastView.show();
        }
        else if(v.getId() == R.id.b3){

            View view = getLayoutInflater().inflate(R.layout.mytoastxml,null);//xml을 객체화
            TextView msg = (TextView)view.findViewById(R.id.msg);//view 가 xml 이고 거기서 textview를 가져온다
            msg.setText("레이아웃으로 만든 토스트 창입니다.");
            Toast toastView = new Toast(this);


            toastView.setDuration(Toast.LENGTH_SHORT);
            toastView.setGravity(Gravity.CENTER,0,100);
            toastView.setView(view);
            toastView.show();
        }

    }

}
