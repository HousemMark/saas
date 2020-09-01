package com.unit.merchant.dal.mapper;

import com.unit.merchant.dal.model.MerchantBaseInfo;
import com.unit.merchant.dal.model.MerchantBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantBaseInfoMapper {
    int countByExample(MerchantBaseInfoExample example);

    int deleteByExample(MerchantBaseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantBaseInfo record);

    int insertSelective(MerchantBaseInfo record);

    List<MerchantBaseInfo> selectByExample(MerchantBaseInfoExample example);

    MerchantBaseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantBaseInfo record, @Param("example") MerchantBaseInfoExample example);

    int updateByExample(@Param("record") MerchantBaseInfo record, @Param("example") MerchantBaseInfoExample example);

    int updateByPrimaryKeySelective(MerchantBaseInfo record);

    int updateByPrimaryKey(MerchantBaseInfo record);
}