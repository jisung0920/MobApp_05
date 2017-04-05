package com.example.jisung.mobapp_05;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
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
import java.util.regex.Pattern;

/**
 * Created by jisung on 2017-03-30.
 */

public class Fragment1 extends Fragment implements View.OnClickListener {
    TextView t1,t2,t3,t4,t5,t6;
    Button[] c;
    Button b1,b2,b3;
    tableInfo[] table;
    int nowTable=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragview = inflater.inflate(R.layout.frag1,container,false);//container 어디에 붙일지
        init(fragview);
        return fragview;
    }


    Boolean EditNull(EditText e,View v){
        if(e.getText().toString().equals("")) {
            Toast.makeText(v.getContext(), "정보를 입력하세요.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }


    void init(View v){

        table = new tableInfo[4];
        c = new Button[4];

        t1 = (TextView)v.findViewById(R.id.t1);
        t2 = (TextView)v.findViewById(R.id.t2);
        t3 = (TextView)v.findViewById(R.id.t3);
        t4 = (TextView)v.findViewById(R.id.t4);
        t5 = (TextView)v.findViewById(R.id.t5);
        t6 = (TextView)v.findViewById(R.id.t6);
        c[0] = (Button)v.findViewById(R.id.c1);
        c[1] = (Button)v.findViewById(R.id.c2);
        c[2] = (Button)v.findViewById(R.id.c3);
        c[3] = (Button)v.findViewById(R.id.c4);
        b1 = (Button)v.findViewById(R.id.b1);
        b2 = (Button)v.findViewById(R.id.b2);
        b3 = (Button)v.findViewById(R.id.b3);
        c[0].setOnClickListener(this);
        c[1].setOnClickListener(this);
        c[2].setOnClickListener(this);
        c[3].setOnClickListener(this);
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

    void tableEmptySetting(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.c1:
                if(table[0]==null){
                    View V = getActivity().getLayoutInflater().inflate(R.layout.mytoastxml,null);
                    TextView msg = (TextView)V.findViewById(R.id.msg);
                    msg.setText("비어있는 테이블입니다.");
                    Toast toast = new Toast(getActivity());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,100);
                    toast.setView(V);
                    toast.show();
                    tableEmptySetting();
                }
                else
                    tableSetting(table[0]);
                nowTable=0;
                break;
            case R.id.c2:
                if(table[1]==null){
                    View V = getActivity().getLayoutInflater().inflate(R.layout.mytoastxml,null);
                    TextView msg = (TextView)V.findViewById(R.id.msg);
                    msg.setText("비어있는 테이블입니다.");
                    Toast toast = new Toast(getActivity());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,100);
                    toast.setView(V);
                    toast.show();
                    tableEmptySetting();}
                else
                    tableSetting(table[1]);
                nowTable=1;
                break;
            case R.id.c3:
                if(table[2]==null){
                    View V = getActivity().getLayoutInflater().inflate(R.layout.mytoastxml,null);
                    TextView msg = (TextView)V.findViewById(R.id.msg);
                    msg.setText("비어있는 테이블입니다.");
                    Toast toast = new Toast(getActivity());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,100);
                    toast.setView(V);
                    toast.show();
                    tableEmptySetting();}
                else
                    tableSetting(table[2]);
                nowTable=2;
                break;
            case R.id.c4:
                if(table[3]==null){
                    View V = getActivity().getLayoutInflater().inflate(R.layout.mytoastxml,null);
                    TextView msg = (TextView)V.findViewById(R.id.msg);
                    msg.setText("비어있는 테이블입니다.");
                    Toast toast = new Toast(getActivity());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,100);
                    toast.setView(V);
                    toast.show();
                    tableEmptySetting();}
                else
                    tableSetting(table[3]);
                nowTable=3;
                break;
            default:
                break;
        }


        if(v.getId() == R.id.b1){

            final View view = View.inflate(getContext(),R.layout.editbox,null);
            final String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .format(new Date(System.currentTimeMillis()));

            TextView enterTime = (TextView)view.findViewById(R.id.enterTime);
            enterTime.setText(time);

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setTitle(c[nowTable].getText().subSequence(0,8)+"입니다.")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            EditText spa = (EditText)((AlertDialog)dialog).findViewById(R.id.spaN);//dialog 안에서 view 내용물 가져오기
                            EditText piz = (EditText)((AlertDialog)dialog).findViewById(R.id.pizN);
                            RadioButton cardCheck = (RadioButton)((AlertDialog)dialog).findViewById(R.id.m1);
                            int card;
                            if(cardCheck.isChecked())
                                card = 10;
                            else
                                card = 30;

                            if(EditNull(spa,view)||EditNull(piz,view))
                                return ;

                            table[nowTable] = new tableInfo(nowTable,time
                                    ,Integer.parseInt(spa.getText().toString())
                                    ,Integer.parseInt(piz.getText().toString())
                                    ,card);

                            c[nowTable].setText(table[nowTable].getName());
                            tableSetting(table[nowTable]);

                            Snackbar.make(getView(),"정보가 입력되었습니다.",2000).setAction("OK", new View.OnClickListener() {//view 대신 getView()
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(getActivity().getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                        }
                    })
                    .show();

        }
        else if(v.getId() == R.id.b2){//정보 받아오고 parsing @@@@@@@@@@@@@@@2
            final View view = View.inflate(getContext(),R.layout.editbox,null);

            if(table[nowTable]==null)
                return;
            EditText spa = (EditText)view.findViewById(R.id.spaN);
            EditText piz = (EditText)view.findViewById(R.id.pizN);

            RadioButton nomal = (RadioButton)view.findViewById(R.id.m1);
            RadioButton vip = (RadioButton)view.findViewById(R.id.m2);
            TextView enterTime = (TextView)view.findViewById(R.id.enterTime);
            int card = table[nowTable].getCard();
            if(card==10)
                nomal.setChecked(true);
            else
                vip.setChecked(false);


            spa.setText(table[nowTable].getSpaNum()+"");
            piz.setText(table[nowTable].getPizNum()+"");
            enterTime.setText(table[nowTable].getDate());

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setTitle(c[nowTable].getText().subSequence(0,8)+"입니다.")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EditText spa = (EditText)((AlertDialog)dialog).findViewById(R.id.spaN);//dialog 안에서 view 내용물 가져오기
                            EditText piz = (EditText)((AlertDialog)dialog).findViewById(R.id.pizN);

                            RadioButton cardCheck = (RadioButton)((AlertDialog)dialog).findViewById(R.id.m1);
                            int card;
                            if(cardCheck.isChecked())
                                card = 10;
                            else
                                card = 30;
                            table[nowTable].setSpaNum(Integer.parseInt(spa.getText().toString()));
                            table[nowTable].setPizNum(Integer.parseInt(piz.getText().toString()));
                            table[nowTable].setCard(card);
                            tableSetting(table[nowTable]);

                            Snackbar.make(getView(),"정보가 수정되었습니다.",2000).setAction("OK", new View.OnClickListener() {//view 대신 getView()
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(getActivity().getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                        }
                    })
                    .show();

        }
        else if(v.getId() == R.id.b3){
            if(table[nowTable]==null)
                return;
            c[nowTable].setText(table[nowTable].getName()+"(비어있음)");
            tableEmptySetting();
            table[nowTable]=null;
            View V = getActivity().getLayoutInflater().inflate(R.layout.mytoastxml,null);
            TextView msg = (TextView)V.findViewById(R.id.msg);
            msg.setText("초기화 되었습니다.");
            Toast toast = new Toast(getActivity());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,100);
            toast.setView(V);
            toast.show();
        }

    }
}
