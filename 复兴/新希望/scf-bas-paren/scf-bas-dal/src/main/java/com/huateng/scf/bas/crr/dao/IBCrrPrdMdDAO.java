package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMdExample;

import java.util.List;

public interface IBCrrPrdMdDAO {
    int countByExample(BCrrPrdMdExample example);

    int deleteByExample(BCrrPrdMdExample example);

    int deleteByPrimaryKey(String prdId);

    void insert(BCrrPrdMd record);

    void insertSelective(BCrrPrdMd record);

    List<BCrrPrdMd> selectByExample(BCrrPrdMdExample example);

    BCrrPrdMd selectByPrimaryKey(String prdId);

    int updateByExampleSelective(BCrrPrdMd record, BCrrPrdMdExample example);

    int updateByExample(BCrrPrdMd record, BCrrPrdMdExample example);

    int updateByPrimaryKeySelective(BCrrPrdMd record);

    int updateByPrimaryKey(BCrrPrdMd record);

    List<BCrrPrdMd> selectByPage(BCrrPrdMdExample example, Page page);

	List<BCrrPrdMd> selectByPrdMd(BCrrPrdMd bCrrPrdMd);

	BCrrPrdMd selectByPrdNm(String prdId);
}