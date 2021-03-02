package com.ATT.controller.User;

import com.ATT.bean.UserInfo;
import com.ATT.dao.Insert;
import com.ATT.dao.UserInfoInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInsertServlet",urlPatterns = "/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
//        DeptInsert.DeptInsert(dept_id,dept_name,dept_manager);

        System.out.println(email+birthday+name);
            UserInfo user = UserInfoInit.init(id, password, name, department, sex, phone, birthday, email);
        Insert.Insert(user,"UserInfo");

        request.getRequestDispatcher(request.getContextPath()+"user/userSearch.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
