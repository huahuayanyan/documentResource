package com.huateng.scf.bas.crg.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtl;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample;
import java.util.List;

public interface BCrgEvalDtlDAO {
    int countByExample(BCrgEvalDtlExample example);

    int deleteByExample(BCrgEvalDtlExample example);

    int deleteByPrimaryKey(String evalDtlId);

    String insert(BCrgEvalDtl record);

    String insertSelective(BCrgEvalDtl record);

    List<BCrgEvalDtl> selectByExample(BCrgEvalDtlExample example);

    BCrgEvalDtl selectByPrimaryKey(String evalDtlId);

    int updateByExampleSelective(BCrgEvalDtl record, BCrgEvalDtlExample example);

    int updateByExample(BCrgEvalDtl record, BCrgEvalDtlExample example);

    int updateByPrimaryKeySelective(BCrgEvalDtl record);

    int updateByPrimaryKey(BCrgEvalDtl record);

    List<BCrgEvalDtl> selectByPage(BCrgEvalDtlExample example, Page page);
}