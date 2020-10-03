/**
 * Software License Declaration.
 * <p>
 * zhilingsd.com, Co,. Ltd.
 * Copyright © 2019 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to zhilingsd contracting agent or authorized programmer only.
 * This source code is written and edited by zhilingsd Co,.Ltd Inc specially for financial
 * cloud contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to zhilingsd Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise zhilingsd will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to zhilingsd Co,. Ltd Inc in time, Thank you!
 */
package com.unit.api.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhilingsd.cloud.api.common.enums.JSONObjectTypeEnum;

/**
 * @author ZhangRong
 * @version Id: JsonExtUtils, v 0.1 2019/5/17 17:35 ZhangRong Exp $$
 */
public class JsonExtUtils {

    public static JSONObjectTypeEnum identifyJSONObectType(String json){
        if (json.indexOf("[") == 0) {
            JSONArray jsonArray = JSONArray.parseArray(json);
            if(null != jsonArray){
                return JSONObjectTypeEnum.JSONARRAY;
            }
        } else {
            JSONObject jsonData = JSONObject.parseObject(json);
            if(null != jsonData){
                return JSONObjectTypeEnum.JSONOBJECT;
            }
        }

        return JSONObjectTypeEnum.NOTJSON;
    }
}
