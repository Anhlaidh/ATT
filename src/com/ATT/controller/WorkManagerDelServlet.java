package com.ATT.controller;

import com.ATT.services.WorkManagerDelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "WorkManagerDelServlet",urlPatterns = "/WorkManagerDelServlet")
public class WorkManagerDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] check=request.getParameterValues("check");
        LinkedList list=new LinkedList();
        for(int i=0;i<check.length;i++){
            list.add(check[i]);
        }
        boolean del = WorkManagerDelService.Del(list,"T_WORK_RECORD");
        response.sendRedirect(request.getContextPath()+"/workmanager/workSearch.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
