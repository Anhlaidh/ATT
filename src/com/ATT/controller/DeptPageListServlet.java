package com.ATT.controller;

import com.ATT.bean.DepartmentBean;
import com.ATT.dao.initializeDepartment;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "DeptPageListServlet",urlPatterns = "/DeptPageListServlet")
public class DeptPageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String management = request.getParameter("management");
        System.out.println(management);
        LinkedList list = null;
        try {
            list = initializeDepartment.get(management);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("departmentList",list);
        request.getRequestDispatcher(request.getContextPath()+"/dept/deptSearch.jsp").forward(request,response);
//        DepartmentBean departmentBean = (DepartmentBean) list.get(0);
//        System.out.println(departmentBean.getName());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
