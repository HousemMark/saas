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
package com.unit.api.common.constants;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 过滤器顺序
 *
 * @author ZhangRong
 * @version Id: FiltersOrderConstant, v 0.1 2019/5/20 19:56 ZhangRong Exp $$
 */
public class FiltersOrderConstant {

    // -----------------------------PRE---------------------------------
    /**
     * FORWARD_FILTER_ORDER = 7
     */
    public static int PRE_FORWARD_FILTER_ORDER = FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 3;

    /**
     * PARAMETER_CHECK_FILTER_ORDER = 8
     */
    public static int PRE_PARAMETER_CHECK_FILTER_ORDER = FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 2;

    /**
     * PERMISSION_FILTER_ORDER = 9
     */
    public static int PRE_PERMISSION_FILTER_ORDER = FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 1;


    // -----------------------------ROUTE---------------------------------
    /**
     * URL_REDIRECT_FILTER_ORDER = 2
     */
    public static int ROUTE_URL_REDIRECT_FILTER_ORDER = FilterConstants.DEBUG_FILTER_ORDER + 1;



    // -----------------------------POST---------------------------------
    /**
     * ERROR_RESPONSE_FILTER_ORDER = 998
     */
    public static int POST_ERROR_RESPONSE_FILTER_ORDER = FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;

    /**
     * PACKAGE_RESPONSE_FILTER_ORDER = 999
     */
    public static int POST_PACKAGE_RESPONSE_FILTER_ORDER = FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;

}
