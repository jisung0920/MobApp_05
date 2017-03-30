package com.example.jisung.mobapp_05;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class testActivity extends AppCompatActivity {

    int index;
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
        else if(v.getId() == R.id.b4){//ctrl+P 를 누르면 인자 확인
            Snackbar.make(v,"Message",2000).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                }
            }).show();
            //setAction (버튼내용, 이벤트 내용)
        }
        else if(v.getId() == R.id.b5){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            //대화상자의 변수명으로 리턴한다.->한번에 다 해도 된다.
            dlg.setTitle("제목").setMessage("내용").setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)//null 이벤트 내용
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"확인을 눌렀습니다.",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })//단순한 순서
                    .show();
        }//대화 상자 버튼
        else if(v.getId() == R.id.b6){
            String data[] = {"치킨","피자"};
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })//목록 배열이 필요하다
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"확인을 눌렀습니다.",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
        }

        else if(v.getId() == R.id.b7){
            final String data[] = {"치킨","피자","짜장","탕수육"};
            final boolean checked[] ={true,false,true,true};//목록을 다중 선택 가능하므로 check된 항목을 순서대로 true, 배열 숫자가 동일해야한다.
            //메모리의 값이 바뀌는 것이니까 상관없다.
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목")
                    .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checked[which] = isChecked;
                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String print = "";
                            for(int i=0;i<data.length;i++){
                                if(checked[i])
                                    print +=","+data[i];
                            }
                            Toast.makeText(getApplicationContext(),print,Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
        }
        else if(v.getId() == R.id.b8){
            View view = View.inflate(this,R.layout.editbox,null);
            final EditText e1 = (EditText)view.findViewById(R.id.e1);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),e1.getText().toString()+"입니다",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();

        }

    }

}
