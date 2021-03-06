package com.example.administrator.infocomm.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.socks.library.KLog;

import java.util.HashMap;

/**
 * Created by yangpengfei10 on 2018/3/13.
 */

public class CompanyDataManager {
    private static String TAG = "CompanyDataManager";
    private static CompanyDataManager instance = null;

    private static HashMap<String, CompanyBean> map = null;
    private static HashMap<String, CompanyBean> enMap = null;

    public CompanyDataManager() {

    }

    public static synchronized CompanyDataManager getinstance() {
        if (instance == null) {
            instance = new CompanyDataManager();
        }
        return instance;
    }


    public void saveSP(String location, int pos, Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("location", location);
        editor.putInt("pos", pos);
        //存储立柜所在位置的 x y 坐标
        switch (location) {
            //E
            case "E1":
                KLog.d();
                editor.putFloat("x", (float) 100.5);
                editor.putFloat("y", (float) 446);
                break;
            case "E2":
                KLog.d();
                editor.putFloat("x", (float) 303);
                editor.putFloat("y", (float) 446.1);
                break;
            case "E3":
                KLog.d();
                editor.putFloat("x", (float) 505.7);
                editor.putFloat("y", (float) 445.2);
                break;
            case "E4":
                KLog.d();
                editor.putFloat("x", (float) 707.1);
                editor.putFloat("y", (float) 445.9);
                break;
            case "E5-01":
                KLog.d();
                editor.putFloat("x", (float) 799.3);
                editor.putFloat("y", (float) 266.2);
                break;
            case "E5-02":
                KLog.d();
                editor.putFloat("x", (float) 852.5);
                editor.putFloat("y", (float) 298.3);
                break;

            //D
            case "D":
                KLog.d();
                editor.putFloat("x", (float) 85.1);
                editor.putFloat("y", (float) 533.9);
                break;
            case "C":
                KLog.d();
                editor.putFloat("x", (float) 355.2);
                editor.putFloat("y", (float) 533.9);
                break;
            case "F-1":
                KLog.d();
                editor.putFloat("x", (float) 604.5);
                editor.putFloat("y", (float) 190.3);
                break;
            case "F-2":
                KLog.d();
                editor.putFloat("x", (float) 602.7);
                editor.putFloat("y", (float) 262.8);
                break;
            case "F-3":
                KLog.d();
                editor.putFloat("x", (float) 608.3);
                editor.putFloat("y", (float) 391.3);
                break;

            //M
            case "M-1":
                KLog.d();
                editor.putFloat("x", (float) 90.4);
                editor.putFloat("y", (float) 576.8);
                break;
            case "M-2":
                KLog.d();
                editor.putFloat("x", (float) 344.7);
                editor.putFloat("y", (float) 85.3);
                break;
            case "M-3":
                KLog.d();
                editor.putFloat("x", (float) 396.3);
                editor.putFloat("y", (float) 93.2);
                break;

            //P
            case "P-1":
                KLog.d();
                editor.putFloat("x", (float) 539.7);
                editor.putFloat("y", (float) 618.9);
                break;
            case "P-2":
                KLog.d();
                editor.putFloat("x", (float) 512);
                editor.putFloat("y", (float) 134);
                break;

            default:
                break;
        }


        if (editor.commit()) {
            KLog.i("SaveSP ok /" + location + "/" + pos);

        } else {
            KLog.e("SaveIpcSP fail /");

        }
    }

    public String getLocationSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        String location = sp.getString("location", "");
        int pos = sp.getInt("pos", 0);

        KLog.i("get location from SP" +
                "location=" + location);

