package com.ATT.controller;

import com.ATT.bean.WorkRecordBean;
import com.ATT.dao.Insert;
import com.ATT.dao.Update;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WorkyouniAR",urlPatterns = "/WorkyouniAR")
public class WorkyouniAR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String decision = request.getParameter("decision");

        WorkRecordBean workRecordBean = new WorkRecordBean();
        workRecordBean.setRecord_id(id);
        if (decision.equals("yes")){
            Update.Update("1",workRecordBean,"T_WORK_RECORD_Y");
        }

        String id2 = request.getParameter("id2");
        WorkRecordBean workRecordBean1=new WorkRecordBean();
        workRecordBean1.setRecord_id(id2);
        if (decision.equals("no")){
            Update.Update("1",workRecordBean1,"T_WORK_RECORD_N");
        }


    }
}
