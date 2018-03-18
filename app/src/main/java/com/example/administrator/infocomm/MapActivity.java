package com.example.administrator.infocomm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.infocomm.addpoint.ImageLayout;
import com.example.administrator.infocomm.addpoint.PointSimple;
import com.example.administrator.infocomm.data.CompanyBean;
import com.example.administrator.infocomm.data.CompanyDataManager;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.administrator.infocomm.R.drawable.m;
import static com.example.administrator.infocomm.data.CompanyDataManager.getinstance;
import static com.socks.library.KLog.I;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class MapActivity extends AppCompatActivity {
    List<PointSimple> imgSimples;
    private static String TAG = "MapActivity";
    @BindView(R.id.title_text)
    TextView title;

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



    @Override
    protected void onCreate( Bundle savedInstanceState) {
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
            try {


            if (lauFlag == 0) {//中文
               CompanyBean temp =  CompanyDataManager.getinstance().getCNCompDataHashMap().get(name);
                double x = temp.getX();
                double y = temp.getY();
                KLog.i(TAG, "x= " + x);
                KLog.i(TAG, "y= " + y);

            } else if (lauFlag == 1){
                CompanyBean temp =  CompanyDataManager.getinstance().getENCompDataHashMap().get(name);
                double x = temp.getX();
                double y = temp.getY();
                KLog.i(TAG, "x= " + x);
                KLog.i(TAG, "y= " + y);
            }

            }catch (NullPointerException e) {
                KLog.e(e);
            }

        }

        title.setText("展馆地图");
        Glide.with(this).load(R.drawable.topmap).into(topmap);
//        Glide.with(this).load(R.drawable.p).into(planMap);
        initPointData();
    }

    private void initPointData() {
        ArrayList<PointSimple> mPointSimple =  new ArrayList<>();
        PointSimple p = new  PointSimple();
        //经测试  = 实际坐标x/图片总宽
        p.width_scale = 0.246f;
        p.height_scale = 0.034f;
        mPointSimple.add(p);

        imageLayout.setPoints(mPointSimple);
        imageLayout.setImgBg(1000,1000,R.drawable.d);

//        //获取图片真正的宽高
//        Glide.with(this)
//                .load(R.drawable.d)
//                .asBitmap()//强制Glide返回一个Bitmap对象
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
//                        int width = bitmap.getWidth();
//                        int height = bitmap.getHeight();
//                        KLog.i(TAG, "width /" + width); //200px
//                        KLog.i(TAG, "height/ " + height); //200px
//                    }
//                });

    }
}
