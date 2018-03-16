package com.example.administrator.infocomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class MapActivity extends AppCompatActivity {
    private static String TAG = "MapActivity";
    @BindView(R.id.title_text)
    TextView title;

    @BindView(R.id.topmap)//顶部3D平面图
    ImageView topmap;

    @BindView(R.id.planmap)//底部平面图
    ImageView planMap;

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.button3)
    Button button3;

    @BindView(R.id.button4)
    Button button4;




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
            KLog.i(TAG, name);

        }

        title.setText("展馆地图");
        Glide.with(this).load(R.drawable.topmap).into(topmap);
        Glide.with(this).load(R.drawable.p).into(planMap);

    }
}
