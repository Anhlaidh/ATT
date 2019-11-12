package com.ATT.services;

import com.ATT.dao.MainDao;

import java.sql.SQLException;

public class MainService {
    public static int MainSearch(String account) throws SQLException {

        int a=MainDao.MainSearch(account);
        return a;

    }

}
