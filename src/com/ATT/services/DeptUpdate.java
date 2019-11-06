package com.ATT.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptUpdate",urlPatterns = "/DeptUpdate")
public class DeptUpdate extends HttpServlet {
//    update T_DEPARTMENT set DEPARTMENT_ID='10010' where DEPARTMENT_ID='10006'
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
