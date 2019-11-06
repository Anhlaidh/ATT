package com.ATT.services;

import com.ATT.bean.DepartmentBean;
import com.ATT.dao.Update;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptUpdate",urlPatterns = "/DeptUpdate")
public class DeptUpdate extends HttpServlet {
//    update T_DEPARTMENT set DEPARTMENT_ID='10010' where DEPARTMENT_ID='10006'
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dept_id = request.getParameter("Dept_id");
        String dept_name = request.getParameter("Dept_name");
        String manager = request.getParameter("Dept_manager");
        DepartmentBean departmentBean = new DepartmentBean();
        departmentBean.setDepartmentId(dept_id);
        departmentBean.setDepartmentName(dept_name);
        departmentBean.setName(manager);
        int update = Update.Update(dept_id, departmentBean, "T_DEPARTMENT");
        System.out.println(update);
        response.sendRedirect(request.getContextPath()+"dept/deptSearch.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
