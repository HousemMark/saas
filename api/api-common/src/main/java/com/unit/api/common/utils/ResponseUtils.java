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

import com.alibaba.fastjson.JSONObject;
import com.zhilingsd.base.common.emuns.ApiResultCodeEnum;

/**
 * @author ZhangRong
 * @version Id: ResponseUtils, v 0.1 2019/6/11 15:01 ZhangRong Exp $$
 */
public class ResponseUtils {
    public static JSONObject wrapperErrorResponse(ApiResultCodeEnum apiResultCodeEnum) {
        return wrapperErrorResponse(apiResultCodeEnum, apiResultCodeEnum.getSubMsg());
    }


    public static JSONObject wrapperErrorResponse(ApiResultCodeEnum apiResultCodeEnum, String subMsg) {
        JSONObject resultJsonObject = new JSONObject();
        JSONObject innerJsonObject = new JSONObject();

        innerJsonObject.put("code", apiResultCodeEnum.getCode());
        innerJsonObject.put("msg", apiResultCodeEnum.getMsg());
        innerJsonObject.put("sub_code", apiResultCodeEnum.getSubCode());
        innerJsonObject.put("sub_msg", subMsg);

        resultJsonObject.put("error_response", innerJsonObject);

        return resultJsonObject;
    }
}
