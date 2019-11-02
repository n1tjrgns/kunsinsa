package com.fakesinsa.fakesinsaboot.service;


import com.fakesinsa.fakesinsaboot.mapper.ShopPagingMapper;
import com.fakesinsa.fakesinsaboot.model.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@ComponentScan
public class ShopPagingService {

    @Autowired
    ShopPagingMapper shopPagingMapper;


    public int getProductCnt() {
        return shopPagingMapper.getProductCnt();
    }

    public List<HashMap<String,Object>> listPaging(Criteria cri) {
        return shopPagingMapper.listPaging(cri);
    }
}
