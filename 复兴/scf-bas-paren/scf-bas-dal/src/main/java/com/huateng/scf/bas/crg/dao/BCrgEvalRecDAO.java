package com.huateng.scf.bas.crg.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRecExample;
import java.util.List;

public interface BCrgEvalRecDAO {
    int countByExample(BCrgEvalRecExample example);

    int deleteByExample(BCrgEvalRecExample example);

    int deleteByPrimaryKey(String evalId);

    void insert(BCrgEvalRec record);

    void insertSelective(BCrgEvalRec record);

    List<BCrgEvalRec> selectByExampleWithBLOBs(BCrgEvalRecExample example);

    List<BCrgEvalRec> selectByExampleWithoutBLOBs(BCrgEvalRecExample example);

    BCrgEvalRec selectByPrimaryKey(String evalId);

    int updateByExampleSelective(BCrgEvalRec record, BCrgEvalRecExample example);

    int updateByExampleWithBLOBs(BCrgEvalRec record, BCrgEvalRecExample example);

    int updateByExampleWithoutBLOBs(BCrgEvalRec record, BCrgEvalRecExample example);

    int updateByPrimaryKeySelective(BCrgEvalRec record);

    int updateByPrimaryKeyWithBLOBs(BCrgEvalRec record);

    int updateByPrimaryKeyWithoutBLOBs(BCrgEvalRec record);

    List<BCrgEvalRec> selectByPage(BCrgEvalRecExample example, Page page);
    
    int updateByExample(BCrgEvalRec record, BCrgEvalRecExample example);
    
    List<BCrgEvalRec> selectByExample(BCrgEvalRecExample example);
    
    BCrgEvalRec selectByProcessId(String processId);
    
    int updateByPrimaryKey(BCrgEvalRec record);

}