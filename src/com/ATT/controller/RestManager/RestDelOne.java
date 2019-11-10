package com.ATT.controller.RestManager;

import com.ATT.dao.Delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RestDelOne",urlPatterns = "/RestDelOne")
public class RestDelOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rest_id = request.getParameter("rest_id");
        boolean delete = Delete.Delete(rest_id, "T_REST_RECORD");
        response.sendRedirect(request.getContextPath()+"/restmanager/restSearch.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
