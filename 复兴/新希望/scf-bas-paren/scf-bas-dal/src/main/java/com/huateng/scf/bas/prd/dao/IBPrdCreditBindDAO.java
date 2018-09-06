package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBindExample;
import java.util.List;

public interface IBPrdCreditBindDAO {
    int countByExample(BPrdCreditBindExample example);

    int deleteByExample(BPrdCreditBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdCreditBind record);

    void insertSelective(BPrdCreditBind record);

    List<BPrdCreditBind> selectByExample(BPrdCreditBindExample example);

    BPrdCreditBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdCreditBind record, BPrdCreditBindExample example);

    int updateByExample(BPrdCreditBind record, BPrdCreditBindExample example);

    int updateByPrimaryKeySelective(BPrdCreditBind record);

    int updateByPrimaryKey(BPrdCreditBind record);
    
    List<BPrdCreditBind> selectCreditBind(BPrdCreditBind bind);

    List<BPrdCreditBind> selectByPage(BPrdCreditBindExample example, Page page);
}