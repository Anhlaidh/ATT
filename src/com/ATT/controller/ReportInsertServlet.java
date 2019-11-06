package com.ATT.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportInsertServlet")
public class ReportInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("insertname");
        String date = request.getParameter("insertdate");
        String process = request.getParameter("insertprocess");
        String content = request.getParameter("insetrcontent");
        String plan = request.getParameter("insertplan");
        String problem = request.getParameter("insertproblem");
        String other = request.getParameter("insertother");
    }
}
