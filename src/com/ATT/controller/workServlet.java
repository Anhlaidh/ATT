package com.ATT.controller;

import com.ATT.bean.WorkRecordBean;
import com.ATT.services.workService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "workServlet", urlPatterns = "/workServlet")
public class workServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String work_date = request.getParameter("work_date");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String work_time = request.getParameter("work_time");
        String beikao = request.getParameter("beikao");
        WorkRecordBean workRecordBean = new WorkRecordBean(account, work_date, start_time, end_time, work_time, beikao);
        workService workService = new workService();
        int result = workService.insertWorkRecord(workRecordBean);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        if (result == 1) {
            response.sendRedirect("/workmanager/workSearch.jsp");

        } else {
            response.sendRedirect("/workmanager/Insert.jsp");
        }


    }
}