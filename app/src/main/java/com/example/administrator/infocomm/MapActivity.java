package com.example.administrator.infocomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.infocomm.addpoint.ImageLayout;
import com.example.administrator.infocomm.addpoint.PointSimple;
import com.example.administrator.infocomm.data.CompanyBean;
import com.example.administrator.infocomm.data.CompanyDataManager;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class MapActivity extends AppCompatActivity {
    List<PointSimple> imgSimples;
    private static String TAG = "MapActivity";

    @BindView(R.id.topmap)//顶部3D平面图
            ImageView topmap;

//    @BindView(R.id.planmap)//底部平面图
//    ImageView planMap;

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.button3)
    Button button3;

    @BindView(R.id.button4)
    Button button4;

    @BindView(R.id.layoutContent)
    ImageLayout imageLayout;


    @OnClick(R.id.button1)
    void Button1() {
        imageLayout.setImgBg(R.drawable.e);
    }

    @OnClick(R.id.button2)
    void Button2() {
        imageLayout.setImgBg(R.drawable.d);
    }

    @OnClick(R.id.button3)
    void Button3() {
        imageLayout.setImgBg(R.drawable.m);
    }

    @OnClick(R.id.button4)
    void Button4() {
        imageLayout.setImgBg(R.drawable.p);
    }

    @OnClick(R.id.button5)
    void Button5() {
        imageLayout.setImgBg(R.drawable.d);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.map_main);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        KLog.i(TAG, intent);
        if (intent.getExtras() != null) {
            String name = intent.getExtras().getString("name");
            int lauFlag = intent.getExtras().getInt("lauFlag");//0为中文   1为英文
            KLog.i(TAG, name);
            KLog.i(TAG, lauFlag);

            CompanyBean temp = null;
            String bootNo = "";
            double x = 0f;
            double y = 0f;
            try {

                if (lauFlag == 0) {//中文
                    temp = CompanyDataManager.getinstance().getCNCompDataHashMap().get(name);
                    x = temp.getX();
                    y = temp.getY();
                    bootNo = temp.getBoothNo();
                    KLog.i(TAG, "x= " + x);
                    KLog.i(TAG, "y= " + y);
                    KLog.i(TAG, "bootNo= " + bootNo);

                } else if (lauFlag == 1) {
                    temp = CompanyDataManager.getinstance().getENCompDataHashMap().get(name);
                    x = temp.getX();
                    y = temp.getY();
                    bootNo = temp.getBoothNo();
                    KLog.i(TAG, "x= " + x);
                    KLog.i(TAG, "y= " + y);
                    KLog.i(TAG, "bootNo= " + bootNo);
                }

            } catch (NullPointerException e) {
                KLog.e(e);
            }
            String h = bootNo.substring(0, 1);//展馆首字母
            KLog.i(TAG, h);
            String loc = CompanyDataManager.getinstance().getLocationSP(this);
            String locHead = loc.substring(0, 1);
            float x1 = CompanyDataManager.getinstance().getLocXSP(this);
            float y1 = CompanyDataManager.getinstance().getLocYSP(this);


            if (h.equals("P")) {
                if (locHead.equals("p")) {//立柜和查询的点 在同一个展馆
                    initPointData(x, y, x1, y1, 760.8, 762, h);
                } else {
                    initPointData(x, y, 760.8, 762, h);
                    Toast.makeText(this, "请先前往对应展馆", Toast.LENGTH_SHORT).show();
                }
            } else if (h.equals("M")) {
                if (locHead.equals("M")) {//立柜和查询的点 在同一个展馆
                    initPointData(x, y, x1, y1, 760.8, 762, h);
                } else {
                    initPointData(x, y, 760.8, 762, h);
                    Toast.makeText(this, "请先前往对应展馆", Toast.LENGTH_SHORT).show();
                }
            } else if (h.equals("E")) {
                if (locHead.equals("E")) {//立柜和查询的点 在同一个展馆
                    initPointData(x, y, x1, y1, 968.2, 585.4, h);
                } else {
                    initPointData(x, y, 968.2, 585.4, h);
                    Toast.makeText(this, "请先前往对应展馆", Toast.LENGTH_SHORT).show();
                }
            } else if (h.equals("D") ||  h.equals("C")|| h.equals("F")) {
                if (locHead.equals("D") ||  locHead.equals("C")|| locHead.equals("F")) {//立柜和查询的点 在同一个展馆
                    initPointData(x, y, x1, y1, 760.8, 762, h);
                } else {
                    initPointData(x, y, 760.8, 762, h);
                    Toast.makeText(this, "请先前往对应展馆", Toast.LENGTH_SHORT).show();
                }
            }


        }


        Glide.with(this).load(R.drawable.topmap).into(topmap);
//        Glide.with(this).load(R.drawable.p).into(planMap);
    }


    private void initPointData(double x, double y, double targetX, double targetY, String h) { //760.8f /762f;
        ArrayList<PointSimple> mPointSimple = new ArrayList<>();
        PointSimple p = new PointSimple();
        //经测试  = 实际坐标x/图片总宽
        p.width_scale = x / targetX;
        p.height_scale = y / targetY;
        KLog.i(p.width_scale);
        KLog.i(p.height_scale);

        mPointSimple.add(p);

        imageLayout.setPoints(mPointSimple);

        if (h.equals("D") || h.equals("C") || h.equals("F")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.d);
        } else if (h.equals("M")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.m);
        } else if (h.equals("P")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.p);
        } else if (h.equals("E")) {//1080 * 1920
            imageLayout.setImgBgAndAddPoints(1000, 563, R.drawable.e);
        }


    }

    private void initPointData(double x, double y, float x1, float y1, double targetX, double targetY, String h) { //760.8f /762f;
        ArrayList<PointSimple> mPointSimple = new ArrayList<>();
        PointSimple p = new PointSimple();
        //展馆位置
        //经测试  = 实际坐标x/图片总宽
        p.width_scale = x / targetX;
        p.height_scale = y / targetY;
        KLog.i(p.width_scale);
        KLog.i(p.height_scale);

        mPointSimple.add(p);

        //立柜位置
        PointSimple l = new PointSimple();
        l.width_scale = x1 / targetX;
        l.height_scale = y1 / targetY;
         mPointSimple.add(l);

        imageLayout.setPoints(mPointSimple);

        if (h.equals("D") || h.equals("C") || h.equals("F")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.d);
        } else if (h.equals("M")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.m);
        } else if (h.equals("P")) {//760.8 *762
            imageLayout.setImgBgAndAddPoints(1000, 1000, R.drawable.p);
        } else if (h.equals("E")) {//1080 * 1920
            imageLayout.setImgBgAndAddPoints(1000, 563, R.drawable.e);
        }


    }
}
