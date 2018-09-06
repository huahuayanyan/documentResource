package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotChgHis;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotChgHisExample;
import java.util.List;

public interface IBCntMprotChgHisDAO {
    int countByExample(BCntMprotChgHisExample example);

    int deleteByExample(BCntMprotChgHisExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntMprotChgHis record);

    void insertSelective(BCntMprotChgHis record);

    List<BCntMprotChgHis> selectByExample(BCntMprotChgHisExample example);

    BCntMprotChgHis selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntMprotChgHis record, BCntMprotChgHisExample example);

    int updateByExample(BCntMprotChgHis record, BCntMprotChgHisExample example);

    int updateByPrimaryKeySelective(BCntMprotChgHis record);

    int updateByPrimaryKey(BCntMprotChgHis record);

    List<BCntMprotChgHis> selectByPage(BCntMprotChgHisExample example, Page page);
}