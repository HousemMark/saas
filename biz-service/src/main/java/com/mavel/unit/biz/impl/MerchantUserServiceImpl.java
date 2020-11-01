package com.mavel.unit.biz.impl;

import com.mavel.unit.biz.MerchantUserService;
import com.mavel.unit.dao.MerchantUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantUserServiceImpl implements MerchantUserService {

    @Autowired
    private MerchantUserDao merchantUserDao;

    public void test() {

    }
}
