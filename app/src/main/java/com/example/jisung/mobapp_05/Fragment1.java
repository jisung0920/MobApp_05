package com.example.jisung.mobapp_05;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jisung on 2017-03-30.
 */

public class Fragment1 extends Fragment implements View.OnClickListener {
    TextView t1,t2,t3,t4,t5,t6;
    Button c1,c2,c3,c4,b1,b2,b3;
    tableInfo table[];
    int nowTable=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragview = inflater.inflate(R.layout.frag1,container,false);//container 어디에 붙일지
        init(fragview);
        return fragview;
    }

    void init(View v){

        t1 = (TextView)v.findViewById(R.id.t1);
        t2 = (TextView)v.findViewById(R.id.t2);
        t3 = (TextView)v.findViewById(R.id.t3);
        t4 = (TextView)v.findViewById(R.id.t4);
        t5 = (TextView)v.findViewById(R.id.t5);
        t6 = (TextView)v.findViewById(R.id.t6);
        c1 = (Button)v.findViewById(R.id.c1);
        c2 = (Button)v.findViewById(R.id.c2);
        c3 = (Button)v.findViewById(R.id.c3);
        c4 = (Button)v.findViewById(R.id.c4);
        b1 = (Button)v.findViewById(R.id.b1);
        b2 = (Button)v.findViewById(R.id.b2);
        b3 = (Button)v.findViewById(R.id.b3);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    void tableSetting(tableInfo table){
        t1.setText(table.getName());
        t2.setText(table.getDate());
        t3.setText(table.getSpaNum()+"개");
        t4.setText(table.getPizNum()+"개");
        String card;
        if(table.getCard()==10)
            card = "기본 멤버쉽";
        else
            card = "VIP 멤버쉽";
        t5.setText(card);
        t6.setText(table.getPrice());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int i;
        switch (v.getId()){
            case R.id.c1:
                i=0;
                tableSetting(table[0]);
                nowTable=0;
                break;
            case R.id.c2:
                i=1;
                tableSetting(table[1]);
                nowTable=1;
                break;
            case R.id.c3:
                i=2;
                tableSetting(table[2]);
                nowTable=2;
                break;
            case R.id.c4:
                i=3;
                tableSetting(table[3]);
                nowTable=3;
                break;
            default:
                i=0;
                break;
        }
        if(v.getId()==R.id.c1){

        }
        else if(v.getId() == R.id.c2){
            Toast.makeText(getActivity(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.c3){
            Toast.makeText(getActivity(),"비어있는 테이블입니다..",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.c4){}
        else if(v.getId() == R.id.b1){
            final View view = View.inflate(getContext(),R.layout.editbox,null);
            final EditText spa = (EditText)view.findViewById(R.id.spaN);
            final EditText piz = (EditText)view.findViewById(R.id.pizN);
            final RadioButton cardCheck = (RadioButton)view.findViewById(R.id.m1);
            final int card;
            if(cardCheck.isChecked())
                card = 10;
            else
                card = 30;

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                                    .format(new Date(System.currentTimeMillis()));
                            Log.d("table1",time);//parse가 안된다.
/*                            table[nowTable] = new tableInfo(nowTable,time
                                    ,Integer.parseInt(spa.toString())
                                    ,Integer.parseInt(piz.toString())
                                    ,card);*/

                            Snackbar.make(getView(),"주문이 완료되었습니다.",2000).setAction("OK", new View.OnClickListener() {//view 대신 getView()
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(getActivity().getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                            Log.d("table1","cehck");
                        }
                    })
                    .show();

        }
        else if(v.getId() == R.id.b2){

        }
        else if(v.getId() == R.id.b3){}

    }
}
