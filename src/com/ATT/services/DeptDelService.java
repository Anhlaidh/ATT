package com.ATT.services;

import com.ATT.dao.Delete;

import java.util.LinkedList;
import java.util.List;

public class DeptDelService {
    public static boolean Del(LinkedList list, String table){
        boolean delete=true;
        boolean temp;
        for (int i =0;i<list.size();i++){

            temp = Delete.Delete(list.get(i).toString(), table);
          delete = temp&&delete;
        }
        return delete;
    }
}
