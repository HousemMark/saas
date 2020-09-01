package com.unit.merchant.dal.mapper;

import com.unit.merchant.dal.model.MerchantResource;
import com.unit.merchant.dal.model.MerchantResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantResourceMapper {
    int countByExample(MerchantResourceExample example);

    int deleteByExample(MerchantResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantResource record);

    int insertSelective(MerchantResource record);

    List<MerchantResource> selectByExample(MerchantResourceExample example);

    MerchantResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantResource record, @Param("example") MerchantResourceExample example);

    int updateByExample(@Param("record") MerchantResource record, @Param("example") MerchantResourceExample example);

    int updateByPrimaryKeySelective(MerchantResource record);

    int updateByPrimaryKey(MerchantResource record);
}