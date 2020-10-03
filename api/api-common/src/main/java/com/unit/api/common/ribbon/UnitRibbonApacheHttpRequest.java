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
package com.unit.api.common.ribbon;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.BasicHttpEntity;
import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpRequest;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandContext;

import java.util.List;

import static org.springframework.cloud.netflix.ribbon.support.RibbonRequestCustomizer.Runner.customize;

/**
 * zlsd定制RibbonApacheHttpRequest.
 * 针对特殊请求设置读超时时间
 */
public class UnitRibbonApacheHttpRequest extends RibbonApacheHttpRequest {

    public UnitRibbonApacheHttpRequest(RibbonCommandContext context) {
        super(context);
    }

    @Override
    public HttpUriRequest toRequest(RequestConfig requestConfig) {
        String routeInfo = "";

        final RequestBuilder builder = RequestBuilder.create(this.context.getMethod());
        builder.setUri(this.uri);
        for (final String name : this.context.getHeaders().keySet()) {
            final List<String> values = this.context.getHeaders().get(name);
            for (final String value : values) {
                builder.addHeader(name, value);
            }
        }

        for (final String name : this.context.getParams().keySet()) {
            final List<String> values = this.context.getParams().get(name);
            for (final String value : values) {
                builder.addParameter(name, value);
            }
        }

        if (this.context.getRequestEntity() != null) {
            final BasicHttpEntity entity;
            entity = new BasicHttpEntity();
            entity.setContent(this.context.getRequestEntity());
            // if the entity contentLength isn't set, transfer-encoding will be set
            // to chunked in org.apache.http.protocol.RequestContent. See gh-1042
            if (this.context.getContentLength() != null) {
                entity.setContentLength(this.context.getContentLength());
            } else if ("GET".equals(this.context.getMethod())) {
                entity.setContentLength(0);
            }
            builder.setEntity(entity);
        }

        customize(this.context.getRequestCustomizers(), builder);

        Header[] apiReadTimeOuts = builder.getHeaders("apiReadTimeOut");
        if (apiReadTimeOuts.length > 0) {
            RequestConfig.Builder configBuilder = RequestConfig.copy(requestConfig);
            configBuilder.setSocketTimeout(Integer.parseInt(apiReadTimeOuts[0].getValue()));
            builder.setConfig(configBuilder.build());
        } else {
            builder.setConfig(requestConfig);
        }

        return builder.build();
    }
}
