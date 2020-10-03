package com.unit.api.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: yuboliang
 * @date: 2020/4/2
 **/
@Getter
@Setter
public class OpenApiAuthenticationResponse {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("token过期时长（秒）")
    private Integer expireSeconds;
}
