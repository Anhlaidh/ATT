package com.ATT.service.impl;

import java.util.HashMap;
import java.util.List;

public interface DeptServiceImp {
    public	int	getTotalRecordNumber(HashMap<String,String> queryInforMap);
    public List getComponentPageList(int fromCount, int endCount, HashMap queryInforMap);


}
