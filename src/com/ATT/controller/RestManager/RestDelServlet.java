package com.ATT.controller.RestManager;

import com.ATT.services.DeptDelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "RestDelServlet",urlPatterns = "/RestDel")
public class RestDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] check = request.getParameterValues("check");
        LinkedList list = new LinkedList();
        for (int i = 0;i<check.length;i++){
            list.add(check[i]);
        }
        boolean t_report_record = DeptDelService.Del(list, "T_REST_RECORD");
        response.sendRedirect(request.getContextPath()+"/restmanager/restSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
