package com.fakesinsa.fakesinsaboot.controller;

import com.fakesinsa.fakesinsaboot.model.Paging;
import com.fakesinsa.fakesinsaboot.model.Product;
import com.fakesinsa.fakesinsaboot.service.ShopPagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopPagingController {
    @Autowired
    private ShopPagingService shopPagingService;


    Paging page = new Paging();
    int pageCount = page.getPageCount();

    @RequestMapping(value="/currentPage", method = RequestMethod.GET)
    public void makeBlick(int currentPage, Model model){

        //페이징 블락은 1~5번 페이지까지만
        int blockNum = 0;
        int start = page.getStart(); //시작 번호
        int end = page.getEnd(); // 끝 번호
        blockNum = (int)Math.floor((currentPage-1) / pageCount);

        start = pageCount * blockNum + 1;
        end = start + (pageCount-1);

        //마지막 페이지 번호 계산
        int totalProductCnt = shopPagingService.getProductCnt();

        int lastPage = page.getLastPage(); // 총 페이지의 마지막 번호
        if(totalProductCnt % page.getPageCount() == 0){
            lastPage = (int) Math.floor(totalProductCnt / pageCount);
        }else{
            lastPage = (int) Math.floor(totalProductCnt / pageCount) + 1;
        }
        System.out.println(start);
        System.out.println(end);
        System.out.println(lastPage);
        model.addAttribute("start",start);
        model.addAttribute("end",end);
        model.addAttribute("lastPage",lastPage);
    }



    /*// 검색을 했을 때 총 페이지의 마지막 번호
    public void makeLastPageNum(String kwd) {
        BoardDAO dao = new BoardDAO();
        int total = dao.getCount(kwd);

        if( total % pageCount == 0 ) {
            lastPageNum = (int)Math.floor(total/pageCount);
        }
        else {
            lastPageNum = (int)Math.floor(total/pageCount) + 1;
        }
    }*/


    //해당 카테고리 별 상품의 개수 출력
    @RequestMapping("/shop")
    public ModelAndView getProductList(Model model){
        //Product pro = new Product();
        //int productCnt = shopPagingService.getProductByCategory(pro);


        List<HashMap<String,Object>> productMap = shopPagingService.getProductByCategory();
        System.out.println(productMap);
        ModelAndView mv = new ModelAndView();
        //model.addAttribute("productMap",productMap);
        mv.addObject("productMap",productMap);
        mv.setViewName("kunsinsa/shop");

        return mv;
    }



}
