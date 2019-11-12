package com.ATT.controller;

import com.ATT.bean.PageInfoBean;
import com.ATT.dao.b.DeptDaoImpl;
import com.ATT.dao.b.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "QueryUserByPage",urlPatterns = "/QueryUserByPage")
public class QueryUserByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int count = UserInfoDaoImpl.getTotalCount();
        String cPage = request.getParameter("currentPage");
        if (cPage==null){
            cPage="1";
        }
        int currentPage=Integer.parseInt(cPage);
        int size =5;


        PageInfoBean pageInfoBean=new PageInfoBean();
        pageInfoBean.setPageSize(size);
        pageInfoBean.setCurrentPage(currentPage);
        LinkedList users = UserInfoDaoImpl.queryUserByPage(pageInfoBean.getCurrentPage(),pageInfoBean.getPageSize());

        pageInfoBean.setBeans(users);



        HttpSession session = request.getSession();
        session.setAttribute("up",pageInfoBean);
        response.sendRedirect(request.getContextPath()+"user/userSearch.jsp");

    }
}
