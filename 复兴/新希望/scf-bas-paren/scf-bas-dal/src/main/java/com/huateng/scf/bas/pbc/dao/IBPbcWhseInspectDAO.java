package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcHkDetail;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspect;
import com.huateng.scf.bas.pbc.dao.model.BPbcWhseInspectExample;
import java.util.List;
import java.util.Map;

public interface IBPbcWhseInspectDAO {
    int countByExample(BPbcWhseInspectExample example);

    int deleteByExample(BPbcWhseInspectExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcWhseInspect record);

    void insertSelective(BPbcWhseInspect record);

    List<BPbcWhseInspect> selectByExample(BPbcWhseInspectExample example);

    BPbcWhseInspect selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcWhseInspect record, BPbcWhseInspectExample example);

    int updateByExample(BPbcWhseInspect record, BPbcWhseInspectExample example);

    int updateByPrimaryKeySelective(BPbcWhseInspect record);

    int updateByPrimaryKey(BPbcWhseInspect record);

    List<BPbcWhseInspect> selectByPage(BPbcWhseInspectExample example, Page page);
    
    List<BPbcHkDetail> findHkInfo(Map map);
    
    int findHkCount(Map map);
}