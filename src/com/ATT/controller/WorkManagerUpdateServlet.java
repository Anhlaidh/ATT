package com.ATT.controller;

import com.ATT.services.WorkManagerUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WorkManagerUpdateServlet",urlPatterns = "/WorkManagerUpdateServlet")
public class WorkManagerUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String record_id =request.getParameter("record_id");
        String work_date=request.getParameter("work_date");
        String start_date=request.getParameter("start_time");
        String end_date=request.getParameter("end_time");
        String work_time=request.getParameter("work_time");
        String work_cause=request.getParameter("work_cause");
        WorkManagerUpdate.Update(record_id,work_date,start_date,end_date,work_time,work_cause);
        response.sendRedirect( request.getContextPath()+"/workmanager/workSearch.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
