package com.ATT.controller.RestManager;

import com.ATT.services.Rest.RestInsertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RestInsertServlet",urlPatterns = "/RestInsert")
public class RestInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String start_date = request.getParameter("start_date");
        String start_time = request.getParameter("start_time");
        String end_date = request.getParameter("end_date");
        String end_time = request.getParameter("end_time");
        String rest_time = request.getParameter("rest_time");
        String beikao = request.getParameter("beikao");
        String rest_cause = request.getParameter("rest_cause");
        RestInsertService.RestInsert(account,start_date,start_time,end_date,end_time,rest_time,rest_cause,beikao);
        response.sendRedirect(request.getContextPath()+"restmanager/restSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
