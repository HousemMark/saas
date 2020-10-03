package com.unit.api.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: yuboliang
 * @date: 2020/4/2
 **/
@ApiModel(value = "API鉴权请求")
@Getter
@Setter
public class OpenApiAuthenticationRequest {

    /**
     * accessKeyId
     */
    @ApiModelProperty(name = "accessKeyId",value = "accessKeyId",required = true)
    @NotBlank(message = "accessKeyId不能为空")
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    @ApiModelProperty(name = "accessKeySecret",value = "accessKeySecret",required = true)
    @NotBlank(message = "accessKeySecret不能为空")
    private String accessKeySecret;
}
