package com.ATT.dao.impl;

import java.util.HashMap;
import java.util.List;

public interface DeptDaoImpl {
   List getComponentPageList(int fromCount, int endCount, HashMap queryInforMap);
    int	getTotalNumber(HashMap<String,String> HashMap);


}
