package com.example.jisung.mobapp_05;

import java.util.Date;

/**
 * Created by jisung on 2017-03-30.
 */

public class tableInfo {
    private String name;
    private String date;
    private int spaNum;
    private int pizNum;
    private int card;
    private String price;

    public tableInfo(){

    }
    public tableInfo( int table,String date, int spaNum, int pizNum, int card) {
        switch (table){
            case 0:
                this.name = "사과 Table";
                break;
            case 1:
                this.name = "포도 Table";
                break;
            case 2:
                this.name = "키위 Table";
                break;
            case 3:
                this.name = "자몽 Table";
                break;
            default:
                break;
        }
        this.date = date;
        this.spaNum = spaNum;
        this.pizNum = pizNum;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSpaNum() {
        return spaNum;
    }

    public void setSpaNum(int spaNum) {
        this.spaNum = spaNum;
    }

    public int getPizNum() {
        return pizNum;
    }

    public void setPizNum(int pizNum) {
        this.pizNum = pizNum;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getPrice() {
        int result =(this.getPizNum()*10000 + this.getSpaNum()*12000)*100/getCard();
        return result+"";
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
