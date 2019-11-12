package com.ATT.controller;

import com.ATT.services.MainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        int myl = -1;
        try {
            myl= MainService.MainSearch(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("mylevel",myl);
        response.sendRedirect(request.getContextPath()+"/user/main.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
