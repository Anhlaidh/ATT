package com.ATT.controller;

import com.ATT.dao.WorkDaoImpl;
import com.ATT.dao.initializeWorkManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@WebServlet(name = "WorkPageListServlet", urlPatterns = "/WorkPageListServlet")
public class WorkPageListServlet extends HttpServlet {
    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String start_date=request.getParameter("start_date");
        String end_date=request.getParameter("end_date");
        int choice=Integer.parseInt(request.getParameter("choice"));
        LinkedList list = null;
        try{
            list= initializeWorkManager.get(start_date,end_date,choice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("workmanagerList",list);
        response.sendRedirect(request.getContextPath()+"/workmanager/workSearch.jsp");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }


}
