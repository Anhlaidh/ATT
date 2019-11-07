package com.ATT.controller;

import com.ATT.dao.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportDelOne",urlPatterns = "/ReportDelOne")
public class ReportDelOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String report_id = request.getParameter("Report_id");
        boolean delete = Delete.Delete(report_id, "T_REPORT_RECORD");
        response.sendRedirect(request.getContextPath()+"/report/reportSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
