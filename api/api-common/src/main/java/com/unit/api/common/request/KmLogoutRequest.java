package com.unit.api.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @program: 智灵时代广州研发中心
 * @description:
 * @author: 吞星(yangguojun)
 * @create: 2020-03-30 14:33
 **/
@ApiModel(value = "业务端登出入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmLogoutRequest implements Serializable {

    @ApiModelProperty(value = "session", required = true)
    @NotEmpty(message = "session不能为空")
    private String session;
}
