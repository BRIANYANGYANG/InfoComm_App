package com.example.administrator.infocomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class MeetingActivity extends AppCompatActivity {

    @BindView(R.id.title_text)
    TextView title;

    @BindView(R.id.meeting_img)
    ImageView meetingImg;

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.button3)
    Button button3;

    @BindView(R.id.button4)
    Button button4;

    @BindView(R.id.button5)
    Button button5;

    @BindView(R.id.button6)
    Button button6;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.meeting_main);
        ButterKnife.bind(this);

        title.setText("高峰会议");

    }
}
