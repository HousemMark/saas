package com.unit.merchant.dal.mapper;

import com.unit.merchant.dal.model.MerchantRole;
import com.unit.merchant.dal.model.MerchantRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantRoleMapper {
    int countByExample(MerchantRoleExample example);

    int deleteByExample(MerchantRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantRole record);

    int insertSelective(MerchantRole record);

    List<MerchantRole> selectByExample(MerchantRoleExample example);

    MerchantRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantRole record, @Param("example") MerchantRoleExample example);

    int updateByExample(@Param("record") MerchantRole record, @Param("example") MerchantRoleExample example);

    int updateByPrimaryKeySelective(MerchantRole record);

    int updateByPrimaryKey(MerchantRole record);
}