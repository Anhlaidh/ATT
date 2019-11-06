package com.ATT.services;

import com.ATT.dao.Search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DeptGetList {
    public static void main(String[] args) {
        LinkedList linkedList = DeptGetList.DeptGetList("MANAGER");
        for (int i = 0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
    }
    public static LinkedList DeptGetList(String column){
        LinkedList linkedList = new LinkedList();
        ResultSet search = Search.Search("ALL", "T_DEPARTMENT");
        try {
            while (search.next()){
                linkedList.add(search.getString(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linkedList;
    }
}
