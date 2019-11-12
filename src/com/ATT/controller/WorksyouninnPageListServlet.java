package com.ATT.controller;

import com.ATT.dao.initializeWorksyouninn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "WorksyouninnPageListServlet",urlPatterns = "/WorksyouninnPageListServlet")
public class WorksyouninnPageListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String startdate=request.getParameter("startdate");
        String enddate=request.getParameter("enddate");
        LinkedList list = null;

        try{

            list=initializeWorksyouninn.get(name,startdate,enddate);
        }catch (SQLException e){
            e.printStackTrace();
        }

        HttpSession session=request.getSession();
        session.setAttribute("worksyouninnList",list);

        response.sendRedirect(request.getContextPath()+"worksyouninn/worksyouninnSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
