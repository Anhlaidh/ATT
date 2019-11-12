package com.ATT.controller;

import com.ATT.bean.PageInfoBean;
import com.ATT.dao.b.DeptDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "QueryDeptByPage",urlPatterns = "/QueryDeptByPage")
public class QueryDeptByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int count = DeptDaoImpl.getTotalCount();
        String cPage = request.getParameter("currentPage");
        if (cPage==null){
            cPage="1";
        }
        int currentPage=Integer.parseInt(cPage);
        int size =5;


        PageInfoBean pageInfoBean=new PageInfoBean();
        pageInfoBean.setPageSize(size);
        pageInfoBean.setCurrentPage(currentPage);
        LinkedList depts = DeptDaoImpl.queryDeptByPage(pageInfoBean.getCurrentPage(),pageInfoBean.getPageSize());

        pageInfoBean.setBeans(depts);



        HttpSession session = request.getSession();
        session.setAttribute("p",pageInfoBean);
        response.sendRedirect(request.getContextPath()+"dept/deptSearch.jsp");
    }
}
