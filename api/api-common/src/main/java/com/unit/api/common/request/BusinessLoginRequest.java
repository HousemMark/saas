package com.unit.api.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author yuboliang
 * @date 2020-2-29
 */
@ApiModel(value = "业务端登录入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessLoginRequest {
    @ApiModelProperty(value = "账号", required = true)
    @NotEmpty(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "平台类型", required = true)
    @NotEmpty(message = "平台类型不能为空")
    private String platform;

    @ApiModelProperty(value = "登录入口", required = false)
    private String entrance;
}
