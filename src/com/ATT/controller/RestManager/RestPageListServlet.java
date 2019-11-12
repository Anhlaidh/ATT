package com.ATT.controller.RestManager;

import com.ATT.dao.RestManager.initializeRest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "RestPageListServlet",urlPatterns = "/RestPageList")
public class RestPageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int state = 0;
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String s = request.getParameter("state");
        //前台状态转int
        if (s.equals("审批中")){
            state = 0;
        }else if (s.equals("已批准")){
            state = 1;
        }else {
            state = 2;
        }
        LinkedList list = null;
        try {
            list = initializeRest.get(start_date,end_date,state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("restlist",list);
        response.sendRedirect(request.getContextPath()+"/restmanager/restSearch.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
