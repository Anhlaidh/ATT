package com.ATT.controller;

import com.ATT.dao.WorkDaoImpl;

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
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");

        Date start_date = null;
        Date end_date=null;
        try {
            start_date = sf1.parse(request.getParameter("start_date"));
            end_date=sf2.parse(request.getParameter("end_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int choice =Integer.parseInt(request.getParameter("choice"));
        LinkedList list=null;
        try {
            list = WorkDaoImpl.getComponentPageList(start_date,end_date,choice);
        }catch (Exception e){
            e.printStackTrace();
        }
        session=request.getSession();
        session.setAttribute("workmanagerList",list);
        response.sendRedirect(request.getContextPath()+"manager/workSearch.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}
