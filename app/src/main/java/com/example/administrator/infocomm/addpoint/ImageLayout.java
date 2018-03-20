package com.example.administrator.infocomm.addpoint;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.administrator.infocomm.R;
import com.socks.library.KLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/18 0018.
 */

public class ImageLayout extends FrameLayout {

    private static  ArrayList<PointSimple> points;

    private static FrameLayout layouPoints;

    private static ImageView imgBg;

    private static Context mContext;

    public ImageLayout(@NonNull Context context) {
        super(context);
    }

    public ImageLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ImageLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void setImgBg(int rID) {
        clearPoints(); //清除标记点

        ViewGroup.LayoutParams lp = imgBg.getLayoutParams();
        lp.width = 998;
        lp.height = 1177;
        KLog.i( lp.width);
        KLog.i( lp.height);

        imgBg.setLayoutParams(lp);
        Glide.with(mContext).load(rID).into(imgBg);
    }


    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        View imgPointLayout = LayoutInflater.from(context).inflate(R.layout.layout_imgview_point,this);

        imgBg = (ImageView) imgPointLayout.findViewById(R.id.imgBg);
        layouPoints = (FrameLayout) imgPointLayout.findViewById(R.id.layouPoints);
    }

    public void setImgBgAndAddPoints(int width, int height, int rID) {
        ViewGroup.LayoutParams lp = imgBg.getLayoutParams();
        lp.width = width;
        lp.height = height;
        KLog.i( lp.width);
        KLog.i( lp.height);

        imgBg.setLayoutParams(lp);

        ViewGroup.LayoutParams lp1 = layouPoints.getLayoutParams();
        lp1.width = width;
        lp1.height = height;

        layouPoints.setLayoutParams(lp1);
        Glide.with(mContext).load(rID).into(imgBg);

        addPoints(width, height);

    }

    public void setPoints(ArrayList<PointSimple> points) {

        this.points = points;
    }

    private void addPoints(int width, int height) {

        layouPoints.removeAllViews();

        for (int i = 0; i < points.size(); i++) {

            double width_scale = points.get(i).width_scale;
            double height_scale = points.get(i).height_scale;


            LinearLayout view = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.layout_img_point, this, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imgPoint);
            imageView.setTag(i);

//            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
//            animationDrawable.start();

            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();

            layoutParams.leftMargin = (int) (width * width_scale);
            layoutParams.topMargin = (int) (height * height_scale);
//            layoutParams.leftMargin = 128;
//            layoutParams.topMargin = 129;

//            imageView.setOnClickListener(this);

            layouPoints.addView(view, layoutParams);
        }


    }

    public void clearPoints() {
        if (layouPoints == null) {
            KLog.e("layouPoints == null");
            return;
        }
        layouPoints.removeAllViews();
    }

}
