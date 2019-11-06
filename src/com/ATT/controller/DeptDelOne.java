package com.ATT.controller;

import com.ATT.dao.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptDelOne",urlPatterns = "/DeptDelOne")
public class DeptDelOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("DepartmentId");

        boolean delete = Delete.Delete(departmentId, "T_DEPARTMENT");
        request.getRequestDispatcher(request.getContextPath()+"/dept/deptSearch.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
