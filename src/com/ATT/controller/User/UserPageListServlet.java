package com.ATT.controller.User;

import com.ATT.bean.UserInfo;
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
        String department = request.getParameter("dept_name");
        System.out.println(name);
        System.out.println(department);



        LinkedList list=null;
        LinkedList  User_Info = new LinkedList();
        try {
            list = initializeList.get("ALL","UserInfo");

            for (int i =0;i<list.size();i++){
                UserInfo user_info = (UserInfo)list.get(i);
                if (department.equals(user_info.getDepartmentName())&&name.equals(user_info.getName())){
                    User_Info.add(user_info);

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(User_Info.size());
        session = request.getSession();
        session.setAttribute("Userlist",User_Info);
        response.sendRedirect(request.getContextPath()+"user/userSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
