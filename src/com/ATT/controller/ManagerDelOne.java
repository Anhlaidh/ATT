package com.ATT.controller;

import com.ATT.dao.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerDelOne",urlPatterns = "/ManagerDelOne")
public class ManagerDelOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recor_id = request.getParameter("recor_id");
        boolean delete = Delete.Delete(recor_id, "T_WORK_RECORD");
        request.getRequestDispatcher(request.getContextPath()+"/manager/workSearch.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
