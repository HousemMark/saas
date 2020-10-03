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

import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandContext;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommand;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommandFactory;

import java.util.Set;
public class UnitHttpCliemtRibbonCommandFactory extends HttpClientRibbonCommandFactory {

    private final SpringClientFactory clientFactory;

    private final ZuulProperties zuulProperties;

    public UnitHttpCliemtRibbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
        super(clientFactory, zuulProperties);
        this.clientFactory = clientFactory;
        this.zuulProperties = zuulProperties;
    }

    public UnitHttpCliemtRibbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties, Set<ZuulFallbackProvider> fallbackProviders) {
        super(clientFactory, zuulProperties, fallbackProviders);
        this.clientFactory = clientFactory;
        this.zuulProperties = zuulProperties;
    }

    @Override
    public HttpClientRibbonCommand create(RibbonCommandContext context) {
        ZuulFallbackProvider zuulFallbackProvider = getFallbackProvider(context.getServiceId());
        final String serviceId = context.getServiceId();
        final RibbonLoadBalancingHttpClient client = this.clientFactory.getClient(
                serviceId, RibbonLoadBalancingHttpClient.class);
        client.setLoadBalancer(this.clientFactory.getLoadBalancer(serviceId));

        return new UnitHttpClientRibbonCommand(serviceId, client, context, zuulProperties, zuulFallbackProvider);
    }
}
