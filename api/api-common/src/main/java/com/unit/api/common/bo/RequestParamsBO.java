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
package com.unit.api.common.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求参数
 * @author ZhangRong
 * @version Id: RequestParamsBO, v 0.1 2019/5/11 17:15 ZhangRong Exp $$
 */
@Getter
@Setter
public class RequestParamsBO {
    /**
     * API接口名称
     * 必填
     * exp: collection.sensitiveword.query
     */
    private String method;

    /**
     * 用户登录授权成功后，颁发给应用的授权信息。
     * 选填
     * exp: 2a72fed8-b12f-48e2-9afc-eb1dad0b5460
     */
    private String session;

    /**
     * 时间戳，时区为GMT+8，格式为yyyy-mm-dd hh:mm:ss，服务端允许客户端请求最大时间误差为10分钟。
     * 必填
     * exp: 2019-05-10 10:23:30
     */
    private String timestamp;

    /**
     * 业务参数,json格式
     * 选填
     * exp: {"name":"ZhangRong"}
     */
    private String data;
}
