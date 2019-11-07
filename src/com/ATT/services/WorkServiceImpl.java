package com.ATT.services;

import com.ATT.dao.WorkDaoImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class WorkServiceImpl {
    public LinkedList getComponentPageList(Date fromCount, Date endCount, int choice) throws SQLException, ClassNotFoundException {
        LinkedList list=null;
        list = WorkDaoImpl.getComponentPageList(fromCount,endCount,choice);
        return list;


    }

}
