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
@ApiModel(value = "管理端登出入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManageLogoutRequest {
    @ApiModelProperty(value = "session", required = true)
    @NotEmpty(message = "session不能为空")
    private String session;
}
