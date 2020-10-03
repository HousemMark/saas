package com.unit.api.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @program: 智灵时代广州研发中心
 * @description:
 * @author: 吞星(yangguojun)
 * @create: 2020-03-30 14:33
 **/
@ApiModel(value = "Km登录入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmLoginRequest {

    @ApiModelProperty(value = "账号", required = true)
    @NotEmpty(message = "账号不能为空")
    private String loginAccount;

    @ApiModelProperty(value = "平台类型", required = true)
    @NotEmpty(message = "平台类型不能为空")
    private String platform;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;


}
