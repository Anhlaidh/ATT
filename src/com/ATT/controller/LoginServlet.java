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
//        response.sendRedirect(request.getContextPath()+"/main.jsp");
//        response.sendRedirect(request.getContextPath()+"/login.jsp");


        if (userInfo==null){
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
            return;
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("UserInfo",userInfo);
            request.getRequestDispatcher(request.getContextPath()+"/main.jsp").forward(request,response);
            return;

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
