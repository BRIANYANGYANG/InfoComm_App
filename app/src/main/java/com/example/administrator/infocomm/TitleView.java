package com.example.administrator.infocomm;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class TitleView extends FrameLayout {
    private TextView titleText;
    private ImageView back;

    public TitleView( Context context,  AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        titleText = findViewById(R.id.title_text);
        back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
    }

    /**
     * 设置标题
     * @param text
     */
    public void setTitleText(String text) {
        titleText.setText(text);
    }
    /**
     * 隐藏返回按钮
     */
    public void hideBackImage(){
        back.setVisibility(View.GONE);
    }
}
