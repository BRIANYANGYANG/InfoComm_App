package com.example.administrator.infocomm.data;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class CompanyBean {
    private String name;
    private String boothPart;//大展馆名  如： E馆  ，D馆
    private String boothNo;//详细展位号码 如ED7-01  ， BJ3-01
    private int x;
    private int y;

   public CompanyBean(String name, String boothPart, String boothNo, int x, int y) {
       this.name = name;
       this.boothNo = boothNo;
       this.boothPart = boothPart;
       this.x = x;
       this.y = y;

       Logger.i(toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoothPart() {
        return boothPart;
    }

    public void setBoothPart(String boothPart) {
        this.boothPart = boothPart;
    }

    public String getBoothNo() {
        return boothNo;
    }

    public void setBoothNo(String boothNo) {
        this.boothNo = boothNo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String a = name + "/"
                +boothPart + "/"
                +boothNo + "/"
                +x + "/"
                +y + "/";
        return a;
    }
}
