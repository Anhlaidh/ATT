package com.ATT.controller;

import com.ATT.dao.initializeRestsyouninn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "RestsyouninnPageListServlet",urlPatterns = "/RestsyouninnPageListServlet")
public class RestsyouninnPageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String startdate=request.getParameter("startdate");
        String enddate=request.getParameter("enddate");
        LinkedList list=null;

        try {
            list= initializeRestsyouninn.get(name,startdate,enddate);
        }catch (SQLException e){
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("restsyouninnList",list);
        response.sendRedirect(request.getContextPath()+"restsyouninn/restsyouninnSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
