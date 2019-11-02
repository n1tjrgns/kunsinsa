package com.fakesinsa.fakesinsaboot.mapper;

import com.fakesinsa.fakesinsaboot.model.Criteria;

import java.util.HashMap;
import java.util.List;

public interface ShopPagingMapper {

        int getProductCnt();

    List<HashMap<String,Object>> listPaging(Criteria cri);

}
