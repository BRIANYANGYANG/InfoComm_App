package com.example.administrator.infocomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.infocomm.data.MapUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/11 0011.
 */


public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.title_text)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.search_main);
        ButterKnife.bind(this);

        title.setText("展商搜索");


        MapUtils.CreatCompanyMap();


    }
}
