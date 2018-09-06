package com.huateng.scf.bas.dcr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrChkDetail;
import com.huateng.scf.bas.dcr.model.BDcrChkDetailExample;
import java.util.List;

public interface BDcrChkDetailDAO {
    int countByExample(BDcrChkDetailExample example);

    int deleteByExample(BDcrChkDetailExample example);

    int deleteByPrimaryKey(String chkDetailId);

    void insert(BDcrChkDetail record);

    void insertSelective(BDcrChkDetail record);

    List<BDcrChkDetail> selectByExample(BDcrChkDetailExample example);

    BDcrChkDetail selectByPrimaryKey(String chkDetailId);

    int updateByExampleSelective(BDcrChkDetail record, BDcrChkDetailExample example);

    int updateByExample(BDcrChkDetail record, BDcrChkDetailExample example);

    int updateByPrimaryKeySelective(BDcrChkDetail record);

    int updateByPrimaryKey(BDcrChkDetail record);

    List<BDcrChkDetail> selectByPage(BDcrChkDetailExample example, Page page);
}