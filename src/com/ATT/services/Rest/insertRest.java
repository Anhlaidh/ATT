package com.ATT.services.Rest;

import com.ATT.bean.RestManagerBean;
import com.ATT.dao.RestManager.RestInsert;

public class insertRest {
    public static int insertRest(RestManagerBean restManagerBean){
        int i = RestInsert.RestInsert(restManagerBean);
        return i;
    }
}
