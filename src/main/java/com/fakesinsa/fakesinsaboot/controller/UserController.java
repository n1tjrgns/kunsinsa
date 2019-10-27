package com.fakesinsa.fakesinsaboot.controller;


import com.fakesinsa.fakesinsaboot.model.User;
import com.fakesinsa.fakesinsaboot.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*쿤신사 경로매핑*/
    @RequestMapping("/cart")
    public String cart(){
        return "kunsinsa/cart";
    }

    @RequestMapping("/")
    public String main(){
        return "kunsinsa/index";
    }

    @RequestMapping("/join")
    public String join(){
        return "kunsinsa/join";
    }

    @RequestMapping("/index")
    public String index(){
        return "kunsinsa/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "kunsinsa/login";
    }

    @RequestMapping("/checkout")
    public String checkout(){
        return "kunsinsa/checkout";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "kunsinsa/logout";
    }

    @RequestMapping("/purchase")
    public String purchase(){
        return "kunsinsa/purchase";
    }

    @RequestMapping("/product-details")
    public String productDetails(){
        return "kunsinsa/product-details";
    }

    @RequestMapping("/signup")
    public String signup(){
        return "kunsinsa/signup";
    }

    @RequestMapping(value = "logincheck")
    public ModelAndView loginCheck(@ModelAttribute("User") User user, HttpServletRequest req){
        System.out.println("로그인 체크 컨트롤러");
        System.out.println(user);
        User userResult = userService.getUserInfo(user);
        System.out.println("유저 비밀번호 확인 :" +userResult.getUserPassword());
        ModelAndView mv = new ModelAndView();
        if(BCrypt.checkpw(user.getUserPassword(),userResult.getUserPassword())){
            System.out.println("비번같음");
            HttpSession session =  req.getSession();
            session.setAttribute("userId", user.getUserId());
            System.out.println(user.getUserId());
            mv.setViewName("index");
        }else{
            System.out.println("비번다름");
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping("signupcheck")
    public ModelAndView signupCheck(@ModelAttribute("User") User user, HttpServletRequest req){
        System.out.println("회원가입 컨트롤러");
        System.out.println(user);

        String userPassword = user.getUserPassword();
        userPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        user.setUserPassword(userPassword);

        int insertUser = userService.setUserInfo(user);

        System.out.println("insert 결과 : "+ insertUser);
        ModelAndView mv = new ModelAndView();

        if(insertUser > 0){
            mv.setViewName("index");
        }else{
            mv.setViewName("signup");
        }
        return mv;
    }
    /*
    //회원가입 컨트롤러
    @RequestMapping(value = "/signupcheck")
    public ModelAndView signUp(HttpServletRequest req, User user) {

        *//*try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*//*

        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");
        String userPassword = req.getParameter("userPassword");
        System.out.println("userName : " + userName);
        System.out.println("userEmail : " + userEmail);


        //bcrypt로 비밀번호 암호화
        userPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        user.setUserPassword(userPassword);
        System.out.println("userPassword : " + userPassword);

        int signUpResult = userService.setUserInfo(userName, userEmail, userPassword);
        System.out.println("signUpResult : " + signUpResult);
        ModelAndView mv = new ModelAndView();

        if (signUpResult == 1) {
            mv.setViewName("redirect:../view/login.jsp");
        } else {
            mv.setViewName("redirect:../view/signup.jsp");
        }
        return mv;
    }

    @RequestMapping("/hello")
    public String Hello(ModelAndView mv){
        //mv.setViewName("hello");
        return "hello";
    }

    @RequestMapping("/")
    public String loginController(ModelAndView mv){
        //mv.setViewName("hello");
        return "login";
    }
    //로그인 컨트롤러
    //@RequestMapping(value = "/logincheck")
    @RequestMapping("/logincheck")
    //public String login(HttpServletRequest req, User user) {
    public ModelAndView login(HttpServletRequest req, User user) {
        System.out.println("logincheck 컨트롤러");
        String userEmail = req.getParameter("userEmail");
        System.out.println("userEmail : " + userEmail);

        //회원정보 확인
        String selectAccount = userService.getUserInfo(userEmail);
        System.out.println("회원정보가 안나옴");
        System.out.println(selectAccount);

        ModelAndView mv = new ModelAndView();
        HttpSession session = req.getSession();

        if (selectAccount != null) {
            //로그인 시 상품 정보를 select해서 같이 넘겨준다.
            //List<Map<Object,Object>> selectProduct = productDaoImpl.getProductInfo();
            //System.out.println(selectProduct);

            //redirect를 하면 정보가 사라져서 session을 사용해
            //session.setAttribute("selectProduct",selectProduct);

            if (BCrypt.checkpw(user.getUserPassword(), selectAccount)) {
               // mv.setViewName("redirect:../view/main.jsp");
                //mv.setViewName("redirect:../view/user/login");
                //return new RedirectView("main.jsp");
                mv.setViewName("redirect://localhost:9000/main");
            }
        } else {
            mv.setViewName("redirect://localhost:9000/login");
            //mv.setViewName("redirect:../view/login.jsp");
        }
        return mv;
    }


    인코딩 맞춰주기
    private void convertEncoding(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }*/
}
