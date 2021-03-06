package com.example.administrator.infocomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.infocomm.data.CompanyBean;
import com.example.administrator.infocomm.data.CompanyDataManager;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/11 0011.
 */


public class SearchActivity extends AppCompatActivity {
    private static String TAG = "SearchActivity";
    private static int lauFlag = 0;//0为中文   1为英文

    @OnClick(R.id.btn_back)
    void back() {
        finish();
    }

    @BindView(R.id.filter_edit)
    ClearEditText mClearEditText;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.dialog)
    TextView dialog;

    @BindView(R.id.sideBar)
    SideBar sideBar;

    @BindView(R.id.btn)
    Button btn;

    @OnClick(R.id.btn)
    public void btn() {
        if (lauFlag == 1) {

            lauFlag = 0;
            KLog.i(TAG, "转换为 chinese ");
            btn.setBackgroundResource(R.drawable.btn_english_selector);

            HashMap<String, CompanyBean> map = CompanyDataManager.getinstance().getCNCompDataHashMap();
            SourceDateList = filledData(map);
            // 根据a-z进行排序源数据
            Collections.sort(SourceDateList, pinyinComparator);
            adapter.updateList(SourceDateList);

        } else {
            lauFlag = 1;
            KLog.i(TAG, "转换为 english");
            btn.setBackgroundResource(R.drawable.btn_chinese_selector);

            HashMap<String, CompanyBean> map = CompanyDataManager.getinstance().getENCompDataHashMap();
            SourceDateList = filledData(map);
            // 根据a-z进行排序源数据
            Collections.sort(SourceDateList, pinyinComparator);
            adapter.updateList(SourceDateList);


        }
    }

    private SortAdapter adapter;
    LinearLayoutManager manager;

    private List<SortModel> SourceDateList;

    /**
     * 根据拼音来排列RecyclerView里面的数据类
     */
    private PinyinComparator pinyinComparator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.search_main);
        ButterKnife.bind(this);

        btn.setVisibility(View.VISIBLE);

        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        pinyinComparator = null;
        sideBar.setTextView(null);
        sideBar.setOnTouchingLetterChangedListener(null);
        SourceDateList = null;
        manager = null;
        mRecyclerView.setLayoutManager(null);
        mRecyclerView.setAdapter(null);
        mRecyclerView = null;
        mClearEditText.addTextChangedListener(null);
        mClearEditText = null;
        adapter.setSeletedDataCB(null);
        adapter = null;


    }
    private void initViews() {
        pinyinComparator = new PinyinComparator();
        sideBar.setTextView(dialog);
        //设置右侧SideBar触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int postion = adapter.getPositionForSection(s.charAt(0));
                if (postion != -1) {
                    manager.scrollToPositionWithOffset(postion, 0);
                }
            }
        });

        //默认先显示中文展馆
        HashMap<String, CompanyBean> map = CompanyDataManager.getinstance().getCNCompDataHashMap();
        SourceDateList = filledData(map);
        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        //RecyclerView社置manager
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        adapter = new SortAdapter(this, SourceDateList);
        mRecyclerView.setAdapter(adapter);

        //根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        adapter.setSeletedDataCB(new SortAdapter.SeletedDataCB() {
            @Override
            public void seletedDataCB(String compName) {
                KLog.i(TAG, compName);
                KLog.i(TAG, lauFlag);

                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("name", compName);
                intent.putExtra("lauFlag", lauFlag);
                startActivity(intent);

            }
        });
    }

    /**
     * 为RecyclerView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setLetters(sortString.toUpperCase());
            } else {
                sortModel.setLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    private List<SortModel> filledData(HashMap<String, CompanyBean> map) {
        List<SortModel> mSortList = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            CompanyBean val = (CompanyBean) entry.getValue();

//            Log.i("CompanyBean", "key=" + key);
//            Log.i("CompanyBean", "val=" + val.toString());

            SortModel sortModel = new SortModel();
            sortModel.setName(val.getName());
            sortModel.setBoothNo(val.getBoothNo());

            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(val.getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setLetters(sortString.toUpperCase());
            } else {
                sortModel.setLetters("#");
            }

            mSortList.add(sortModel);
        }

        return mSortList;
    }


    /**
     * 根据输入框中的值来过滤数据并更新RecyclerView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1 ||
                        PinyinUtils.getFirstSpell(name).startsWith(filterStr.toString())
                        //不区分大小写
                        || PinyinUtils.getFirstSpell(name).toLowerCase().startsWith(filterStr.toString())
                        || PinyinUtils.getFirstSpell(name).toUpperCase().startsWith(filterStr.toString())
                        ) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateList(filterDateList);
    }


}