        return location;

    }

    public float getLocXSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        float x = sp.getFloat("x", 0.0f);

        KLog.i("get x from SP" +
                "x=" + x);

        return x;

    }

    public float getLocYSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        float y = sp.getFloat("y", 0.0f);

        KLog.i("get y from SP" +
                "y=" + y);

        return y;

    }

    public int getSpinnerPosSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences("location", Context.MODE_PRIVATE);
        String location = sp.getString("location", "");
        int pos = sp.getInt("pos", -1);

        KLog.i("get pos from SP" +
                "pos=" + location);

        return pos;

    }

    public static synchronized HashMap<String, CompanyBean> getCNCompDataHashMap() {

        if (map != null) {
            KLog.i(TAG, "map already exist ");
            return map;
        } else {
            KLog.i(TAG, "map = null, new a map ");

            map = new HashMap<>();

            //E馆中文

            map.put(MapUtils.trim(" 广州魅视电子科技有限公司                               "), new CompanyBean(" 广州魅视电子科技有限公司                           ", "    EA1-01      ", 34.9, 390.2));
            map.put(MapUtils.trim(" 北京东方佳联影视技术有限公司                          "), new CompanyBean(" 北京东方佳联影视技术有限公司                     ", "     EA2-01     ", 36.5, 335.3));
            map.put(MapUtils.trim(" 迪碧音响技术（中国）有限公司                          "), new CompanyBean(" 迪碧音响技术（中国）有限公司                     ", "     EA3-01     ", 34.2, 299.7));
            map.put(MapUtils.trim(" 奥罗拉多媒体亚洲有限公司                               "), new CompanyBean(" 奥罗拉多媒体亚洲有限公司                           ", "    EA4-01      ", 54.1, 223.1));
            map.put(MapUtils.trim(" 天地众和（香港）专业技术有限公司                    "), new CompanyBean("  天地众和（香港）专业技术有限公司                ", "    EA5-01      ", 20.7, 126.4));
            map.put(MapUtils.trim(" 上海寰视网络科技有限公司                               "), new CompanyBean(" 上海寰视网络科技有限公司                           ", "    EA6-01      ", 55.4, 165.4));
            map.put(MapUtils.trim(" 莱威视觉亚洲有限公司                                    "), new CompanyBean("  莱威视觉亚洲有限公司                                ", "    EA4-03      ", 48.5, 248.1));
            map.put(MapUtils.trim(" 深圳市迈锐光电有限公司                                  "), new CompanyBean(" 深圳市迈锐光电有限公司                             ", "     EA8-01     ", 55.7, 91.9));
            map.put(MapUtils.trim(" 深圳前海创思特光电科技有限公司                       "), new CompanyBean(" 深圳前海创思特光电科技有限公司                   ", "    EA9-01      ", 25, 38));
            map.put(MapUtils.trim(" 华泰敏控股有限公司                                       "), new CompanyBean(" 华泰敏控股有限公司                                   ", "    EA10-01    ", 60, 37));
            map.put(MapUtils.trim(" 珠海市雷蒙数字音频设备有限公司                       "), new CompanyBean(" 珠海市雷蒙数字音频设备有限公司                   ", "    EB9-01      ", 100.3, 36.8));
            map.put(MapUtils.trim(" 方图智能（深圳）科技集团股份有限公司               "), new CompanyBean(" 方图智能（深圳）科技集团股份有限公司           ", "    EB7-01      ", 101.1, 92.4));
            map.put(MapUtils.trim(" 深圳市东微智能科技股份有限公司                       "), new CompanyBean(" 深圳市东微智能科技股份有限公司                   ", "    EB5-01      ", 100.9, 165.4));
            map.put(MapUtils.trim(" 上海大因多媒体技术有限公司                            "), new CompanyBean("  上海大因多媒体技术有限公司                        ", "    EB3-01      ", 100.6, 233.8));
            map.put(MapUtils.trim(" 照彰实业（东莞）有限公司                               "), new CompanyBean(" 照彰实业（东莞）有限公司                           ", "    EB2-01      ", 113.9, 301.2));
            map.put(MapUtils.trim(" 松下电器（中国）有限公司                               "), new CompanyBean(" 松下电器（中国）有限公司                           ", "    EB1-01      ", 113.3, 367.1));
            map.put(MapUtils.trim(" LG电子（中国）有限公司                                 "), new CompanyBean(" LG电子（中国）有限公司                             ", "    EC1-01      ", 196.1, 367.8));
            map.put(MapUtils.trim(" 深圳市洲明科技股份有限公司                            "), new CompanyBean("  深圳市洲明科技股份有限公司                        ", "    EC2-01      ", 195.3, 301.5));
            map.put(MapUtils.trim(" 森海塞尔电子(北京)有限公司                             "), new CompanyBean(" 森海塞尔电子(北京)有限公司                        ", "     EB4-01     ", 137.4, 233.8));
            map.put(MapUtils.trim(" 北京铁三角技术开发有限公司                            "), new CompanyBean("  北京铁三角技术开发有限公司                        ", "    EB6-01      ", 137.6, 166.2));
            map.put(MapUtils.trim(" 恩平市海天电子科技有限公司                            "), new CompanyBean("  恩平市海天电子科技有限公司                        ", "    EB8-01      ", 137.1, 91.6));
            map.put(MapUtils.trim(" 康朔孚智能控制科技（上海）有限公司                  "), new CompanyBean(" 康朔孚智能控制科技（上海）有限公司             ", "     EB10-01    ", 137.6, 37));
            map.put(MapUtils.trim(" Comm-Tec Asia Limited                               "), new CompanyBean(" Comm-Tec Asia Limited                          ", "     EC9-01     ", 178.2, 37.3));
            map.put(MapUtils.trim(" 上海三思电子工程有限公司                               "), new CompanyBean(" 上海三思电子工程有限公司                           ", "    EC7-01      ", 177.2, 92.4));
            map.put(MapUtils.trim(" 大连科迪视频技术有限公司                               "), new CompanyBean(" 大连科迪视频技术有限公司                           ", "    EC5-01      ", 178.2, 165.9));
            map.put(MapUtils.trim(" 沃府视讯                                                    "), new CompanyBean("  沃府视讯                                                ", "    EC3-01      ", 177.7, 233.8));
            map.put(MapUtils.trim(" 爱普生（中国）有限公司                                  "), new CompanyBean(" 爱普生（中国）有限公司                             ", "     ED1-01     ", 275.0, 367.3));
            map.put(MapUtils.trim(" 北京缔佳宝胜科技有限公司                               "), new CompanyBean(" 北京缔佳宝胜科技有限公司                           ", "    ED2-01      ", 274.9, 306.1));
            map.put(MapUtils.trim(" 北京淳中科技股份有限公司                               "), new CompanyBean(" 北京淳中科技股份有限公司                           ", "    ED3-01      ", 275.5, 233.8));
            map.put(MapUtils.trim(" 北京太平宝迪科技发展有限公司                          "), new CompanyBean(" 北京太平宝迪科技发展有限公司                     ", "     EC4-01     ", 216.0, 233.8));
            map.put(MapUtils.trim(" ClearOne Inc.                                            "), new CompanyBean("  ClearOne Inc.                                        ", "    EC6-01      ", 216.5, 165.7));
            map.put(MapUtils.trim(" 深圳市艾比森光电股份有限公司                          "), new CompanyBean(" 深圳市艾比森光电股份有限公司                     ", "     ED5-01     ", 234.6, 92.2));
            map.put(MapUtils.trim(" 声丽佳音频设计（亚洲）有限公司                       "), new CompanyBean(" 声丽佳音频设计（亚洲）有限公司                   ", "    EC10-01    ", 216.5, 37.3));
            map.put(MapUtils.trim(" 声丽佳音频设计（亚洲）有限公司                       "), new CompanyBean(" 声丽佳音频设计（亚洲）有限公司                   ", "    ED7-01      ", 253.5, 36.8));
            map.put(MapUtils.trim(" 北京显约科技有限公司                                    "), new CompanyBean("  北京显约科技有限公司                                ", "    ED8-01      ", 392.6, 37));
            map.put(MapUtils.trim(" 上海大视电子科技有限公司                               "), new CompanyBean(" 上海大视电子科技有限公司                           ", "    ED6-01      ", 293.1, 91.9));
            map.put(MapUtils.trim(" 利亚德光电股份有限公司                                  "), new CompanyBean(" 利亚德光电股份有限公司                             ", "     ED4-01     ", 275.7, 165.9));
            map.put(MapUtils.trim(" 深圳市汉锐信息技术股份有限公司                       "), new CompanyBean(" 深圳市汉锐信息技术股份有限公司                   ", "    EE7-01      ", 349.3, 38));
            map.put(MapUtils.trim(" 厦门视诚科技有限公司                                    "), new CompanyBean("  厦门视诚科技有限公司                                ", "    EE5-01      ", 347.5, 92.4));
            map.put(MapUtils.trim(" 北京环宇蓝博科技有限公司                               "), new CompanyBean(" 北京环宇蓝博科技有限公司                           ", "    EE4-02      ", 359.5, 142.4));
            map.put(MapUtils.trim(" 克莱默电子                                                  "), new CompanyBean(" 克莱默电子                                             ", "     EE4-01      ", 359.5, 173.8));
            map.put(MapUtils.trim(" 张家港宝视特影视器材有限公司                          "), new CompanyBean(" 张家港宝视特影视器材有限公司                     ", "     EE8-01      ", 392.7, 37.5));
            map.put(MapUtils.trim(" 大连捷成实业发展有限公司                               "), new CompanyBean(" 大连捷成实业发展有限公司                           ", "    EE6-01      ", 392.9, 91.9));
            map.put(MapUtils.trim(" 铁力山（北京）控制技术有限公司                       "), new CompanyBean(" 铁力山（北京）控制技术有限公司                   ", "    EF5-01      ", 418.2, 165.2));
            map.put(MapUtils.trim(" 河北海捷现代教学设备有限公司                          "), new CompanyBean(" 河北海捷现代教学设备有限公司                     ", "     EF9-01      ", 433.3, 36.8));
            map.put(MapUtils.trim(" 北京科旭威尔科技股份有限公司                          "), new CompanyBean(" 北京科旭威尔科技股份有限公司                     ", "     EF7-01      ", 433.3, 92.2));
            map.put(MapUtils.trim(" 英国艾德科技有限公司                                    "), new CompanyBean("  英国艾德科技有限公司                                ", "    EF10-01    ", 471.8, 36.8));
            map.put(MapUtils.trim(" 凯新创达（深圳）科技发展有限公司                    "), new CompanyBean("  凯新创达（深圳）科技发展有限公司                ", "    EF8-01      ", 471.8, 91.9));
            map.put(MapUtils.trim(" 深圳市台电实业有限公司                                  "), new CompanyBean(" 深圳市台电实业有限公司                             ", "     EF6-01      ", 463.4, 165.7));
            map.put(MapUtils.trim(" 深圳市中帝威科技有限公司                               "), new CompanyBean(" 深圳市中帝威科技有限公司                           ", "    EG9-01      ", 510.4, 36.5));
            map.put(MapUtils.trim(" 清投智能（北京）科技股份有限公司                    "), new CompanyBean("  清投智能（北京）科技股份有限公司                ", "    EG7-01      ", 510.4, 91.9));
            map.put(MapUtils.trim(" 北京宏正腾达科技有限公司                               "), new CompanyBean(" 北京宏正腾达科技有限公司                           ", "    EG5-01      ", 503.0, 165.2));
            map.put(MapUtils.trim(" 广州市埃威姆电子科技有限公司                          "), new CompanyBean(" 广州市埃威姆电子科技有限公司                     ", "     EG10-01    ", 556.3, 36.5));
            map.put(MapUtils.trim(" 雅马哈乐器音响（中国）投资有限公司                  "), new CompanyBean(" 雅马哈乐器音响（中国）投资有限公司             ", "     EG8-01     ", 548.7, 92.2));
            map.put(MapUtils.trim(" 南鹏科技开发有限公司                                    "), new CompanyBean("  南鹏科技开发有限公司                                ", "    EG6-01      ", 540.8, 165.7));
            map.put(MapUtils.trim(" HDBaseT Alliance / Valens                           "), new CompanyBean(" HDBaseT Alliance / Valens                      ", "     EH9-01     ", 616.1, 36.8));
            map.put(MapUtils.trim(" 深圳市迈普视通科技有限公司                            "), new CompanyBean("  深圳市迈普视通科技有限公司                        ", "    EH6-01      ", 588.5, 91.9));
            map.put(MapUtils.trim(" 上海派乐电气有限公司                                    "), new CompanyBean("  上海派乐电气有限公司                                ", "    EH4-01      ", 580.8, 165.2));
            map.put(MapUtils.trim(" Penton Audio                                             "), new CompanyBean(" Penton Audio                                         ", "    EH7-01      ", 629.1, 92.2));
            map.put(MapUtils.trim(" 广州华汇音响顾问有限公司                               "), new CompanyBean(" 广州华汇音响顾问有限公司                           ", "    EH5-01      ", 623.7, 165.2));
            map.put(MapUtils.trim(" 广州市天誉创高电子科技有限公司                       "), new CompanyBean(" 广州市天誉创高电子科技有限公司                   ", "    EE3-01      ", 336.4, 233.8));
            map.put(MapUtils.trim(" 杰云通(北京) 技术有限公司                              "), new CompanyBean("  杰云通(北京) 技术有限公司                          ", "    EF3-01      ", 429.7, 234.6));
            map.put(MapUtils.trim(" 深圳市载德光电技术开发有限公司                       "), new CompanyBean(" 深圳市载德光电技术开发有限公司                   ", "    EF4-01      ", 471.1, 233.3));
            map.put(MapUtils.trim(" 广州美视晶莹银幕有限公司                               "), new CompanyBean(" 广州美视晶莹银幕有限公司                           ", "    EG3-01      ", 515.7, 234.1));
            map.put(MapUtils.trim(" 佛山市天创中电经贸有限公司                            "), new CompanyBean("  佛山市天创中电经贸有限公司                        ", "    EG4-01      ", 557.9, 234.1));
            map.put(MapUtils.trim(" 哈曼科技(深圳)有限公司                                  "), new CompanyBean(" 哈曼科技(深圳)有限公司                              ", "    EH3-01      ", 613.8, 233.8));
            map.put(MapUtils.trim(" 北京博睿维讯科技有限公司                               "), new CompanyBean(" 北京博睿维讯科技有限公司                           ", "    EE2-01      ", 366.7, 304.0));
            map.put(MapUtils.trim(" 北京双旗世纪科技有限公司                               "), new CompanyBean(" 北京双旗世纪科技有限公司                           ", "    EF2-01      ", 448.2, 304.3));
            map.put(MapUtils.trim(" 北京小鸟科技股份有限公司                               "), new CompanyBean(" 北京小鸟科技股份有限公司                           ", "    EG2-01      ", 530.4, 304.9));
            map.put(MapUtils.trim(" 深圳市联建光电股份有限公司                            "), new CompanyBean("  深圳市联建光电股份有限公司                        ", "    EH2-01      ", 609.8, 304.9));
            map.put(MapUtils.trim(" 爱思创电子（上海）有限公司                            "), new CompanyBean("  爱思创电子（上海）有限公司                        ", "    EE1-01      ", 365.5, 367.3));
            map.put(MapUtils.trim(" 索尼（中国）有限公司                                    "), new CompanyBean("  索尼（中国）有限公司                                ", "    EF1-01      ", 447.7, 367.5));
            map.put(MapUtils.trim(" 广州德浩科视电子科技有限公司                          "), new CompanyBean(" 广州德浩科视电子科技有限公司                     ", "     EG1-01     ", 530.5, 366.6));
            map.put(MapUtils.trim(" 深圳市奥拓电子股份有限公司                            "), new CompanyBean("  深圳市奥拓电子股份有限公司                        ", "    EH1-01      ", 608.7, 366.6));
            map.put(MapUtils.trim(" 广州湖森电子科技有限公司                               "), new CompanyBean(" 广州湖森电子科技有限公司                           ", "    EJ6-01       ", 691.9, 37));
            map.put(MapUtils.trim(" 广州长图量传电子科技有限公司                          "), new CompanyBean(" 广州长图量传电子科技有限公司                     ", "     EK7-01     ", 765.2, 36.5));
            map.put(MapUtils.trim(" 广州市保伦电子有限公司                                  "), new CompanyBean(" 广州市保伦电子有限公司                             ", "     EJ5-01      ", 683.0, 91.4));
            map.put(MapUtils.trim(" 南中国科技国际有限公司                                  "), new CompanyBean(" 南中国科技国际有限公司                             ", "     EK5-01     ", 730.7, 91.6));
            map.put(MapUtils.trim(" 睿铭声光科技有限公司                                    "), new CompanyBean("  睿铭声光科技有限公司                                ", "    EK6-01      ", 777.2, 92.2));
            map.put(MapUtils.trim(" 易科国际科技有限公司                                    "), new CompanyBean("  易科国际科技有限公司                                ", "    EJ4-01      ", 687.6, 165.4));
            map.put(MapUtils.trim(" 苏州舒尔贸易有限公司                                    "), new CompanyBean("  苏州舒尔贸易有限公司                                ", "    EK4-01      ", 738.6, 165.4));
            map.put(MapUtils.trim(" 杭州席媒科技有限公司                                    "), new CompanyBean("  杭州席媒科技有限公司                                ", "    EL4-01      ", 780.5, 165.9));
            map.put(MapUtils.trim(" 深圳锐取信息技术股份有限公司                          "), new CompanyBean(" 深圳锐取信息技术股份有限公司                     ", "     EJ3-01      ", 381.4, 233.1));
            map.put(MapUtils.trim(" 西安北光数码科技有限公司                               "), new CompanyBean(" 西安北光数码科技有限公司                           ", "    EJ3-02       ", 722.5, 233.8));
            map.put(MapUtils.trim(" 北京威泰嘉业科技有限公司                               "), new CompanyBean(" 北京威泰嘉业科技有限公司                           ", "    EK3-01      ", 773.4, 234.3));
            map.put(MapUtils.trim(" 上海纬而视科技股份有限公司                            "), new CompanyBean("  上海纬而视科技股份有限公司                        ", "    EJ2-01      ", 697.2, 305.2));
            map.put(MapUtils.trim(" 博士视听系统（上海）有限公司                          "), new CompanyBean(" 博士视听系统（上海）有限公司                     ", "     EK2-01     ", 755.3, 305.2));
            map.put(MapUtils.trim(" 北京天翼讯通科技有限公司                               "), new CompanyBean(" 北京天翼讯通科技有限公司                           ", "    EL2-01      ", 793.1, 309.5));
            map.put(MapUtils.trim(" 日立数字映像（中国）有限公司上海分公司            "), new CompanyBean("  日立数字映像（中国）有限公司上海分公司        ", "    EJ1-01      ", 694.6, 366.1));
            map.put(MapUtils.trim(" 北京飞马拓新电子设备有限公司                          "), new CompanyBean(" 北京飞马拓新电子设备有限公司                     ", "     EK1-01     ", 754.0, 367.5));
            map.put(MapUtils.trim(" 北京飞马拓新电子设备有限公司                          "), new CompanyBean(" 北京飞马拓新电子设备有限公司                     ", "     EL1-01      ", 793.1, 372.5));


            //D馆中文
            map.put(MapUtils.trim("   雅思达                                                                   "), new CompanyBean("   雅思达                                             ", "      DD1-05                     ", 19.5, 136.9));
            map.put(MapUtils.trim("   南京美乐威电子科技有限公司                                         "), new CompanyBean("   南京美乐威电子科技有限公司                   ", "      DD1-02                     ", 19.7, 171.8));
            map.put(MapUtils.trim("   深圳大希创新科技有限公司                                           "), new CompanyBean("   深圳大希创新科技有限公司                     ", "      DD1-01                     ", 19.5, 188.4));
            map.put(MapUtils.trim("   宁波音王电声股份有限公司                                           "), new CompanyBean("   宁波音王电声股份有限公司                      ", "     DB4-01                      ", 91.8, 129.9));
            map.put(MapUtils.trim("   深圳市大通无限科技有限公司                                        "), new CompanyBean("    深圳市大通无限科技有限公司                   ", "      DB6-03                     ", 133.3, 123.4));
            map.put(MapUtils.trim("   上海曦煜智能科技有限公司                                           "), new CompanyBean("   上海曦煜智能科技有限公司                      ", "     DB6-02                      ", 133.6, 174.0));
            map.put(MapUtils.trim("   深圳市美誉数码科技有限公司                                        "), new CompanyBean("    深圳市美誉数码科技有限公司                   ", "      DB6-01                     ", 133.6, 191));
            map.put(MapUtils.trim("   先歌国际影音有限公司                                                 "), new CompanyBean("   先歌国际影音有限公司                           ", "      DB3-01                     ", 92.1, 189.8));
            map.put(MapUtils.trim("   广州君南视听科技有限公司                                           "), new CompanyBean("   广州君南视听科技有限公司                      ", "     DC4-01                      ", 23.9, 271.4));
            map.put(MapUtils.trim("   深圳市声菲特科技技术有限公司                                      "), new CompanyBean("   深圳市声菲特科技技术有限公司                 ", "     DC4-02                      ", 23.3, 294.6));
            map.put(MapUtils.trim("   佛山市柯博明珠数码电子有限公司                                   "), new CompanyBean("   佛山市柯博明珠数码电子有限公司               ", "     DC1-01                      ", 24.5, 345.5));
            map.put(MapUtils.trim("   深圳市海勤科技有限公司                                              "), new CompanyBean("   深圳市海勤科技有限公司                         ", "     DC3-01                      ", 62, 285));
            map.put(MapUtils.trim("   深圳市技湛科技有限公司                                              "), new CompanyBean("   深圳市技湛科技有限公司                         ", "     DC2-01                      ", 62, 345.2));
            map.put(MapUtils.trim("   杭州艾力特音频技术有限公司                                        "), new CompanyBean("    杭州艾力特音频技术有限公司                   ", "      DB2-01                     ", 92.7, 288.4));
            map.put(MapUtils.trim("   北京祝融视觉科技股份有限公司                                      "), new CompanyBean("   北京祝融视觉科技股份有限公司                 ", "     DB1-01                      ", 92.4, 345.8));
            map.put(MapUtils.trim("   长沙中天电子设计开发有限公司                                      "), new CompanyBean("   长沙中天电子设计开发有限公司                 ", "     DB5-04                      ", 133.9, 293.7));
            map.put(MapUtils.trim("   深圳市科地通信技术有限公司                                         "), new CompanyBean("   深圳市科地通信技术有限公司                    ", "     DB5-03                      ", 134.2, 310.4));
            map.put(MapUtils.trim("   深圳雷克维尔电子有限公司                                          "), new CompanyBean("    深圳雷克维尔电子有限公司                     ", "      DB5-02                     ", 133.9, 327.8));
            map.put(MapUtils.trim("   恩缇艾音频设备技术（苏州）有限公司                              "), new CompanyBean("   恩缇艾音频设备技术（苏州）有限公司                ", "      DB5-01                     ", 134.6, 344.2));
            map.put(MapUtils.trim("   深圳市好会通科技有限公司                                          "), new CompanyBean("    深圳市好会通科技有限公司                     ", "      DA2-03                     ", 92.4, 431.1));
            map.put(MapUtils.trim("   广州佳比亚电子科技有限公司                                        "), new CompanyBean("    广州佳比亚电子科技有限公司                   ", "      DA2-01                     ", 91.8, 475.7));
            map.put(MapUtils.trim("   深圳市冠标科技发展有限公司                                         "), new CompanyBean("   深圳市冠标科技发展有限公司                   ", "      DA1-03                      ", 127.4, 439.8));
            map.put(MapUtils.trim("   广州市瀚丽美电子有限公司                                           "), new CompanyBean("   广州市瀚丽美电子有限公司                     ", "      DA1-01                     ", 127.4, 474.2));
            map.put(MapUtils.trim("   苏州清听声学科技有限公司                                           "), new CompanyBean("   苏州清听声学科技有限公司                      ", "     CA7-02                      ", 187.3, 25.2));
            map.put(MapUtils.trim("   维摩（北京）科技有限公司                                           "), new CompanyBean("   维摩（北京）科技有限公司                      ", "     CA7-01                      ", 212.9, 25.9));
            map.put(MapUtils.trim("   深圳市金九天视实业有限公司                                        "), new CompanyBean("    深圳市金九天视实业有限公司                   ", "      CA6-01                     ", 178.4, 73.9));
            map.put(MapUtils.trim("   AAVARA Innovation Corp.                                         "), new CompanyBean("   AAVARA Innovation Corp.                   ", "      CA6-03                     ", 212.7, 73.9));
            map.put(MapUtils.trim("   深圳市玩视科技有限公司                                              "), new CompanyBean("   深圳市玩视科技有限公司                         ", "     CB6-01                      ", 253.5, 72.3));
            map.put(MapUtils.trim("   杭州晨安科技股份有限公司                                           "), new CompanyBean("   杭州晨安科技股份有限公司                      ", "     CB6-02                      ", 282.7, 72.6));
            map.put(MapUtils.trim("   恩平市宝丰电子器材厂                                                 "), new CompanyBean("   恩平市宝丰电子器材厂                           ", "      CA5-03                     ", 203.1, 118));
            map.put(MapUtils.trim("   广州畅世智能科技有限公司                                          "), new CompanyBean("    广州畅世智能科技有限公司                     ", "      CA5-02                     ", 177.7, 118.7));
            map.put(MapUtils.trim("   浙江冠轩智能科技有限公司                                           "), new CompanyBean("   浙江冠轩智能科技有限公司                     ", "      CA5-01                     ", 194.8, 141.6));
            map.put(MapUtils.trim("   北京久达之声科贸有限公司                                           "), new CompanyBean("   北京久达之声科贸有限公司                      ", "     CB5-01                      ", 269.6, 144.2));
            map.put(MapUtils.trim("   毕孚自动化设备贸易（上海）有限公司                              "), new CompanyBean("   毕孚自动化设备贸易（上海）有限公司                 ", "     CB5-02                      ", 267.8, 120.8));
            map.put(MapUtils.trim("   安恒利（上海）贸易有限公司                                        "), new CompanyBean("    安恒利（上海）贸易有限公司                   ", "      CA4-01                     ", 195.9, 198.7));
            map.put(MapUtils.trim("   厦门亿联网络技术股份有限公司                                      "), new CompanyBean("   厦门亿联网络技术股份有限公司                 ", "     CB4-01                      ", 266.3, 199.4));
            map.put(MapUtils.trim("   广州凯图电子科技有限公司                                           "), new CompanyBean("   广州凯图电子科技有限公司                     ", "      CA3-01                     ", 194.7, 276.3));
            map.put(MapUtils.trim("   广州市迪士普音响科技有限公司                                      "), new CompanyBean("   广州市迪士普音响科技有限公司                 ", "     CB3-01                      ", 269.4, 277.6));
            map.put(MapUtils.trim("   深圳市科伦特科技有限公司                                          "), new CompanyBean("    深圳市科伦特科技有限公司                     ", "      CA2-01                     ", 195, 343.6));
            map.put(MapUtils.trim("   北京博信宏达机房设备有限公司                                      "), new CompanyBean("   北京博信宏达机房设备有限公司                 ", "     CB2-01                      ", 267.9, 343.9));
            map.put(MapUtils.trim("   杭州海康威视数字技术股份有限公司                                 "), new CompanyBean("   杭州海康威视数字技术股份有限公司                ", "      CA1-01                      ", 194.3, 416.3));
            map.put(MapUtils.trim("   杭州华会通科技股份有限公司                                         "), new CompanyBean("   杭州华会通科技股份有限公司                   ", "      CB1-01                      ", 267.5, 417.0));
            map.put(MapUtils.trim("   佳耐美电气（天津）有限公司                                         "), new CompanyBean("   佳耐美电气（天津）有限公司                    ", "     CE1-01                      ", 299.9, 25.7));
            map.put(MapUtils.trim("   天津瑞发科半导体技术有限公司                                      "), new CompanyBean("   天津瑞发科半导体技术有限公司                 ", "     CE1-03                      ", 335.6, 25.9));
            map.put(MapUtils.trim("   林迪（宁波）电子有限公司                                           "), new CompanyBean("   林迪（宁波）电子有限公司                     ", "      CE1-05                      ", 369.5, 24.9));
            map.put(MapUtils.trim("   新基科技股份有限公司                                                 "), new CompanyBean("   新基科技股份有限公司                           ", "      CE1-07                      ", 396.2, 25.6));
            map.put(MapUtils.trim("   深圳市宝疆科技有限公司                                             "), new CompanyBean("    深圳市宝疆科技有限公司                        ", "      CE1-08                     ", 413.0, 25.6));
            map.put(MapUtils.trim("   佑霖科技股份有限公司                                                "), new CompanyBean("    佑霖科技股份有限公司                           ", "      CE1-09                     ", 432.9, 25.4));
            map.put(MapUtils.trim("   广州和力视听设备有限公司                                           "), new CompanyBean("   广州和力视听设备有限公司                     ", "      CC6-01                      ", 346.4, 72.6));
            map.put(MapUtils.trim("   Listen Technologies                                                "), new CompanyBean("   Listen Technologies                           ", "     CC6-02                      ", 374.1, 71.4));
            map.put(MapUtils.trim("   江门市捷思通电子科技有限公司                                     "), new CompanyBean("    江门市捷思通电子科技有限公司                ", "      CD6-01                     ", 424.9, 72.5));
            map.put(MapUtils.trim("   深圳市网今科技有限公司                                              "), new CompanyBean("   深圳市网今科技有限公司                         ", "     CD6-02                      ", 473.9, 74.9));
            map.put(MapUtils.trim("   广州市东来电子科技有限公司                                         "), new CompanyBean("   广州市东来电子科技有限公司                   ", "      CD6-04                      ", 473.7, 47.4));
            map.put(MapUtils.trim("   深圳市鸿哲智能系统工程有限公司                                   "), new CompanyBean("   深圳市鸿哲智能系统工程有限公司                ", "      CC5-01                     ", 359.6, 132.2));
            map.put(MapUtils.trim("   上海洋铭数码科技有限公司                                          "), new CompanyBean("    上海洋铭数码科技有限公司                     ", "      CC4-01                     ", 358.5, 198.5));
            map.put(MapUtils.trim("   深圳市翌田科技有限公司                                              "), new CompanyBean("   深圳市翌田科技有限公司                        ", "      CD5-02                     ", 439.3, 122.2));
            map.put(MapUtils.trim("   湖北安心智能科技有限公司                                          "), new CompanyBean("    湖北安心智能科技有限公司                     ", "      CD5-01                     ", 441.1, 143.4));
            map.put(MapUtils.trim("   上海精仪达智能科技有限公司                                        "), new CompanyBean("    上海精仪达智能科技有限公司                   ", "      CD4-01                     ", 437.8, 198.2));
            map.put(MapUtils.trim("   伟成资讯科技有限公司                                                 "), new CompanyBean("   伟成资讯科技有限公司                            ", "     CC3-01-B                      ", 359.8, 277.2));
            map.put(MapUtils.trim("   炬力北方微电子有限公司                                              "), new CompanyBean("   炬力北方微电子有限公司                         ", "     CC3-01-C                      ", 359.8, 277.2));
            map.put(MapUtils.trim("   中强光电股份有限公司                                                 "), new CompanyBean("   中强光电股份有限公司                            ", "     CC3-01-A                      ", 359.8, 277.2));
            map.put(MapUtils.trim("   上海谷睿电子科技有限公司                                          "), new CompanyBean("    上海谷睿电子科技有限公司                     ", "      CD3-01                     ", 438.3, 276.1));
            map.put(MapUtils.trim("   上海晨驭信息科技有限公司                                           "), new CompanyBean("   上海晨驭信息科技有限公司                      ", "     CD2-01                      ", 437.1, 334.8));
            map.put(MapUtils.trim("   承大科技有限公司                                                      "), new CompanyBean("   承大科技有限公司                                 ", "     CC2-01-C                      ", 359.1, 336.6));
            map.put(MapUtils.trim("   日升电子股份有限公司                                                "), new CompanyBean("    日升电子股份有限公司                           ", "      CC2-01-A                     ", 359.1, 336.6));
            map.put(MapUtils.trim("   承远科技股份有限公司                                                 "), new CompanyBean("   承远科技股份有限公司                            ", "     CC2-01-B                      ", 359.1, 336.6));
            map.put(MapUtils.trim("   聪泰科技开发股份有限公司                                           "), new CompanyBean("   聪泰科技开发股份有限公司                      ", "     CC1-01-A                      ", 360.5, 410.7));
            map.put(MapUtils.trim("   五角科技股份有限公司                                                 "), new CompanyBean("   五角科技股份有限公司                            ", "     CC1-01-C                      ", 360.5, 410.7));
            map.put(MapUtils.trim("   台湾数位广告牌多媒体联盟                                           "), new CompanyBean("   台湾数位广告牌多媒体联盟                      ", "     CC1-01                      ", 360.5, 410.7));
            map.put(MapUtils.trim("   嘉世联有限公司                                                        "), new CompanyBean("    嘉世联有限公司                                   ", "      CC1-01-B                     ", 360.5, 410.7));
            map.put(MapUtils.trim("   捷波资讯股份有限公司                                                "), new CompanyBean("    捷波资讯股份有限公司                           ", "      CC1-01-D                     ", 360.5, 410.7));
            map.put(MapUtils.trim("   宏亮科技                                                                "), new CompanyBean("    宏亮科技                                           ", "      CC1-01-E                     ", 360.5, 410.7));
            map.put(MapUtils.trim("   英特尔（中国）有限公司                                              "), new CompanyBean("   英特尔（中国）有限公司                        ", "      CD1-01                     ", 438.5, 407.7));
            map.put(MapUtils.trim("   广州南翼信息科技有限公司                                          "), new CompanyBean("    广州南翼信息科技有限公司                     ", "      FA5-01                     ", 580.1, 195.7));
            map.put(MapUtils.trim("   深圳市爱鑫微电子有限公司                                           "), new CompanyBean("   深圳市爱鑫微电子有限公司                      ", "     FA4-01                       ", 580.1, 380.5));
            map.put(MapUtils.trim("   上海派逗数字科技股份有限公司                                      "), new CompanyBean("   上海派逗数字科技股份有限公司                ", "      FA3-01                     ", 580.4, 409.7));
            map.put(MapUtils.trim("   深圳市康冠商用科技有限公司                                         "), new CompanyBean("   深圳市康冠商用科技有限公司                   ", "      FB3-01                      ", 665.0, 236.9));
            map.put(MapUtils.trim("   北京合想同创科技有限公司                                           "), new CompanyBean("   北京合想同创科技有限公司                     ", "      FC3-01                     ", 704.4, 235.7));
            map.put(MapUtils.trim("   深圳市保凌影像科技有限公司                                        "), new CompanyBean("    深圳市保凌影像科技有限公司                   ", "      FD7-01                     ", 739.1, 227.6));
            map.put(MapUtils.trim("   上海示见信息技术有限公司                                          "), new CompanyBean("    上海示见信息技术有限公司                     ", "      FD6-01                     ", 739.7, 245.6));
            map.put(MapUtils.trim("   上海索望光电科技有限公司                                          "), new CompanyBean("    上海索望光电科技有限公司                     ", "      FB2-01                     ", 663.5, 290.6));
            map.put(MapUtils.trim("   深圳市云智科技有限公司                                             "), new CompanyBean("    深圳市云智科技有限公司                        ", "      FC2-01                     ", 705.3, 290.3));
            map.put(MapUtils.trim("   上海菱博电子技术股份有限公司                                      "), new CompanyBean("   上海菱博电子技术股份有限公司                ", "      FC1-01                      ", 705.0, 345.2));
            map.put(MapUtils.trim("   北京视通科技有限公司                                                 "), new CompanyBean("   北京视通科技有限公司                            ", "     FD5-01                       ", 739.1, 273.2));
            map.put(MapUtils.trim("   兴天通讯技术有限公司                                                 "), new CompanyBean("   兴天通讯技术有限公司                            ", "     FD4-01                      ", 739.4, 290.9));
            map.put(MapUtils.trim("   杭州大和热磁电子有限公司                                          "), new CompanyBean("    杭州大和热磁电子有限公司                     ", "      FD3-01                     ", 740.3, 307.7));
            map.put(MapUtils.trim("   Polycom通讯系统（北京）有限公司                                "), new CompanyBean("   Polycom通讯系统（北京）有限公司                ", "      FB1-01                     ", 663.5, 345.5));
            map.put(MapUtils.trim("   上海菱博电子技术股份有限公司                                      "), new CompanyBean("   上海菱博电子技术股份有限公司                 ", "     FC1-01                      ", 705.0, 345.0));
            map.put(MapUtils.trim("   深圳市华序通科技有限公司                                          "), new CompanyBean("    深圳市华序通科技有限公司                     ", "      FD2-01                     ", 739.4, 337.4));
            map.put(MapUtils.trim("   北京阳光金网科技发展有限公司                                      "), new CompanyBean("   北京阳光金网科技发展有限公司                ", "      FD1-01                     ", 740.0, 353.9));


            //p    cn
            map.put(MapUtils.trim(" 钢穗贸易（上海）有限公司                                                    "), new CompanyBean("      钢穗贸易（上海）有限公司                                                          ", "       PA4-06                        ", 310.8, 201.7));
            map.put(MapUtils.trim(" 深圳市昊一源科技有限公司                                                    "), new CompanyBean("      深圳市昊一源科技有限公司                                                         ", "        PA4-05                       ", 310.6, 218.0));
            map.put(MapUtils.trim(" Macro Image Technology Inc.                                                    "), new CompanyBean("      Macro Image Technology Inc.                                                         ", "        PA4-03                       ", 310.0, 235.7));
            map.put(MapUtils.trim(" 深圳托马斯贸易有限公司                                                    "), new CompanyBean("      深圳托马斯贸易有限公司                                                          ", "       PA4-02                        ", 310.0, 252.6));
            map.put(MapUtils.trim(" 广州准音电子科技有限公司                                                   "), new CompanyBean("       广州准音电子科技有限公司                                                         ", "        PA4-01                       ", 310.0, 277.4));
            map.put(MapUtils.trim(" 深圳市康帕斯科技发展有限公司                                                    "), new CompanyBean("      深圳市康帕斯科技发展有限公司                                                          ", "       PB6-02                        ", 354.7, 207.4));
            map.put(MapUtils.trim(" 阿米纳音响（深圳）有限公司                                                   "), new CompanyBean("       阿米纳音响（深圳）有限公司                                                         ", "        PB6-01                       ", 323.7, 225.2));
            map.put(MapUtils.trim(" 青岛海信激光显示股份有限公司                                                    "), new CompanyBean("      青岛海信激光显示股份有限公司                                                         ", "        PB5-01                       ", 353.5, 273.1));
            map.put(MapUtils.trim(" 深圳鑫亿光科技有限公司                                                    "), new CompanyBean("      深圳鑫亿光科技有限公司                                                          ", "       PC6-02                        ", 408.2, 206.7));
            map.put(MapUtils.trim(" 上海迪东实业有限公司                                                    "), new CompanyBean("      上海迪东实业有限公司                                                          ", "       PC6-01                        ", 407.6, 227.2));
            map.put(MapUtils.trim(" 汉创企业（中国）有限公司                                                    "), new CompanyBean("      汉创企业（中国）有限公司                                                          ", "       PC5-01                        ", 408.4, 271.1));
            map.put(MapUtils.trim(" 丽台（上海）信息科技有限公司                                                    "), new CompanyBean("      丽台（上海）信息科技有限公司                                                          ", "       PA3-08                        ", 309.2, 334.7));
            map.put(MapUtils.trim(" 昆山立摩电子科技有限公司                                                    "), new CompanyBean("      昆山立摩电子科技有限公司                                                          ", "       PA3-07                        ", 310.5, 360.4));
            map.put(MapUtils.trim(" 北京理澳视通科技有限公司                                                   "), new CompanyBean("       北京理澳视通科技有限公司                                                         ", "        PA3-05                       ", 310.9, 386.7));
            map.put(MapUtils.trim(" 佛山市创思特音响有限公司                                                    "), new CompanyBean("      佛山市创思特音响有限公司                                                          ", "       PA3-04                        ", 310.7, 410.3));
            map.put(MapUtils.trim(" 深圳市顺讯电子有限公司                                                    "), new CompanyBean("      深圳市顺讯电子有限公司                                                          ", "       PA3-03                        ", 310.3, 426.7));
            map.put(MapUtils.trim(" 北京麦创思科技发展有限公司                                                    "), new CompanyBean("      北京麦创思科技发展有限公司                                                          ", "       PA3-01                        ", 310.1, 452.6));
            map.put(MapUtils.trim(" 广州市创视智能设备有限公司                                                   "), new CompanyBean("       广州市创视智能设备有限公司                                                         ", "        PB4-01                       ", 352.3, 351.3));
            map.put(MapUtils.trim(" 北京方圆智汇电子科技有限公司                                                    "), new CompanyBean("      北京方圆智汇电子科技有限公司                                                         ", "        PB3-01                       ", 352.5, 412.0));
            map.put(MapUtils.trim(" 苏州科达科技股份有限公司                                                   "), new CompanyBean("       苏州科达科技股份有限公司                                                         ", "        PB2-01                       ", 351.9, 475.6));
            map.put(MapUtils.trim(" 苏州科达科技股份有限公司                                                   "), new CompanyBean("       苏州科达科技股份有限公司                                                         ", "        pc2-01                       ", 351.9, 475.7));
            map.put(MapUtils.trim(" 北京东方久瑞科技股份有限公司                                                    "), new CompanyBean("      北京东方久瑞科技股份有限公司                                                         ", "        PC1-01                        ", 379.7, 546.6));
            map.put(MapUtils.trim(" 安徽科视激光科技有限公司                                                    "), new CompanyBean("      安徽科视激光科技有限公司                                                         ", "        PC4-01                       ", 406.6, 349.2));
            map.put(MapUtils.trim(" 成都菲斯特科技有限公司                                                    "), new CompanyBean("      成都菲斯特科技有限公司                                                          ", "       PC3-01                        ", 406.6, 411.6));
            map.put(MapUtils.trim(" 成都市锐极科技有限公司                                                    "), new CompanyBean("      成都市锐极科技有限公司                                                          ", "       PD6-01                        ", 476.6, 216.3));
            map.put(MapUtils.trim(" 重庆融豪太视科技有限公司                                                   "), new CompanyBean("       重庆融豪太视科技有限公司                                                         ", "        PD5-01                       ", 510.1, 271.8));
            map.put(MapUtils.trim(" 深圳市天合光电有限公司                                                    "), new CompanyBean("      深圳市天合光电有限公司                                                         ", "        PE6-02                       ", 528.8, 217.2));
            map.put(MapUtils.trim(" 北京博创力讯科技有限公司                                                    "), new CompanyBean("      北京博创力讯科技有限公司                                                          ", "       PE6-01                        ", 552.1, 216.6));
            map.put(MapUtils.trim(" 亚特龙亚洲有限公司                                                    "), new CompanyBean("      亚特龙亚洲有限公司                                                          ", "       PD4-01                        ", 476.4, 349.6));
            map.put(MapUtils.trim(" 迈诗得（北京）科技有限公司                                                    "), new CompanyBean("      迈诗得（北京）科技有限公司                                                         ", "        PD3-01                       ", 509.5, 411.1));
            map.put(MapUtils.trim(" 无锡视美乐激光显示科技有限公司                                                   "), new CompanyBean("       无锡视美乐激光显示科技有限公司                                                         ", "        PE4-01                       ", 542.9, 349.2));
            map.put(MapUtils.trim(" 厦门强力巨彩光电科技有限公司                                                    "), new CompanyBean("      厦门强力巨彩光电科技有限公司                                                         ", "        PD2-01                       ", 477.2, 477.0));
            map.put(MapUtils.trim(" 北京彩易达科技发展有限公司                                                    "), new CompanyBean("      北京彩易达科技发展有限公司                                                          ", "       PD1-01                        ", 507.3, 545.6));
            map.put(MapUtils.trim(" 广州视臻信息科技有限公司                                                    "), new CompanyBean("      广州视臻信息科技有限公司                                                          ", "       PE2-01                        ", 546.8, 476.6));
            map.put(MapUtils.trim(" 内田洋行办公设备（上海）有限公司                                                   "), new CompanyBean("       内田洋行办公设备（上海）有限公司                                                         ", "        PF6-01                       ", 629.5, 216.2));
            map.put(MapUtils.trim(" 内田洋行办公设备（上海）有限公司                                                    "), new CompanyBean("      内田洋行办公设备（上海）有限公司                                                          ", "       PF5-01                        ", 629.3, 271.3));
            map.put(MapUtils.trim(" 北京科思诺工程技术有限公司                                                    "), new CompanyBean("      北京科思诺工程技术有限公司                                                         ", "        PG4-03                       ", 680.8, 223.3));
            map.put(MapUtils.trim(" WiseJet Inc.                                                    "), new CompanyBean("      WiseJet Inc.                                                          ", "       PG4-01                        ", 680.4, 256.6));
            map.put(MapUtils.trim(" 深圳市东景盛电子技术有限公司                                                   "), new CompanyBean("       深圳市东景盛电子技术有限公司                                                         ", "        PG3-12                       ", 680.2, 301.6));
            map.put(MapUtils.trim(" 广州市迈拓维矩电子有限公司                                                    "), new CompanyBean("      广州市迈拓维矩电子有限公司                                                          ", "       PG3-10                        ", 681.3, 332.8));
            map.put(MapUtils.trim(" 北京博衍思创信息科技有限公司                                                    "), new CompanyBean("      北京博衍思创信息科技有限公司                                                         ", "        PG3-09                        ", 680.4, 357.1));
            map.put(MapUtils.trim(" 深圳市朗恒科技有限公司                                                    "), new CompanyBean("      深圳市朗恒科技有限公司                                                         ", "        PG3-07                        ", 680.4, 385.9));
            map.put(MapUtils.trim(" 上海直真视通科技有限公司                                                    "), new CompanyBean("      上海直真视通科技有限公司                                                          ", "       PG3-05                        ", 680.2, 416.5));
            map.put(MapUtils.trim(" 东莞阿尔泰显示技术有限公司                                                    "), new CompanyBean("      东莞阿尔泰显示技术有限公司                                                          ", "       PF4-01                        ", 627.4, 350.0));
            map.put(MapUtils.trim(" TCL商用信息科技（惠州）股份有限公司                                                    "), new CompanyBean("      TCL商用信息科技（惠州）股份有限公司                                                         ", "        PF3-01                        ", 628.9, 412.0));
            map.put(MapUtils.trim(" 北京市博汇科技股份有限公司                                                    "), new CompanyBean("      北京市博汇科技股份有限公司                                                         ", "        PF2-01                        ", 627.6, 474.9));
            map.put(MapUtils.trim(" 北京金中恒科技股份有限公司                                                   "), new CompanyBean("       北京金中恒科技股份有限公司                                                         ", "        PG2-01                       ", 680.0, 475.1));
            map.put(MapUtils.trim(" 深圳市鸿合创新信息技术有限责任公司                                                   "), new CompanyBean("       深圳市鸿合创新信息技术有限责任公司                                                         ", "        PF1-01                       ", 633.2, 545.8));


            // m cn
            map.put(MapUtils.trim("  广州市迪士普音响科技有限公司                                                   "), new CompanyBean("   广州市迪士普音响科技有限公司                                                             ", "     MB1-02                          ", 23.6, 539.2));
            map.put(MapUtils.trim("  深圳市乔登影音器材有限公司                                                   "), new CompanyBean("   深圳市乔登影音器材有限公司                                                            ", "      MB1-03                         ", 25.5, 589.4));
            map.put(MapUtils.trim("  台湾得琦电子股份有限公司                                                   "), new CompanyBean("   台湾得琦电子股份有限公司                                                            ", "      MB1-01                         ", 74.4, 513.4));
            map.put(MapUtils.trim("  卡讯电子股份有限公司                                                   "), new CompanyBean("   卡讯电子股份有限公司                                                             ", "     MB2-01                          ", 26.1, 660.4));
            map.put(MapUtils.trim("  TV One Ltd.                                                  "), new CompanyBean("    TV One Ltd.                                                            ", "      MB4-01                         ", 84.7, 688.4));
            map.put(MapUtils.trim("  Dataton AB                                                   "), new CompanyBean("   Dataton AB                                                             ", "     M306A                          ", 321.4, 339.6));
            map.put(MapUtils.trim("  杭州中科极光科技有限公司                                                  "), new CompanyBean("    杭州中科极光科技有限公司                                                            ", "      M306B                         ", 371.6, 344.3));
            map.put(MapUtils.trim("  深圳市帅映科技股份有限公司                                                   "), new CompanyBean("   深圳市帅映科技股份有限公司                                                            ", "      M307A                         ", 424.9, 340.6));
            map.put(MapUtils.trim("  巴可伟视（北京）电子有限公司                                                   "), new CompanyBean("   巴可伟视（北京）电子有限公司                                                             ", "     M308                          ", 607.6, 341.3));
            map.put(MapUtils.trim("  Project Syntropy GmbH                                                   "), new CompanyBean("   Project Syntropy GmbH                                                             ", "     MA15-01                          ", 278.8, 450.9));
            map.put(MapUtils.trim("  ANALOG WAY                                                   "), new CompanyBean("   ANALOG WAY                                                             ", "     MA16-01                          ", 339.8, 453.0));
            map.put(MapUtils.trim("  北京仁光科技有限公司                                                   "), new CompanyBean("   北京仁光科技有限公司                                                             ", "     MA17-01                          ", 403.3, 453.0));
            map.put(MapUtils.trim("  北京仁光科技有限公司                                                   "), new CompanyBean("   北京仁光科技有限公司                                                             ", "     MA18-01                          ", 484.9, 453.0));
            map.put(MapUtils.trim("  杭州中科极光科技有限公司                                                  "), new CompanyBean("    杭州中科极光科技有限公司                                                            ", "      MA19-01                         ", 556.9, 454.8));
            map.put(MapUtils.trim("  鸿视线科技（北京）有限公司                                                   "), new CompanyBean("   鸿视线科技（北京）有限公司                                                             ", "     MA21-01                          ", 621.5, 471.2));
            map.put(MapUtils.trim("  北京赢康科技股份有限公司                                                   "), new CompanyBean("   北京赢康科技股份有限公司                                                             ", "     M311B                          ", 281.4, 578.5));
            map.put(MapUtils.trim("  中达电通股份有限公司                                                   "), new CompanyBean("   中达电通股份有限公司                                                             ", "     M311A                          ", 360.2, 580.7));
            map.put(MapUtils.trim("  快思聪有限公司                                                  "), new CompanyBean("    快思聪有限公司                                                            ", "      M310                         ", 462.2, 575.4));
            map.put(MapUtils.trim("  北京威林视讯科技有限公司                                                   "), new CompanyBean("   北京威林视讯科技有限公司                                                            ", "      M309B-02                         ", 554.6, 613.9));
            map.put(MapUtils.trim("  四川长虹电器股份有限公司                                                  "), new CompanyBean("    四川长虹电器股份有限公司                                                            ", "      M309B-01                         ", 554.6, 549.2));
            map.put(MapUtils.trim("  北京华堂立业科技有限公司                                                  "), new CompanyBean("    北京华堂立业科技有限公司                                                            ", "      M309A-11                         ", 639.7, 629.9));
            map.put(MapUtils.trim("  北京大恒创新技术有限公司                                                   "), new CompanyBean("   北京大恒创新技术有限公司                                                            ", "      M309A-10                          ", 660.2, 629.6));
            map.put(MapUtils.trim("  Audinate, Inc.                                                   "), new CompanyBean("   Audinate, Inc.                                                            ", "      M309A-09                         ", 677.6, 629.9));
            map.put(MapUtils.trim("  南京优比互动多媒体有限公司                                                   "), new CompanyBean("   南京优比互动多媒体有限公司                                                             ", "     M309A-08                          ", 695.3, 630.4));
            map.put(MapUtils.trim("  沈阳秀展科技有限公司                                                   "), new CompanyBean("   沈阳秀展科技有限公司                                                             ", "     M309A-05                          ", 695.8, 590.4));
            map.put(MapUtils.trim("  珠海福睿电子科技有限公司                                                  "), new CompanyBean("    珠海福睿电子科技有限公司                                                            ", "      M309A-04                         ", 677.3, 589.8));
            map.put(MapUtils.trim("  深圳市音飙科技有限公司                                                   "), new CompanyBean("   深圳市音飙科技有限公司                                                            ", "      M309A-03                         ", 660.2, 590.4));
            map.put(MapUtils.trim("  昆山思雷电子科技有限公司                                                   "), new CompanyBean("   昆山思雷电子科技有限公司                                                             ", "     M309A-02                          ", 639.4, 590.1));
            map.put(MapUtils.trim("  中航国画（上海）激光显示技有限公司                                                   "), new CompanyBean("   中航国画（上海）激光显示技有限公司                                                             ", "     M309A-01                          ", 664.9, 551.1));


        }

        KLog.d(TAG, map.hashCode());
        return map;

    }


    public static synchronized HashMap<String, CompanyBean> getENCompDataHashMap() {

        if (enMap != null) {
            KLog.i(TAG, "enMap already exist ");
            return enMap;
        } else {
            KLog.i(TAG, "enMap = null, new a enMap ");

            enMap = new HashMap<>();

//            enMap.put(MapUtils.trim("testname    .-.   "), new CompanyBean("testname01", "ED9-21", 350, 550));

            //E馆英文

            enMap.put(MapUtils.trim("  Guangzhou Meishi Electronic Technology Co., Ltd.                                        "), new CompanyBean("  Guangzhou Meishi Electronic Technology Co., Ltd.                                                                   ", "    EA1-01      ", 34.9, 390.2));
            enMap.put(MapUtils.trim("  Beijing Oriental Prime Connections Film TV Technology Co., Ltd.                    "), new CompanyBean("  Beijing Oriental Prime Connections Film TV Technology Co., Ltd.                                                                  ", "     EA2-01     ", 36.5, 335.3));
            enMap.put(MapUtils.trim("  d&b Audiotechnik (China) Ltd.                                                                   "), new CompanyBean("  d&b Audiotechnik (China) Ltd.                                                                  ", "     EA3-01     ", 34.2, 299.7));
            enMap.put(MapUtils.trim("  Aurora Multimedia Asia Limited                                                                  "), new CompanyBean("  Aurora Multimedia Asia Limited                                                                   ", "    EA4-01      ", 54.1, 223.1));
            enMap.put(MapUtils.trim("  AVCONE & COROARAC (HK) Professional Co., Ltd.                                        "), new CompanyBean("AVCONE & COROARAC (HK) Professional Co., Ltd.                                                                  ", "    EA5-01      ", 20.7, 126.4));
            enMap.put(MapUtils.trim("  MicsView Network Technology Co., Ltd.                                                       "), new CompanyBean("  MicsView Network Technology Co., Ltd.                                                                   ", "    EA6-01      ", 55.4, 165.4));
            enMap.put(MapUtils.trim("  Lightware Visual Engineering Asia Limited                                                   "), new CompanyBean("   Lightware Visual Engineering Asia Limited                                                                  ", "    EA4-03      ", 48.5, 248.1));
            enMap.put(MapUtils.trim("  Shenzhen Mary Photoelectricity Co.,Ltd.                                                      "), new CompanyBean("  Shenzhen Mary Photoelectricity Co.,Ltd.                                                                  ", "     EA8-01     ", 55.7, 91.9));
            enMap.put(MapUtils.trim("  Transtech LED Co., Ltd .                                                                           "), new CompanyBean("  Transtech LED Co., Ltd .                                                                   ", "    EA9-01      ", 25, 38));
            enMap.put(MapUtils.trim("  Shenzhen Walltiming Technologies Co., Ltd.                                                "), new CompanyBean("  Shenzhen Walltiming Technologies Co., Ltd.                                                                   ", "    EA10-01    ", 60, 37));
            enMap.put(MapUtils.trim("  Restmoment Digital Audio Equipment Co., Ltd.                                            "), new CompanyBean("  Restmoment Digital Audio Equipment Co., Ltd.                                                                   ", "    EB9-01      ", 100.3, 36.8));
            enMap.put(MapUtils.trim("  FionTu Intelligence Technology (China) Corp.                                               "), new CompanyBean("  FionTu Intelligence Technology (China) Corp.                                                                   ", "    EB7-01      ", 101.1, 92.4));
            enMap.put(MapUtils.trim("  Shenzhen Tendzone Intelligent Technology Co., Ltd.                                     "), new CompanyBean("  Shenzhen Tendzone Intelligent Technology Co., Ltd.                                                                   ", "    EB5-01      ", 100.9, 165.4));
            enMap.put(MapUtils.trim("  Shanghai Danacoid Multimedia Technology Co., Ltd.                                      "), new CompanyBean("   Shanghai Danacoid Multimedia Technology Co., Ltd.                                                                  ", "    EB3-01      ", 100.6, 233.8));
            enMap.put(MapUtils.trim("  Chiu Cheung (Dongguan) Company Limited                                                  "), new CompanyBean("  Chiu Cheung (Dongguan) Company Limited                                                                   ", "    EB2-01      ", 113.9, 301.2));
            enMap.put(MapUtils.trim("  Panasonic Corporation of China                                                                  "), new CompanyBean("  Panasonic Corporation of China                                                                   ", "    EB1-01      ", 113.3, 367.1));
            enMap.put(MapUtils.trim("  LG Electronics (China) Co., Ltd.                                                                  "), new CompanyBean("  LG Electronics (China) Co., Ltd.                                                                   ", "    EC1-01      ", 196.1, 367.8));
            enMap.put(MapUtils.trim("  Unilumin Group Co., Ltd.                                                                          "), new CompanyBean("   Unilumin Group Co., Ltd.                                                                  ", "    EC2-01      ", 195.3, 301.5));
            enMap.put(MapUtils.trim("  Sennheiser Electronic (Beijing) Co., Ltd.                                                      "), new CompanyBean("  Sennheiser Electronic (Beijing) Co., Ltd.                                                                  ", "     EB4-01     ", 137.4, 233.8));
            enMap.put(MapUtils.trim("  Audio-Technica (Greater China) Limited                                                       "), new CompanyBean("   Audio-Technica (Greater China) Limited                                                                  ", "    EB6-01      ", 137.6, 166.2));
            enMap.put(MapUtils.trim("  Haitian Electronic Technology Co., Ltd.                                                      "), new CompanyBean("   Haitian Electronic Technology Co., Ltd.                                                                  ", "    EB8-01      ", 137.1, 91.6));
            enMap.put(MapUtils.trim("  Control4 Corporation                                                                                "), new CompanyBean("  Control4 Corporation                                                                  ", "     EB10-01    ", 137.6, 37));
            enMap.put(MapUtils.trim("  Comm-Tec Asia Limited                                                                            "), new CompanyBean("  Comm-Tec Asia Limited                                                                  ", "     EC9-01     ", 178.2, 37.3));
            enMap.put(MapUtils.trim("  Shanghai Sansi Electronic Engineering Co., Ltd.                                            "), new CompanyBean("  Shanghai Sansi Electronic Engineering Co., Ltd.                                                                   ", "    EC7-01      ", 177.2, 92.4));
            enMap.put(MapUtils.trim("  Co-Edifice Video Technology Co., Ltd.                                                         "), new CompanyBean("  Co-Edifice Video Technology Co., Ltd.                                                                   ", "    EC5-01      ", 178.2, 165.9));
            enMap.put(MapUtils.trim("  WolfVision GmbH                                                                                     "), new CompanyBean("   WolfVision GmbH                                                                  ", "    EC3-01      ", 177.7, 233.8));
            enMap.put(MapUtils.trim("  Epson (China) Co., Ltd.                                                                             "), new CompanyBean("  Epson (China) Co., Ltd.                                                                  ", "     ED1-01     ", 275.0, 367.3));
            enMap.put(MapUtils.trim("  Digital Projection Ltd.                                                                               "), new CompanyBean("  Digital Projection Ltd.                                                                   ", "    ED2-01      ", 274.9, 306.1));
            enMap.put(MapUtils.trim("  Beijing Tricolor Technology Co., Ltd.                                                           "), new CompanyBean("  Beijing Tricolor Technology Co., Ltd.                                                                   ", "    ED3-01      ", 275.5, 233.8));
            enMap.put(MapUtils.trim("  Beijing Pacific Budee Technology Development Co., Ltd.                                "), new CompanyBean("  Beijing Pacific Budee Technology Development Co., Ltd.                                                                  ", "     EC4-01     ", 216.0, 233.8));
            enMap.put(MapUtils.trim("  ClearOne Inc.                                                                                           "), new CompanyBean("   ClearOne Inc.                                                                  ", "    EC6-01      ", 216.5, 165.7));
            enMap.put(MapUtils.trim("  Shenzhen Absen Optoelectronic Co., Ltd.                                                    "), new CompanyBean("  Shenzhen Absen Optoelectronic Co., Ltd.                                                                  ", "     ED5-01     ", 234.6, 92.2));
            enMap.put(MapUtils.trim("  Xilica Audio Design (Asia) Ltd.                                                                   "), new CompanyBean("  Xilica Audio Design (Asia) Ltd.                                                                   ", "    EC10-01    ", 216.5, 37.3));
            enMap.put(MapUtils.trim("  Xilica Audio Design (Asia) Ltd.                                                                   "), new CompanyBean("  Xilica Audio Design (Asia) Ltd.                                                                   ", "    ED7-01      ", 253.5, 36.8));
            enMap.put(MapUtils.trim("  Beijing Shinyview Tech Co., Ltd.                                                               "), new CompanyBean("   Beijing Shinyview Tech Co., Ltd.                                                                  ", "    ED8-01      ", 392.6, 37));
            enMap.put(MapUtils.trim("  Shanghai Mviewtech Co., Ltd.                                                                    "), new CompanyBean("  Shanghai Mviewtech Co., Ltd.                                                                   ", "    ED6-01      ", 293.1, 91.9));
            enMap.put(MapUtils.trim("  Leyard Optoelectronic Co., Ltd.                                                                  "), new CompanyBean("  Leyard Optoelectronic Co., Ltd.                                                                  ", "     ED4-01     ", 275.7, 165.9));
            enMap.put(MapUtils.trim("  Shenzhen Hanrui Technology Co., Ltd.                                                        "), new CompanyBean("  Shenzhen Hanrui Technology Co., Ltd.                                                                   ", "    EE7-01      ", 349.3, 38));
            enMap.put(MapUtils.trim("  Xiamen RGBlink Science & Technology Co., Ltd.                                            "), new CompanyBean("   Xiamen RGBlink Science & Technology Co., Ltd.                                                                  ", "    EE5-01      ", 347.5, 92.4));
            enMap.put(MapUtils.trim("  Beijing Huanyulanbo Technology Co., Ltd.                                                   "), new CompanyBean("  Beijing Huanyulanbo Technology Co., Ltd.                                                                   ", "    EE4-02      ", 359.5, 142.4));
            enMap.put(MapUtils.trim("  Kramer Electronics Ltd.                                                                             "), new CompanyBean("  Kramer Electronics Ltd.                                                                  ", "     EE4-01      ", 359.5, 173.8));
            enMap.put(MapUtils.trim("  Zhangjiagang Bosste Video And Flim Equipment Co., Ltd.                              "), new CompanyBean("  Zhangjiagang Bosste Video And Flim Equipment Co., Ltd.                                                                  ", "     EE8-01      ", 392.7, 37.5));
            enMap.put(MapUtils.trim("  Dalian GigaTec Electronics Co., Ltd.                                                            "), new CompanyBean("  Dalian GigaTec Electronics Co., Ltd.                                                                   ", "    EE6-01      ", 392.9, 91.9));
            enMap.put(MapUtils.trim("  Mt.Titlis (Beijing) Systems Control Technology Co., Ltd.                                "), new CompanyBean("  Mt.Titlis (Beijing) Systems Control Technology Co., Ltd.                                                                   ", "    EF5-01      ", 418.2, 165.2));
            enMap.put(MapUtils.trim("  Hebei Haijie Modern Educational Equipment Co., Ltd.                                    "), new CompanyBean("  Hebei Haijie Modern Educational Equipment Co., Ltd.                                                                  ", "     EF9-01      ", 433.3, 36.8));
            enMap.put(MapUtils.trim("  Beijing KXWELL Technology Co., Ltd.                                                          "), new CompanyBean("  Beijing KXWELL Technology Co., Ltd.                                                                  ", "     EF7-01      ", 433.3, 92.2));
            enMap.put(MapUtils.trim("  Adder Technology Ltd.                                                                              "), new CompanyBean("   Adder Technology Ltd.                                                                  ", "    EF10-01    ", 471.8, 36.8));
            enMap.put(MapUtils.trim("  Kensence (Shen Zhen) Technology Co., Ltd.                                                "), new CompanyBean("   Kensence (Shen Zhen) Technology Co., Ltd.                                                                  ", "    EF8-01      ", 471.8, 91.9));
            enMap.put(MapUtils.trim("  Taiden Industrial Co., Ltd.                                                                        "), new CompanyBean("  Taiden Industrial Co., Ltd.                                                                  ", "     EF6-01      ", 463.4, 165.7));
            enMap.put(MapUtils.trim("  ShenZhen DeviceWell Technology Co., Ltd.                                                  "), new CompanyBean("  ShenZhen DeviceWell Technology Co., Ltd.                                                                   ", "    EG9-01      ", 510.4, 36.5));
            enMap.put(MapUtils.trim("  Tsingtoo (Beijing) Technology Co., Ltd.                                                       "), new CompanyBean("   Tsingtoo (Beijing) Technology Co., Ltd.                                                                  ", "    EG7-01      ", 510.4, 91.9));
            enMap.put(MapUtils.trim("  ATEN China Co., Ltd.                                                                                "), new CompanyBean("  ATEN China Co., Ltd.                                                                   ", "    EG5-01      ", 503.0, 165.2));
            enMap.put(MapUtils.trim("  Guangzhou AVMedia Electronic Technology Co., Ltd.                                     "), new CompanyBean("  Guangzhou AVMedia Electronic Technology Co., Ltd.                                                                  ", "     EG10-01    ", 556.3, 36.5));
            enMap.put(MapUtils.trim("  YAMAHA Music & Electronics (China) Co., Ltd.                                              "), new CompanyBean("  YAMAHA Music & Electronics (China) Co., Ltd.                                                                  ", "     EG8-01     ", 548.7, 92.2));
            enMap.put(MapUtils.trim("  Nanpeng Technology Development Ltd.                                                       "), new CompanyBean("   Nanpeng Technology Development Ltd.                                                                  ", "    EG6-01      ", 540.8, 165.7));
            enMap.put(MapUtils.trim("  HDBaseT Alliance           Valens                                                                "), new CompanyBean("  HDBaseT Alliance           Valens                                                                  ", "     EH9-01     ", 616.1, 36.8));
            enMap.put(MapUtils.trim("  Shenzhen Magnimage Technology Co., Ltd.                                                  "), new CompanyBean("   Shenzhen Magnimage Technology Co., Ltd.                                                                  ", "    EH6-01      ", 588.5, 91.9));
            enMap.put(MapUtils.trim("  Shanghai Pallas Electric Company Limited                                                  "), new CompanyBean("   Shanghai Pallas Electric Company Limited                                                                  ", "    EH4-01      ", 580.8, 165.2));
            enMap.put(MapUtils.trim("  ATEIS CHINA                                                                                           "), new CompanyBean("  ATEIS CHINA                                                                   ", "    EH7-01      ", 629.1, 92.2));
            enMap.put(MapUtils.trim("  Rightway Audio Consultants Ltd.                                                                "), new CompanyBean("  Rightway Audio Consultants Ltd.                                                                   ", "    EH5-01      ", 623.7, 165.2));
            enMap.put(MapUtils.trim("  Guangzhou CREATOR Technology Co., Ltd. (China)                                       "), new CompanyBean("  Guangzhou CREATOR Technology Co., Ltd. (China)                                                                   ", "    EE3-01      ", 336.4, 233.8));
            enMap.put(MapUtils.trim("  ECflow (Beijing) Technology Co., Ltd.                                                        "), new CompanyBean("   ECflow (Beijing) Technology Co., Ltd.                                                                  ", "    EF3-01      ", 429.7, 234.6));
            enMap.put(MapUtils.trim("  Cuanbo                                                                                                  "), new CompanyBean("  Cuanbo                                                                   ", "    EF4-01      ", 471.1, 233.3));
            enMap.put(MapUtils.trim("  Guangzhou Grandview Crystal Screen Co., Ltd.                                             "), new CompanyBean("  Guangzhou Grandview Crystal Screen Co., Ltd.                                                                   ", "    EG3-01      ", 515.7, 234.1));
            enMap.put(MapUtils.trim("  TICO Digital Technology Co., Ltd.                                                              "), new CompanyBean("   TICO Digital Technology Co., Ltd.                                                                  ", "    EG4-01      ", 557.9, 234.1));
            enMap.put(MapUtils.trim("  Harman International                                                                               "), new CompanyBean("  Harman International                                                                   ", "    EH3-01      ", 613.8, 233.8));
            enMap.put(MapUtils.trim("  Beijing Brillview Technology Co., Ltd.                                                         "), new CompanyBean("  Beijing Brillview Technology Co., Ltd.                                                                   ", "    EE2-01      ", 366.7, 304.0));
            enMap.put(MapUtils.trim("  Beijing Twinflag Century Technology Co., Ltd.                                              "), new CompanyBean("  Beijing Twinflag Century Technology Co., Ltd.                                                                   ", "    EF2-01      ", 448.2, 304.3));
            enMap.put(MapUtils.trim("  DigiBird Technology Co., Ltd.                                                                     "), new CompanyBean("  DigiBird Technology Co., Ltd.                                                                   ", "    EG2-01      ", 530.4, 304.9));
            enMap.put(MapUtils.trim("  Shenzhen Liantronics Co., Ltd.                                                                  "), new CompanyBean("   Shenzhen Liantronics Co., Ltd.                                                                  ", "    EH2-01      ", 609.8, 304.9));
            enMap.put(MapUtils.trim("  Extron Electronics (Shanghai) Co., Ltd.                                                       "), new CompanyBean("   Extron Electronics (Shanghai) Co., Ltd.                                                                  ", "    EE1-01      ", 365.5, 367.3));
            enMap.put(MapUtils.trim("  Sony (China) Limited                                                                                "), new CompanyBean("   Sony (China) Limited                                                                  ", "    EF1-01      ", 447.7, 367.5));
            enMap.put(MapUtils.trim("  Dehao Vision Electronics Technology Limited                                               "), new CompanyBean("  Dehao Vision Electronics Technology Limited                                                                  ", "     EG1-01     ", 530.5, 366.6));
            enMap.put(MapUtils.trim("  Shenzhen AOTO Electronics Co., Ltd.                                                          "), new CompanyBean("   Shenzhen AOTO Electronics Co., Ltd.                                                                  ", "    EH1-01      ", 608.7, 366.6));
            enMap.put(MapUtils.trim("  Guangzhou Husion Electronics Co., Ltd.                                                       "), new CompanyBean("  Guangzhou Husion Electronics Co., Ltd.                                                                   ", "    EJ6-01       ", 691.9, 37));
            enMap.put(MapUtils.trim("  Chartu Technologies Co., Ltd.                                                                    "), new CompanyBean("  Chartu Technologies Co., Ltd.                                                                  ", "     EK7-01     ", 765.2, 36.5));
            enMap.put(MapUtils.trim("  Guangzhou BaoLun Electronics Co., Ltd.                                                      "), new CompanyBean("  Guangzhou BaoLun Electronics Co., Ltd.                                                                  ", "     EJ5-01      ", 683.0, 91.4));
            enMap.put(MapUtils.trim("  South China House of Technology International Limited                                 "), new CompanyBean("  South China House of Technology International Limited                                                                  ", "     EK5-01     ", 730.7, 91.6));
            enMap.put(MapUtils.trim("  Real Music Acoustics & Lighting Technology Co., Ltd.                                    "), new CompanyBean("   Real Music Acoustics & Lighting Technology Co., Ltd.                                                                  ", "    EK6-01      ", 777.2, 92.2));
            enMap.put(MapUtils.trim("  Shenzhen EZpro Sound & Light Technology Co., Ltd.                               "), new CompanyBean("   Shenzhen EZpro Sound & Light Technology Co., Ltd.                                                                  ", "    EJ4-01      ", 687.6, 165.4));
            enMap.put(MapUtils.trim("  Shure China Trading Co., Ltd.                                           "), new CompanyBean("   Shure China Trading Co., Ltd.                                                                  ", "    EK4-01      ", 738.6, 165.4));
            enMap.put(MapUtils.trim("  Hangzhou DeskMedia Technology Co., Ltd.                           "), new CompanyBean("   Hangzhou DeskMedia Technology Co., Ltd.                                                                  ", "    EL4-01      ", 780.5, 165.9));
            enMap.put(MapUtils.trim("  SZ Reach Tech Co., Ltd.                                                                            "), new CompanyBean("  SZ Reach Tech Co., Ltd.                                                                  ", "     EJ3-01      ", 381.4, 233.1));
            enMap.put(MapUtils.trim("  Xi'an Beiguang Digital Technology Co., Ltd.                                                 "), new CompanyBean("  Xi'an Beiguang Digital Technology Co., Ltd.                                                                   ", "    EJ3-02       ", 722.5, 233.8));
            enMap.put(MapUtils.trim("  Beijing Weitaijiaye Science & Technology Co., Ltd.                                       "), new CompanyBean("  Beijing Weitaijiaye Science & Technology Co., Ltd.                                                                   ", "    EK3-01      ", 773.4, 234.3));
            enMap.put(MapUtils.trim("  Viamax Technologies Co., Ltd.                                                                  "), new CompanyBean("   Viamax Technologies Co., Ltd.                                                                  ", "    EJ2-01      ", 697.2, 305.2));
            enMap.put(MapUtils.trim("  Bose Electronics (Shanghai) Company Limited                                              "), new CompanyBean("  Bose Electronics (Shanghai) Company Limited                                                                  ", "     EK2-01     ", 755.3, 305.2));
            enMap.put(MapUtils.trim("  Beijing Wingmax Technology Co., Ltd.                                                        "), new CompanyBean("  Beijing Wingmax Technology Co., Ltd.                                                                   ", "    EL2-01      ", 793.1, 309.5));
            enMap.put(MapUtils.trim("  Hitachi Consumer Marketing (China) Ltd.                                                    "), new CompanyBean("   Hitachi Consumer Marketing (China) Ltd.                                                                  ", "    EJ1-01      ", 694.6, 366.1));
            enMap.put(MapUtils.trim("  Beijing Innovational Fametal Equipment Co., Ltd.                                         "), new CompanyBean("  Beijing Innovational Fametal Equipment Co., Ltd.                                                                  ", "     EK1-01     ", 754.0, 367.5));
            enMap.put(MapUtils.trim("  Beijing Innovational Fametal Equipment Co., Ltd.                                         "), new CompanyBean("  Beijing Innovational Fametal Equipment Co., Ltd.                                                                  ", "     EL1-01      ", 793.1, 372.5));


            //D馆英文
            enMap.put(MapUtils.trim("    Asystems Corporation                                                                                             "), new CompanyBean("    Asystems Corporation                                                                                                       ", "      DD1-05                     ", 19.5, 136.9));
            enMap.put(MapUtils.trim("    Nanjing Magewell Electronics Co., Ltd.                                                                                             "), new CompanyBean("    Nanjing Magewell Electronics Co., Ltd.                                                                                                       ", "      DD1-02                     ", 19.7, 171.8));
            enMap.put(MapUtils.trim("    Shenzhen Daxi Innov Tech Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen Daxi Innov Tech Co., Ltd.                                                                                                       ", "      DD1-01                     ", 19.5, 188.4));
            enMap.put(MapUtils.trim("    Ningbo Soundking Electronics & Sound Co., Ltd.                                                                                             "), new CompanyBean("    Ningbo Soundking Electronics & Sound Co., Ltd.                                                                                                        ", "     DB4-01                      ", 91.8, 129.9));
            enMap.put(MapUtils.trim("    Shenzhen Da Tong Infinite Technology Co., Ltd.                                                                                            "), new CompanyBean("     Shenzhen Da Tong Infinite Technology Co., Ltd.                                                                                                       ", "      DB6-03                     ", 133.3, 123.4));
            enMap.put(MapUtils.trim("    Shanghai Xiyu Intelligent Technology Co., Ltd.                                                                                             "), new CompanyBean("    Shanghai Xiyu Intelligent Technology Co., Ltd.                                                                                                        ", "     DB6-02                      ", 133.6, 174.0));
            enMap.put(MapUtils.trim("    Measy Technology Co., Ltd.                                                                                            "), new CompanyBean("     Measy Technology Co., Ltd.                                                                                                       ", "      DB6-01                     ", 133.6, 191));
            enMap.put(MapUtils.trim("    先歌国际影音有限公司                                                                                             "), new CompanyBean("    先歌国际影音有限公司                                                                                                       ", "      DB3-01                     ", 92.1, 189.8));
            enMap.put(MapUtils.trim("    Guangzhou Junnan Audiovisual Technology Co., Ltd.                                                                                             "), new CompanyBean("    Guangzhou Junnan Audiovisual Technology Co., Ltd.                                                                                                        ", "     DC4-01                      ", 23.9, 271.4));
            enMap.put(MapUtils.trim("    S-Track Science & Technology Co., Ltd.                                                                                             "), new CompanyBean("    S-Track Science & Technology Co., Ltd.                                                                                                        ", "     DC4-02                      ", 23.3, 294.6));
            enMap.put(MapUtils.trim("    Kobble Pearl Digital Electronic Co., Ltd.                                                                                             "), new CompanyBean("    Kobble Pearl Digital Electronic Co., Ltd.                                                                                                        ", "     DC1-01                      ", 24.5, 345.5));
            enMap.put(MapUtils.trim("    Shenzhen Hikeen Technology Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen Hikeen Technology Co., Ltd.                                                                                                        ", "     DC3-01                      ", 62, 285));
            enMap.put(MapUtils.trim("    Shenzhen GEAZAN Technology Co.,Ltd.                                                                                             "), new CompanyBean("    Shenzhen GEAZAN Technology Co.,Ltd.                                                                                                        ", "     DC2-01                      ", 62, 345.2));
            enMap.put(MapUtils.trim("    Hangzhou Elite-Audio Co., Ltd.                                                                                            "), new CompanyBean("     Hangzhou Elite-Audio Co., Ltd.                                                                                                       ", "      DB2-01                     ", 92.7, 288.4));
            enMap.put(MapUtils.trim("    Beijing Zoolon Visual Technologies Corp.                                                                                             "), new CompanyBean("    Beijing Zoolon Visual Technologies Corp.                                                                                                        ", "     DB1-01                      ", 92.4, 345.8));
            enMap.put(MapUtils.trim("    Changsha SunVote Limited                                                                                             "), new CompanyBean("    Changsha SunVote Limited                                                                                                        ", "     DB5-04                      ", 133.9, 293.7));
            enMap.put(MapUtils.trim("    Shenzhen Acorid Communication Technology Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen Acorid Communication Technology Co., Ltd.                                                                                                        ", "     DB5-03                      ", 134.2, 310.4));
            enMap.put(MapUtils.trim("    Lake-View Electronics Co., Ltd.                                                                                            "), new CompanyBean("     Lake-View Electronics Co., Ltd.                                                                                                       ", "      DB5-02                     ", 133.9, 327.8));
            enMap.put(MapUtils.trim("    NTI CHINA Co., Ltd.                                                                                             "), new CompanyBean("    NTI CHINA Co., Ltd.                                                                                                       ", "      DB5-01                     ", 134.6, 344.2));
            enMap.put(MapUtils.trim("    Shenzhen Haohuitong Technology Ltd.                                                                                            "), new CompanyBean("     Shenzhen Haohuitong Technology Ltd.                                                                                                       ", "      DA2-03                     ", 92.4, 431.1));
            enMap.put(MapUtils.trim("    Guangzhou Jusbe Electronic Technology Co., Ltd.                                                                                            "), new CompanyBean("     Guangzhou Jusbe Electronic Technology Co., Ltd.                                                                                                       ", "      DA2-01                     ", 91.8, 475.7));
            enMap.put(MapUtils.trim("    Soyo Technology Development Co., Ltd.                                                                                             "), new CompanyBean("    Soyo Technology Development Co., Ltd.                                                                                                       ", "      DA1-03                      ", 127.4, 439.8));
            enMap.put(MapUtils.trim("    Guangzhou Home& Beauty Electronics Co., Ltd.                                                                                             "), new CompanyBean("    Guangzhou Home& Beauty Electronics Co., Ltd.                                                                                                       ", "      DA1-01                     ", 127.4, 474.2));
            enMap.put(MapUtils.trim("    Audfly Technology Co., Ltd.                                                                                             "), new CompanyBean("    Audfly Technology Co., Ltd.                                                                                                        ", "     CA7-02                      ", 187.3, 25.2));
            enMap.put(MapUtils.trim("    Vmore Technology, Inc.                                                                                             "), new CompanyBean("    Vmore Technology, Inc.                                                                                                        ", "     CA7-01                      ", 212.9, 25.9));
            enMap.put(MapUtils.trim("    Shenzhen JinJiuTianShi Industry Co., Limited                                                                                            "), new CompanyBean("     Shenzhen JinJiuTianShi Industry Co., Limited                                                                                                       ", "      CA6-01                     ", 178.4, 73.9));
            enMap.put(MapUtils.trim("    AAVARA Innovation Corp.                                                                                             "), new CompanyBean("    AAVARA Innovation Corp.                                                                                                       ", "      CA6-03                     ", 212.7, 73.9));
            enMap.put(MapUtils.trim("    HDCVT Technology                                                                                             "), new CompanyBean("    HDCVT Technology                                                                                                        ", "     CB6-01                      ", 253.5, 72.3));
            enMap.put(MapUtils.trim("    Hangzhou iSmart Video Tech Co., Ltd.                                                                                             "), new CompanyBean("    Hangzhou iSmart Video Tech Co., Ltd.                                                                                                        ", "     CB6-02                      ", 282.7, 72.6));
            enMap.put(MapUtils.trim("    Enping Baofeng Electronic Equipment Factory                                                                                             "), new CompanyBean("    Enping Baofeng Electronic Equipment Factory                                                                                                       ", "      CA5-03                     ", 203.1, 118));
            enMap.put(MapUtils.trim("    Guangzhou ChangShi Intelligent Technology Co., Ltd.                                                                                            "), new CompanyBean("     Guangzhou ChangShi Intelligent Technology Co., Ltd.                                                                                                       ", "      CA5-02                     ", 177.7, 118.7));
            enMap.put(MapUtils.trim("    Zhejiang Guanxuan Intelligent Technology Co., Ltd.                                                                                             "), new CompanyBean("    Zhejiang Guanxuan Intelligent Technology Co., Ltd.                                                                                                       ", "      CA5-01                     ", 194.8, 141.6));
            enMap.put(MapUtils.trim("    Beijing Jinzhongheng Science & Technology Co., Ltd.                                                                                             "), new CompanyBean("    Beijing Jinzhongheng Science & Technology Co., Ltd.                                                                                                        ", "     CB5-01                      ", 269.6, 144.2));
            enMap.put(MapUtils.trim("    Beckhoff Automation (Shanghai) Co., Ltd.                                                                                             "), new CompanyBean("    Beckhoff Automation (Shanghai) Co., Ltd.                                                                                                        ", "     CB5-02                      ", 267.8, 120.8));
            enMap.put(MapUtils.trim("    Advanced Communication Equipment (International) Co., Ltd.                                                                                            "), new CompanyBean("     Advanced Communication Equipment (International) Co., Ltd.                                                                                                       ", "      CA4-01                     ", 195.9, 198.7));
            enMap.put(MapUtils.trim("    Yealink Network Technology Co., Ltd.                                                                                             "), new CompanyBean("    Yealink Network Technology Co., Ltd.                                                                                                        ", "     CB4-01                      ", 266.3, 199.4));
            enMap.put(MapUtils.trim("    EASTCATO                                                                                             "), new CompanyBean("    EASTCATO                                                                                                       ", "      CA3-01                     ", 194.7, 276.3));
            enMap.put(MapUtils.trim("    Guangzhou DSPPA Audio Co., Ltd.                                                                                             "), new CompanyBean("    Guangzhou DSPPA Audio Co., Ltd.                                                                                                        ", "     CB3-01                      ", 269.4, 277.6));
            enMap.put(MapUtils.trim("    Shen Zhen CLT LED Technology Co., Ltd.                                                                                            "), new CompanyBean("     Shen Zhen CLT LED Technology Co., Ltd.                                                                                                       ", "      CA2-01                     ", 195, 343.6));
            enMap.put(MapUtils.trim("    Beijing Boxin Hongda Computer Room Equipment Co., Ltd.                                                                                             "), new CompanyBean("    Beijing Boxin Hongda Computer Room Equipment Co., Ltd.                                                                                                        ", "     CB2-01                      ", 267.9, 343.9));
            enMap.put(MapUtils.trim("    Hangzhou Hikvision Digital Technology Co., Ltd.                                                                                             "), new CompanyBean("    Hangzhou Hikvision Digital Technology Co., Ltd.                                                                                                       ", "      CA1-01                      ", 194.3, 416.3));
            enMap.put(MapUtils.trim("    Hangzhou Huahuitong Technologies Co., Ltd.                                                                                             "), new CompanyBean("    Hangzhou Huahuitong Technologies Co., Ltd.                                                                                                       ", "      CB1-01                      ", 267.5, 417.0));
            enMap.put(MapUtils.trim("    CANARE Electric Corporation of Tianjin                                                                                             "), new CompanyBean("    CANARE Electric Corporation of Tianjin                                                                                                        ", "     CE1-01                      ", 299.9, 25.7));
            enMap.put(MapUtils.trim("    NOREL Systems Ltd.                                                                                             "), new CompanyBean("    NOREL Systems Ltd.                                                                                                        ", "     CE1-03                      ", 335.6, 25.9));
            enMap.put(MapUtils.trim("    Lindy-Elektronik GmbH                                                                                             "), new CompanyBean("    Lindy-Elektronik GmbH                                                                                                       ", "      CE1-05                      ", 369.5, 24.9));
            enMap.put(MapUtils.trim("    Smart Cabling & Transmission Corp.                                                                                             "), new CompanyBean("    Smart Cabling & Transmission Corp.                                                                                                       ", "      CE1-07                      ", 396.2, 25.6));
            enMap.put(MapUtils.trim("    BoeGam                                                                                            "), new CompanyBean("     BoeGam                                                                                                       ", "      CE1-08                     ", 413.0, 25.6));
            enMap.put(MapUtils.trim("    Uniclass Technology Co., Ltd.                                                                                            "), new CompanyBean("     Uniclass Technology Co., Ltd.                                                                                                       ", "      CE1-09                     ", 432.9, 25.4));
            enMap.put(MapUtils.trim("    Guangzhou HLEE Audiovisual Equipment Co., Ltd.                                                                                             "), new CompanyBean("    Guangzhou HLEE Audiovisual Equipment Co., Ltd.                                                                                                       ", "      CC6-01                      ", 346.4, 72.6));
            enMap.put(MapUtils.trim("    Listen Technologies                                                                                             "), new CompanyBean("    Listen Technologies                                                                                                        ", "     CC6-02                      ", 374.1, 71.4));
            enMap.put(MapUtils.trim("    Guangzhou Gestton Technology Co., Ltd.                                                                                            "), new CompanyBean("     Guangzhou Gestton Technology Co., Ltd.                                                                                                       ", "      CD6-01                     ", 424.9, 72.5));
            enMap.put(MapUtils.trim("    Shenzhen OneKing Technologies Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen OneKing Technologies Co., Ltd.                                                                                                        ", "     CD6-02                      ", 473.9, 74.9));
            enMap.put(MapUtils.trim("    Guangzhou Donglai Electronic Tech Co., Ltd.                                                                                             "), new CompanyBean("    Guangzhou Donglai Electronic Tech Co., Ltd.                                                                                                       ", "      CD6-04                      ", 473.7, 47.4));
            enMap.put(MapUtils.trim("    Shenzhen Hongzhe Intelligent System Engineering Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen Hongzhe Intelligent System Engineering Co., Ltd.                                                                                                       ", "      CC5-01                     ", 359.6, 132.2));
            enMap.put(MapUtils.trim("    Datavideo Technologies China Co., Ltd.                                                                                            "), new CompanyBean("     Datavideo Technologies China Co., Ltd.                                                                                                       ", "      CC4-01                     ", 358.5, 198.5));
            enMap.put(MapUtils.trim("    Interlink Technology (Shenzhen) Co., Ltd.                                                                                             "), new CompanyBean("    Interlink Technology (Shenzhen) Co., Ltd.                                                                                                       ", "      CD5-02                     ", 439.3, 122.2));
            enMap.put(MapUtils.trim("    Hubei Anxin Smart Technology Co., Ltd.                                                                                            "), new CompanyBean("     Hubei Anxin Smart Technology Co., Ltd.                                                                                                       ", "      CD5-01                     ", 441.1, 143.4));
            enMap.put(MapUtils.trim("    Jomard?Intelligent?Technology?Co., Ltd.                                                                                            "), new CompanyBean("     Jomard?Intelligent?Technology?Co., Ltd.                                                                                                       ", "      CD4-01                     ", 437.8, 198.2));
            enMap.put(MapUtils.trim("    Greatwall Infotech Co., Ltd.                                                                                             "), new CompanyBean("    Greatwall Infotech Co., Ltd.                                                                                                        ", "     CC3-01-B                      ", 359.8, 277.2));
            enMap.put(MapUtils.trim("    Winner Wave TW Limited                                                                                             "), new CompanyBean("    Winner Wave TW Limited                                                                                                        ", "     CC3-01-C                      ", 359.8, 277.2));
            enMap.put(MapUtils.trim("    中强光电股份有限公司                                                                                             "), new CompanyBean("    中强光电股份有限公司                                                                                                        ", "     CC3-01-A                      ", 359.8, 277.2));
            enMap.put(MapUtils.trim("    Shanghai GuRui Electronic Technology Co., Ltd.                                                                                            "), new CompanyBean("     Shanghai GuRui Electronic Technology Co., Ltd.                                                                                                       ", "      CD3-01                     ", 438.3, 276.1));
            enMap.put(MapUtils.trim("    Sunrise Vision (ShangHai) Infotech Co., Ltd.                                                                                             "), new CompanyBean("    Sunrise Vision (ShangHai) Infotech Co., Ltd.                                                                                                        ", "     CD2-01                      ", 437.1, 334.8));
            enMap.put(MapUtils.trim("    MAXTEK Go-Go Co., Ltd.                                                                                             "), new CompanyBean("    MAXTEK Go-Go Co., Ltd.                                                                                                        ", "     CC2-01-C                      ", 359.1, 336.6));
            enMap.put(MapUtils.trim("    Sun Rise Exact Industrial Co., Ltd.                                                                                            "), new CompanyBean("     Sun Rise Exact Industrial Co., Ltd.                                                                                                       ", "      CC2-01-A                     ", 359.1, 336.6));
            enMap.put(MapUtils.trim("    VNS Inc.                                                                                             "), new CompanyBean("    VNS Inc.                                                                                                        ", "     CC2-01-B                      ", 359.1, 336.6));
            enMap.put(MapUtils.trim("    Yuan High-Tech Development Co., Ltd.                                                                                             "), new CompanyBean("    Yuan High-Tech Development Co., Ltd.                                                                                                        ", "     CC1-01-A                      ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    Pstek Technology Co., Ltd.                                                                                             "), new CompanyBean("    Pstek Technology Co., Ltd.                                                                                                        ", "     CC1-01-C                      ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    台湾数位广告牌多媒体联盟                                                                                             "), new CompanyBean("    台湾数位广告牌多媒体联盟                                                                                                        ", "     CC1-01                      ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    The 10Xer Inc.                                                                                            "), new CompanyBean("     The 10Xer Inc.                                                                                                       ", "      CC1-01-B                     ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    Jetway Information Co., Ltd.                                                                                            "), new CompanyBean("     Jetway Information Co., Ltd.                                                                                                       ", "      CC1-01-D                     ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    TeVii Technology Co., Ltd.                                                                                            "), new CompanyBean("     TeVii Technology Co., Ltd.                                                                                                       ", "      CC1-01-E                     ", 360.5, 410.7));
            enMap.put(MapUtils.trim("    Intel China Ltd.                                                                                             "), new CompanyBean("    Intel China Ltd.                                                                                                       ", "      CD1-01                     ", 438.5, 407.7));
            enMap.put(MapUtils.trim("    Guangzhou Southwing Information Technology Co., Ltd.                                                                                            "), new CompanyBean("     Guangzhou Southwing Information Technology Co., Ltd.                                                                                                       ", "      FA5-01                     ", 580.1, 195.7));
            enMap.put(MapUtils.trim("    Shenzhen AIOSTAR Electronics Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen AIOSTAR Electronics Co., Ltd.                                                                                                        ", "     FA4-01                       ", 580.1, 380.5));
            enMap.put(MapUtils.trim("    π Digital Technology Co., Ltd.                                                                                             "), new CompanyBean("    π Digital Technology Co., Ltd.                                                                                                       ", "      FA3-01                     ", 580.4, 409.7));
            enMap.put(MapUtils.trim("    Shenzhen KTC Commercial Display Technology Co., Ltd.                                                                                             "), new CompanyBean("    Shenzhen KTC Commercial Display Technology Co., Ltd.                                                                                                       ", "      FB3-01                      ", 665.0, 236.9));
            enMap.put(MapUtils.trim("    Beijing Hexiangtongchuang Technology Co., Ltd.                                                                                             "), new CompanyBean("    Beijing Hexiangtongchuang Technology Co., Ltd.                                                                                                       ", "      FC3-01                     ", 704.4, 235.7));
            enMap.put(MapUtils.trim("    Bolin Technology Co., Ltd.                                                                                            "), new CompanyBean("     Bolin Technology Co., Ltd.                                                                                                       ", "      FD7-01                     ", 739.1, 227.6));
            enMap.put(MapUtils.trim("    Shanghai Shi Xian IT Co., Ltd.                                                                                            "), new CompanyBean("     Shanghai Shi Xian IT Co., Ltd.                                                                                                       ", "      FD6-01                     ", 739.7, 245.6));
            enMap.put(MapUtils.trim("    Shanghai Suowoo Optoelectronics Technology Co., Ltd.                                                                                            "), new CompanyBean("     Shanghai Suowoo Optoelectronics Technology Co., Ltd.                                                                                                       ", "      FB2-01                     ", 663.5, 290.6));
            enMap.put(MapUtils.trim("    YDEA (Shenzhen) Technology Co., Ltd.                                                                                            "), new CompanyBean("     YDEA (Shenzhen) Technology Co., Ltd.                                                                                                       ", "      FC2-01                     ", 705.3, 290.3));
            enMap.put(MapUtils.trim("    Shanghai Linbell Electronic Technologies Co., Ltd.                                                                                             "), new CompanyBean("    Shanghai Linbell Electronic Technologies Co., Ltd.                                                                                                       ", "      FC1-01                      ", 705.0, 345.2));
            enMap.put(MapUtils.trim("    Beijing AVSYS Technology Co., Ltd.                                                                                             "), new CompanyBean("    Beijing AVSYS Technology Co., Ltd.                                                                                                        ", "     FD5-01                       ", 739.1, 273.2));
            enMap.put(MapUtils.trim("    Citen Communicaton Technology Co., Ltd.                                                                                             "), new CompanyBean("    Citen Communicaton Technology Co., Ltd.                                                                                                        ", "     FD4-01                      ", 739.4, 290.9));
            enMap.put(MapUtils.trim("    HangZhou DaHe Thermo-Magnetics Co., Ltd.                                                                                            "), new CompanyBean("     HangZhou DaHe Thermo-Magnetics Co., Ltd.                                                                                                       ", "      FD3-01                     ", 740.3, 307.7));
            enMap.put(MapUtils.trim("    Polycom Communication Solutions (Beijing) Co., LTD.                                                                                             "), new CompanyBean("    Polycom Communication Solutions (Beijing) Co., LTD.                                                                                                       ", "      FB1-01                     ", 663.5, 345.5));
            enMap.put(MapUtils.trim("    Shanghai Linbell Electronic Technologies Co., Ltd.                                                                                             "), new CompanyBean("    Shanghai Linbell Electronic Technologies Co., Ltd.                                                                                                        ", "     FC1-01                      ", 705.0, 345.0));
            enMap.put(MapUtils.trim("    Shenzhen huhupretong science and Technology Co., Ltd.                                                                                            "), new CompanyBean("     Shenzhen huhupretong science and Technology Co., Ltd.                                                                                                       ", "      FD2-01                     ", 739.4, 337.4));
            enMap.put(MapUtils.trim("    GoldSunshine Networks Co., Ltd.                                                                                             "), new CompanyBean("    GoldSunshine Networks Co., Ltd.                                                                                                       ", "      FD1-01                     ", 740.0, 353.9));

            //p en
            enMap.put(MapUtils.trim("    Gansui T.F.S Inc.                                                 "), new CompanyBean("    Gansui T.F.S Inc.                                                            ", "       PA4-06                        ", 310.8, 201.7));
            enMap.put(MapUtils.trim("    Shenzhen Hollyland Technology Co., Ltd.                                                 "), new CompanyBean("    Shenzhen Hollyland Technology Co., Ltd.                                                           ", "        PA4-05                       ", 310.6, 218.0));
            enMap.put(MapUtils.trim("    Macro Image Technology Inc.                                                 "), new CompanyBean("    Macro Image Technology Inc.                                                           ", "        PA4-03                       ", 310.0, 235.7));
            enMap.put(MapUtils.trim("    Shenzhen Thomas Trade Co.,Ltd.                                                 "), new CompanyBean("    Shenzhen Thomas Trade Co.,Ltd.                                                            ", "       PA4-02                        ", 310.0, 252.6));
            enMap.put(MapUtils.trim("    Guangzhou Zhunyin Electronic Technology Co., Ltd.                                                "), new CompanyBean("     Guangzhou Zhunyin Electronic Technology Co., Ltd.                                                           ", "        PA4-01                       ", 310.0, 277.4));
            enMap.put(MapUtils.trim("    Shenzhen Compass Technology Development Co., Ltd.                                                 "), new CompanyBean("    Shenzhen Compass Technology Development Co., Ltd.                                                            ", "       PB6-02                        ", 354.7, 207.4));
            enMap.put(MapUtils.trim("    AMN acoustics (Shenzhen) Co.,Ltd.                                                "), new CompanyBean("     AMN acoustics (Shenzhen) Co.,Ltd.                                                           ", "        PB6-01                       ", 323.7, 225.2));
            enMap.put(MapUtils.trim("    Qingdao Hisense Electronics Co., Ltd.                                                 "), new CompanyBean("    Qingdao Hisense Electronics Co., Ltd.                                                           ", "        PB5-01                       ", 353.5, 273.1));
            enMap.put(MapUtils.trim("    Shen Zhen Xin Lightever Technology Co., Ltd.                                                 "), new CompanyBean("    Shen Zhen Xin Lightever Technology Co., Ltd.                                                            ", "       PC6-02                        ", 408.2, 206.7));
            enMap.put(MapUtils.trim("    Shanghai Didon Industrial Co., Ltd.                                                 "), new CompanyBean("    Shanghai Didon Industrial Co., Ltd.                                                            ", "       PC6-01                        ", 407.6, 227.2));
            enMap.put(MapUtils.trim("    Hatress Enterprise (China) Co., Ltd.                                                 "), new CompanyBean("    Hatress Enterprise (China) Co., Ltd.                                                            ", "       PC5-01                        ", 408.4, 271.1));
            enMap.put(MapUtils.trim("    Leadtek (Shanghai) Research Inc.                                                 "), new CompanyBean("    Leadtek (Shanghai) Research Inc.                                                            ", "       PA3-08                        ", 309.2, 334.7));
            enMap.put(MapUtils.trim("    Leadermounts (Kunshan) Electronics Tech Co., Ltd.                                                 "), new CompanyBean("    Leadermounts (Kunshan) Electronics Tech Co., Ltd.                                                            ", "       PA3-07                        ", 310.5, 360.4));
            enMap.put(MapUtils.trim("    BeiJing LiAoVideo Tech Co., Ltd.                                                "), new CompanyBean("     BeiJing LiAoVideo Tech Co., Ltd.                                                           ", "        PA3-05                       ", 310.9, 386.7));
            enMap.put(MapUtils.trim("    Foshan Chanstek Audio Co., Ltd.                                                 "), new CompanyBean("    Foshan Chanstek Audio Co., Ltd.                                                            ", "       PA3-04                        ", 310.7, 410.3));
            enMap.put(MapUtils.trim("    FoxunHD Co., Ltd.                                                 "), new CompanyBean("    FoxunHD Co., Ltd.                                                            ", "       PA3-03                        ", 310.3, 426.7));
            enMap.put(MapUtils.trim("    Beijing Matrix Technology Development Co., Ltd.                                                 "), new CompanyBean("    Beijing Matrix Technology Development Co., Ltd.                                                            ", "       PA3-01                        ", 310.1, 452.6));
            enMap.put(MapUtils.trim("    Guangzhou Cmax Smart Equipment Co., Ltd.                                                "), new CompanyBean("     Guangzhou Cmax Smart Equipment Co., Ltd.                                                           ", "        PB4-01                       ", 352.3, 351.3));
            enMap.put(MapUtils.trim("    Beijing Fangyuan zhihui Electronic Technology Co., Ltd.                                                 "), new CompanyBean("    Beijing Fangyuan zhihui Electronic Technology Co., Ltd.                                                           ", "        PB3-01                       ", 352.5, 412.0));
            enMap.put(MapUtils.trim("    Suzhou Keda Technology Co., Ltd.                                                "), new CompanyBean("     Suzhou Keda Technology Co., Ltd.                                                           ", "        PB2-01                       ", 351.9, 475.6));
            enMap.put(MapUtils.trim("    Suzhou Keda Technology Co., Ltd.                                                "), new CompanyBean("     Suzhou Keda Technology Co., Ltd.                                                           ", "        pc2-01                       ", 351.9, 475.7));
            enMap.put(MapUtils.trim("    Beijing Dongfang Jiurui Technology Corp. Ltd.                                                 "), new CompanyBean("    Beijing Dongfang Jiurui Technology Corp. Ltd.                                                           ", "        PC1-01                        ", 379.7, 546.6));
            enMap.put(MapUtils.trim("    Anhui Keshilaser Technology Corp. Ltd.                                                 "), new CompanyBean("    Anhui Keshilaser Technology Corp. Ltd.                                                           ", "        PC4-01                       ", 406.6, 349.2));
            enMap.put(MapUtils.trim("    Chengdu Fscreen Sci-tech Co., Ltd.                                                 "), new CompanyBean("    Chengdu Fscreen Sci-tech Co., Ltd.                                                            ", "       PC3-01                        ", 406.6, 411.6));
            enMap.put(MapUtils.trim("    Range Tech                                                 "), new CompanyBean("    Range Tech                                                            ", "       PD6-01                        ", 476.6, 216.3));
            enMap.put(MapUtils.trim("    Chongqing RongHao Display Technology Co., Ltd                                                "), new CompanyBean("     Chongqing RongHao Display Technology Co., Ltd                                                           ", "        PD5-01                       ", 510.1, 271.8));
            enMap.put(MapUtils.trim("    Shenzhen Teeho Optoelectronics Co., Ltd.                                                 "), new CompanyBean("    Shenzhen Teeho Optoelectronics Co., Ltd.                                                           ", "        PE6-02                       ", 528.8, 217.2));
            enMap.put(MapUtils.trim("    Beijing Bochuang Lixun Technology Co., Ltd.                                                 "), new CompanyBean("    Beijing Bochuang Lixun Technology Co., Ltd.                                                            ", "       PE6-01                        ", 552.1, 216.6));
            enMap.put(MapUtils.trim("    Atlona Asia Co., Ltd.                                                 "), new CompanyBean("    Atlona Asia Co., Ltd.                                                            ", "       PD4-01                        ", 476.4, 349.6));
            enMap.put(MapUtils.trim("    Mindstec Asia (Beijing) Technology Ltd.                                                 "), new CompanyBean("    Mindstec Asia (Beijing) Technology Ltd.                                                           ", "        PD3-01                       ", 509.5, 411.1));
            enMap.put(MapUtils.trim("    Wuxi Seemile Laser Display Technology Co., Ltd.                                                "), new CompanyBean("     Wuxi Seemile Laser Display Technology Co., Ltd.                                                           ", "        PE4-01                       ", 542.9, 349.2));
            enMap.put(MapUtils.trim("    Xiamen Qiangli Jucai Opto-Electronic Technology Co., Ltd.                                                 "), new CompanyBean("    Xiamen Qiangli Jucai Opto-Electronic Technology Co., Ltd.                                                           ", "        PD2-01                       ", 477.2, 477.0));
            enMap.put(MapUtils.trim("    Beijing Caiyida Science and Technology Development Co., Ltd.                                                 "), new CompanyBean("    Beijing Caiyida Science and Technology Development Co., Ltd.                                                            ", "       PD1-01                        ", 507.3, 545.6));
            enMap.put(MapUtils.trim("    Guangzhou Shizhen Technology Co., Ltd.                                                 "), new CompanyBean("    Guangzhou Shizhen Technology Co., Ltd.                                                            ", "       PE2-01                        ", 546.8, 476.6));
            enMap.put(MapUtils.trim("    Uchida Yoko Office Facilities Co., Ltd.                                                "), new CompanyBean("     Uchida Yoko Office Facilities Co., Ltd.                                                           ", "        PF6-01                       ", 629.5, 216.2));
            enMap.put(MapUtils.trim("    Uchida Yoko Office Facilities Co., Ltd.                                                 "), new CompanyBean("    Uchida Yoko Office Facilities Co., Ltd.                                                            ", "       PF5-01                        ", 629.3, 271.3));
            enMap.put(MapUtils.trim("    Bei Jing Kesino Engineering Technology Co., Ltd.                                                 "), new CompanyBean("    Bei Jing Kesino Engineering Technology Co., Ltd.                                                           ", "        PG4-03                       ", 680.8, 223.3));
            enMap.put(MapUtils.trim("    WiseJet Inc.                                                 "), new CompanyBean("    WiseJet Inc.                                                            ", "       PG4-01                        ", 680.4, 256.6));
            enMap.put(MapUtils.trim("    Shenzhen East-toptech Electronic Technology Co., Ltd.                                                "), new CompanyBean("     Shenzhen East-toptech Electronic Technology Co., Ltd.                                                           ", "        PG3-12                       ", 680.2, 301.6));
            enMap.put(MapUtils.trim("    Guangzhou MT-VIKI Electronics Co., Ltd.                                                 "), new CompanyBean("    Guangzhou MT-VIKI Electronics Co., Ltd.                                                            ", "       PG3-10                        ", 681.3, 332.8));
            enMap.put(MapUtils.trim("    Beijing Beyondinfo Technology Co., Ltd.                                                 "), new CompanyBean("    Beijing Beyondinfo Technology Co., Ltd.                                                           ", "        PG3-09                        ", 680.4, 357.1));
            enMap.put(MapUtils.trim("    Shenzhen Langheng Tech. Co., Ltd.                                                 "), new CompanyBean("    Shenzhen Langheng Tech. Co., Ltd.                                                           ", "        PG3-07                        ", 680.4, 385.9));
            enMap.put(MapUtils.trim("    Shanghai ZhiZhen Video-Communications Science-Tech Co., Ltd.                                                 "), new CompanyBean("    Shanghai ZhiZhen Video-Communications Science-Tech Co., Ltd.                                                            ", "       PG3-05                        ", 680.2, 416.5));
            enMap.put(MapUtils.trim("    Dongguan aet Technology Co., Ltd.                                                 "), new CompanyBean("    Dongguan aet Technology Co., Ltd.                                                            ", "       PF4-01                        ", 627.4, 350.0));
            enMap.put(MapUtils.trim("    TCL Business Information Technology (Huizhou) Co., Ltd.                                                 "), new CompanyBean("    TCL Business Information Technology (Huizhou) Co., Ltd.                                                           ", "        PF3-01                        ", 628.9, 412.0));
            enMap.put(MapUtils.trim("    Beijing Bohui Science & Technology Co., Ltd.                                                 "), new CompanyBean("    Beijing Bohui Science & Technology Co., Ltd.                                                           ", "        PF2-01                        ", 627.6, 474.9));
            enMap.put(MapUtils.trim("    Beijing Jinzhongheng Science & Technology Co., Ltd.                                                "), new CompanyBean("     Beijing Jinzhongheng Science & Technology Co., Ltd.                                                           ", "        PG2-01                       ", 680.0, 475.1));
            enMap.put(MapUtils.trim("    Hitevision Co., Ltd.                                                "), new CompanyBean("     Hitevision Co., Ltd.                                                           ", "        PF1-01                       ", 633.2, 545.8));

            // m en
            enMap.put(MapUtils.trim("  Guangzhou DSPPA Audio Co., Ltd.                                                   "), new CompanyBean("     Guangzhou DSPPA Audio Co., Ltd.                                                           ", "     MB1-02                          ", 23.6, 539.2));
            enMap.put(MapUtils.trim("  Qiaodeng Video & Audio Equipments Co., Ltd.                                                   "), new CompanyBean("     Qiaodeng Video & Audio Equipments Co., Ltd.                                                          ", "      MB1-03                         ", 25.5, 589.4));
            enMap.put(MapUtils.trim("  JTS Professional Co., Ltd.                                                   "), new CompanyBean("     JTS Professional Co., Ltd.                                                          ", "      MB1-01                         ", 74.4, 513.4));
            enMap.put(MapUtils.trim("  BXB Electronics Co., Ltd.                                                   "), new CompanyBean("     BXB Electronics Co., Ltd.                                                           ", "     MB2-01                          ", 26.1, 660.4));
            enMap.put(MapUtils.trim("  TV One Ltd.                                                  "), new CompanyBean("      TV One Ltd.                                                          ", "      MB4-01                         ", 84.7, 688.4));
            enMap.put(MapUtils.trim("  Dataton AB                                                   "), new CompanyBean("     Dataton AB                                                           ", "     M306A                          ", 321.4, 339.6));
            enMap.put(MapUtils.trim("  Casiris Technology Co., Ltd.                                                  "), new CompanyBean("      Casiris Technology Co., Ltd.                                                          ", "      M306B                         ", 371.6, 344.3));
            enMap.put(MapUtils.trim("  Avanza Corporation                                                   "), new CompanyBean("     Avanza Corporation                                                          ", "      M307A                         ", 424.9, 340.6));
            enMap.put(MapUtils.trim("  BARCO                                                   "), new CompanyBean("     BARCO                                                           ", "     M308                          ", 607.6, 341.3));
            enMap.put(MapUtils.trim("  Project Syntropy GmbH                                                   "), new CompanyBean("     Project Syntropy GmbH                                                           ", "     MA15-01                          ", 278.8, 450.9));
            enMap.put(MapUtils.trim("  ANALOG WAY                                                   "), new CompanyBean("     ANALOG WAY                                                           ", "     MA16-01                          ", 339.8, 453.0));
            enMap.put(MapUtils.trim("  Zen-Ai TECHNOLOGY                                                   "), new CompanyBean("     Zen-Ai TECHNOLOGY                                                           ", "     MA17-01                          ", 403.3, 453.0));
            enMap.put(MapUtils.trim("  Zen-Ai TECHNOLOGY                                                   "), new CompanyBean("     Zen-Ai TECHNOLOGY                                                           ", "     MA18-01                          ", 484.9, 453.0));
            enMap.put(MapUtils.trim("  Casiris Technology Co., Ltd.                                                  "), new CompanyBean("      Casiris Technology Co., Ltd.                                                          ", "      MA19-01                         ", 556.9, 454.8));
            enMap.put(MapUtils.trim("  Redline Technology (Beijing) Co., Ltd.                                                   "), new CompanyBean("     Redline Technology (Beijing) Co., Ltd.                                                           ", "     MA21-01                          ", 621.5, 471.2));
            enMap.put(MapUtils.trim("  Beijing Wincomn Technology Co., Ltd.                                                   "), new CompanyBean("     Beijing Wincomn Technology Co., Ltd.                                                           ", "     M311B                          ", 281.4, 578.5));
            enMap.put(MapUtils.trim("  Delta                                                   "), new CompanyBean("     Delta                                                           ", "     M311A                          ", 360.2, 580.7));
            enMap.put(MapUtils.trim("  Crestron                                                  "), new CompanyBean("      Crestron                                                          ", "      M310                         ", 462.2, 575.4));
            enMap.put(MapUtils.trim("  Vlinc Technology Co., Ltd. Beijing                                                   "), new CompanyBean("     Vlinc Technology Co., Ltd. Beijing                                                          ", "      M309B-02                         ", 554.6, 613.9));
            enMap.put(MapUtils.trim("  Changhong Electric Co., Ltd.                                                  "), new CompanyBean("      Changhong Electric Co., Ltd.                                                          ", "      M309B-01                         ", 554.6, 549.2));
            enMap.put(MapUtils.trim("  Beijing Huatang Liye Technology Co., Ltd.                                                  "), new CompanyBean("      Beijing Huatang Liye Technology Co., Ltd.                                                          ", "      M309A-11                         ", 639.7, 629.9));
            enMap.put(MapUtils.trim("  Beijing Daheng Innovative Technology Co., Ltd.                                                   "), new CompanyBean("     Beijing Daheng Innovative Technology Co., Ltd.                                                          ", "      M309A-10                          ", 660.2, 629.6));
            enMap.put(MapUtils.trim("  Audinate, Inc.                                                   "), new CompanyBean("     Audinate, Inc.                                                          ", "      M309A-09                         ", 677.6, 629.9));
            enMap.put(MapUtils.trim("  Nanjing Ubi Inteactive Media Co., Ltd.                                                   "), new CompanyBean("     Nanjing Ubi Inteactive Media Co., Ltd.                                                           ", "     M309A-08                          ", 695.3, 630.4));
            enMap.put(MapUtils.trim("  Syitshow Technology Co., Ltd.                                                   "), new CompanyBean("     Syitshow Technology Co., Ltd.                                                           ", "     M309A-05                          ", 695.8, 590.4));
            enMap.put(MapUtils.trim("  Farreach Electronic Co., Ltd.                                                  "), new CompanyBean("      Farreach Electronic Co., Ltd.                                                          ", "      M309A-04                         ", 677.3, 589.8));
            enMap.put(MapUtils.trim("  iBuild Co., Ltd.                                                   "), new CompanyBean("     iBuild Co., Ltd.                                                          ", "      M309A-03                         ", 660.2, 590.4));
            enMap.put(MapUtils.trim("  Kunshan Silei Technology Ltd.                                                   "), new CompanyBean("     Kunshan Silei Technology Ltd.                                                           ", "     M309A-02                          ", 639.4, 590.1));
            enMap.put(MapUtils.trim("  Shanghai Aviation Electric Co., Ltd.                                                   "), new CompanyBean("     Shanghai Aviation Electric Co., Ltd.                                                           ", "     M309A-01                          ", 664.9, 551.1));


        }

        KLog.d(TAG, enMap.hashCode());
        return enMap;

    }

}
