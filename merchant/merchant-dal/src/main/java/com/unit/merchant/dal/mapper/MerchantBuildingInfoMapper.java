package com.unit.merchant.dal.mapper;

import com.unit.merchant.dal.model.MerchantBuildingInfo;
import com.unit.merchant.dal.model.MerchantBuildingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantBuildingInfoMapper {
    int countByExample(MerchantBuildingInfoExample example);

    int deleteByExample(MerchantBuildingInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantBuildingInfo record);

    int insertSelective(MerchantBuildingInfo record);

    List<MerchantBuildingInfo> selectByExample(MerchantBuildingInfoExample example);

    MerchantBuildingInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantBuildingInfo record, @Param("example") MerchantBuildingInfoExample example);

    int updateByExample(@Param("record") MerchantBuildingInfo record, @Param("example") MerchantBuildingInfoExample example);

    int updateByPrimaryKeySelective(MerchantBuildingInfo record);

    int updateByPrimaryKey(MerchantBuildingInfo record);
}