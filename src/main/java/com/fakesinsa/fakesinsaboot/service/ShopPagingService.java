package com.fakesinsa.fakesinsaboot.service;


import com.fakesinsa.fakesinsaboot.mapper.ShopPagingMapper;
import com.fakesinsa.fakesinsaboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@ComponentScan
public class ShopPagingService {

    @Autowired
    ShopPagingMapper shopPagingMapper;

    public List<HashMap<String,Object>> getProductByCategory(){
        return shopPagingMapper.getProductByCategory();
    }


    public int getProductCnt() {
        return shopPagingMapper.getProductCnt();
    }
}
