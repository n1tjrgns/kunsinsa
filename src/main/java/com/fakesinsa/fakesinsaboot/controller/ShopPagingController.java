package com.fakesinsa.fakesinsaboot.controller;

import com.fakesinsa.fakesinsaboot.model.Criteria;
import com.fakesinsa.fakesinsaboot.model.PageMaker;
import com.fakesinsa.fakesinsaboot.service.ShopPagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class ShopPagingController {
    @Autowired
    private ShopPagingService shopPagingService;

    //상품 리스트 페이징
    @RequestMapping("/shop")
    public String getProductList(Criteria cri, Model model) throws Exception{
        PageMaker pm = new PageMaker();
        System.out.println(cri.getCategory());
        pm.setCri(cri);
        pm.setTotalCount(shopPagingService.getProductCnt());
        List<HashMap<String,Object>> page = shopPagingService.listPaging(cri);
        System.out.println(page);
        model.addAttribute("productList", page);
        model.addAttribute("pageMaker", pm);

        return "kunsinsa/shop";
    }



}
