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
 * @date 2020-3-3
 */
@ApiModel(value = "管理端登录入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManageLoginRequest {
    @ApiModelProperty(value = "账号", required = true)
    @NotEmpty(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
