package com.ATT.controller;

import com.ATT.bean.UserInfoBean;
import com.ATT.dao.UserDao;
import com.ATT.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String department_name=request.getParameter("department_name");
        String sex=request.getParameter("sex");
        String mobile=request.getParameter("mobile");
        String birthday=request.getParameter("birthday");
        String email=request.getParameter("email");
        System.out.println("...account:"+account+"...password:"+password+"...name:"+name+"...department_name:"+department_name+"...sex:"+sex+"...mobile:"+mobile+"...birthday:"+birthday+"...email:"+email);
        UserInfoBean userInfoBean=new UserInfoBean(account,password,name,sex,birthday,mobile,email,department_name);
        UserInfoBean userInfoBean1=new UserInfoBean(department_name);
        int a=UserDao.updateUser(userInfoBean);
        int b=UserDao.updateUser2(userInfoBean1);
        System.out.println(a);
        System.out.println(b);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
