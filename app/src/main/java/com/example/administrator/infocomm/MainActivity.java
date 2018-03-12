package com.example.administrator.infocomm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.button1)
        //展商搜索
    void button1() {
        Logger.i("jump to SearchActivity ");
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.button2)
//地图map
    void button2() {
        Logger.i("jump to MapActivity ");
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button3)
//会议信息
    void button3() {
        Logger.i("jump to MeetingActivity ");
        Intent intent = new Intent(this, MeetingActivity.class);
        startActivity(intent);
    }

    @BindView(R.id.topvideo)
    VideoView mVideoView;

    @BindView(R.id.autorollview)
    RollPagerView mRollPagerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("onCreate");
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //播放本地视频
        setupVideo();

        //图片轮播
        mRollPagerView.setAdapter(new MyPagerAdapter());
        mRollPagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyPagerAdapter extends StaticPagerAdapter {
        private  int[] image = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
//            imageView.setImageResource(image[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            Glide.with(container.getContext()).load(image[position]).into(imageView);
            return imageView;
        }

        @Override
        public int getCount() {
            return image.length;
        }
    }

    private void setupVideo() {

        try {
            Uri uri = Uri.parse("/mnt/sdcard/infocomm/video/2.mp4");
            mVideoView.setVideoURI(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Logger.i("onPrepared");
                mVideoView.start();
//                mp.setLooping(true);
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Logger.i("onCompletion");
                mp.start();
                mp.setLooping(true);
            }
        });
        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Logger.i("onError" + what + extra);
                stopPlaybackVideo();
                mVideoView.start();
                return true;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mVideoView.isPlaying()) {
            mVideoView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoView.canPause()) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPlaybackVideo();
    }

    private void stopPlaybackVideo() {
        try {
            mVideoView.stopPlayback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


