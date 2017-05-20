/*
 *
 *  * Copyright 2017 Sherchen
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.sherchen.code.androidconventions.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * <pre>
 *     author : Sherchen
 *     e-mail : ncuboy_045wsq@qq.com
 *     time   : 2017/5/19
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public class MethodUtil {

    /**
     * 清除SP
     */
    public static void resetPreference(){

    }

    /**
     * 判断是否csdn博客
     * @return
     */
    public static boolean isCsdn(){
        return false;
    }

    public static boolean isOk(int blogTime){
        return false;
    }

    public static void readBlog(){
        int blogTime = 1000;//局部变量
        for(int i=0;i<5;i++){
            Log.d("sherchen", "打印临时变量:" + i);
        }
    }

    /**
     * 获取Sim卡运营商名称
     * <p>中国移动、如中国联通、中国电信</p>
     * @param context 上下文
     * @return 移动网络运营商名称
     */
    public static String getSimOperatorByMnc(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        String operator = tm != null ? tm.getSimOperator() : null;
        if (operator == null) return null;
        switch (operator) {
            case "46000":
            case "46002":
            case "46007":
                return "中国移动";
            case "46001":
                return "中国联通";
            case "46003":
                return "中国电信";
            default:
                return operator;
        }
    }

}
