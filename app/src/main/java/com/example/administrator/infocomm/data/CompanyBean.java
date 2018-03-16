package com.example.administrator.infocomm.data;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class CompanyBean {
    private String name;
    private String boothPart;//大展馆名  如： E馆  ，D馆
    private String boothNo;//详细展位号码 如ED7-01  ， BJ3-01

    private double x;
    private double y;


    public CompanyBean(String name, String boothNo, double x, double y) {
        this.name = name.trim();
        this.boothNo = boothNo.trim();
        this.x = x;
        this.y = y;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String a = name + "/"
                + boothNo + "/"
                + x + "/"
                + y + "/";
        return a;
    }
}
