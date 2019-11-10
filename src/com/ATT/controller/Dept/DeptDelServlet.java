package com.ATT.controller.Dept;

import com.ATT.services.DeptDelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "DeptDelServlet",urlPatterns = "/DeptDelServlet")
public class DeptDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] check = request.getParameterValues("check");

        LinkedList list = new LinkedList();
        for (int i = 0;i<check.length;i++){
            list.add(check[i]);
        }
        boolean t_department = DeptDelService.Del(list, "T_DEPARTMENT");

        request.getRequestDispatcher(request.getContextPath()+"/dept/deptSearch.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }


}
