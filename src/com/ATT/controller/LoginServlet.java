package com.ATT.controller;

import com.ATT.bean.UserInfo;
import com.ATT.services.LoginService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    String Username;
    String Password;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Username = request.getParameter("username");
        Password = request.getParameter("password");
        LoginService Login = new LoginService();
        UserInfo userInfo = Login.login(Username, Password);
        if ("null".equals(userInfo)){
            request.getRequestDispatcher("login.jsp");
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("UserInfo",userInfo);
            request.getRequestDispatcher("main.jsp");


        }


//        UserInfo UserInfo = null;
//        try {
//             UserInfo= initializeBean.get();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("UserInfo",UserInfo);


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
