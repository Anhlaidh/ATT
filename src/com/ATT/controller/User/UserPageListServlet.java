package com.ATT.controller.User;

import com.ATT.dao.initializeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "UserPageListServlet",urlPatterns ="/UserPageListServlet")
public class UserPageListServlet extends HttpServlet {
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String department = request.getParameter("department");
        System.out.println(name);
        LinkedList list = null;
        try {
            list = initializeList.get(name,"UserInfo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session = request.getSession();
        session.setAttribute("departmentList",list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
