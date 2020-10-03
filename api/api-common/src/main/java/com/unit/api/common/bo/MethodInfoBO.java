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

/**
 * 调用后端方法的信息
 * @author ZhangRong
 * @version Id: MethodInfoBO, v 0.1 2019/5/11 15:22 ZhangRong Exp $$
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MethodInfoBO {
    /**
     * 服务Id
     * exp: zlsd-collection-console
     */
    private String serviceId;

    /**
     * 接口方法名
     * exp: /alarmWord/query-alarm-word
     */
    private String api;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 请求方式，可选GET,POST
     * exp: GET
     */
    private String methodType;

    /**
     * 特定超时时间
     * exp: 5000
     */
    private Integer readTimeOut;

}
