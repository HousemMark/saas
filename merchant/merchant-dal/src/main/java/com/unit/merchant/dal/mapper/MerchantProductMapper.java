package com.unit.merchant.dal.mapper;

import com.unit.merchant.dal.model.MerchantProduct;
import com.unit.merchant.dal.model.MerchantProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantProductMapper {
    int countByExample(MerchantProductExample example);

    int deleteByExample(MerchantProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantProduct record);

    int insertSelective(MerchantProduct record);

    List<MerchantProduct> selectByExample(MerchantProductExample example);

    MerchantProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantProduct record, @Param("example") MerchantProductExample example);

    int updateByExample(@Param("record") MerchantProduct record, @Param("example") MerchantProductExample example);

    int updateByPrimaryKeySelective(MerchantProduct record);

    int updateByPrimaryKey(MerchantProduct record);
}