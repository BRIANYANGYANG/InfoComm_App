package com.example.administrator.infocomm.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.orhanobut.logger.Logger;

import java.util.HashMap;

/**
 * Created by yangpengfei10 on 2018/3/13.
 */

public class CompanyDataManager {
    private static  String TAG = "CompanyDataManager";
    private static CompanyDataManager instance = null;

    private HashMap<String, CompanyBean> map;

    public CompanyDataManager() {

    }

    public static synchronized CompanyDataManager getinstance () {
        if (instance == null) {
            instance = new CompanyDataManager();
        }
        return instance;
    }



    public void saveSP(String location, int pos, Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("location",location);
        editor.putInt("pos",pos);
        if (editor.commit()) {
            Logger.i("SaveSP ok /" + location + "/" + pos);

        } else {
            Logger.e( "SaveIpcSP fail /");

        }
    }

    public String getLocationSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        String location = sp.getString("location","");
        int pos = sp.getInt("pos", 0);

        Logger.i("get location from SP" +
                "location=" + location);

        return  location;

    }

    public int getSpinnerPosSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        String location = sp.getString("location","");
        int pos = sp.getInt("pos", -1);

        Logger.i("get pos from SP" +
                "pos=" + location);

        return  pos;

    }

    public HashMap<String, CompanyBean> getCompDataHashMap() {
        map = new HashMap<>();
        map.put(MapUtils.trim("testname    .-.   "), new CompanyBean("testname01", "ED9-21", 350, 550));

        map.put(MapUtils.trim("3M China Ltd.                                                                                "), new CompanyBean("   3M China Ltd.                                                                        ", "       ED7-01     ",    1    ,  100  ));
        map.put(MapUtils.trim("81it.com                                                                                       "), new CompanyBean("   81it.com                                                                               ", "       BJ3-01      ",    2    ,  99   ));
        map.put(MapUtils.trim("AAVARA Innovation Corp.                                                                "), new CompanyBean("   AAVARA Innovation Corp.                                                        ", "       CA5-03     ",    3    ,  98    ));
        map.put(MapUtils.trim("Adder Technology Ltd.                                                                    "),new CompanyBean("    Adder Technology Ltd.                                                            ", "       EA10-01   ",     4   ,   97   ));
        map.put(MapUtils.trim("Advanced Communication Equipment (International) Co., Ltd.              "),new CompanyBean("    Advanced Communication Equipment (International) Co., Ltd.      ", "       CC6-01     ",    5    ,  96   ));
        map.put(MapUtils.trim("AnDisplay                                                                                     "),new CompanyBean("    AnDisplay                                                                             ", "       BB3-01     ",    6    ,  95   ));
        map.put(MapUtils.trim("Appotronics Co., Ltd.                                                                      "), new CompanyBean("   Appotronics Co., Ltd.                                                              ", "       MA18-0     ",    7    ,  94   ));
        map.put(MapUtils.trim("Asukanet Co., Ltd.                                                                         "),new CompanyBean("    Asukanet Co., Ltd.                                                                 ", "       CD3-02     ",    8    ,  93   ));
        map.put(MapUtils.trim("ATEIS                                                                                           "), new CompanyBean("   ATEIS                                                                                   ", "       EH7-01     ",    9    ,  92   ));
        map.put(MapUtils.trim("ATEN China Co., Ltd.                                                                      "), new CompanyBean("    ATEN China Co., Ltd.                                                             ", "        EG6-01    ",     10  ,  91   ));
        map.put(MapUtils.trim("Atlona Asia Co., Ltd.                                                                      "),new CompanyBean("    Atlona Asia Co., Ltd.                                                              ", "       PE4-01     ",    11  ,   90   ));
        map.put(MapUtils.trim("Audfly Technology Co., Ltd.                                                             "), new CompanyBean("    Audfly Technology Co., Ltd.                                                    ", "        CE1-03     ",    12  ,  89    ));
        map.put(MapUtils.trim("audio160.com                                                                                "), new CompanyBean("   audio160.com                                                                        ", "       BG2-04     ",    13  ,  88    ));
        map.put(MapUtils.trim("Audio-Technica (Greater China) Limited                                             "), new CompanyBean("   Audio-Technica (Greater China) Limited                                     ", "       EG3-01     ",    14  ,  87    ));
        map.put(MapUtils.trim("Aurora Multimedia Asia Limited                                                        "), new CompanyBean("   Aurora Multimedia Asia Limited                                                ", "       EK5-01     ",     15  ,  86   ));
        map.put(MapUtils.trim("AVCONE & COROARAC (HK) Professional Co., Ltd.                               "), new CompanyBean("   AVCONE & COROARAC (HK) Professional Co., Ltd.                      ", "       EK7-01     ",     16  ,  85   ));
        map.put(MapUtils.trim("Avwin Corporation (China)                                                               "), new CompanyBean("   Avwin Corporation (China)                                                       ", "       PE6-01     ",     17  ,  84   ));
        map.put(MapUtils.trim("BARCO                                                                                         "),new CompanyBean("    BARCO                                                                                 ", "       Meeting    ",    18  ,  83    ));
        map.put(MapUtils.trim("Beckhoff Automation (Shanghai) Co., Ltd.                                          "), new CompanyBean("   Beckhoff Automation (Shanghai) Co., Ltd.                                 ", "        CD4-02    ",     19  ,  82   ));
        map.put(MapUtils.trim("Beijing Beyondinfo Technology Co., Ltd.                                            "), new CompanyBean("   Beijing Beyondinfo Technology Co., Ltd.                                    ", "       PG2-12     ",    20  ,   81   ));
        map.put(MapUtils.trim("Beijing Brillview Technology Co., Ltd.                                                "), new CompanyBean("   Beijing Brillview Technology Co., Ltd.                                       ", "        ED3-01    ",     21  ,  80   ));
        map.put(MapUtils.trim("Beijing Caiyida Science and Technology Development Co., Ltd.             "), new CompanyBean("   Beijing Caiyida Science and Technology Development Co., Ltd.     ", "       PC1-01     ",     22  ,  79   ));
        map.put(MapUtils.trim("Beijing Depull Technology Co., Ltd.                                                   "), new CompanyBean("   Beijing Depull Technology Co., Ltd.                                          ", "       PE3-01     ",     23  ,  78   ));
        map.put(MapUtils.trim("Beijing Dongfang Jiurui Technology Corp. Ltd.                                    "),new CompanyBean("    Beijing Dongfang Jiurui Technology Corp. Ltd.                            ", "       PD5-01     ",    24  ,  77    ));
        map.put(MapUtils.trim("Beijing Haidian Pangu Technology Company                                       "), new CompanyBean("   Beijing Haidian Pangu Technology Company                               ", "       CC5-03     ",    25  ,  76    ));
        map.put(MapUtils.trim("BeiJing Hanv Video Technology Co., Ltd.                                            "), new CompanyBean("   BeiJing Hanv Video Technology Co., Ltd.                                   ", "       PC6-03     ",     26  ,  75   ));
        map.put(MapUtils.trim("Beijing Huanyulanbo Technology Co., Ltd.                                          "), new CompanyBean("   Beijing Huanyulanbo Technology Co., Ltd.                                 ", "       EB10-01    ",    27  ,  74    ));
        map.put(MapUtils.trim("Beijing Innovational Fametal Equipment Co., Ltd.                               "), new CompanyBean("   Beijing Innovational Fametal Equipment Co., Ltd.                       ", "       EK2-01     ",    28  ,   73   ));


        map.put(MapUtils.trim("    3M(中国)有限公司                                                       "), new CompanyBean("    3M(中国)有限公司                                                    ", "       ED7-01     ",    1    ,  100  ));
        map.put(MapUtils.trim("    军桥网                                                       "), new CompanyBean("    军桥网                                                    ", "       BJ3-01      ",    2    ,  99   ));
        map.put(MapUtils.trim("    AAVARA Innovation Corp.                                                       "), new CompanyBean("    AAVARA Innovation Corp.                                                    ", "       CA5-03     ",    3    ,  98    ));
        map.put(MapUtils.trim("    英国艾德科技有限公司                                                      "),new CompanyBean("      英国艾德科技有限公司                                                  ", "       EA10-01   ",     4   ,   97   ));
        map.put(MapUtils.trim("    安恒利（国际）有限公司                                                      "),new CompanyBean("      安恒利（国际）有限公司                                                  ", "       CC6-01     ",    5    ,  96   ));
        map.put(MapUtils.trim("    深圳市一显科技有限公司                                                      "),new CompanyBean("      深圳市一显科技有限公司                                                  ", "       BB3-01     ",    6    ,  95   ));
        map.put(MapUtils.trim("    深圳市光峰光电技术有限公司                                                       "), new CompanyBean("    深圳市光峰光电技术有限公司                                                    ", "       MA18-0     ",    7    ,  94   ));
        map.put(MapUtils.trim("    Asukanet Co., Ltd.                                                      "),new CompanyBean("      Asukanet Co., Ltd.                                                  ", "       CD3-02     ",    8    ,  93   ));
        map.put(MapUtils.trim("    亚提斯中国技术服务中心(上海亚声贸易有限公司)                                                       "), new CompanyBean("    亚提斯中国技术服务中心(上海亚声贸易有限公司)                                                    ", "       EH7-01     ",    9    ,  92   ));
        map.put(MapUtils.trim("    北京宏正腾达科技有限公司                                                       "), new CompanyBean("    北京宏正腾达科技有限公司                                                    ", "        EG6-01    ",     10  ,  91   ));
        map.put(MapUtils.trim("    亚特龙亚洲有限公司                                                      "),new CompanyBean("      亚特龙亚洲有限公司                                                  ", "       PE4-01     ",    11  ,   90   ));
        map.put(MapUtils.trim("    苏州清听声学科技有限公司                                                       "), new CompanyBean("    苏州清听声学科技有限公司                                                    ", "        CE1-03     ",    12  ,  89    ));
        map.put(MapUtils.trim("    音响网                                                       "), new CompanyBean("    音响网                                                    ", "       BG2-04     ",    13  ,  88    ));
        map.put(MapUtils.trim("    鐵三角（大中华）有限公司                                                       "), new CompanyBean("    鐵三角（大中华）有限公司                                                    ", "       EG3-01     ",    14  ,  87    ));
        map.put(MapUtils.trim("    奥罗拉多媒体亚洲有限公司                                                       "), new CompanyBean("    奥罗拉多媒体亚洲有限公司                                                    ", "       EK5-01     ",     15  ,  86   ));
        map.put(MapUtils.trim("    天地众和（香港）专业技术有限公司                                                       "), new CompanyBean("    天地众和（香港）专业技术有限公司                                                   ", "       EK7-01     ",     16  ,  85   ));
        map.put(MapUtils.trim("    广州赢溢电子有限公司                                                       "), new CompanyBean("    广州赢溢电子有限公司                                                    ", "       PE6-01     ",     17  ,  84   ));
        map.put(MapUtils.trim("    巴可伟视（北京）电子有限公司                                                      "),new CompanyBean("      巴可伟视（北京）电子有限公司                                                  ", "       Meeting    ",    18  ,  83    ));
        map.put(MapUtils.trim("    毕孚自动化设备贸易（上海）有限公司                                                       "), new CompanyBean("    毕孚自动化设备贸易（上海）有限公司                                                   ", "        CD4-02    ",     19  ,  82   ));
        map.put(MapUtils.trim("    北京博衍思创信息科技有限公司                                                       "), new CompanyBean("    北京博衍思创信息科技有限公司                                                    ", "       PG2-12     ",    20  ,   81   ));
        map.put(MapUtils.trim("    北京博睿维讯科技有限公司                                                       "), new CompanyBean("    北京博睿维讯科技有限公司                                                   ", "        ED3-01    ",     21  ,  80   ));
        map.put(MapUtils.trim("    北京彩易达科技发展有限公司                                                       "), new CompanyBean("    北京彩易达科技发展有限公司                                                    ", "       PC1-01     ",     22  ,  79   ));
        map.put(MapUtils.trim("    北京德普视讯科技有限公司                                                       "), new CompanyBean("    北京德普视讯科技有限公司                                                   ", "       PE3-01     ",     23  ,  78   ));
        map.put(MapUtils.trim("    北京东方久瑞科技股份有限公司                                                      "),new CompanyBean("      北京东方久瑞科技股份有限公司                                                  ", "       PD5-01     ",    24  ,  77    ));
        map.put(MapUtils.trim("    北京海淀盘古技术公司                                                       "), new CompanyBean("    北京海淀盘古技术公司                                                    ", "       CC5-03     ",    25  ,  76    ));
        map.put(MapUtils.trim("    北京汉维视讯技术有限公司                                                       "), new CompanyBean("    北京汉维视讯技术有限公司                                                   ", "       PC6-03     ",     26  ,  75   ));
        map.put(MapUtils.trim("    北京环宇蓝博科技有限公司                                                       "), new CompanyBean("    北京环宇蓝博科技有限公司                                                   ", "       EB10-01    ",    27  ,  74    ));
        map.put(MapUtils.trim("    北京飞马拓新电子设备有限公司                                                       "), new CompanyBean("    北京飞马拓新电子设备有限公司                                                    ", "       EK2-01     ",    28  ,   73   ));









        return map;
    }







}
