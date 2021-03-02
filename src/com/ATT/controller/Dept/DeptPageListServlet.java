package com.ATT.controller.Dept;

import com.ATT.dao.initDepartment;
import com.ATT.dao.initializeList;

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
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String management = request.getParameter("management");
        System.out.println(management);
        LinkedList list = null;
        try {
            list = initializeList.get(management,"DepartmentBean");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        session = request.getSession();
        session.setAttribute("departmentList",list);
response.sendRedirect(request.getContextPath()+"dept/deptSearch.jsp");
//        DepartmentBean departmentBean = (DepartmentBean) list.get(0);
//        System.out.println(departmentBean.getName());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
