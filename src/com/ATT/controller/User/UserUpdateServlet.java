package com.ATT.controller.User;

import com.ATT.bean.UserInfo;
import com.ATT.dao.Update;
import com.ATT.dao.UserInfoInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet",urlPatterns = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        System.out.println(sex);
        UserInfo user = UserInfoInit.init(id, password, name, department, sex, phone, birthday, email);
        Update.Update(id,user,"T_USER_INFO");
        response.sendRedirect(request.getContextPath()+"user/userSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
