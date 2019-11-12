package com.ATT.controller;

import com.ATT.dao.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WorkManagerDelOne",urlPatterns = "/ManagerDelOne")
public class WorkManagerDelOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String record_id = request.getParameter("record_id");
        boolean delete = Delete.Delete(record_id, "T_WORK_RECORD");
        response.sendRedirect(request.getContextPath()+"/workmanager/workSearch.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
