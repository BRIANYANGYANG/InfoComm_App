package com.example.administrator.infocomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class MeetingActivity extends AppCompatActivity {



    @BindView(R.id.meeting_img)
    ImageView meetingImg;

    @OnClick(R.id.button1)
     void Button1() {
        Glide.with(this).load(R.drawable.metting1).into(meetingImg);
    }

    @OnClick(R.id.button2)
    void Button2() {
        Glide.with(this).load(R.drawable.metting2).into(meetingImg);
    }

    @OnClick(R.id.button3)
    void Button3() {
        Glide.with(this).load(R.drawable.metting3).into(meetingImg);
    }
    @OnClick(R.id.button4)
    void Button4() {
        Glide.with(this).load(R.drawable.metting4).into(meetingImg);
    } @OnClick(R.id.button5)
    void Button5() {
        Glide.with(this).load(R.drawable.metting5).into(meetingImg);
    }
    @OnClick(R.id.button6)
    void Button6() {
        Glide.with(this).load(R.drawable.metting6).into(meetingImg);
    }

    @OnClick(R.id.button7)
    void Button7() {
        Glide.with(this).load(R.drawable.metting7).into(meetingImg);
    }

    @OnClick(R.id.button8)
    void Button8() {
        Glide.with(this).load(R.drawable.metting8).into(meetingImg);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.meeting_main);
        ButterKnife.bind(this);

        Glide.with(this).load(R.drawable.metting1).into(meetingImg);


    }
}
