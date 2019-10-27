package com.fakesinsa.fakesinsaboot.mapper;

import java.util.HashMap;
import java.util.List;

public interface ShopPagingMapper {

    List<HashMap<String,Object>> getProductByCategory() ;

    int getProductCnt();
}
