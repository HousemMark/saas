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

import com.zhilingsd.base.common.utils.ThreadContextUtil;
import com.zhilingsd.cloud.api.common.bo.RequestParamsBO;

import java.util.Map;

/**
 * 系统工具
 *
 * @author ZhangRong
 * @version Id: ApiAppUtils, v 0.1 2019/5/20 20:15 ZhangRong Exp $$
 */
public class ApiAppUtils {

    private volatile static ApiAppUtils app = null;

    private ApiAppUtils() {
    }

    public static synchronized ApiAppUtils getInstance() {
        if (app == null) {
            synchronized (ApiAppUtils.class) {
                if (app == null) {
                    app = new ApiAppUtils();
                }
            }
        }
        return app;
    }

    public static Boolean getIsForwardTo() {
        return (Boolean) ThreadContextUtil.getInstance().get("isForwardTo");
    }

    public static void setIsForwardTo(Boolean isForwardTo) {
        ThreadContextUtil.getInstance().set("isForwardTo", isForwardTo);
    }

    public static RequestParamsBO getRequestParams() {
        return (RequestParamsBO) ThreadContextUtil.getInstance().get("requestParams");
    }

    public static void setRequestParams(RequestParamsBO requestParams) {
        ThreadContextUtil.getInstance().set("requestParams", requestParams);
    }

    public static Map<String, Object> getDataMap() {
        return (Map<String, Object>) ThreadContextUtil.getInstance().get("dataMap");
    }

    public static void setDataMap(Map<String, Object> dataMap) {
        ThreadContextUtil.getInstance().set("dataMap", dataMap);
    }

    public static void clean() {
        ThreadContextUtil.getInstance().clean();
    }
}
