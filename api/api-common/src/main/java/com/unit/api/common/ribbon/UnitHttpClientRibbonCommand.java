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

import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpRequest;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandContext;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommand;

public class UnitHttpClientRibbonCommand extends HttpClientRibbonCommand {

    public UnitHttpClientRibbonCommand(final String commandKey,
                                       final RibbonLoadBalancingHttpClient client,
                                       final RibbonCommandContext context,
                                       final ZuulProperties zuulProperties) {
        super(commandKey, client, context, zuulProperties);
    }

    public UnitHttpClientRibbonCommand(final String commandKey,
                                       final RibbonLoadBalancingHttpClient client,
                                       final RibbonCommandContext context,
                                       final ZuulProperties zuulProperties,
                                       final ZuulFallbackProvider zuulFallbackProvider) {
        super(commandKey, client, context, zuulProperties, zuulFallbackProvider);
    }

    public UnitHttpClientRibbonCommand(final String commandKey,
                                       final RibbonLoadBalancingHttpClient client,
                                       final RibbonCommandContext context,
                                       final ZuulProperties zuulProperties,
                                       final ZuulFallbackProvider zuulFallbackProvider,
                                       final IClientConfig config) {
        super(commandKey, client, context, zuulProperties, zuulFallbackProvider, config);
    }

    @Override
    protected RibbonApacheHttpRequest createRequest() throws Exception {
        RibbonApacheHttpRequest ribbonApacheHttpRequest = new UnitRibbonApacheHttpRequest(this.context);
        return ribbonApacheHttpRequest;
    }
}
