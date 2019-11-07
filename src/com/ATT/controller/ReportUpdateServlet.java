package com.ATT.controller;

import com.ATT.bean.ReportBean;
import com.ATT.services.ReportUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportUpdate",urlPatterns = "/ReportUpdate")
public class ReportUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int report_id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String report_date = request.getParameter("report_date");
        String work_process = request.getParameter("work_process");
        String work_content = request.getParameter("work_content");
        String tomorrow_plan = request.getParameter("tomorrow_plan");
        String problem = request.getParameter("problem");
        String other = request.getParameter("other");
        ReportUpdate.ReportUpdate(report_id,name,report_date,work_process,work_content,tomorrow_plan,problem,other);
        response.sendRedirect(request.getContextPath()+"report/reportSearch.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
